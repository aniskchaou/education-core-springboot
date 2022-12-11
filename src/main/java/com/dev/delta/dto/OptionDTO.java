package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.entities.Option;
import com.dev.delta.repositories.OptionRepository;

public class OptionDTO implements DTO {

	@Autowired
	OptionRepository  optionRepository;
	
	@Override
	public void populate() {
		option.setOption(null);
		option.setQuestion(question);
		optionRepository.save(option);

	}

}
