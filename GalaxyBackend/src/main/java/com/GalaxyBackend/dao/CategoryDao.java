package com.GalaxyBackend.dao;

import java.util.List;

import com.GalaxyBackend.model.Category;

public interface CategoryDao 
{
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);

	public Category getCategory(int categoryId);
	public List<Category> listCategory();
}
