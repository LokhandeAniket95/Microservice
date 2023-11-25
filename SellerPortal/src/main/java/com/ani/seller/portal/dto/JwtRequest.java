package com.ani.seller.portal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtRequest {
	private String userId;
	private String password;
}
