package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
