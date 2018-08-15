package com.Galaxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{

	@RequestMapping(value= {"/","Home","index"})
	public String home()
	{
		return "index";
	}
	
	@RequestMapping(value= "/AboutUs")
	public String aboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping(value= "/ContactUs")
	public String contactUs()
	{
		return "ContactUs";
	}
}
