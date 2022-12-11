package com.dev.delta.services;

import com.dev.delta.entities.Enroll;
import com.dev.delta.repositories.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollService {
    /**
     * EnrollRepository
     */
    @Autowired
    private EnrollRepository EnrollRepository;


    /**
     * getEnrolls
     * @return
     */
    public java.util.List<Enroll> getEnrolls()
    {
        return EnrollRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return EnrollRepository.count();
    }

    /**
     * save
     * @param Enroll
     */
    public void save(Enroll Enroll)
    {
        EnrollRepository.save(Enroll);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<Enroll> findById(Long id) {
        return EnrollRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        EnrollRepository.delete(EnrollRepository.findById(id).get());
    }
}