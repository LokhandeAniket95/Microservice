package com.ani.seller.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.seller.portal.dto.JwtRequest;
import com.ani.seller.portal.dto.JwtResponse;
import com.ani.seller.portal.dto.SellerDetailsDto;
import com.ani.seller.portal.model.SellerDetails;
import com.ani.seller.portal.security.CustomUserDetails;
import com.ani.seller.portal.security.JwtHelper;
import com.ani.seller.portal.service.SellerDetailsService;

@RestController
@RequestMapping("/logon")
public class SellerLoginOrSignupController {
	
	@Autowired
	public SellerDetailsService sellerDetailsService;
	
	@Autowired
	public CustomUserDetails customUserDetails;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtHelper helper;
	
	@PostMapping("/creatNewSeller")
	public ResponseEntity<SellerDetails> creatNewSeller(@RequestBody SellerDetailsDto sellerDetailsDto){
		return new ResponseEntity<SellerDetails>(sellerDetailsService.creatNewSeller(sellerDetailsDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		this.doAuthenticate(request.getUserId(), request.getPassword());
		UserDetails userDetails = customUserDetails.loadUserByUsername(request.getUserId());
		String token = this.helper.generateToken(userDetails);
		JwtResponse response = JwtResponse.builder()
				.token(token)
				.userId(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
        	authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

}
