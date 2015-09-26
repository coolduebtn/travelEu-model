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

public class CategoryRepositoryIntegrationTest extends AbstractRepositoryIntegrationTest{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private Category category;

	@Autowired
	private AttractionRepository attractionRepository;
	
	private City city;
	
	@Before
	public void init(){
		Country country = CountryTestBuilder.aCountry().buildAndPersist();
		city = CityTestBuilder.aCity().withCountry(country).buildAndPersist();
		category=CategoryTestBuilder.aCategory().buildAndPersist();
	}
	
	
	@Test
	public void persist(){
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void addAttractions(){
		Attraction attraction1 = createAttraction("eiffel");
		Attraction attraction2 = createAttraction("sacre coeur");
		category.setAttractions(Sets.newHashSet(attraction1,attraction2));
		Category byId = categoryRepository.getById(category.getId());
		assertThat(byId.getAttractions()).containsOnly(attraction1,attraction2);
	}
	
	public Attraction createAttraction(String name){
		
		Attraction attraction = AttractionTestBuilder.anAttraction().withName(name).build();
		attraction.setCity(city);
		attractionRepository.persist(attraction);
		return attraction;
	}

}
