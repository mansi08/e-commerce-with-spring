package com.GalaxyBackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GalaxyBackend.dao.CategoryDao;
import com.GalaxyBackend.model.Category;

public class CategoryDaoTest 
{
private static AnnotationConfigApplicationContext context=null;
private static CategoryDao categoryDao=null;
private Category c=null;

@BeforeClass
public static void setUpBeforeClass()throws Exception
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.GalaxyBackend");
	context.refresh();
	categoryDao=(CategoryDao)context.getBean("categoryDao");
}
@Ignore
@Test
public void testAddCategory()
{
	c=new Category();
	c.setCategoryId(1);
	c.setCategoryName("Levis");
	c.setCategoryDesc("Leather bag");
	System.out.println("Category details saved");
	assertTrue("Could not save Category details",categoryDao.addCategory(c));
}

@Ignore
@Test
public void testUpdateCategory()
{
	c=new Category();
	c.setCategoryId(1);
	c.setCategoryName("Puma");
	c.setCategoryDesc("Leather bag");
	System.out.println("Category details saved");
	assertTrue("Could not save Category details",categoryDao.updateCategory(c));
}

@Ignore
@Test
public void testDeleteCategory()
{
	assertTrue("Could not delete Category Details",categoryDao.deleteCategory(1));
}

@Ignore
@Test
public void testGetCategoryById()
{
	fail("yet not implemented");
}

@Ignore
@Test
public void testListCategory()
{
	List<Category> listCategory= categoryDao.listCategory();
	assertNotNull("Problem in retrieving", listCategory);
}
}
