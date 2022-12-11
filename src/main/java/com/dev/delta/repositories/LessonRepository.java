package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
