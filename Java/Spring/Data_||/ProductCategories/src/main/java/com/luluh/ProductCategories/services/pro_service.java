package com.luluh.ProductCategories.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.ProductCategories.models.Category;
import com.luluh.ProductCategories.models.Product;
import com.luluh.ProductCategories.repositories.proRepo;

import java.util.List;

@Service
public class pro_service {

	private final proRepo proRepo;

	public pro_service(com.luluh.ProductCategories.repositories.proRepo proRepo) {
		super();
		this.proRepo = proRepo;
	}
	
	public ArrayList<Product> all(){
		return (ArrayList<Product>) proRepo.findAll();
	}
	    // creates 
	    public Product create_new (Product l) {
	        return proRepo.save(l);
	    }
	    
	    public Product find_one (Long id) {
	        Optional<Product> optional_li = proRepo.findById(id);
	        if(optional_li.isPresent()) {
	            return optional_li.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public void update (Product p , Category c) {
	    	List<Category> All = p.getCategories();
	    	All.add(c);
	    	p.setCategories(All);
	    	proRepo.save(p);
	    }
}

