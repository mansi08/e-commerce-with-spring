package com.Galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GalaxyBackend.dao.SupplierDao;
import com.GalaxyBackend.model.Supplier;

@Controller
public class SupplierController 
{

	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/Supplier")
	public String ShowSupplier(Model model)
	{
		model.addAttribute("UserClickedSupplier", "true");
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList",supplierDao.listSupplier());
		
		return "Supplier";
		
	}
	
	@PostMapping
	@RequestMapping(value="/SaveSupplier",method=RequestMethod.POST)
	public String SaveSupplier(@ModelAttribute("supplier")Supplier supplier)
	{
		supplierDao.addSupplier(supplier);
		
		return "redirect:/Supplier";
		
	}

	@RequestMapping(value="/editSupplier/{supplierID}")
	public String ClickedEdit(@PathVariable("supplierID") int supplierID,Model model)
	{
		model.addAttribute("UserClickedEdit", "true");
		model.addAttribute("supplier",supplierDao.getSupplier(supplierID) );
		model.addAttribute("supplierList",supplierDao.listSupplier());
		
		return "Supplier";//mapping issue Bhanoo
		
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String UpdateSupplier(@ModelAttribute("supplier")Supplier supplier)
	{
		supplierDao.updateSupplier(supplier);
		
		return "redirect:/Supplier";
		
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierID}")
	public String DeleteSupplier(@PathVariable("supplierID")int supplierID,Model model)
	{
		Supplier supplier=supplierDao.getSupplier(supplierID);
		supplierDao.deleteSupplier(supplierID);
		
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", supplierDao.listSupplier());
		return "redirect:/Supplier";
		
	}
}
