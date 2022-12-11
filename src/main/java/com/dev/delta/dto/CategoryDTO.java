package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.CategoryRepository;
@Service
public class CategoryDTO implements DTO {

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public void populate() {
		// TODO Auto-generated method stub
       category.setName("");
       categoryRepository.save(category);
	}

}
