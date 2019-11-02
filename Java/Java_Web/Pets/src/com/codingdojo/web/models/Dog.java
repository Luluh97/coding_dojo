package com.codingdojo.web.models;

public class Dog extends Animal implements Pet {
	
	public Dog(String name, String breed, int weight) {
		super(name,breed,weight);
	}
	
	public Dog() {
		
	}
	
	public String showAffection() {
		if(getWeight() < 30) {
			return getName()+" hops on your lap";
		}
		
		else {
			return getName()+" curls up next to you";
		}
	}

}
