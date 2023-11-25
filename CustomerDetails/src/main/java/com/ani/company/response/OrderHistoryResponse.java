package com.ani.company.response;

import java.util.Date;
import java.util.List;

import com.ani.company.dto.OrderDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OrderHistoryResponse {
	
	private Long custId;
	private String firstName;
	private String lastName;
	private String country;
	private String state;
	private String email;
	private Date dob;
	private String userId;
	private String password;
	private Date createDate;
	private Date updateDate;
	private String isDisable;
	private String isDeleted;
	private List<OrderDetails> orderDetails;

}
