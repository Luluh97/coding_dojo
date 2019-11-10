package com.luluh.Countries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String code;
    private String name;
    private String continent;
    private String region;
    private Double surface_area;
    private Short population;
    private Double life_expectancy;
    private Double gnp;
    private Double gnp_old;
    private String local_name;
    private String government_form;
    private Integer capital;
    private String head_of_state;
    private String code2;
    
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;
    private List<City> cities;
    
    public List<Language> getLanguage() {
		return languages;
	}

	public void setLanguage(List<Language> languages) {
		this.languages = languages;
	}
	
	
	public List<City> getCity() {
		return cities;
	}

	public void setCity(List<City> cities) {
		this.cities = cities;
	}
    
    public Country() {}
   
	public Country( String code,
     String name,
     String continent,
     String region,
     Double surface_area,
     Short population,
     Double life_expectancy,
     Double gnp,
     Double gnp_old,
     String local_name,
     String government_form,
      String head_of_state,

     Integer capital, 
     String code2) {
	
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.capital = capital;
		this.code2 = code2;
	    this.head_of_state=head_of_state;


	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	public Double getSurfaceArea() {
		return surface_area;
	}

	public void setSurfaceArea(Double surface_area) {
		this.surface_area = surface_area;
	}
	
	public Short getPopulation() {
		return population;
	}

	public void setPopulation(Short population) {
		this.population = population;
	}
	
	public Double getLifeExpectancy() {
		return life_expectancy;
	}

	public void setLifeExpectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	
	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	
	public Double getGnpOld() {
		return gnp_old;
	}

	public void setGnpOld(Double gnp_old) {
		this.gnp_old = gnp_old;
	}
	
	public String getLocalName() {
		return local_name;
	}

	public void setLocalName(String local_name) {
		this.local_name = local_name;
	}
	
	public String getGovernmentForm() {
		return government_form;
	}

	public void setGovernmentForm(String government_form) {
		this.government_form = government_form;
	}

	public String getHeadState() {
		return head_of_state;
	}

	public void setHeadState(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	
	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	
	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
