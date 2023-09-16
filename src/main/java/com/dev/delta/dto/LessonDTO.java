package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.LessonRepository;

@Service
public class LessonDTO  implements DTO{

	@Autowired
	LessonRepository  lessonRepository ;
	
	@Override
	public void populate() {
		lesson.setDuration("");
		lesson.setIsFree("");
		lesson.setSummary("");
		lesson.setTitle("");
		lesson.setVideo("");
		lessonRepository.save(lesson);
		
	}

}
