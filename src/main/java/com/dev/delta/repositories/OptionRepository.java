package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Option;

public interface OptionRepository extends JpaRepository<Option,Long> {

}
