package com.travel.repo;

import static org.fest.assertions.Assertions.assertThat;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.builder.AttractionTestBuilder;
import com.travel.builder.CityTestBuilder;
import com.travel.builder.CountryTestBuilder;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.Attraction;

public class CityRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private SessionFactory sessionFactory;

	private Country country;

	private City city;

	@Before
	public void init() {
		country = CountryTestBuilder.aCountry().buildAndPersist();
		city = CityTestBuilder.aCity().build();
		//country.addCity(city);
		city.setCountry(country);
		cityRepository.persist(city);
	}
	
	@Test
	public void persistCity(){
		assertThat(city.getId()).isNotNull();
	}
	
	@Test
	public void deleteCity(){
		Long cityId = city.getId();
		cityRepository.delete(city);
		assertThat(cityRepository.getById(cityId)).isNull();
		assertThat(countryRepository.getById(country.getId()).getCities()).isEmpty();
	}
	
	@Test
	public void getCityByNameTest() {

		City byName = cityRepository.getByPermalink(city.getPermalink());
		assertThat(byName).isNotNull();
		assertThat(city).isEqualTo(byName);

	}

	@Test
	public void addAttraction() {

		Attraction aTodo = AttractionTestBuilder.anAttraction().build();
		city.addAttraction(aTodo);
		Long cityId = city.getId();
		City cityFromDb = cityRepository.getById(cityId);
		assertThat(cityFromDb.getAttractions()).containsOnly(aTodo);
	}

}
