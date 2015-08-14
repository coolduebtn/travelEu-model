package com.travel.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Attraction extends AbstractBaseEntity {
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private String website;
	
	private String hours;
	
	private String travelInstructions;
	
	private Long siteRating;
	
	private String tips;
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="Attraction_Category", 
                joinColumns={@JoinColumn(name="attraction_id")}, 
                inverseJoinColumns={@JoinColumn(name="category_id")})
	private Set<Category> categories=newHashSet();

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getTravelInstructions() {
		return travelInstructions;
	}

	public void setTravelInstructions(String travelInstructions) {
		this.travelInstructions = travelInstructions;
	}


	public Long getSiteRating() {
		return siteRating;
	}

	public void setSiteRating(Long siteRating) {
		this.siteRating = siteRating;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

}
