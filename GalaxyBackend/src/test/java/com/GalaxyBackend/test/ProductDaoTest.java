package com.GalaxyBackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GalaxyBackend.dao.ProductDao;
import com.GalaxyBackend.model.Product;


public class ProductDaoTest 
{
	private static AnnotationConfigApplicationContext context=null;
	private static ProductDao productDao=null;
	private Product p=null;

	@BeforeClass
	public static void setUpBeforeClass()throws Exception
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.GalaxyBackend");
		context.refresh();
		productDao=(ProductDao)context.getBean("productDao");
	}

@Ignore
	@Test
	public void testAddProduct() 
	{
	p=new Product();
	p.setProductId(1);
p.setCategoryId(1);
p.setSupplierId(1);
p.setColour("black");
p.setProductDescription("This is a bag");
p.setProductName("bag");
p.setProductPrice(2000);
p.setSize(2);
p.setStock(78);
	System.out.println("Product Details Saved");
	assertTrue("Could not save product details",productDao.addProduct(p));
	}

	@Ignore
	@Test
	public void testUpdateProduct() 
	{
	p=new Product();
	p.setProductId(1);
	p.setCategoryId(2);
	p.setSupplierId(1);
	p.setColour("black-blue");
	p.setProductDescription("This is a bag");
	p.setProductName("bag");
	p.setProductPrice(2000);
	p.setSize(2);
	p.setStock(100);
	System.out.println("Product Details Saved");
	assertTrue("Could not save product details",productDao.addProduct(p));
	}

	@Ignore
	@Test
	public void testDeleteProduct()
	{
		//p=new Product();
		assertTrue("Could not delete User details", productDao.deleteProduct(1));
		}

	@Ignore
	@Test
	public void testGetProductById()
	{
			fail("not yet implemented");
		}

	@Ignore
	@Test
	public void testGetProductBySupplierId()
	{
			fail("not yet implemented");
		}

	@Ignore
	@Test
	public void testGetProductByCategoryId()
	{
			fail("not yet implemented");
		}
	@Ignore
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDao.listProducts();
		assertNotNull("Problem in Retrieving:",listProducts);
	}
}
