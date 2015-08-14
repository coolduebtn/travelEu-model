package com.travel.builder;

import com.travel.model.Attraction;

public class AttractionTestBuilder extends AbstractTestBuilder<Attraction> {
	
	public static AttractionTestBuilder anAttraction() {
		return new AttractionTestBuilder();	
	}

	private String name ="attraction";
	private String description="description";
	
	public AttractionTestBuilder withName(String name) {
		this.name  = name;
		return this;
	}

	public AttractionTestBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	
	@Override
	public Attraction build() {
		Attraction attraction = new Attraction();
		attraction.setName(name);
		//attraction.setPermalink(Utils.generatePermalink(name));
		attraction.setDescription(description);
		return attraction;
	}
	

}
