package com.film.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.film.entity.SeatEntity;



@Repository
public interface SeatREPO extends JpaRepository<SeatEntity, Long> {
	
	@Query(value = "select * from seat_entity where customer_b_id=?", nativeQuery = true)
	public List<SeatEntity> getAllSeat(long id);
	
	@Query(value = "select * from seat_entity inner join seat_entity_seat_no"
			+ " on seat_entity.s_id = seat_entity_seat_no.seat_entity_s_id"
			+ " inner join show_schedule"
			+ " on seat_entity.currentdate_date_id = show_schedule.date_id"
			+ " where show_date = ? and show_time = ?", nativeQuery = true)
	public List<SeatEntity> getAllByDate(LocalDate date, String time);


}
