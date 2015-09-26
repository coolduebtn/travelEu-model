package com.travel.service;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.travel.mapper.DtoMapper;
import com.travel.model.Category;
import com.travel.model.dto.CategoryDto;
import com.travel.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private DtoMapper dtoMapper; 
	
	@Transactional(readOnly=true)
	public List<CategoryDto> getCategories(){
		return newArrayList(transform(categoryRepository.getAll(), new Function<Category,CategoryDto>() {
			@Override
			public CategoryDto apply(Category category) {
				return dtoMapper.toCategoryDto(category);
			}
		}));
	}

}
