package com.dev.delta.dto;

import com.dev.delta.entities.*;

public interface DTO {

	public User user=new User();
	public Role role=new Role();
	public Blog blog=new Blog();
	public Category category=new Category();
	public Course course=new Course();
	public Enroll enroll=new Enroll();
	public Instructor instructor=new Instructor();
	public Coupon coupon=new Coupon();
	public Student student=new Student();
	public Lesson lesson=new Lesson(); 
	public Section section=new Section();
	public Quiz  quiz=new Quiz();
	public SystemSettings settings=new SystemSettings();
	public Question question=new Question();
	public SubCategory subCategory=new SubCategory();
	public WebsiteSettings websiteSettings=new WebsiteSettings();
	public Option option=new Option();
	Paymentt pay=new Paymentt();
	public void populate();
}
