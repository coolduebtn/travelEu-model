package com.travel.repo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.builder.CityTestBuilder;
import com.travel.builder.CountryTestBuilder;
import com.travel.model.City;
import com.travel.model.Country;

public class CountryRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {

	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void persistCountryTest() {
		Country country = CountryTestBuilder.aCountry().build();
		countryRepository.persist(country);
		assertThat(country.getId()).isNotNull();
	}

	@Test
	public void addCityTest() {
		Country belgium = CountryTestBuilder.aCountry().buildAndPersist();

		City brussels = CityTestBuilder.aCity().build();
		belgium.addCity(brussels);

		Country fromdb = countryRepository.getById(belgium.getId());
		assertThat(fromdb.getCities()).containsOnly(brussels);

	}

	@Test
	public void deleteCityTest() {
		Country belgium = CountryTestBuilder.aCountry().buildAndPersist();

		City brussels = CityTestBuilder.aCity().build();
		belgium.addCity(brussels);

		City brugges = CityTestBuilder.aCity().withName("brugges").build();
		belgium.addCity(brugges);

		Country fromdb = countryRepository.getById(belgium.getId());
		assertThat(fromdb.getCities()).containsOnly(brussels, brugges);

		fromdb.removeCity(brugges);

		Country fromdb2 = countryRepository.getById(belgium.getId());
		assertThat(fromdb2.getCities()).containsOnly(brussels);

	}

	@Test
	public void getCountryByNameTest() {
		Country belgium = CountryTestBuilder.aCountry().buildAndPersist();

		assertThat(belgium.getId()).isNotNull();

		Country byName = countryRepository.getByPermalink(belgium.getPermalink());
		assertThat(byName).isNotNull();
		assertThat(belgium).isEqualTo(byName);

	}

}
