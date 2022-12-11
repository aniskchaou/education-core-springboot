package com.dev.delta.dto;

import com.dev.delta.entities.Blog;
import com.dev.delta.entities.Category;
import com.dev.delta.entities.Coupon;
import com.dev.delta.entities.Course;
import com.dev.delta.entities.Enroll;
import com.dev.delta.entities.Instructor;
import com.dev.delta.entities.Lesson;
import com.dev.delta.entities.Option;
import com.dev.delta.entities.Question;
import com.dev.delta.entities.Quiz;
import com.dev.delta.entities.Role;
import com.dev.delta.entities.Section;
import com.dev.delta.entities.Student;
import com.dev.delta.entities.SubCategory;
import com.dev.delta.entities.SystemSettings;
import com.dev.delta.entities.User;
import com.dev.delta.entities.WebsiteSettings;

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
	public void populate();
}
