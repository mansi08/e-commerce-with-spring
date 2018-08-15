package com.GalaxyBackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GalaxyBackend.dao.ProductDao;
import com.GalaxyBackend.model.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) 
	{
	try 
	{
	sessionFactory.getCurrentSession().save(product);
	return true;
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		return false;
	}
	
	}

	public boolean updateProduct(Product product) 
	{
		try 
		{
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
			
	
	}

	public boolean deleteProduct(int productId) {
		try 
		{
		sessionFactory.getCurrentSession().delete(getProduct(productId));
		return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public Product getProduct(int productId) 
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class, productId);
			return product;
		}
				
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;	
		}
		
	}

	public List<Product> listProducts() 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Product");
			List<Product> listProducts=query.list();
			session.close();
			return listProducts;
		}
		catch (Exception e) 
		{
			return null;	
			}
		
	}

}
