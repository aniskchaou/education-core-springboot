package com.dev.delta.controllers;

import com.dev.delta.entities.Lesson;
import com.dev.delta.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class LessonController {
    /**
     * LessonService
     */
    @Autowired
    private LessonService lessonService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/lessons")
    public String getCountries(Model model) {
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);
        return "lesson/index";
    }

    @GetMapping("/addlesson")
    public String addBlogForm(Model model) {

        return "lesson/add";
    }

    /**
     * addLesson
     * @param Lesson
     * @param model
     * @return
     */
    @PostMapping("/addlesson")
    public String addLesson(Lesson Lesson, Model model) {
        lessonService.save(Lesson);
        return "redirect:/lessons";
    }



    /**
     * addLesson
     * @param Lesson
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addLesson") public String addLessonForm( Model model) {
     * //LessonService.save(Lesson); return "Lesson/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/Lesson/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Lesson lesson = lessonService.findById(id).get();
        model.addAttribute("category", lesson);

        return "Lesson/view";
    }


    @RequestMapping("/editlesson/{id}")
    public String editLesson(@PathVariable("id") Long id, Model model) {

        Lesson lesson = lessonService.findById(id).get();
        model.addAttribute("category", lesson);

        return "lesson/edit";
    }

    /**
     * updateLesson
     * @param id
     * @param Lesson
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updatelesson/{id}")
    public String updateLesson(@PathVariable("id") long id, @Validated Lesson Lesson,
                                 BindingResult result,
                                 Model model) {

        lessonService.save(Lesson);
        return "redirect:/lessons";
    }

    /**
     * deleteLesson
     * @param id
     * @return
     */
    @GetMapping("/deletelesson/{id}")
    @Transactional
    public String deleteLesson(@PathVariable("id") Long id) {
        lessonService.delete(id);
        return "redirect:/lessons";
    }
}
