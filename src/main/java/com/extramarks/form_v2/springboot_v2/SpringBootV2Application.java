package com.extramarks.form_v2.springboot_v2;

import com.extramarks.form_v2.springboot_v2.controller.FormController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SpringBootV2Application {

    public static void main(String[] args) {
//        new File(FormController.uploadDirectory).mkdir();
        SpringApplication.run(SpringBootV2Application.class, args);
    }
}
