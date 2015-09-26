package com.travel.mapper;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.travel.model.Attraction;
import com.travel.model.Category;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.dto.AttractionDto;
import com.travel.model.dto.CategoryDto;
import com.travel.model.dto.CityDto;
import com.travel.model.dto.CountryDto;

@Component
public class ModelMapper {
	
	public Country toCountry(CountryDto countryDto, Country country){
		if(country==null){
			country=new Country();
		}
		country.setName(countryDto.getName());
		country.setDescription(countryDto.getDescription());
		return country;
	}
	
	public City toCity(CityDto cityDto, City city){
		if(city==null){
			city=new City();
		}
		city.setName(cityDto.getName());
		city.setDescription(cityDto.getDescription());
		return city;
	}

	public Attraction toAttraction(AttractionDto attractionDto, Attraction attraction) {
		if(attraction==null){
			attraction=new Attraction();
		}
		attraction.setName(attractionDto.getName());
		attraction.setDescription(attractionDto.getDescription());
		attraction.setAddress(attractionDto.getAddress());
		attraction.setEmail(attractionDto.getEmail());
		attraction.setHours(attractionDto.getHours());
		attraction.setPhone(attractionDto.getPhone());
		attraction.setSiteRating(attractionDto.getSiteRating());
		attraction.setTips(attractionDto.getTips());
		attraction.setTravelInstructions(attractionDto.getTravelInstructions());
		attraction.setWebsite(attractionDto.getWebsite());
		
		
		return attraction;
	}
}
