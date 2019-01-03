package com.bosch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.mapper.CategoryMapper;
import com.bosch.pojo.Category;
import com.bosch.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	
	public List<Category> list(){

		return categoryMapper.list();
	};

}
