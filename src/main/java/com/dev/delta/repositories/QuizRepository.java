package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
