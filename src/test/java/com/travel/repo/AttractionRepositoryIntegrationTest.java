package com.travel.repo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Sets;
import com.travel.builder.AttractionTestBuilder;
import com.travel.builder.CategoryTestBuilder;
import com.travel.builder.CityTestBuilder;
import com.travel.builder.CountryTestBuilder;
import com.travel.model.Attraction;
import com.travel.model.Category;
import com.travel.model.City;
import com.travel.model.Country;

public class AttractionRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {
	
	@Autowired
	private AttractionRepository attractionRepository;
	
	private City city;
	
	private Attraction attraction;
	
	@Before
	public void init() {
		Country country = CountryTestBuilder.aCountry().buildAndPersist();
		attraction = AttractionTestBuilder.anAttraction().build();
		city = CityTestBuilder.aCity().withCountry(country).buildAndPersist();
		attraction.setCity(city);
		attractionRepository.persist(attraction);
	}
	
	
	@Test
	public void persistAttraction(){
		assertThat(attraction.getId()).isNotNull();
	}
	
	
	@Test
	public void getAttractionByLink(){
		
		Attraction attractionByPermalink = attractionRepository.getByPermalink(attraction.getName());
		assertThat(attractionByPermalink).isNotNull();
		assertThat(attractionByPermalink).isEqualTo(attraction);
		
	}
	
	@Test
	public void addCategories(){
		//Attraction attraction = AttractionTestBuilder.anAttraction().build();
		Category category1 = CategoryTestBuilder.aCategory().withName("monument").build();
		Category category2 = CategoryTestBuilder.aCategory().withName("park").build();
		attraction.setCategories(Sets.newHashSet(category1,category2));
		//Long id = attractionRepository.persist(attraction);
		Attraction fromDb = attractionRepository.getById(attraction.getId());
		assertThat(fromDb.getCategories()).containsOnly(category1,category2);
		
	}

}
