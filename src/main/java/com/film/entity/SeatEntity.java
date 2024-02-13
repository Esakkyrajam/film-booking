package com.film.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;



@Entity
public class SeatEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private long sId;
	
	@ElementCollection
	private List<String> seatNo;
	
	@ElementCollection
	private List<Double> price;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	private CustomerEntity customer;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CurrentDateEntity currentdate;

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public List<String> getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CurrentDateEntity getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(CurrentDateEntity currentdate) {
		this.currentdate = currentdate;
	}

	public SeatEntity(List<String> seatNo, List<Double> price, double total, CustomerEntity customer,
			CurrentDateEntity currentdate) {
		super();
		this.seatNo = seatNo;
		this.price = price;
		this.total = total;
		this.customer = customer;
		this.currentdate = currentdate;
	}

	public SeatEntity(long sId, List<String> seatNo, List<Double> price, double total, CustomerEntity customer,
			CurrentDateEntity currentdate) {
		super();
		this.sId = sId;
		this.seatNo = seatNo;
		this.price = price;
		this.total = total;
		this.customer = customer;
		this.currentdate = currentdate;
	}

	public SeatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seat [sId=" + sId + ", seatNo=" + seatNo + ", price=" + price + ", total=" + total + ", customer="
				+ customer + ", currentdate=" + currentdate + "]";
	}

		
	
}
