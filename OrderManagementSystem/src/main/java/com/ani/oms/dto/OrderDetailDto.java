package com.ani.oms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OrderDetailDto {
	
	private Long orderid;
	private String orderRefNum;
	private Long userId;
	private Long sellerId;
	private Long productId;
	private String orderStatus;
	private String deliveryCountry;
	private String deliveryState;

}
