package com.film.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "show_schedule")
public class CurrentDateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "date_id")
	private long DateId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "show_date")
	private Date showDate;
	
	@Column(name = "show_time")
	private String showTime;
	
	@OneToMany(mappedBy = "currentdate", fetch = FetchType.EAGER)
	private List<SeatEntity> seat;

	public long getDateId() {
		return DateId;
	}

	public void setDateId(long dateId) {
		DateId = dateId;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public List<SeatEntity> getSeat() {
		return seat;
	}

	public void setSeat(List<SeatEntity> seat) {
		this.seat = seat;
	}

	public CurrentDateEntity(Date showDate, String showTime, List<SeatEntity> seat) {
		super();
		this.showDate = showDate;
		this.showTime = showTime;
		this.seat = seat;
	}

	public CurrentDateEntity(long dateId, Date showDate, String showTime, List<SeatEntity> seat) {
		super();
		DateId = dateId;
		this.showDate = showDate;
		this.showTime = showTime;
		this.seat = seat;
	}

	public CurrentDateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CurrentDateOperation [DateId=" + DateId + ", showDate=" + showDate + ", showTime=" + showTime
				+ ", seat=" + seat + "]";
	}

	


}
