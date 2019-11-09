package com.luluh.ProductCategories.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.ProductCategories.models.Category;
import com.luluh.ProductCategories.models.Product;
import com.luluh.ProductCategories.repositories.catoRepo;

import java.util.List;

@Service
public class cato_service {
	private final catoRepo catoRepo;

	public cato_service(com.luluh.ProductCategories.repositories.catoRepo catoRepo) {
		super();
		this.catoRepo = catoRepo;
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) catoRepo.findAll();
	}
	    // creates 
	    public Category create_new (Category l) {
	        return catoRepo.save(l);
	    }
	    
	    public Category find_one (Long id) {
	        Optional<Category> optional_li = catoRepo.findById(id);
	        if(optional_li.isPresent()) {
	            return optional_li.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public void update (Product p , Category c) {
	    	List<Product> All = c.getProducts();
	    	All.add(p);
	    	c.setProducts(All);
	    	catoRepo.save(c);
	    }
}
