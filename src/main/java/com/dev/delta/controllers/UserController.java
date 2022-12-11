package com.dev.delta.controllers;

import com.dev.delta.entities.User;
import com.dev.delta.services.UserService;
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
public class UserController {
    /**
     * UserService
     */
    @Autowired
    private UserService UserService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String getCountries(Model model) {
        List<User> users = UserService.getUsers();
        model.addAttribute("users", users);
        return "User/index";
    }

    @GetMapping("/addUser")
    public String addBlogForm(Model model) {

        return "User/add";
    }

    /**
     * addUser
     * @param User
     * @param model
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User User, Model model) {
        UserService.save(User);
        return "redirect:/users";
    }



    /**
     * addUser
     * @param User
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addUser") public String addUserForm( Model model) {
     * //UserService.save(User); return "User/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/User/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        User User = UserService.findById(id).get();
        model.addAttribute("User", User);

        return "User/view";
    }


    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {

        User User = UserService.findById(id).get();
        model.addAttribute("User", User);

        return "User/edit";
    }

    /**
     * updateUser
     * @param id
     * @param User
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated User User,
                                 BindingResult result,
                                 Model model) {

        UserService.save(User);
        return "redirect:/users";
    }

    /**
     * deleteUser
     * @param id
     * @return
     */
    @GetMapping("/deleteUser/{id}")
    @Transactional
    public String deleteUser(@PathVariable("id") Long id) {
        UserService.delete(id);
        return "redirect:/users";
    }
}
