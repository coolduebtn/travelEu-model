package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.travel.model.dto.CountryDto;
import com.travel.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<CountryDto> getCountriesList() {
		List<CountryDto> allCountries = countryService.getAllCountries();
		return allCountries;
	}

	@RequestMapping(value = "/country/{permalink}", method = RequestMethod.GET)
	public @ResponseBody
	CountryDto getCountryByName(@PathVariable String permalink) {
		return countryService.getCountryByPermalink(permalink);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	CountryDto getCountryById(@PathVariable long id) {
		return countryService.getCountryById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody CountryDto country) {
		return countryService.createCountry(country);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody CountryDto countryDto) {
		countryService.saveOrUpdate(countryDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		countryService.deleteCountry(id);
	}

}
