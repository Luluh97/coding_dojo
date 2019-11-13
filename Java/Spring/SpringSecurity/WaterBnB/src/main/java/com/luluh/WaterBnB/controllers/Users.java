package com.luluh.WaterBnB.controllers;

import java.security.Principal;
import java.util.ArrayList;
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

import com.luluh.WaterBnB.models.Pool;
import com.luluh.WaterBnB.models.Review;
import com.luluh.WaterBnB.models.Role;
import com.luluh.WaterBnB.models.User;
import com.luluh.WaterBnB.services.UserService;
import com.luluh.WaterBnB.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    private static ArrayList<String> sizes;
    private static ArrayList<String> rates;
    public Users(UserService userService,  UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
        sizes = new ArrayList<>();
        sizes.add("Small");
        sizes.add("Medium");
        sizes.add("Large");
        rates = new ArrayList<>();
        rates.add("1");
        rates.add("2");
        rates.add("3");
        rates.add("4");
        rates.add("5");
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
	        return "redirect:/dashboard";
        }
        else {
	        userService.saveWithUserRole(user);
	        return "redirect:/dashboard";

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
    public String home(@Valid @ModelAttribute("pool") Pool pool, Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("currentUser",  user);
        List<Pool> pools = userService.allPools();
		model.addAttribute("pools", pools);
        List<Role> roles = user.getRoles();
		for( int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getName().equals("ROLE_ADMIN")) {				
	        	model.addAttribute("sizes", sizes);	        	
	        	return "hostPage.jsp";
			}
		}  
        	return "guestPage.jsp";        
    }
    
    @PostMapping(value="/pools")
    public String create(@Valid @ModelAttribute("pool") Pool pool, BindingResult result) {
        if (result.hasErrors()) {
            return "/hostPage.jsp";
        } else {
        	userService.createPool(pool);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/host/pools/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Pool pool = userService.findPool(id);
        model.addAttribute("sizes", sizes);
        model.addAttribute("pool", pool);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/edit/{id}")
    public String update(@Valid @ModelAttribute("pool") Pool pool, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
        	userService.updatePool(pool);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/review/{id}")
    public String review(@Valid @ModelAttribute("review") Review review, @PathVariable("id") Long id, Model model) {
        Pool pool = userService.findPool(id);
        model.addAttribute("pool", pool);
        model.addAttribute("rates", rates);
        return "/review.jsp";
    }
    
    
    @RequestMapping("/pools/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Pool pool = userService.findPool(id);
        List<Review> reviews = userService.allReviews();
		model.addAttribute("reviews", reviews);
        model.addAttribute("pool", pool);
        return "/show.jsp";
    }

    @PostMapping("/reviews")
    public String createReview(@Valid @ModelAttribute("review") Review review, BindingResult result) {
        if (result.hasErrors()) {
            return "/guestPage.jsp";
        } else {
        	userService.createReview(review);
            return "redirect:/";
        }
    }
}
