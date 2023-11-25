package com.ani.company.model;

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

@Entity
@Table(name = "customer")
@DynamicUpdate
@DynamicInsert
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	@NotBlank
	@Column(name="firstname")
	private String firstName;
	@NotBlank
	@Column(name="lastname")
	private String lastName;
	@NotBlank
	@Column(name="country")
	private String country;
	@NotBlank
	@Column(name="state")
	private String state;
	@Email
	@Column(name="email")
	private String email;
	@Column(name="dob")
	private Date dob;
	@NotBlank
	@Column(name="userid")
	private String userId;
	@NotBlank
	@Column(name="password")
	private String password;
	@Column(name="createdate")
	private Date createDate;
	@Column(name="updatedate")
	private Date updateDate;
	@NotBlank
	@Column(name="isdisable")
	private String isDisable = "N";
	@NotBlank
	@Column(name="isdeleted")
	private String isDeleted = "N";
	
	public CustomerDetails() {}
	
	public CustomerDetails(Long custId, @NotBlank String firstName, @NotBlank String lastName,
			@NotBlank String country, @NotBlank String state, @Email String email, @NotBlank Date dob,
			@NotBlank String userId, @NotBlank String password, @NotBlank Date createDate, @NotBlank Date updateDate,
			@NotBlank String isDisable, @NotBlank String isDeleted) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.state = state;
		this.email = email;
		this.dob = dob;
		this.userId = userId;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDisable = isDisable;
		this.isDeleted = isDeleted;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(String isDisable) {
		this.isDisable = isDisable;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "CustomerDetails [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", country=" + country + ", state=" + state + ", email=" + email + ", dob=" + dob + ", userId="
				+ userId + ", password=" + password + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", isDisable=" + isDisable + ", isDeleted=" + isDeleted + "]";
	}

}
