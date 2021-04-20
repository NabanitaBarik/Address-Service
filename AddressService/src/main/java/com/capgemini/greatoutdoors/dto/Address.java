/****************************************************************************************************************************
 - File Name        : Address Service DTO
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is a POJO class that is used to map the data in the database.
  ****************************************************************************************************************************/ 

package com.capgemini.greatoutdoors.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private Integer addressId;
	@Min(1) @Max(100)
	private Integer flatNo;
	private Integer street;
	@Pattern(regexp="^[a-zA-Z]{1,20}$", message="locality should be alphabetic value")
	@NotNull(message="Address field should not be null!") 
	@NotBlank(message="Address field should not be blank!")
	private String locality;
	@Pattern(regexp="^[a-zA-Z]{1,20}$", message="area should be alphabetic value")
	@NotNull(message="Address field should not be null!") 
	@NotBlank(message="Address field should not be blank!")
	private String area;
	private long pincode;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(Integer flatNo) {
		this.flatNo = flatNo;
	}
	public Integer getStreet() {
		return street;
	}
	public void setStreet(Integer street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", street=" + street + ", locality="
				+ locality + ", area=" + area + ", pincode=" + pincode + "]";
	}

	
}
