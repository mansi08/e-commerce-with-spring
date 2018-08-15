package com.GalaxyBackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GalaxyBackend.dao.UserDao;
import com.GalaxyBackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao 
{

	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateUser(User user) 
	{
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;

		}
	}

	public boolean delete(int userId) 
	{
		try {
			sessionFactory.getCurrentSession().delete(getUser(userId));
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;

		}
	}

	public List<User> listUsers() 
	{
	try 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUsers=query.list();
		session.close();
			return listUsers;
				}
		catch(Exception e)
	{
			e.printStackTrace();
			return null;
	}
		}

	public User getUser(int userId) 
	{
		try 
		{
		Session session= sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,userId);
		return user;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByEmail(String userEmail) 
	{
		try 
		{
		Session session= sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,userEmail);
		return user;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
