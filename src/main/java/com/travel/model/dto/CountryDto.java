package com.travel.model.dto;

import java.util.Set;

import com.google.common.collect.Sets;

public class CountryDto extends AbstractDto{
	
	private Set<CityDto> cities = Sets.newHashSet();

	public Set<CityDto> getCities() {
		return cities;
	}

	public void setCities(Set<CityDto> cities) {
		this.cities = cities;
	}
	
	

}
