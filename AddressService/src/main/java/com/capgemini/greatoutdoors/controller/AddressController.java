/****************************************************************************************************************************
 - File Name        : Address Service Controller
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is an end point controller to consume Address Services.
  ****************************************************************************************************************************/
package com.capgemini.greatoutdoors.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.greatoutdoors.dao.AddressEntity;
import com.capgemini.greatoutdoors.dto.Address;
import com.capgemini.greatoutdoors.exception.AddressIdNotFoundException;
import com.capgemini.greatoutdoors.exception.AreaNotFoundException;
import com.capgemini.greatoutdoors.service.AddressServiceImp;

@RestController
@RequestMapping(value = "/address")
@Validated
public class AddressController {

	@Autowired
	private AddressServiceImp service;

	/****************************************************************************************************************************
	 * - Method Name : viewAddress - Return type : List<Address> - Author : Nabanita
	 * Barik - Creation Date : 13-06-2020 - Description : Getting all the address
	 * information from the database. - End Point Url :
	 * http://localhost:9098/address/view
	 ****************************************************************************************************************************/

	@GetMapping("/view")
	public List<Address> viewAddress() {
		return service.viewAddress();
	}

	/****************************************************************************************************************************
	 * - Method Name : viewAddressById - Input Parameters : Integer addresid -
	 * Return type : AddressEntity - Author : Nabanita Barik - Creation Date :
	 * 13-06-2020 - Description : Getting the address information using the address
	 * id from the database. - End Point Url : http://localhost:9098/address
	 ****************************************************************************************************************************/

	@GetMapping("/{addressId}")
	public AddressEntity viewAddressById(@PathVariable("addressId") @Min(1000) Integer addressId)
			throws AddressIdNotFoundException {
		return service.viewAddressById(addressId);
	}

	/****************************************************************************************************************************
	 * - Method Name : addAddress - Input Parameters : Address address - Return type
	 * : ResponseEntity<String> - Author : Nabanita Barik - Creation Date :
	 * 13-06-2020 - Description : Inserting the address information into the
	 * database. - End Point Url : http://localhost:9098/address/add
	 ****************************************************************************************************************************/

	@PostMapping("/add")
	public ResponseEntity<String> addAddress(@Valid @RequestBody Address address) {
		return new ResponseEntity<String>(service.addAddress(address), HttpStatus.ACCEPTED);
	}

	/****************************************************************************************************************************
	 * - Method Name : updateAddressById - Input Parameters : Integer addressId,
	 * Address address - Return type : ResponseEntity<String> - Author : Nabanita
	 * Barik - Creation Date : 13-06-2020 - Description : Updating the address
	 * information in the database. - End Point Url : http://localhost:9098/address
	 ****************************************************************************************************************************/

	@PutMapping("/{addressId}")
	public ResponseEntity<String> updateAddressById(@PathVariable("addressId") @Min(1000) Integer addressId,
			@Valid @RequestBody Address address) throws AddressIdNotFoundException {
		return ResponseEntity.ok(service.updateAddressById(addressId, address));
	}

	/****************************************************************************************************************************
	 * - Method Name : deleteAddress - Input Parameters : Integer addressId, Address
	 * address - Return type : ResponseEntity<String> - Author : Nabanita Barik -
	 * Creation Date : 13-06-2020 - Description : Deleting the address from the
	 * database. - End Point Url : http://localhost:9098/address
	 ****************************************************************************************************************************/

	@DeleteMapping("/{addressId}")
	public ResponseEntity<String> deleteAddressById(@PathVariable("addressId") @Min(1000) Integer addressId,
			Address address) throws AddressIdNotFoundException {
		return ResponseEntity.ok(service.deleteAddressById(addressId, address));
	}
	
	/****************************************************************************************************************************
	 * - Method Name : viewAddressByArea - Input Parameters : String area
	 *  - Return type : ResponseEntity<String> - Author : Nabanita Barik -
	 * Creation Date : 18-06-2020 - Description : Getting the address from the
	 * database. - End Point Url : http://localhost:9098/address
	 ****************************************************************************************************************************/
	
	@GetMapping("/getByArea/{area}")
	public ResponseEntity<AddressEntity> viewAddressByArea(@PathVariable("area") String area)
			throws AreaNotFoundException
	{
		AddressEntity addEntity=service.viewAddressByArea(area);
		return ResponseEntity.status(HttpStatus.OK).body(addEntity);
		
	}
}
