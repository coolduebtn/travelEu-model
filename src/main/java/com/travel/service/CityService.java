package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travel.mapper.DtoMapper;
import com.travel.mapper.ModelMapper;
import com.travel.model.Attraction;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.dto.AttractionDto;
import com.travel.model.dto.CityDto;
import com.travel.repo.AttractionRepository;
import com.travel.repo.CityRepository;
import com.travel.utils.Utils;


@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DtoMapper dtoMapper; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AttractionRepository attractionRepository;

	@Transactional
	public CityDto getById(Long cityId) {
		return dtoMapper.toCityDto(cityRepository.getById(cityId));
	}

	@Transactional
	public void saveOrUpdate(CityDto cityDto) {
		City city = cityRepository.getById(cityDto.getId());
		modelMapper.toCity(cityDto, city);
		city.setPermalink(Utils.generatePermalink(city.getName()));
		cityRepository.saveOrUpdate(city);
	}

	@Transactional
	public CityDto getCityByPermalink(String permalink) {
		return dtoMapper.toCityDto(cityRepository.getByPermalink(permalink));
	}

	@Transactional
	public void addAttraction(AttractionDto attractionDto, Long cityId) {
		Attraction attraction =modelMapper.toAttraction(attractionDto,null);
		City city = cityRepository.getById(cityId);
		attraction.setCity(city);
		city.addAttraction(attraction);		
	}

	@Transactional
	public void removeAttraction(Long attractionId) {
		Attraction attraction = attractionRepository.getById(attractionId);
		City city = attraction.getCity();
		city.removeAttraction(attraction);		
	}

	
}
