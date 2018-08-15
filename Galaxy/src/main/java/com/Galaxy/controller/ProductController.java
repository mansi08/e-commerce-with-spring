package com.Galaxy.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GalaxyBackend.dao.CategoryDao;
import com.GalaxyBackend.dao.ProductDao;
import com.GalaxyBackend.dao.SupplierDao;
import com.GalaxyBackend.model.Product;

@Controller
public class ProductController 
{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/Product")
	public String ShowProduct(Model model)
	{
		model.addAttribute("UserClickedProduct", "true");
		model.addAttribute("product", new Product());
		model.addAttribute("productList", productDao.listProducts());
		model.addAttribute("url","SaveProduct");
		model.addAttribute("categoryList" , categoryDao.listCategory());
		model.addAttribute("supplierList", supplierDao.listSupplier() );
		
		return "Product"; //jsp page returned
	}
	
	@RequestMapping("/ProductDisplay")
	public String DisplayAllProducts(Model model)
	{
		model.addAttribute("productList", productDao.listProducts());
		return "ProductDisplay"; //another jsp page of name ProductDisplay
		
	}
	
	@RequestMapping("/totalProductInfo/{productID}")
	public String ShowTotalProductDisplay(@PathVariable ("productID") int productID, Model model)
	{
		Product product=productDao.getProduct(productID);
		model.addAttribute("product", product);
		model.addAttribute("categoryname", categoryDao.getCategory(product.getCategoryId()).getCategoryName());
		return "ProductsTotalInfo"; //another jsp page of name TotalProductInfo
	}
	
	@PostMapping
	@RequestMapping(value="/SaveProduct", method=RequestMethod.POST)
	public String SaveProduct(@ModelAttribute("product")Product product)
	{
				
		if(product.getFile().isEmpty())
		{
			return "redirect:/Product"; //to 1st url request mapping
		}
		
		try 
		{
		byte bytes[]=product.getFile().getBytes();
		String dir="C:\\Users\\Mansi Gupta\\eclipse-workspace\\Galaxy\\src\\main\\webapp\\assests\\images\\product\\";
		Path path=Paths.get(dir+product.getCode()+".jpg");
		Files.write(path,bytes);
		}
		
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
	productDao.addProduct(product);	
	
	return "redirect:/Product"; //redirected to ShowProduct()'s url
	}
	
	@RequestMapping(value="/editProduct/{productID}")
	public String ClickedEdit(@PathVariable("productID") int productID, Model model)
	{
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("product", productDao.getProduct(productID));
		model.addAttribute("url","UpdateProduct");
		model.addAttribute("productList", productDao.listProducts());
		
		return "Product"; //jsp page
	}
	
	@RequestMapping(value="/UpdateProduct", method=RequestMethod.POST)
	public String UpdateProduct(@ModelAttribute("product")Product product)
	{
	productDao.updateProduct(product);	
	
	return "redirect:/Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productID}")
	public String DeleteProduct(@PathVariable("productID") int productID, Model model)
	{
		Product product=productDao.getProduct(productID);
		productDao.deleteProduct(productID);
		
		model.addAttribute("product", new Product());
		model.addAttribute("productList", productDao.listProducts());
		
		return "redirect:/Product";
	}
}
