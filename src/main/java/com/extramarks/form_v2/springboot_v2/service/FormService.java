package com.extramarks.form_v2.springboot_v2.service;

import com.extramarks.form_v2.springboot_v2.entity.Form;
import com.extramarks.form_v2.springboot_v2.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public Form saveForm(Form form){
        return formRepository.save(form);
    }

    public List<Form> getForms(){
        return formRepository.findAll();
    }

    public Form getFormById(int id){
        return formRepository.findById(id).orElse(null);
    }

    public Form updateForm (Form form){
        Form existingForm=formRepository.findById(form.getId()).orElse(null);

        existingForm.setName(form.getName());
        existingForm.setEmail(form.getEmail());
        existingForm.setMobile(form.getMobile());
        existingForm.setGender(form.getGender());
        existingForm.setSkills(form.getSkills());
        existingForm.setState(form.getState());

        return formRepository.save(existingForm);
    }
}
