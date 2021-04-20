/****************************************************************************************************************************
 - File Name        : Room Service Interface Implementation
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is an implementation of service interface of Address Services.
  ****************************************************************************************************************************/

package com.capgemini.greatoutdoors.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.greatoutdoors.dao.AddressEntity;
import com.capgemini.greatoutdoors.dao.AddressRepository;
import com.capgemini.greatoutdoors.dto.Address;
import com.capgemini.greatoutdoors.exception.AddressIdNotFoundException;
import com.capgemini.greatoutdoors.exception.AreaNotFoundException;

@Service
public class AddressServiceImp implements IAddressService {

	@Autowired
	private AddressRepository repository;

	/****************************************************************************************************************************
	 * - Method Name : viewAddress - Return type : List<Address> - Author : Nabanita
	 * Barik - Creation Date : 13-06-2020 - Description : Getting all the address
	 * information from the database.
	 ****************************************************************************************************************************/

	@Override
	public List<Address> viewAddress() {
		List<AddressEntity> entityList = repository.findAll();
		List<Address> addressList = new ArrayList<>();
		for (AddressEntity a : entityList) {
			Address address = new Address();
			address.setAddressId(a.getAddressId());
			address.setFlatNo(a.getFlatNo());
			address.setStreet(a.getStreet());
			address.setLocality(a.getLocality());
			address.setArea(a.getArea());
			address.setPincode(a.getPincode());
			addressList.add(address);
		}
		return addressList;
	}

	/****************************************************************************************************************************
	 * - Method Name : viewAddressById - Input Parameters : Integer addressId -
	 * Return type : AddressEntity - Author : Nabanita Barik - Creation Date :
	 * 13-06-2020 - Description : Getting the address information using the address
	 * id from the database.
	 ****************************************************************************************************************************/
	@Override
	public AddressEntity viewAddressById(Integer addressId) throws AddressIdNotFoundException {
		Optional<AddressEntity> entityList = repository.findById(addressId);
		if (entityList.isPresent()) {
			return entityList.get();
		} else
			throw new AddressIdNotFoundException("Address Id is not found!");
	}

	/****************************************************************************************************************************
	 * - Method Name : addAddress - Input Parameters : Address address - Return type
	 * : String - Author : Nabanita Barik - Creation Date : 13-06-2020 - Description
	 * : Inserting the address information into the database.
	 ****************************************************************************************************************************/

	@Override
	public String addAddress(Address address) {
		Optional<AddressEntity> optional = repository.findById(address.getAddressId());
		String msg;
		if (optional.isPresent()) {
			msg = "This Address is not added and it is already stored with given id";
		} else {
			AddressEntity entityList = new AddressEntity();
			entityList.setAddressId(address.getAddressId());
			entityList.setFlatNo(address.getFlatNo());
			entityList.setStreet(address.getStreet());
			entityList.setLocality(address.getLocality());
			entityList.setArea(address.getArea());
			entityList.setPincode(address.getPincode());
			repository.saveAndFlush(entityList);
			msg = "Address is added " + entityList.getAddressId();
		}
		return msg;

	}

	/****************************************************************************************************************************
	 * - Method Name : updateAddressById - Input Parameters : Integer addressId,
	 * Address address - Return type : String - Author : Nabanita Barik - Creation
	 * Date : 13-06-2020 - Description : Updating the address information in the
	 * database.
	 ****************************************************************************************************************************/

	@Override
	public String updateAddressById(Integer addressId, Address address) throws AddressIdNotFoundException {
		Optional<AddressEntity> entityList = repository.findById(addressId);
		if (entityList.isPresent()) {
			AddressEntity newEntityList = entityList.get();
			newEntityList.setAddressId(address.getAddressId());
			newEntityList.setFlatNo(address.getFlatNo());
			newEntityList.setStreet(address.getStreet());
			newEntityList.setArea(address.getArea());
			newEntityList.setPincode(address.getPincode());
			repository.save(newEntityList);
		}

		else {
			throw new AddressIdNotFoundException("Address Id is not found!");
		}
		return "Address is updated successfully!";
	}

	/****************************************************************************************************************************
	 * - Method Name : deleteAddressById - Input Parameters : Integer addressId,
	 * Address address - Return type : String - Author : Nabanita Barik - Creation
	 * Date : 13-06-2020 - Description : Deleting the address from the database.
	 ****************************************************************************************************************************/

	@Override
	public String deleteAddressById(Integer addressId, Address address) throws AddressIdNotFoundException {
		Optional<AddressEntity> optional = repository.findById(addressId);
		if (optional.isPresent()) {
			repository.deleteById(addressId);
		} else {
			throw new AddressIdNotFoundException("Address Id is not found!");
		}
		return "Address is deleted " + address.getAddressId();
	}

	/****************************************************************************************************************************
	 * - Method Name : viewAddressByArea - Input Parameters : String area
	 * - Return type : String - Author : Nabanita Barik - Creation
	 * Date : 18-06-2020 - Description : Getting the address from the database.
	 ****************************************************************************************************************************/
	
	@Override
	public AddressEntity viewAddressByArea(String area) throws AreaNotFoundException 
	{
		Optional<AddressEntity> addEntity = repository.findByArea(area);
		if(addEntity.isPresent())
		{
			return addEntity.get();
		}
		else {
			throw new AreaNotFoundException(" Area not found");
		}
	}
	

}
