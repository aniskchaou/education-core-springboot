package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
