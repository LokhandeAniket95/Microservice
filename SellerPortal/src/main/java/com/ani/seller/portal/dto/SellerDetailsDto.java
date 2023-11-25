package com.ani.seller.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SellerDetailsDto {
	
	private Long custId;
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String state;
	
	private String email;
	
	private String dob;
	
	private String userId;
	
	private String password;

}
