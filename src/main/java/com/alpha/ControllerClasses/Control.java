package com.alpha.ControllerClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alpha.EntityClasses.Ent;
import com.alpha.repository.Repo;

@Controller
public class Control {

    @Autowired
    private Repo repo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // Home Page
    @GetMapping("/homee")
    public String newHome() {
        System.out.println("In home page _______________________________");
        return "home";
    }
    
    // Login Page
    @GetMapping("/login")
    public String loginpage() {
        System.out.println("In login page _______________________________");
        return "loginpage";
    }
    
    // Signup Page
    @GetMapping("/signup")
    public String signuppage() {
        System.out.println("In signup page _______________________________");
        return "signup";
    }
    
    // Navigation Bar
    @GetMapping("/navbar")
    public String navbarpage() {
    	System.out.println("In navbar page _______________________________");
    	return "navbar";
    }
    
    
    // About Page
    @GetMapping("/about")
    public String aboutpage() {
        System.out.println("In about page _______________________________");
        return "About";
    }
    
    @GetMapping("/hello")
    public String hellopage() {
      //  System.out.println("In signup page _______________________________");
        return "hello";
    }

    // Handle Signup and store the entered value into database
    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmpassword,
            @RequestParam Integer eid,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) String dob,
            RedirectAttributes redirectAttributes) {

        // Basic validation for passwords
        if (!password.equals(confirmpassword)) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match.");
            return "redirect:/signup";
        }

        // Create and save new user
        Ent person = new Ent();
        person.setUsername(username);
        person.setPassword(passwordEncoder.encode(password));
        person.setConfirmpassword(confirmpassword);
        person.setEid(eid);
        if (address != null) person.setAddress(address);
        if (gender != null) person.setGender(gender);
        if (designation != null) person.setDesignation(designation);
        if (dob != null) person.setDob(dob);
        

        repo.save(person);

        System.out.println("____________________________________________________________________");
        System.out.println(person);

        return "redirect:/login"; // Redirect to login after signup
    }
}
