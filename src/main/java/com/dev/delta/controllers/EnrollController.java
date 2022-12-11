package com.dev.delta.controllers;

import com.dev.delta.entities.Enroll;
import com.dev.delta.services.EnrollService;
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
public class EnrollController {
    /**
     * EnrollService
     */
    @Autowired
    private EnrollService EnrollService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/enrolls")
    public String getCountries(Model model) {
        List<Enroll> enrolls = EnrollService.getEnrolls();
        model.addAttribute("enrolls", enrolls);
        return "Enroll/index";
    }

    @GetMapping("/addEnroll")
    public String addBlogForm(Model model) {

        return "Enroll/add";
    }

    /**
     * addEnroll
     * @param Enroll
     * @param model
     * @return
     */
    @PostMapping("/addEnroll")
    public String addEnroll(Enroll Enroll, Model model) {
        EnrollService.save(Enroll);
        return "redirect:/enrolls";
    }



    /**
     * addEnroll
     * @param Enroll
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addEnroll") public String addEnrollForm( Model model) {
     * //EnrollService.save(Enroll); return "Enroll/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/Enroll/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Enroll Enroll = EnrollService.findById(id).get();
        model.addAttribute("Enroll", Enroll);

        return "Enroll/view";
    }


    @RequestMapping("/editEnroll/{id}")
    public String editEnroll(@PathVariable("id") Long id, Model model) {

        Enroll Enroll = EnrollService.findById(id).get();
        model.addAttribute("Enroll", Enroll);

        return "Enroll/edit";
    }

    /**
     * updateEnroll
     * @param id
     * @param Enroll
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateEnroll/{id}")
    public String updateEnroll(@PathVariable("id") long id, @Validated Enroll Enroll,
                                 BindingResult result,
                                 Model model) {

        EnrollService.save(Enroll);
        return "redirect:/enrolls";
    }

    /**
     * deleteEnroll
     * @param id
     * @return
     */
    @GetMapping("/deleteEnroll/{id}")
    @Transactional
    public String deleteEnroll(@PathVariable("id") Long id) {
        EnrollService.delete(id);
        return "redirect:/enrolls";
    }
}