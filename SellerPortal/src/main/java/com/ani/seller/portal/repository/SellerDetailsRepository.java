package com.ani.seller.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.seller.portal.model.SellerDetails;

public interface SellerDetailsRepository extends JpaRepository<SellerDetails, Long> {
	
	List<SellerDetails> findBySellerId(Long sellerId);
	SellerDetails findByEmail(String email);

}
