package com.film.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.entity.OrderEntity;



@Repository
public interface OrderREPO extends JpaRepository<OrderEntity, Long> {
	
	@Query(value = "select * from order_entity where customer_b_id=? ORDER BY h_id DESC", nativeQuery = true)
	public List<OrderEntity> getAllOrder(long id);

}
