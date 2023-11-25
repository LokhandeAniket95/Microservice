package com.ani.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.oms.dto.OrderDetailDto;
import com.ani.oms.model.OrderDetails;
import com.ani.oms.service.OrderDetailsService;

@RestController
@RequestMapping("/oms")
public class OrderDetailsController {
	
	@Autowired
	public OrderDetailsService orderDetailsService;
	
	@PostMapping("/placeNewOrder")
	public ResponseEntity<OrderDetails> placeNewOrder(@RequestBody OrderDetailDto orderDetailDto){
		return new ResponseEntity<OrderDetails>(orderDetailsService.placeNewOrder(orderDetailDto), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAllOrderDetails")
	public ResponseEntity<List<OrderDetails>> getAllOrderDetails(){
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/getOrderDetailsById/{orderId}")
	public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable String orderId){
		return new ResponseEntity<OrderDetails>(orderDetailsService.getOrderDetailsById(orderId),HttpStatus.OK);
	}
	
	@GetMapping("/getOrderDetailsByUserId/{orderId}")
	public ResponseEntity<List<OrderDetails>> getOrderDetailsByUserId(@PathVariable String orderId){
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getOrderDetailsByUserId(orderId),HttpStatus.OK);
	}

}
