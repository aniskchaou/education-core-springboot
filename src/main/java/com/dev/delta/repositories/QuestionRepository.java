package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
