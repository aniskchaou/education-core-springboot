package com.dev.delta.services;

import com.dev.delta.entities.Section;
import com.dev.delta.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionService {
    /**
     * SectionRepository
     */
    @Autowired
    private SectionRepository SectionRepository;


    /**
     * getSections
     * @return
     */
    public java.util.List<Section> getSections()
    {
        return SectionRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return SectionRepository.count();
    }

    /**
     * save
     * @param Section
     */
    public void save(Section Section)
    {
        SectionRepository.save(Section);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<Section> findById(Long id) {
        return SectionRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        SectionRepository.delete(SectionRepository.findById(id).get());
    }
}