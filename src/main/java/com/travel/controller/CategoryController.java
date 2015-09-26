package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.model.dto.CategoryDto;
import com.travel.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService countryService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<CategoryDto> getCountriesList() {
		return countryService.getCategories();
	}

}
