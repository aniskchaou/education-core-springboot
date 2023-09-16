package com.dev.delta.controllers;

import com.dev.delta.entities.Course;
import com.dev.delta.entities.Enroll;
import com.dev.delta.entities.Student;
import com.dev.delta.services.CourseService;
import com.dev.delta.services.EnrollService;
import com.dev.delta.services.StudentService;
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

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/enrolls")
    public String getCountries(Model model) {
        List<Enroll> enrolls = EnrollService.getEnrolls();
        model.addAttribute("enrolls", enrolls);
        return "enroll/index";
    }

    @GetMapping("/addenroll")
    public String addBlogForm(Model model) {

        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);

        return "enroll/add";
    }

    /**
     * addEnroll
     * @param Enroll
     * @param model
     * @return
     */
    @PostMapping("/addenroll")
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
    @RequestMapping("/enroll/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Enroll Enroll = EnrollService.findById(id).get();
        model.addAttribute("Enroll", Enroll);

        return "Enroll/view";
    }


    @RequestMapping("/editenroll/{id}")
    public String editEnroll(@PathVariable("id") Long id, Model model) {

        Enroll Enroll = EnrollService.findById(id).get();
        model.addAttribute("enroll", Enroll);
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);

        return "enroll/edit";
    }

    /**
     * updateEnroll
     * @param id
     * @param Enroll
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateenroll/{id}")
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
    @GetMapping("/deleteenroll/{id}")
    @Transactional
    public String deleteEnroll(@PathVariable("id") Long id) {
        EnrollService.delete(id);
        return "redirect:/enrolls";
    }
}