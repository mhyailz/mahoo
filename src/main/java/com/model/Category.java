package com.model;

import java.util.List;

public class Category {

	public Long id;
	
	public String name;
	
	public Long parentCategoryId;
	
	public List<Category> secondCategoryList;

	
	
	/****************get set *******************/
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public List<Category> getSecondCategoryList() {
		return secondCategoryList;
	}

	public void setSecondCategoryList(List<Category> secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}


	
}
