package com.GalaxyBackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GalaxyBackend.dao.CategoryDao;
import com.GalaxyBackend.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCategory(Category category) 
	{
		try 
		{
	sessionFactory.getCurrentSession().save(category);	
	return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) 
	{
		try 
		{
	sessionFactory.getCurrentSession().update(category);	
	return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteCategory(int categoryId) 
	{
		try 
		{
	sessionFactory.getCurrentSession().delete(getCategory(categoryId));	
	return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
	}

	public Category getCategory(int categoryId) 
	{
		try 
		{
		Session session= sessionFactory.getCurrentSession();
		Category category=(Category)session.get(Category.class,categoryId);
		return category;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Category> listCategory() 
	{
	try 
	{
		Session session= sessionFactory.openSession();
		Query query= session.createQuery("from Category");
		List<Category> listCategory=query.list();
		session.close();
			return listCategory;	
	}
	catch(Exception e)	
	{
		e.printStackTrace();
		return null;
	}
	}

}
