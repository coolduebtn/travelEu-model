package com.travel.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.Sets;
import com.travel.utils.Utils;

@Entity(name = "Category")
public class Category implements BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String permalink;
	
    @ManyToMany(mappedBy="categories")
    private Set<Attraction> attractions = Sets.newHashSet();
    
    public Category() {
		// TODO Auto-generated constructor stub
	}
    
    public Category(String name) {
		setName(name);
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.setPermalink(Utils.generatePermalink(name));
	}
	

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}
	
	

}
