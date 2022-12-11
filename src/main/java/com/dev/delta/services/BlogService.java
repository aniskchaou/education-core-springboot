package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Blog;
import com.dev.delta.repositories.BlogRepository;
@Service
public class BlogService {
	/**
	 * blogRepository
	 */
	@Autowired
	private BlogRepository blogRepository;
	

	/**
	 * getBlogs
	 * @return
	 */
	public java.util.List<Blog> getBlogs()
	{
		return blogRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return blogRepository.count();
	}

	/**
	 * save
	 * @param blog
	 */
	public void save(Blog blog)
	{
		blogRepository.save(blog);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Blog> findById(Long id) {
		return blogRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		blogRepository.delete(blogRepository.findById(id).get());
	}
}
