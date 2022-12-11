package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Student;
import com.dev.delta.repositories.StudentRepository;
@Service
public class StudentService {
	/**
	 * studentRepository
	 */
	@Autowired
	private StudentRepository studentRepository;
	

	/**
	 * getStudents
	 * @return
	 */
	public java.util.List<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return studentRepository.count();
	}

	/**
	 * save
	 * @param student
	 */
	public void save(Student student)
	{
		studentRepository.save(student);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		studentRepository.delete(studentRepository.findById(id).get());
	}
}
