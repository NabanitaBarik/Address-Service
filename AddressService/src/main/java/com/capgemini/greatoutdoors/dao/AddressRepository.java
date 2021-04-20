/****************************************************************************************************************************
 - File Name        : Address Service DAO
 - Author           : Nabanita Barik
 - Creation Date    : 13-06-2020
 - Description      : This is a repository class used to use the database for Address Services.
  ****************************************************************************************************************************/ 


package com.capgemini.greatoutdoors.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

	public Optional<AddressEntity> findByArea(String area);




}
