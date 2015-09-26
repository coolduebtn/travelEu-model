package com.travel.model.dto;

import java.util.Set;

import com.google.common.collect.Sets;

public class AttractionDto extends AbstractDto{
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private String website;
	
	private String hours;
	
	private String travelInstructions;
	
	private Long siteRating;
	
	private String tips;
	
	private Set<CategoryDto> categories=Sets.newHashSet();

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

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}
	
}
