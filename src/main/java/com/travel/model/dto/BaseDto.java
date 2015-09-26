package com.travel.model.dto;

public abstract class BaseDto {
	
	private Long id;

	private String name;
	
	private String permalink;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}


}
