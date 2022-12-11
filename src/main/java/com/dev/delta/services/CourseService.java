package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Course;
import com.dev.delta.repositories.CourseRepository;
@Service
public class CourseService {
	/**
	 * courseRepository
	 */
	@Autowired
	private CourseRepository courseRepository;
	

	/**
	 * getCourses
	 * @return
	 */
	public java.util.List<Course> getCourses()
	{
		return courseRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return courseRepository.count();
	}

	/**
	 * save
	 * @param course
	 */
	public void save(Course course)
	{
		courseRepository.save(course);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Course> findById(Long id) {
		return courseRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		courseRepository.delete(courseRepository.findById(id).get());
	}
}
