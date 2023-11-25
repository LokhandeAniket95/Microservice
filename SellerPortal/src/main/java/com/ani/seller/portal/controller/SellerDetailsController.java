package com.ani.seller.portal.controller;

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

import com.ani.seller.portal.dto.SellerDetailsDto;
import com.ani.seller.portal.model.SellerDetails;
import com.ani.seller.portal.service.SellerDetailsService;

@RestController
@RequestMapping("/seller")
public class SellerDetailsController {
	
	@Autowired
	public SellerDetailsService sellerDetailsService;
	
	@GetMapping("/details/getAllCustomerDetails")
	public ResponseEntity<List<SellerDetails>> getAllSellerDetails(){
		return new ResponseEntity<List<SellerDetails>>(sellerDetailsService.getAllSellerDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/details/getCustomerDetailsById/{userId}")
	public ResponseEntity<SellerDetails> getSellerDetailsById(@PathVariable String userId){
		return new ResponseEntity<SellerDetails>(sellerDetailsService.getSellerDetailsById(userId),HttpStatus.OK);
	}

}
