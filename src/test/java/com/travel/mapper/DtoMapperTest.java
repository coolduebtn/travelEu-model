package com.travel.mapper;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.ReflectionTestUtils;
import com.travel.builder.AttractionTestBuilder;
import com.travel.builder.CityTestBuilder;
import com.travel.builder.CountryTestBuilder;
import com.travel.model.Attraction;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.dto.AttractionDto;
import com.travel.model.dto.CityDto;
import com.travel.model.dto.CountryDto;
import com.travel.repo.AbstractRepositoryIntegrationTest;

public class DtoMapperTest extends AbstractRepositoryIntegrationTest{
	
	@Autowired
	private DtoMapper dtoMapper;
	
	
	@Test
	public void toAttractionDtoMapperTest(){
		Attraction attraction=AttractionTestBuilder.anAttraction().build();
		ReflectionTestUtils.setField(attraction, "id", 1l);
		AttractionDto attractionDto = dtoMapper.toAttractionDto(attraction);
		assertThat(attractionDto).isNotNull();
		assertThat(attractionDto.getName()).isEqualTo(attraction.getName());
		assertThat(attractionDto.getDescription()).isEqualTo(attraction.getDescription());
	}
	
	@Test
	public void toCityDtoMapperTest(){
		Attraction attraction=AttractionTestBuilder.anAttraction().build();
		ReflectionTestUtils.setField(attraction, "id", 1l);
		City city=CityTestBuilder.aCity().build();
		ReflectionTestUtils.setField(city, "id", 2l);
		city.addAttraction(attraction);
		CityDto cityDto = dtoMapper.toCityDto(city);
		assertThat(cityDto).isNotNull();
		assertThat(cityDto.getName()).isEqualTo(city.getName());
		assertThat(cityDto.getDescription()).isEqualTo(city.getDescription());
		assertThat(cityDto.getAttractions().size()).isEqualTo(1);
		AttractionDto attract = cityDto.getAttractions().iterator().next();
		assertThat(attract.getName()).isEqualTo(attraction.getName());
	}
	
	@Test
	public void toCountryDtoMapperTest(){
		City city=CityTestBuilder.aCity().build();
		ReflectionTestUtils.setField(city, "id", 2l);
		
		Country country=CountryTestBuilder.aCountry().build();
		ReflectionTestUtils.setField(country, "id", 1l);
		country.addCity(city);
		CountryDto countryDto = dtoMapper.toCountryDto(country);
		assertThat(countryDto).isNotNull();
		assertThat(countryDto.getName()).isEqualTo(country.getName());
		assertThat(countryDto.getDescription()).isEqualTo(country.getDescription());
		
		assertThat(countryDto.getCities().size()).isEqualTo(1);
		CityDto mappedcity = countryDto.getCities().iterator().next();
		assertThat(mappedcity.getName()).isEqualTo(city.getName());
	}
 
}
