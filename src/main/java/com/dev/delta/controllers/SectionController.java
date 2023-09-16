package com.dev.delta.controllers;

import com.dev.delta.entities.Lesson;
import com.dev.delta.entities.Section;
import com.dev.delta.services.LessonService;
import com.dev.delta.services.SectionService;
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
public class SectionController {
    /**
     * SectionService
     */
    @Autowired
    private SectionService sectionService;

    @Autowired
    LessonService lessonService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/sections")
    public String getCountries(Model model) {
        List<Section> sections = sectionService.getSections();
        model.addAttribute("sections", sections);
        return "section/index";
    }

    @GetMapping("/addsection")
    public String addBlogForm(Model model) {
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);

        return "section/add";
    }

    /**
     * addSection
     * @param Section
     * @param model
     * @return
     */
    @PostMapping("/addsection")
    public String addSection(Section Section, Model model) {
        sectionService.save(Section);
        return "redirect:/sections";
    }



    /**
     * addSection
     * @param Section
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addSection") public String addSectionForm( Model model) {
     * //SectionService.save(Section); return "Section/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/section/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Section section = sectionService.findById(id).get();
        model.addAttribute("section", section);

        return "section/view";
    }


    @RequestMapping("/editsection/{id}")
    public String editSection(@PathVariable("id") Long id, Model model) {
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);
        Section section = sectionService.findById(id).get();
        model.addAttribute("section", section);

        return "section/edit";
    }

    /**
     * updateSection
     * @param id
     * @param Section
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updatesection/{id}")
    public String updateSection(@PathVariable("id") long id, @Validated Section Section,
                                 BindingResult result,
                                 Model model) {

        sectionService.save(Section);
        return "redirect:/sections";
    }

    /**
     * deleteSection
     * @param id
     * @return
     */
    @GetMapping("/deletesection/{id}")
    @Transactional
    public String deleteSection(@PathVariable("id") Long id) {
        sectionService.delete(id);
        return "redirect:/sections";
    }
}
