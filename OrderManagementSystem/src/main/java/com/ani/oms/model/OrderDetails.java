package com.ani.oms.model;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	@NotBlank
	@Column(name="orderrefnum")
	private String orderRefNum;
	@Column(name="userid")
	private Long userId;
	@Column(name="sellerid")
	private Long sellerId;
	@Column(name="productid")
	private Long productId;
	@Column(name="orderstatus")
	private String orderStatus;
	@NotBlank
	@Column(name="deliverycountry")
	private String deliveryCountry;
	@NotBlank
	@Column(name="deliverystate")
	private String deliveryState;
	@Column(name="createdate")
	private Date createDate;
	@Column(name="updatedate")
	private Date updateDate;
	@NotBlank
	@Column(name="isdeleted")
	private String isDeleted = "N";
	
	public OrderDetails() {
		
	}

	public OrderDetails(Long orderid, @NotBlank String orderRefNum, @NotBlank Long userId, @NotBlank Long sellerId,
			@NotBlank Long productId, String orderStatus, @NotBlank String deliveryCountry,
			@NotBlank String deliveryState, Date createDate, Date updateDate, @NotBlank String isDeleted) {
		super();
		this.orderid = orderid;
		this.orderRefNum = orderRefNum;
		this.userId = userId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.orderStatus = orderStatus;
		this.deliveryCountry = deliveryCountry;
		this.deliveryState = deliveryState;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getOrderRefNum() {
		return orderRefNum;
	}

	public void setOrderRefNum(String orderRefNum) {
		this.orderRefNum = orderRefNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}
