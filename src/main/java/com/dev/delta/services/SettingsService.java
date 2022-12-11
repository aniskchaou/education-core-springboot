package com.dev.delta.services;

import com.dev.delta.entities.SystemSettings;
import com.dev.delta.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsService {
    /**
     * SettingsRepository
     */
    @Autowired
    private SettingsRepository SettingsRepository;


    /**
     * getSettingss
     * @return
     */
    public java.util.List<SystemSettings> getSettingss()
    {
        return SettingsRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return SettingsRepository.count();
    }

    /**
     * save
     * @param Settings
     */
    public void save(SystemSettings Settings)
    {
        SettingsRepository.save(Settings);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<SystemSettings> findById(Long id) {
        return SettingsRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        SettingsRepository.delete(SettingsRepository.findById(id).get());
    }
}