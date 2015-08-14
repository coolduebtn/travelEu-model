package com.travel.repo;

import org.springframework.stereotype.Repository;

import com.travel.model.Attraction;

@Repository
public class AttractionRepository extends BaseEntityRepository<Attraction> {

	@Override
	public Class<Attraction> getPersistentClass() {
		return Attraction.class;
	}
	
}
