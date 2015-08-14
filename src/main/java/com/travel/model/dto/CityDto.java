package com.travel.model.dto;

import java.util.Set;

import com.google.common.collect.Sets;

public class CityDto extends AbstractDto{
	
	private Set<AttractionDto> attractions = Sets.newHashSet();

	public Set<AttractionDto> getAttractions() {
		return attractions;
	}

	public void setAttractions(Set<AttractionDto> attractions) {
		this.attractions = attractions;
	}
	
	

}
