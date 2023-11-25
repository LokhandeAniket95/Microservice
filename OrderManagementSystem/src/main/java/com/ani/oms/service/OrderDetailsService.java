package com.ani.oms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.oms.customexception.NoSuchRecordFoundException;
import com.ani.oms.dto.OrderDetailDto;
import com.ani.oms.model.OrderDetails;
import com.ani.oms.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
	
	@Autowired
	public OrderDetailsRepository orderDetailsRepository;
	
	public OrderDetails placeNewOrder(OrderDetailDto orderDetailDto) {
		var orderDetails = new OrderDetails();
		orderDetails.setOrderRefNum(UUID.randomUUID().toString());
		orderDetails.setOrderStatus(orderDetailDto.getOrderStatus());
		orderDetails.setDeliveryCountry(orderDetailDto.getDeliveryCountry());
		orderDetails.setDeliveryState(orderDetailDto.getDeliveryState());
		orderDetails.setSellerId(orderDetailDto.getSellerId());
		orderDetails.setUserId(orderDetailDto.getUserId());
		orderDetails.setProductId(orderDetailDto.getProductId());
		orderDetails.setCreateDate(new Date());
		orderDetails.setUpdateDate(new Date());
		return orderDetailsRepository.save(orderDetails);
	}
	
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}
	
	public OrderDetails getOrderDetailsById(String orderId) {
		return orderDetailsRepository.findById(Long.valueOf(orderId))
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + orderId));
	}
	
	public List<OrderDetails> getOrderDetailsByUserId(String orderId) {
		return Optional.of(orderDetailsRepository.findByUserId(Long.valueOf(orderId)))
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + orderId));
	}

}
