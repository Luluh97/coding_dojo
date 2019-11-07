package com.luluh.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {

   @RequestMapping("/m/{d}")
   public String show1(@PathVariable("d") String d){
    	return "The "+d+" is awesome!"; 
    }
   
   @RequestMapping("/n/{b}")
   public String show2(@PathVariable("b") String b){
    	return b+" is located in Southern California"; 
    }
   
   @RequestMapping("/b/{s}")
   public String show3(@PathVariable("s") String s){
    	return s+" dojo is the headquarters"; 
    }
}
