package com.dev.delta.entities;

import javax.persistence.*;

@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	String name;
	String discount;
	String limitdate;
	String code;

	@ManyToOne
	Course course;

	public String getLimitdate() {
		return limitdate;
	}

	public void setLimitdate(String limitdate) {
		this.limitdate = limitdate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Coupon() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getLimit() {
		return limitdate;
	}
	public void setLimit(String limit) {
		this.limitdate = limit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
