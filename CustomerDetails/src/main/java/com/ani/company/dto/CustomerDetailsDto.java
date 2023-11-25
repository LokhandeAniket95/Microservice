package com.ani.company.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CustomerDetailsDto {
	
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
