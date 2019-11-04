package com.luluh.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	 @RequestMapping("/")
	 public String index(HttpSession session) {
		 if(session.getAttribute("count") == null) {
	        	
	        	session.setAttribute("count", 0);
	        }
	        else {
	        	int count = (Integer) session.getAttribute("count");
	        	count ++;
	        	session.setAttribute("count", count);
	        }
		 
		 return "index.jsp";
	 }
	 
	 @RequestMapping("/counter")
	 public String counter(){
	        
	        return "counter.jsp";
	    }
	
}
