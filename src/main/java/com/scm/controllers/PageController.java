package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");
        model.addAttribute("name","Substring Technology");
        model.addAttribute("YouTubeChannel","Learn coding with Durgesh");
        return "home";
    }

    //aboout route

    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("About Page Loading");
        return "about";
    }


    // services

    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("services Page Loading");
        return "services";
    }

    // contact

    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    // login

    @GetMapping("/login")
    public String login(){
        return new String("login");
    }

    // register

    @GetMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        // default data bhi dal sakte hai
        // userForm.setName("Sandip");
        model.addAttribute("userForm",userForm);
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){
        System.out.println("Processing registration");
        //fetch the form data
        System.out.println(userForm);

        //validate form data
        // todo::validation userform Next video

        //save to data base


        //userservice

        // UserForm--> User
//        User user = User.builder()
//                .name(userForm.getName())
//                .email(userForm.getEmail())
//                .password(userForm.getPassword())
//                .about(userForm.getAbout())
//                .phoneNumber(userForm.getPhoneNumber())
//                .profilePic(
//                        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEipfpWVOTztT90BWUxYwy_MBRYK1rb4exPBexciDWk09l2cARaqPPHkQSAyrPkiDWW9cKWiuhyUlvkuhEY5UbbFiSC9U11ckhBx-5MFvCd1_KT5TQbKh15itWCwKgQ8zkJpYRuJN0N-MIjnTtGNVaq8msPzgiE2TMnhQuWqkmO6m2idnJ5t6BfF8oA/w557-h640/Best%20WhatsApp%20Profile%20Pictures%20in%20the%20World%20%20Sweet%20Images%20For%20WhatsApp%20Profile%20DPz%20(41).jpg")
//                .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEipfpWVOTztT90BWUxYwy_MBRYK1rb4exPBexciDWk09l2cARaqPPHkQSAyrPkiDWW9cKWiuhyUlvkuhEY5UbbFiSC9U11ckhBx-5MFvCd1_KT5TQbKh15itWCwKgQ8zkJpYRuJN0N-MIjnTtGNVaq8msPzgiE2TMnhQuWqkmO6m2idnJ5t6BfF8oA/w557-h640/Best%20WhatsApp%20Profile%20Pictures%20in%20the%20World%20%20Sweet%20Images%20For%20WhatsApp%20Profile%20DPz%20(41).jpg");
        user.setEnabled(userForm.isEnabled());
        user.setEmailVerified(userForm.isEmailVerified());
        user.setPhoneVerified(userForm.isPhoneVerified());
        user.setProvider(userForm.getProvider());
        user.setProviderUserId(userForm.getProviderUserId());

        User savedUser = userService.saveUser(user);
        System.out.println("User saved");

        // message = registration succcessful
        // add message:

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        //redirect to login page
        return "redirect:/register";
    }

}
