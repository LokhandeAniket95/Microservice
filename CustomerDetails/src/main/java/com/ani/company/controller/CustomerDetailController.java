package com.ani.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.company.dto.CustomerDetailsDto;
import com.ani.company.model.CustomerDetails;
import com.ani.company.response.OrderHistoryResponse;
import com.ani.company.service.CustomerDetailsService;

@RestController
@RequestMapping("/customer")
public class CustomerDetailController {
	
	@Autowired
	public CustomerDetailsService customerDetailsService;
	
	@PostMapping("/createNewCustomer")
	public ResponseEntity<CustomerDetails> createNewCustomer(@RequestBody CustomerDetailsDto customerDetailsDto){
		return new ResponseEntity<CustomerDetails>(customerDetailsService.createNewCustomer(customerDetailsDto), HttpStatus.CREATED);
	}
	
	@PatchMapping("/updateCustomerPassword")
	public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody CustomerDetailsDto customerDetailsDto){
		return new ResponseEntity<CustomerDetails>(customerDetailsService.updateCustomerPassword(customerDetailsDto), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllCustomerDetails")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails(){
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsService.getAllCustomerDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerDetailsById/{userId}")
	public ResponseEntity<CustomerDetails> getCustomerDetailsById(@PathVariable String userId){
		return new ResponseEntity<CustomerDetails>(customerDetailsService.getCustomerDetailsById(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerOrderDetailsByCustId/{userId}")
	public ResponseEntity<OrderHistoryResponse> getCustomerOrderDetailsByCustId(@PathVariable String userId){
		return new ResponseEntity<OrderHistoryResponse>(customerDetailsService.getCustomerOrderDetailsByCustId(userId),HttpStatus.OK);
	}

}
