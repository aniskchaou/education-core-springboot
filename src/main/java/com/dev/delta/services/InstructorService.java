package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Instructor;
import com.dev.delta.repositories.InstructorRepository;
@Service
public class InstructorService {
	/**
	 * instructorRepository
	 */
	@Autowired
	private InstructorRepository instructorRepository;
	

	/**
	 * getInstructors
	 * @return
	 */
	public java.util.List<Instructor> getInstructors()
	{
		return instructorRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return instructorRepository.count();
	}

	/**
	 * save
	 * @param instructor
	 */
	public void save(Instructor instructor)
	{
		instructorRepository.save(instructor);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Instructor> findById(Long id) {
		return instructorRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		instructorRepository.delete(instructorRepository.findById(id).get());
	}
}
