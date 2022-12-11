package com.dev.delta.controllers;

import com.dev.delta.entities.Settings;
import com.dev.delta.entities.SystemSettings;
import com.dev.delta.services.SettingsService;
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
public class SettingsController {
    /**
     * SettingsService
     */
    @Autowired
    private SettingsService SettingsService;

    /**
     * getCountries
     * @param model
     * @return
     */
    @GetMapping("/settings")
    public String getCountries(Model model) {
        List<SystemSettings> settings = SettingsService.getSettingss();
        model.addAttribute("settings", settings);
        return "Settings/index";
    }

    @GetMapping("/addSettings")
    public String addBlogForm(Model model) {

        return "Settings/add";
    }

    /**
     * addSettings
     * @param Settings
     * @param model
     * @return
     */
    @PostMapping("/addSettings")
    public String addSettings(SystemSettings Settings, Model model) {
        SettingsService.save(Settings);
        return "redirect:/settings";
    }



    /**
     * addSettings
     * @param Settings
     * @param model
     * @return
     */
    /*
     * @GetMapping("/addSettings") public String addSettingsForm( Model model) {
     * //SettingsService.save(Settings); return "Settings/add"; }
     */



    /**
     * findById
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/Settings/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        SystemSettings Settings = SettingsService.findById(id).get();
        model.addAttribute("Settings", Settings);

        return "Settings/view";
    }


    @RequestMapping("/editSettings/{id}")
    public String editSettings(@PathVariable("id") Long id, Model model) {

        SystemSettings Settings = SettingsService.findById(id).get();
        model.addAttribute("Settings", Settings);

        return "Settings/edit";
    }

    /**
     * updateSettings
     * @param id
     * @param Settings
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/updateSettings/{id}")
    public String updateSettings(@PathVariable("id") long id, @Validated SystemSettings Settings,
                                 BindingResult result,
                                 Model model) {

        SettingsService.save(Settings);
        return "redirect:/settings";
    }

    /**
     * deleteSettings
     * @param id
     * @return
     */
    @GetMapping("/deleteSettings/{id}")
    @Transactional
    public String deleteSettings(@PathVariable("id") Long id) {
        SettingsService.delete(id);
        return "redirect:/settings";
    }
}
