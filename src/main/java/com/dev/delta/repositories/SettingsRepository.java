package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.SystemSettings;

public interface SettingsRepository extends JpaRepository<SystemSettings, Long> {

}
