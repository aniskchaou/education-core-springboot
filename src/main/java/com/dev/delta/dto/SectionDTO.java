package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.SectionRepository;

@Service
public class SectionDTO implements DTO{

	@Autowired
	SectionRepository  sectionRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		//section.setQuestion(question);
		section.setTitle("");
		section.setLesson(lesson);
		sectionRepository.save(section);
	}

}
