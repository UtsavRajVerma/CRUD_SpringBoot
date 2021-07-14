package com.extramarks.form_v2.springboot_v2.entity;

import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;

@ToString
@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="Form_Table")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String state;
    private String gender;
    private String skills;
    private String image;
//    @Transient
//    private MultipartFile file;

    public Form(String name, String email, String mobile, String state, String gender, String skills) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;
    }

    public Form(String name, String email, String mobile, String state, String gender, String skills, String image) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;
        this.image = image;
    }

    /*
    public Form(String name, String email, String mobile, String state, String gender, String skills, MultipartFile file) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;
        this.file = file;
    }
    */

    public Form() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//
////    public MultipartFile getFile() {
////        return file;
////    }
////
////    public void setFile(MultipartFile file) {
////        this.file = file;
////    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
}
