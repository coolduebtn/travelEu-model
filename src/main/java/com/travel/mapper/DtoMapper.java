package com.travel.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.travel.model.Attraction;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.dto.AttractionDto;
import com.travel.model.dto.CityDto;
import com.travel.model.dto.CountryDto;

@Component
public class DtoMapper {
	
	private Mapper mapper = new DozerBeanMapper();
	
	public AttractionDto toAttractionDto(Attraction attraction){
		return mapper.map(attraction, AttractionDto.class);
	}
	
	public CityDto toCityDto(City city){
		return mapper.map(city, CityDto.class);
	}
	
	public CountryDto toCountryDto(Country country){
		return mapper.map(country, CountryDto.class);
	}

}
