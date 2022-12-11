package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.repositories.EnrollRepository;

public class EnrollDTO implements DTO {

	@Autowired
	EnrollRepository enrollRepository ;
	
	@Override
	public void populate() {
		enroll.setCourse(course);
		enroll.setStudent(student);
		enrollRepository.save(enroll);

	}

}
