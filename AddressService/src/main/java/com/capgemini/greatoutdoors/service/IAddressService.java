/****************************************************************************************************************************
 - File Name        : Address Service Interface
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is a service interface of Address Services.
  ****************************************************************************************************************************/ 

package com.capgemini.greatoutdoors.service;

import java.util.List;

import com.capgemini.greatoutdoors.dao.AddressEntity;
import com.capgemini.greatoutdoors.dto.Address;
import com.capgemini.greatoutdoors.exception.AddressIdNotFoundException;
import com.capgemini.greatoutdoors.exception.AreaNotFoundException;

public interface IAddressService {

	/****************************************************************************************************************************
	- Method Name      : viewAddress
	- Return type      : List<Address>
	- Author           : Nabanita Barik
	- Creation Date    : 13-06-2020
	- Description      : Getting all the address information from the database.
	****************************************************************************************************************************/ 
	public List<Address> viewAddress();
	
	/****************************************************************************************************************************
	- Method Name      : viewAddressById
	- Input Parameters : Integer addressId
	- Return type      : AddressEntity
	- Author           : Nabanita Barik
	- Creation Date    : 13-06-2020
	- Description      : Getting the address information using the address id from the database.
	****************************************************************************************************************************/	
	public AddressEntity viewAddressById(Integer addressId) throws AddressIdNotFoundException;
	
	
	/****************************************************************************************************************************
	 - Method Name      : addAddress
	 - Input Parameters : Address address
	 - Return type      : String
	 - Author           : Nabanita Barik
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the address information into the database.
	  ****************************************************************************************************************************/ 	
	public String addAddress(Address address);
	
	
	/****************************************************************************************************************************
	- Method Name      : updateAddressById
	- Input Parameters : Integer addressId, Address address
	- Return type      : String
	- Author           : Nabanita Barik
	- Creation Date    : 13-06-2020
	- Description      : Updating the address information in the database.
	****************************************************************************************************************************/ 	
	public String updateAddressById(Integer addressId, Address address) throws AddressIdNotFoundException;
	
	/****************************************************************************************************************************
	 - Method Name      : deleteAddressById
	 - Input Parameters : Integer addressId, Address address
	 - Return type      : String
	 - Author           : Nabanita Barik
	 - Creation Date    : 13-06-2020
	 - Description      : Deleting the address from the database.
	  ****************************************************************************************************************************/ 	
	public String deleteAddressById(Integer addressId, Address address) throws AddressIdNotFoundException;
	
	/****************************************************************************************************************************
	 - Method Name      : viewAddressByArea
	 - Input Parameters : String area
	 - Return type      : AddressEntity
	 - Author           : Nabanita Barik
	 - Creation Date    : 18-06-2020
	 - Description      : Getting the address from the database.
	  ****************************************************************************************************************************/ 
	
	public AddressEntity viewAddressByArea(String area) throws AreaNotFoundException; 
}
