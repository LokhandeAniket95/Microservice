package com.ani.company.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OrderDetails {
	
	
	private Long orderid;
	
	private String orderRefNum;
	
	private Long userId;
	
	private Long sellerId;
	
	private Long productId;
	
	private String orderStatus;
	
	private String deliveryCountry;
	
	private String deliveryState;
	
	private Date createDate;
	
	private Date updateDate;
	
	private String isDeleted;
	
	
}
