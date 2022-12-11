package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.repositories.CourseRepository;

public class CourseDTO implements DTO {

	@Autowired
	CourseRepository     courseRepository  ;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
       course.setCapacity("");
       course.setCategory(category);
       course.setCourseDescription("");
       course.setCourseRequirements("");
       course.setCoverImage("");
       course.setDiscount("");
       course.setDownloadable("");
       course.setDuration("");
       course.setFeaturedCourse("");
       course.setIsfree("");
       course.setLanguage("");
       course.setLevel("");
       course.setPartnerInstructor("");
       course.setPreviewVideo("");
       course.setTopicTitle("");
       course.setThumbnail("");
       course.setStartDate("");
       course.setPrice("");
       course.setPreviewVideo("");
       courseRepository.save(course);
	}

}
