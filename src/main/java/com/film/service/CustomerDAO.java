package com.film.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.film.entity.CurrentDateEntity;
import com.film.entity.CustomerEntity;
import com.film.entity.MovieDetailsEntity;
import com.film.entity.OrderEntity;
import com.film.entity.SeatEntity;


@Component
public class CustomerDAO {
	
	@Autowired
	private CustomerREPO customerrepo;
	
	@Autowired
	private SeatREPO seatrepo;
	
	@Autowired
	private OrderREPO orderrepo;
	
	@Autowired
	private MovieREPO movierepo;
	
	
	public int save(CustomerEntity customer) {
		
		customerrepo.save(customer);
		return 1;
		
	}
	
//	@Cacheable(cacheNames = "login", key = "'customer'+#email+#password")
	public CustomerEntity login(String email, String password) {
		CustomerEntity customer = customerrepo.findByEmailAndPassword(email, password);
		return customer;
	}
	
	public int saveSeat(SeatEntity seat, CustomerEntity customer, Date date, String time){
		List<SeatEntity> list = new ArrayList<SeatEntity>();
		list.add(seat);
		customer.setSeat(list);
		CurrentDateEntity currentdateentity= new CurrentDateEntity();
		currentdateentity.setShowDate(date);
		currentdateentity.setShowTime(time);
		currentdateentity.setSeat(list);
		
		seat.setCurrentdate(currentdateentity);
		seat.setCurrentdate(currentdateentity);
		seat.setCustomer(customer);
		SeatEntity save = seatrepo.save(seat);
		return 1;
	}
	
	public List<SeatEntity> getSeats(long id){
		List<SeatEntity> list = seatrepo.getAllSeat(id);
		return list;
	}
	
	public List<CustomerEntity> getAll(){
		List<CustomerEntity> findAll = customerrepo.findAll();
		return findAll;
	}
	
	public OrderEntity saveHistory(OrderEntity order, CustomerEntity customer) {
		customer.setOrder(order);
		OrderEntity save = orderrepo.save(order);
		return save;
	}
	
//	@Cacheable(cacheNames = "history", key = "#id")
	public List<OrderEntity> getAllHistory(long id){
		List<OrderEntity> list = orderrepo.getAllOrder(id);		
		return list;
	}
	
	public List<SeatEntity> getAllSeat(LocalDate date, String time){
		List<SeatEntity> list = seatrepo.getAllByDate(date, time);
		return list;
	}
	
	public void delete(long id) {
		seatrepo.deleteById(id);
	}
	
	public int updateDetail(CustomerEntity customer) {
		customerrepo.save(customer);
		return 1;
	}
	
	public List<MovieDetailsEntity> getAllMovie(){
		List<MovieDetailsEntity> list = this.movierepo.findAll();
		return list;
	}
	
	public List<CustomerEntity> getAllCustomers() {
        List<CustomerEntity> allCustomers = customerrepo.findAllBy();
        return allCustomers;
    }
	
	

}
