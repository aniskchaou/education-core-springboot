package com.dev.delta.services;

import com.dev.delta.entities.Lesson;
import com.dev.delta.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    /**
     * LessonRepository
     */
    @Autowired
    private LessonRepository LessonRepository;


    /**
     * getLessons
     * @return
     */
    public java.util.List<Lesson> getLessons()
    {
        return LessonRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return LessonRepository.count();
    }

    /**
     * save
     * @param Lesson
     */
    public void save(Lesson Lesson)
    {
        LessonRepository.save(Lesson);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<Lesson> findById(Long id) {
        return LessonRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        LessonRepository.delete(LessonRepository.findById(id).get());
    }
}