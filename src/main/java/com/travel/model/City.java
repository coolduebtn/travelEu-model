package com.travel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.common.collect.Sets;

@Entity(name = "City")
public class City extends AbstractBaseEntity {

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER,mappedBy="city")
	//@JoinColumn(name = "city_id", nullable = false)
	private Set<Attraction> attractions = Sets.newHashSet();

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

	public void addAttraction(Attraction todo) {
		getAttractions().add(todo);
	}

	public void removeAttraction(Attraction todo) {
		getAttractions().remove(todo);
	}

	 public Country getCountry() {
	 return country;
	 }
	
	 public void setCountry(Country country) {
	 this.country = country;
	 }

}
