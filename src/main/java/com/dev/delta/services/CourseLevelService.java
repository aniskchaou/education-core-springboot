package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.CourseLevel;
import com.dev.delta.repositories.CourseLevelRepository;
@Service
public class CourseLevelService {
	/**
	 * courseLevelRepository
	 */
	@Autowired
	private CourseLevelRepository courseLevelRepository;
	

	/**
	 * getCourseLevels
	 * @return
	 */
	public java.util.List<CourseLevel> getCourseLevels()
	{
		return courseLevelRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return courseLevelRepository.count();
	}

	/**
	 * save
	 * @param courseLevel
	 */
	public void save(CourseLevel courseLevel)
	{
		courseLevelRepository.save(courseLevel);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<CourseLevel> findById(Long id) {
		return courseLevelRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		courseLevelRepository.delete(courseLevelRepository.findById(id).get());
	}
}
