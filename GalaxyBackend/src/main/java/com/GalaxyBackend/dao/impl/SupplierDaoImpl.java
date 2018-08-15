package com.GalaxyBackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GalaxyBackend.dao.SupplierDao;
import com.GalaxyBackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) 
	{
	try 
	{
	sessionFactory.getCurrentSession().save(supplier);	
		return true;
		}
		catch(Exception e)
	{
			e.printStackTrace();
			return false;
	}
	}

	public boolean updateSupplier(Supplier supplier) 
	{
		try 
		{
		sessionFactory.getCurrentSession().update(supplier);	
			return true;
			}
			catch(Exception e)
		{
				e.printStackTrace();
				return false;
		}
	}

	public boolean deleteSupplier(int supplierId) 
	{
		try 
		{
		sessionFactory.getCurrentSession().delete(getSupplier(supplierId));	
			return true;
			}
			catch(Exception e)
		{
				e.printStackTrace();
				return false;
		}	
	}

	public Supplier getSupplier(int supplierId) 
	{
		try 
		{
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		return supplier;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Supplier> listSupplier() 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> listSupplier=query.list();
			session.close();
			return listSupplier;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
