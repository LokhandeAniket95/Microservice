package com.ani.seller.portal.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ani.seller.portal.customexception.NoSuchRecordFoundException;
import com.ani.seller.portal.dto.SellerDetailsDto;
import com.ani.seller.portal.model.SellerDetails;
import com.ani.seller.portal.repository.SellerDetailsRepository;
import com.ani.seller.portal.security.SecurityConfig;

@Service
public class SellerDetailsService {
	
	@Autowired
	public SellerDetailsRepository sellerDetailsRepository;
	
	@Autowired
	public SecurityConfig securityConfig;

	public SellerDetails creatNewSeller(SellerDetailsDto sellerDetailsDto) {
		var sellerDetails = new SellerDetails();
		sellerDetails.setFirstName(sellerDetailsDto.getFirstName());
		sellerDetails.setLastName(sellerDetailsDto.getLastName());
		sellerDetails.setCountry(sellerDetailsDto.getCountry());
		sellerDetails.setState(sellerDetailsDto.getState());
		sellerDetails.setEmail(sellerDetailsDto.getEmail());
		try {
			Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sellerDetailsDto.getDob());
			sellerDetails.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		sellerDetails.setUserId(sellerDetailsDto.getUserId());
		sellerDetails.setPassword(securityConfig.passwordEncoder().encode(sellerDetailsDto.getPassword()));
		sellerDetails.setCreateDate(new Date());
		sellerDetails.setUpdateDate(new Date());
		return sellerDetailsRepository.save(sellerDetails);
	}

	public List<SellerDetails> getAllSellerDetails() {
		return sellerDetailsRepository.findAll();
	}
	
	public SellerDetails getSellerDetailsById(String sellerId) {
		return sellerDetailsRepository.findById(Long.valueOf(sellerId))
				.orElseThrow(() -> new NoSuchRecordFoundException("record not Found for id" + sellerId));
	}
	

}
