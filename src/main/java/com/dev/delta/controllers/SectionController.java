package com.dev.delta.controllers;

import com.dev.delta.entities.Section;
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
    private SectionService SectionService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/sections")
    public String getCountries(Model model) {
        List<Section> sections = SectionService.getSections();
        model.addAttribute("sections", sections);
        return "Section/index";
    }

    @GetMapping("/addSection")
    public String addBlogForm(Model model) {

        return "Section/add";
    }

    /**
     * addSection
     * @param Section
     * @param model
     * @return
     */
    @PostMapping("/addSection")
    public String addSection(Section Section, Model model) {
        SectionService.save(Section);
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
    @RequestMapping("/Section/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Section Section = SectionService.findById(id).get();
        model.addAttribute("Section", Section);

        return "Section/view";
    }


    @RequestMapping("/editSection/{id}")
    public String editSection(@PathVariable("id") Long id, Model model) {

        Section Section = SectionService.findById(id).get();
        model.addAttribute("Section", Section);

        return "Section/edit";
    }

    /**
     * updateSection
     * @param id
     * @param Section
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateSection/{id}")
    public String updateSection(@PathVariable("id") long id, @Validated Section Section,
                                 BindingResult result,
                                 Model model) {

        SectionService.save(Section);
        return "redirect:/sections";
    }

    /**
     * deleteSection
     * @param id
     * @return
     */
    @GetMapping("/deleteSection/{id}")
    @Transactional
    public String deleteSection(@PathVariable("id") Long id) {
        SectionService.delete(id);
        return "redirect:/sections";
    }
}
