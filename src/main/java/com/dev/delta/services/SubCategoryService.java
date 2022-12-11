package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.SubCategory;
import com.dev.delta.repositories.SubCategoryRepository;
@Service
public class SubCategoryService {
	/**
	 * subCategoryRepository
	 */
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	

	/**
	 * getSubCategorys
	 * @return
	 */
	public java.util.List<SubCategory> getSubCategorys()
	{
		return subCategoryRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return subCategoryRepository.count();
	}

	/**
	 * save
	 * @param subCategory
	 */
	public void save(SubCategory subCategory)
	{
		subCategoryRepository.save(subCategory);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<SubCategory> findById(Long id) {
		return subCategoryRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		subCategoryRepository.delete(subCategoryRepository.findById(id).get());
	}
}
