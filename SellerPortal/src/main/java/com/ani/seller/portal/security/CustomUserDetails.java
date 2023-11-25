package com.ani.seller.portal.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ani.seller.portal.model.SellerDetails;
import com.ani.seller.portal.repository.SellerDetailsRepository;

@Service
public class CustomUserDetails implements UserDetailsService{
	
	@Autowired
	private SellerDetailsRepository sellerDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SellerDetails sellerDetails = sellerDetailsRepository.findByEmail(username);
		return User.builder()
				.username(sellerDetails.getEmail())
				.password(sellerDetails.getPassword())
				.authorities(new ArrayList<>())
				.build();
	}

}
