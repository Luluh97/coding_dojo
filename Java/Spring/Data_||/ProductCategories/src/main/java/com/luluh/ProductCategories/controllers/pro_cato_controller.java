package com.luluh.ProductCategories.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luluh.ProductCategories.models.Category;
import com.luluh.ProductCategories.models.Product;
import com.luluh.ProductCategories.services.cato_service;
import com.luluh.ProductCategories.services.pro_service;
@Controller
public class pro_cato_controller {

	private final cato_service c_service;
	private final pro_service p_service;
	public pro_cato_controller(cato_service c_service, pro_service p_service) {
		super();
		this.c_service = c_service;
		this.p_service = p_service;
	}
	
	@RequestMapping("products/new")
	public String showForm(@ModelAttribute("product") Product product) {
		return "new_pro.jsp";
	}
	 
	 @RequestMapping(value="/products/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("product") Product product , BindingResult result) {
	        if (result.hasErrors()) {
	            return "new_pro.jsp";
	        } else {
	        	p_service.create_new(product);
	            return "redirect:/products/new";
	        }
	    }
	 
	 @RequestMapping("products/{id}")
		public String showPerson(@PathVariable Long id, Model model) {
		 Product p = p_service.find_one(id);
			if(p == null) {
				return "redirect:/products/new";
			}
			model.addAttribute("product",p);
			model.addAttribute("cato" , p.getCategories());
			List <Category> c =p.getCategories();
			List <Category> Allc =c_service.all();
			for(int i=0; i < c.size(); i++) {
				if(Allc.contains(c.get(i))) {
					Allc.remove(c.get(i));
				}
			}
			model.addAttribute("Allc",Allc);
			return "show_pro.jsp";
		}
	 
	 @RequestMapping("catos/new")
		public String newninja (@ModelAttribute("categories") Category categories) {
			return "new_cato.jsp";
		}
		 
		 @RequestMapping(value="/catos/new", method=RequestMethod.POST)
		    public String create(@Valid @ModelAttribute("categories") Category categories , BindingResult result) {
		        if (result.hasErrors()) {
		            return "new_cato.jsp";
		        } else {
		        	c_service.create_new(categories);
		            return "redirect:/catos/new";
		        }
		    }
		 @RequestMapping("catos/{id}")
			public String show_cato(@PathVariable Long id, Model model) {
			 Category c = c_service.find_one(id);
				if(c == null) {
					return "redirect:/catos/new";
				}
				model.addAttribute("cato",c);
				model.addAttribute("products" , c.getProducts());
				List <Product> p =c.getProducts();
				List <Product> Allp =p_service.all();
				for(int i=0; i < p.size(); i++) {
					if(Allp.contains(p.get(i))) {
						Allp.remove(p.get(i));
					}
				}
				model.addAttribute("Allp",Allp);
				return "show_cato.jsp";
			}
		 @RequestMapping(value="/addc", method=RequestMethod.POST)
		 public String addCat(@RequestParam("newCategory") Long cat_id, @RequestParam("product") Long prod_id, Model model) {
			 
				Category c = c_service.find_one(cat_id);
				Product p = p_service.find_one(prod_id);
				
				p_service.update(p, c);
				
				return "redirect:/products/" + prod_id;
			}
		 
		 @RequestMapping(value="/addp", method=RequestMethod.POST)
		 public String addpro(@RequestParam("newPro") Long prod_id, @RequestParam("cato") Long cat_id, Model model) {
			 
				Category c = c_service.find_one(cat_id);
				Product p = p_service.find_one(prod_id);
				
				c_service.update(p, c);
				
				return "redirect:/catos/" + cat_id;
			}
}

