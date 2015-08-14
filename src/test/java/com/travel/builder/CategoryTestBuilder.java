package com.travel.builder;

import com.travel.model.Category;

public class CategoryTestBuilder extends AbstractTestBuilder<Category> {
	
	private String name;
	
	public static CategoryTestBuilder aCategory(){
		return new CategoryTestBuilder();
	}
	
	public CategoryTestBuilder withName(String name) {
		this.name  = name;
		return this;
	}

	@Override
	public Category build() {
		Category category=new Category();
		category.setName(name);
		return category;
	}

}
