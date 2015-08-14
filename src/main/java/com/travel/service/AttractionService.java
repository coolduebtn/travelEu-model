package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travel.mapper.DtoMapper;
import com.travel.mapper.ModelMapper;
import com.travel.model.Attraction;
import com.travel.model.dto.AttractionDto;
import com.travel.repo.AttractionRepository;
import com.travel.utils.Utils;

@Service
public class AttractionService {
	
	@Autowired
	private AttractionRepository attractionRepository;
	
	@Autowired
	private DtoMapper dtoMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public AttractionDto getById(Long attractionId) {
		return dtoMapper.toAttractionDto(attractionRepository.getById(attractionId));
	}

	@Transactional
	public void saveOrUpdate(AttractionDto attractionDto) {
		Attraction attraction = attractionRepository.getById(attractionDto.getId());
		modelMapper.toAttraction(attractionDto,attraction);
		attraction.setPermalink(Utils.generatePermalink(attraction.getName()));
		attractionRepository.saveOrUpdate(attraction);
	}

	@Transactional
	public AttractionDto getAttractionByPermalink(String permalink) {
		return dtoMapper.toAttractionDto(attractionRepository.getByPermalink(permalink));
	}

}
