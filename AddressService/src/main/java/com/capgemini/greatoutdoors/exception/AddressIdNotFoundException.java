/****************************************************************************************************************************
 - File Name        : Address Service Exception 
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is an Address Id Not Found Exception class used to use handler the proper exception for Address Services.
  ****************************************************************************************************************************/ 


package com.capgemini.greatoutdoors.exception;

public class AddressIdNotFoundException extends Exception{

	public AddressIdNotFoundException(String message) {
		super(message); 
	}
}