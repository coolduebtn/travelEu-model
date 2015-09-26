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

import com.travel.model.dto.AttractionDto;
import com.travel.service.AttractionService;
import com.travel.service.CityService;

@Controller
@RequestMapping("/attractions")
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	AttractionDto getAttractionById(@PathVariable("id") Long id) {
		return attractionService.getById(id);
	}

	@RequestMapping(value = "/{attractionId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("attractionId") Long attractionId,
			@RequestBody AttractionDto attractionDto) {
		attractionService.saveOrUpdate(attractionDto);
	}
	
	@RequestMapping(value = "/attraction/{permalink}", method = RequestMethod.GET)
	public @ResponseBody
	AttractionDto getAttractionByName(@PathVariable String permalink) {
		return attractionService.getAttractionByPermalink(permalink);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		cityService.removeAttraction(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody AttractionDto attractionDto,
			@RequestParam(value = "cityId", required = true) Long cityId) {
		cityService.addAttraction(attractionDto,cityId);
	}

}
