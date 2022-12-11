package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.entities.Instructor;
import com.dev.delta.repositories.InstructorRepository;

public class InstructorDTO implements DTO {

	@Autowired
	InstructorRepository  instructorRepository;
	
	@Override
	public void populate() {
		instructor.setAbout("");
		instructor.setDateOfBirth("");
		instructor.setEmail("");
		instructor.setFacebook("");
		instructor.setImage("");
		instructor.setInstagram("");
		instructor.setLinkedin("");
		instructor.setName("");
		instructor.setPhone("");
		instructor.setTwitter("");
		instructorRepository.save(instructor);
		
	}

}
