package com.travel.repo;

import org.springframework.stereotype.Repository;

import com.travel.model.Category;

@Repository
public class CategoryRepository extends BaseEntityRepository<Category>{

	@Override
	public Class<Category> getPersistentClass() {
		return Category.class;
	}

}
