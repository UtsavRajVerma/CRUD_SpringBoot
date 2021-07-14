package com.extramarks.form_v2.springboot_v2.controller;

import com.extramarks.form_v2.springboot_v2.SpringBootV2Application;
import com.extramarks.form_v2.springboot_v2.entity.Form;
import com.extramarks.form_v2.springboot_v2.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

//    @GetMapping("/")
//    public String viewHomePage(){
//        return "index";
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new SpringBootV2Application());
//        return "signup form";
//    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestBody Form form){
        return formService.saveForm(form);
    }

    @PostMapping("/file2")
    public String handleForm(@RequestParam("name") String userName,
                             @RequestParam("email") String userMail,
                             @RequestParam("mobile") String userMobile,
                             @RequestParam("state") String userState,
                             @RequestParam("gender") String userGender,
                             @RequestParam("skills") String userSkills, Model model){

        model.addAttribute("name",userName);
        model.addAttribute("email",userMail);
        model.addAttribute("mobile",userMobile);
        model.addAttribute("state",userState);
        model.addAttribute("gender",userGender);
        model.addAttribute("skills",userSkills);
        return "success";
    }

    @GetMapping("/get")
    public List<Form> findAllForms(){
        return formService.getForms();
    }

    @GetMapping("/getById/{id}")
    public Form findFormById(@PathVariable int id) {
        return formService.getFormById(id);
    }

    @PutMapping("/update")
    public Form updateForm(@RequestBody Form form){
        return formService.updateForm(form);
    }
}
