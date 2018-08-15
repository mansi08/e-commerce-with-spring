package com.Galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GalaxyBackend.dao.CategoryDao;
import com.GalaxyBackend.model.Category;

@Controller
public class CategoryController 
{

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/Category")
	public String ShowCategory(Model model)
	{
		model.addAttribute("UserClickedCategory", "true");
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList",categoryDao.listCategory());
		
		return "Category";
		
		/*SRINIVAS SIR METHOD*/
		/*List<Category> listCategory=categoryDao.listCategory();
		model.addAttribute("categoryList", listCategory);
		return "Category";*/
	}
	
	@PostMapping
	@RequestMapping(value="/SaveCategory",method=RequestMethod.POST)
	public String SaveCategory(@ModelAttribute("category")Category category)
	{
		categoryDao.addCategory(category);
		
		return "redirect:/Category";
		
	}

	@RequestMapping(value="/editCategory/{categoryID}")
	public String ClickedEdit(@PathVariable("categoryID") int categoryID,Model model)
	{
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("category",categoryDao.getCategory(categoryID) );
		model.addAttribute("categoryList",categoryDao.listCategory());
		
		return "Category";//mapping issue Bhanoo
		
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String UpdateCategory(@ModelAttribute("category")Category category)
	{
		categoryDao.updateCategory(category);
		
		return "redirect:/Category";
		
	}
	
	@RequestMapping(value="/deleteCategory/{categoryID}")
	public String DeleteCategory(@PathVariable("categoryID")int categoryID,Model model)
	{
		Category category=categoryDao.getCategory(categoryID);
		categoryDao.deleteCategory(categoryID);
		
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryDao.listCategory());
		return "redirect:/Category";
		
	}
}
