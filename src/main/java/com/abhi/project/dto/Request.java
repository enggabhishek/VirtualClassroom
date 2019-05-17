package com.abhi.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REQUEST")
public class Request {
	
	@Id
	@Column(name="combine")
	private String combine;
	@Column(name="rollno")
	private String rollno;
	@Column(name="email")
	private String email;
	@Column(name="ratings")
	private Double ratings;
	@Column(name="status")
	private String status;
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCombine(String combine) {
		this.combine = combine;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	public String getCombine() {
		return combine;
	}
	public String getEmail() {
		return email;
	}
	public Double getRatings() {
		return ratings;
	}
	public String getRollno() {
		return rollno;
	}
	public String getStatus() {
		return status;
	}
}
