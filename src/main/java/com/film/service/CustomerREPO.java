package com.film.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.entity.CustomerEntity;

@Repository
public interface CustomerREPO extends JpaRepository<CustomerEntity, Long> {
	
	public CustomerEntity findByEmailAndPassword(String email, String password);
	
	public List<CustomerEntity> findAllBy();

}
