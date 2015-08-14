package com.travel.repo;

import org.springframework.stereotype.Repository;

import com.travel.model.City;

@Repository
public class CityRepository extends BaseEntityRepository<City> {

	@Override
	public Class<City> getPersistentClass() {
		return City.class;
	}
	
}
