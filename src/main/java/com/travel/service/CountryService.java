package com.travel.service;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.travel.mapper.DtoMapper;
import com.travel.mapper.ModelMapper;
import com.travel.model.City;
import com.travel.model.Country;
import com.travel.model.dto.CityDto;
import com.travel.model.dto.CountryDto;
import com.travel.repo.CityRepository;
import com.travel.repo.CountryRepository;
import com.travel.utils.Utils;

@Service
public class CountryService {
	
	@Autowired
	private DtoMapper dtoMapper;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;

	@Transactional
	public List<CountryDto> getAllCountries() {
		return newArrayList(transform(countryRepository.getAll(), new Function<Country,CountryDto>() {
			@Override
			public CountryDto apply(Country country) {
				return dtoMapper.toCountryDto(country);
			}
		}));
		
	}

	
	@Transactional
	public CountryDto getCountryByPermalink(String permalink) {
		return dtoMapper.toCountryDto(countryRepository.getByPermalink(permalink));
	}

	@Transactional
	public CountryDto getCountryById(long id) {
		return dtoMapper.toCountryDto(countryRepository.getById(id));
	}

	@Transactional
	public Long createCountry(CountryDto countryDto) {
		return countryRepository.persist(modelMapper.toCountry(countryDto,null));
	}

	@Transactional
	public void saveOrUpdate(CountryDto countryDto) {
		Country country = countryRepository.getById(countryDto.getId());
		modelMapper.toCountry(countryDto,country);
		country.setPermalink(Utils.generatePermalink(country.getName()));
		countryRepository.saveOrUpdate(country);
	}

	@Transactional
	public void deleteCountry(Long id) {
		Country countryToBeDeleted = countryRepository.getById(id);
		countryRepository.delete(countryToBeDeleted);
	}


	@Transactional
	public void addCity(CityDto cityDto, Long countryId) {
		Country country = countryRepository.getById(countryId);
		City city = modelMapper.toCity(cityDto,null);
		city.setCountry(country);
		country.addCity(city);
	}

	@Transactional
	public void removeCity(Long cityId) {
		City city = cityRepository.getById(cityId);
		Country country = city.getCountry();
		country.removeCity(city);
	}
	

}
