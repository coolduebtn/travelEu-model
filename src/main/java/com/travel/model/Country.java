package com.travel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.google.common.collect.Sets;

@Entity(name = "Country")
public class Country extends AbstractBaseEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER,mappedBy="country")
	//@JoinColumn(name = "country_id", nullable = false)
	private Set<City> cities = Sets.newHashSet();

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public void addCity(City city) {
		city.setPermalink(city.getName());
		getCities().add(city);
	}

	public void removeCity(City city) {
		getCities().remove(city);

	}

}
