package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Category;
import com.dev.delta.repositories.CategoryRepository;
@Service
public class CategoryService {
	/**
	 * categoryRepository
	 */
	@Autowired
	private CategoryRepository categoryRepository;
	

	/**
	 * getCategorys
	 * @return
	 */
	public java.util.List<Category> getCategorys()
	{
		return categoryRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return categoryRepository.count();
	}

	/**
	 * save
	 * @param category
	 */
	public void save(Category category)
	{
		categoryRepository.save(category);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		categoryRepository.delete(categoryRepository.findById(id).get());
	}
}
