package com.extramarks.form_v2.springboot_v2.controller;

import com.extramarks.form_v2.springboot_v2.entity.Form;
import com.extramarks.form_v2.springboot_v2.fileHelper.FileUploadHelper;
import com.extramarks.form_v2.springboot_v2.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    /*
    public String getUrl(@RequestParam("profileImage") MultipartFile file) throws IOException{
       File saveFile=new ClassPathResource("static/image/").getFile();
       Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());

       Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

        return path.toString();
    }
    */

//    -> ORIGINAL Git Version
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestBody Form form){
        return formService.saveForm(form);
    }

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestParam Form form, @RequestParam("profileImage") MultipartFile file) throws IOException {
        String receivedUrl=getUrl(file);
        form.setImage(receivedUrl);
        return formService.saveForm(form);
    }
    */

    /*
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new SpringBootV2Application());
        return "signup form";
    }
    */

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestBody Form form, @RequestParam("profileImage") MultipartFile file){
            try {
                System.out.println("Add form: "+ form.toString());
                if(file.isEmpty()) System.out.println("Cannot upload empty image.");
                else{
                    form.setImage(file.getOriginalFilename());

                    File saveFile=new ClassPathResource("static/image/").getFile();

                    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
                    Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Image successfully uploaded.");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return formService.saveForm(form);
    }
    */

    //    public static String uploadDirectory=System.getProperty("user.dir")+"/uploads";

    //    @RequestMapping("/add")
//    public String uploadPage(Model model){
//        return "index";
//    }

    /*
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("form") Form form, @RequestParam (value="name",defaultValue = "false") boolean name,Model model){
        System.out.println(("Name: "+ name));
        System.out.println(("Form: ")+ form);
        return "index";
    }
    */

    /*
    public static String UPLOAD_DIR=System.getProperty("user.dir")+"/home/extramarks/IdeaProjects/SpringBoot_v2/src/main/resources/static/image";

    @CrossOrigin("localhost:63342")
    @RequestMapping("/add")
    @ResponseBody
    public String addForm(Form form, @RequestParam("image") MultipartFile file){
        StringBuilder fileNames=new StringBuilder();
        String fileName=form.getId()+file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath=Paths.get(UPLOAD_DIR,fileName);

        try {
            Files.write(fileNameAndPath,file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        form.setImage(fileName);
        formService.saveForm(form);
        return "Image upload successful.";
    }
      */

    /*
    //ABV
    @PostMapping("/add")
    public String userInfo(Form form, @RequestParam("image") MultipartFile file, Model model) throws IOException {
        Files.copy(file.getInputStream(), Paths.get(fileUploadHelper.UPLOAD_DIR+"/"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
        form.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("img/"+file.getOriginalFilename()).toUriString());
        formService.saveForm(form);
        model.addAttribute("obj", form);
        return "file2";
    }
    */

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/add")
    public String addForm(Model model, @RequestParam("image") MultipartFile file){
        Path fileNameAndPath=Paths.get(FileUploadHelper.UPLOAD_DIR, file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("msg","Successfully attached image.");
        return "index";
    }
    */

    @PostMapping("/file2")
    public String handleForm(@RequestParam("name") String userName, @RequestParam("email") String userMail,
                             @RequestParam("mobile") String userMobile, @RequestParam("state") String userState,
                             @RequestParam("gender") String userGender,@RequestParam("skills") String userSkills,
                             @RequestParam("image") String userImage,Model model){

        model.addAttribute("name",userName);
        model.addAttribute("email",userMail);
        model.addAttribute("mobile",userMobile);
        model.addAttribute("state",userState);
        model.addAttribute("gender",userGender);
        model.addAttribute("skills",userSkills);
        model.addAttribute("image",userImage);
        return "success";
    }

    /*
    @RequestMapping("/file2")
    public String handleForm(@RequestParam("name") String userName, @RequestParam("email") String userMail,
                             @RequestParam("mobile") String userMobile, @RequestParam("state") String userState,
                             @RequestParam("gender") String userGender,@RequestParam("skills") String userSkills,
                             @RequestParam("image") String userImage,Model model, @RequestParam("image") MultipartFile file){
//
//        model.addAttribute("name",userName);
//        model.addAttribute("email",userMail);
//        model.addAttribute("mobile",userMobile);
//        model.addAttribute("state",userState);
//        model.addAttribute("gender",userGender);
//        model.addAttribute("skills",userSkills);
//        model.addAttribute("image",userImage);
//        return "success";

          try{
              Path fileNameAndPath=Paths.get(uploadDirectory,file.getOriginalFilename());
              String fileName=file.getOriginalFilename();
              Files.write(fileNameAndPath,file.getBytes());
          }
          catch(IOException e){
              e.printStackTrace();
          }
          model.addAttribute("msg","Successfully added image");
          return "file2";
    }
    */

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
