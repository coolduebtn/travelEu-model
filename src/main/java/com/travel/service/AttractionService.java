package com.travel.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.travel.mapper.DtoMapper;
import com.travel.mapper.ModelMapper;
import com.travel.model.Attraction;
import com.travel.model.Category;
import com.travel.model.dto.AttractionDto;
import com.travel.model.dto.CategoryDto;
import com.travel.repo.AttractionRepository;
import com.travel.repo.CategoryRepository;
import com.travel.utils.Utils;

@Service
public class AttractionService {
	
	@Autowired
	private AttractionRepository attractionRepository;
	
	@Autowired
	private DtoMapper dtoMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public AttractionDto getById(Long attractionId) {
		return dtoMapper.toAttractionDto(attractionRepository.getById(attractionId));
	}

	@Transactional
	public void saveOrUpdate(AttractionDto attractionDto) {
		Attraction attraction = attractionRepository.getById(attractionDto.getId());
		modelMapper.toAttraction(attractionDto,attraction);
		Collection<Category> categories = Collections2.transform(attractionDto.getCategories(),new Function<CategoryDto, Category>() {

			@Override
			public Category apply(CategoryDto input) {
				return categoryRepository.getById(input.getId());
			}
		});
		attraction.setCategories(Sets.newHashSet(categories));
		attraction.setPermalink(Utils.generatePermalink(attraction.getName()));
		attractionRepository.saveOrUpdate(attraction);
	}

	@Transactional
	public AttractionDto getAttractionByPermalink(String permalink) {
		return dtoMapper.toAttractionDto(attractionRepository.getByPermalink(permalink));
	}

}
