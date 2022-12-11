package com.dev.delta.services;

import com.dev.delta.entities.Option;
import com.dev.delta.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionService {
    /**
     * OptionRepository
     */
    @Autowired
    private OptionRepository OptionRepository;


    /**
     * getOptions
     * @return
     */
    public java.util.List<Option> getOptions()
    {
        return OptionRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return OptionRepository.count();
    }

    /**
     * save
     * @param Option
     */
    public void save(Option Option)
    {
        OptionRepository.save(Option);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<Option> findById(Long id) {
        return OptionRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        OptionRepository.delete(OptionRepository.findById(id).get());
    }
}