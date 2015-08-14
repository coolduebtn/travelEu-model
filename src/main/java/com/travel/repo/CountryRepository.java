package com.travel.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.travel.model.Country;

@Repository
public class CountryRepository extends BaseEntityRepository<Country> {

	@Override
	public Class<Country> getPersistentClass() {
		return Country.class;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAll() {
		return (List<Country>) session().createCriteria(getPersistentClass())
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}


}
