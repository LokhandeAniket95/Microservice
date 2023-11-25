package com.ani.company.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;
	@NotBlank
	@Column(name="countrycode")
	private String countryCode;
	@NotBlank
	@Column(name="countryname")
	private String countryName;
	@NotBlank
	@Column(name="code")
	private String code;

}
