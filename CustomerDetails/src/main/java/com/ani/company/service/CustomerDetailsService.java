package com.ani.company.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.company.Repository.CustomerRepository;
import com.ani.company.customexception.NoSuchRecordFoundException;
import com.ani.company.dto.CustomerDetailsDto;
import com.ani.company.dto.OrderDetails;
import com.ani.company.feignclient.OmsFeignClient;
import com.ani.company.model.CustomerDetails;
import com.ani.company.response.OrderHistoryResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerDetailsService {
	
	final Logger logger = LoggerFactory.getLogger(CustomerDetailsService.class);
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	private OmsFeignClient omsFeignClient;

	public CustomerDetails createNewCustomer(CustomerDetailsDto customerDetailsDto) {
		var customerDetails = new CustomerDetails();
		customerDetails.setFirstName(customerDetailsDto.getFirstName());
		customerDetails.setLastName(customerDetailsDto.getLastName());
		customerDetails.setCountry(customerDetailsDto.getCountry());
		customerDetails.setState(customerDetailsDto.getState());
		customerDetails.setEmail(customerDetailsDto.getEmail());
		try {
			Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(customerDetailsDto.getDob());
			customerDetails.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		customerDetails.setUserId(customerDetailsDto.getUserId());
		customerDetails.setPassword(customerDetailsDto.getPassword());
		customerDetails.setCreateDate(new Date());
		customerDetails.setUpdateDate(new Date());
		return customerRepository.save(customerDetails);
	}
	
	public CustomerDetails updateCustomerPassword(CustomerDetailsDto customerDetailsDto) {
		CustomerDetails customerDetails = customerRepository.findById(customerDetailsDto.getCustId())
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + customerDetailsDto.getCustId()));
		customerDetails.setPassword(customerDetailsDto.getPassword());
		customerDetails.setUpdateDate(new Date());
		return customerRepository.save(customerDetails);
	}
	
	public List<CustomerDetails> getAllCustomerDetails(){
		return customerRepository.findAll();
	}

	public CustomerDetails getCustomerDetailsById(String userId) {
		return customerRepository.findById(Long.valueOf(userId))
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + userId));
	}
	
	@CircuitBreaker(name = "orderHistory", fallbackMethod = "orderHistoryFallback")
	public OrderHistoryResponse getCustomerOrderDetailsByCustId(String userId) {
		CustomerDetails customerDetails = customerRepository.findById(Long.valueOf(userId))
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + userId));
		List<OrderDetails> orderDetails = omsFeignClient.getOrderDetailByuserId(userId);
		final var orderHistoryResponse = OrderHistoryResponse.builder()
				.custId(customerDetails.getCustId())
				.firstName(customerDetails.getFirstName())
				.lastName(customerDetails.getLastName())
				.dob(customerDetails.getDob())
				.country(customerDetails.getCountry())
				.state(customerDetails.getState())
				.email(customerDetails.getEmail())
				.createDate(customerDetails.getCreateDate())
				.isDeleted(customerDetails.getIsDeleted())
				.isDisable(customerDetails.getIsDisable())
				.orderDetails(orderDetails)
				.build();
		return orderHistoryResponse;
	}
	
	public OrderHistoryResponse orderHistoryFallback(String userId, Exception ex) {
		logger.info("Fallback is executed because service is down: ", ex.getMessage());
		final var orderHistoryResponse = OrderHistoryResponse.builder()
				.custId(1l)
				.firstName("dummy")
				.lastName("dummy")
				.build();
		return orderHistoryResponse;
	}
}
