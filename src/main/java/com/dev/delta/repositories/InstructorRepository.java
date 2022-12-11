package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
