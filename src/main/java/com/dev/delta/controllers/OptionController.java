package com.dev.delta.controllers;

import com.dev.delta.entities.Option;
import com.dev.delta.services.OptionService;
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
public class OptionController {
    /**
     * OptionService
     */
    @Autowired
    private OptionService OptionService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/options")
    public String getCountries(Model model) {
        List<Option> options = OptionService.getOptions();
        model.addAttribute("options", options);
        return "Option/index";
    }

    @GetMapping("/addOption")
    public String addBlogForm(Model model) {

        return "Option/add";
    }

    /**
     * addOption
     * @param Option
     * @param model
     * @return
     */
    @PostMapping("/addOption")
    public String addOption(Option Option, Model model) {
        OptionService.save(Option);
        return "redirect:/options";
    }



    /**
     * addOption
     * @param Option
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addOption") public String addOptionForm( Model model) {
     * //OptionService.save(Option); return "Option/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/Option/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Option Option = OptionService.findById(id).get();
        model.addAttribute("Option", Option);

        return "Option/view";
    }


    @RequestMapping("/editOption/{id}")
    public String editOption(@PathVariable("id") Long id, Model model) {

        Option Option = OptionService.findById(id).get();
        model.addAttribute("Option", Option);

        return "Option/edit";
    }

    /**
     * updateOption
     * @param id
     * @param Option
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateOption/{id}")
    public String updateOption(@PathVariable("id") long id, @Validated Option Option,
                                 BindingResult result,
                                 Model model) {

        OptionService.save(Option);
        return "redirect:/options";
    }

    /**
     * deleteOption
     * @param id
     * @return
     */
    @GetMapping("/deleteOption/{id}")
    @Transactional
    public String deleteOption(@PathVariable("id") Long id) {
        OptionService.delete(id);
        return "redirect:/options";
    }
}