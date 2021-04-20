/****************************************************************************************************************************
 - File Name        : Adddress Service DAO
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is an entity class that is used to map the data in the database.
  ****************************************************************************************************************************/ 

package com.capgemini.greatoutdoors.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private Integer addressId;
	
	@Column(name="flat_no") 
	private Integer flatNo;
	
	private Integer street;
	
	private String locality;
	
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
		return "AddressEntity [addressId=" + addressId + ", flatNo=" + flatNo + ", street=" + street + ", locality="
				+ locality + ", area=" + area + ", pincode=" + pincode + "]";
	}
	
}
