package com.ani.company.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ani.company.dto.OrderDetails;

@FeignClient(name = "ORDER-MANAGEMENT")
public interface OmsFeignClient {
	
	@GetMapping("/oms/getOrderDetailsByUserId/{userId}")
	List<OrderDetails> getOrderDetailByuserId(@PathVariable String userId);

}
