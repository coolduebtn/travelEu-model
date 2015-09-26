package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.travel.model.dto.CityDto;
import com.travel.service.CityService;
import com.travel.service.CountryService;

@Controller
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService cityService;

	@Autowired
	public CountryService countryService;

	@RequestMapping(value = "/{cityId}", method = RequestMethod.GET)
	public @ResponseBody
	CityDto getCityById(@PathVariable("cityId") Long cityId) {
		return cityService.getById(cityId);
	}

	@RequestMapping(value = "/{cityId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("cityId") Long cityId,
			@RequestBody CityDto cityDto) {
		cityService.saveOrUpdate(cityDto);
	}
	
	@RequestMapping(value = "/city/{permalink}", method = RequestMethod.GET)
	public @ResponseBody
	CityDto getCityByName(@PathVariable String permalink) {
		return cityService.getCityByPermalink(permalink);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		countryService.removeCity(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody CityDto cityDto,
			@RequestParam(value = "countryId", required = true) Long countryId) {
		countryService.addCity(cityDto,countryId);
	}

}
