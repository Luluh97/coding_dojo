package com.luluh.auth.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luluh.auth.models.User;
import com.luluh.auth.models.Role;
import com.luluh.auth.services.UserService;
import com.luluh.auth.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    public Users(UserService userService,  UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
         List<User> users = userService.allUsers();
        if(users.size() == 0 ) {
	        userService.saveUserWithAdminRole(user); 
	        return "redirect:/";
        }
        else {
	        userService.saveWithUserRole(user);
	        return "redirect:/";

        }
    }
    
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "index.jsp";
    }
    
    
    @RequestMapping(value = "/")
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("currentUser",  user);
        
        List<Role> roles = user.getRoles();
		for( int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getName().equals("ROLE_ADMIN")) {
				List<User> users = userService.allUsers();
	        	users.remove(0);
	        	model.addAttribute("users", users);
	        	return "adminPage.jsp";
			}
		}  
        	return "homePage.jsp";        
    }
    
    
    @RequestMapping(value="/remove/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	userService.deleteUser(id);
        return "redirect:/";
    }
    
    @RequestMapping(value="/change/{id}")
    public String changeRole(@PathVariable("id") Long id) {
    	User user = userService.findUser(id);
    	 userService.changeUserWithAdminRole(user);
        return "redirect:/";
    }
     
}
































//package com.luluh.auth.controllers;
//
//import java.security.Principal;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.luluh.auth.models.User;
//import com.luluh.auth.services.UserService;
//import com.luluh.auth.validator.UserValidator;
//
//@Controller
//public class Users {
//    private UserService userService;
//    private UserValidator userValidator;
//    public Users(UserService userService,  UserValidator userValidator) {
//        this.userService = userService;
//        this.userValidator = userValidator;
//    }
//    
//    @RequestMapping("/registration")
//    public String registerForm(@Valid @ModelAttribute("user") User user) {
//        return "registrationPage.jsp";
//    }
//    
//    @PostMapping("/registration")
//    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
//        userValidator.validate(user, result);
//        if (result.hasErrors()) {
//            return "registrationPage.jsp";
//        }
//        
//        userService.saveWithUserRole(user);
//        return "redirect:/login";
//    }
//    
//    
//    @RequestMapping("/login")
//    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
//        if(error != null) {
//            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
//        }
//        if(logout != null) {
//            model.addAttribute("logoutMessage", "Logout Successful!");
//        }
//        return "loginPage.jsp";
//    }
//    
//    @RequestMapping(value = {"/", "/home"})
//    public String home(Principal principal, Model model) {
//        String username = principal.getName();
//        model.addAttribute("currentUser", userService.findByUsername(username));
//        return "homePage.jsp";
//    }
//    
//    
//}