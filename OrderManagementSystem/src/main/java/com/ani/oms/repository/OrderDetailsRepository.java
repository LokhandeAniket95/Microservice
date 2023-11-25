package com.ani.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.oms.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{
	
	List<OrderDetails> findByUserId(Long userId);

}
