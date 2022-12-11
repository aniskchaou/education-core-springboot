package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
