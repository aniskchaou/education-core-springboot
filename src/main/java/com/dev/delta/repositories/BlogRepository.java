package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{

}
