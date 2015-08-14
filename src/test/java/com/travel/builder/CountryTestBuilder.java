package com.travel.builder;

import com.travel.model.City;
import com.travel.model.Country;
import com.travel.utils.Utils;

public class CountryTestBuilder extends AbstractTestBuilder<Country> {

	private String name = "Belgium";

	private String description = "cockpit of europe";

	private City[] cities = null;

	public static CountryTestBuilder aCountry() {
		return new CountryTestBuilder();
	}

	public CountryTestBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CountryTestBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public CountryTestBuilder withCity(City... cities) {
		this.cities = cities;
		return this;
	}

	@Override
	public Country build() {
		Country country = new Country();
		country.setName(name);
		country.setDescription(description);

		if (cities != null) {
			for (City city : cities) {
				country.addCity(city);
			}
		}
		return country;
	}

}
