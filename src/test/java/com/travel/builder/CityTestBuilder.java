package com.travel.builder;

import com.travel.model.Attraction;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.utils.Utils;

public class CityTestBuilder extends AbstractTestBuilder<City> {

	private String name = "brussels";

	private String description = "heart of eu";

	private Country country;
	

	public static CityTestBuilder aCity() {
		return new CityTestBuilder();
	}

	public CityTestBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CityTestBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public CityTestBuilder withCountry(Country country) {
		this.country=country;
		return this;
	}
	
	@Override
	public City build() {
		City city = new City();
		city.setName(name);
		city.setDescription(description);
		city.setCountry(country);
		return city;
	}

}
