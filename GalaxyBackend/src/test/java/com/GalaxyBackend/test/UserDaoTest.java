package com.GalaxyBackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GalaxyBackend.dao.UserDao;
import com.GalaxyBackend.model.User;

public class UserDaoTest 
{
private static AnnotationConfigApplicationContext context=null;
private static UserDao userDao=null;
private User u=null;

@BeforeClass
public static void setUpBeforeClass()throws Exception
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.GalaxyBackend");
	context.refresh();
	userDao=(UserDao)context.getBean("userDao");
}

@Ignore
@Test
public void testAddUser() 
{
u=new User();
u.setUserId(2);
u.setUserName("Mansi");
u.setUserEmail("m@gmail.com");
u.setUserPassword("abc");
u.setUserPhoneNumber("8960441778");
System.out.println("User Details Saved");
assertTrue("Could not save user details",userDao.addUser(u));
}

@Ignore
@Test
public void testUpdateUser() 
{
u=new User();
u.setUserId(1);
u.setUserName("Shubham");
u.setUserEmail("shubhamm@gmail.com");
u.setUserPassword("abc");
u.setUserPhoneNumber("8960441787");
System.out.println("User Details Saved");
assertTrue("Could not save user details",userDao.addUser(u));
}

@Ignore
@Test
public void testDeleteUser()
{
	u=new User();
	assertTrue("Could not delete User details",userDao.delete(1));
	}

@Ignore
@Test
public void testGetUserById()
{
		fail("not yet implemented");
	}

@Ignore
@Test
public void testGetUserByEmail()
{
		fail("not yet implemented");
	}

@Ignore
@Test
public void listUserTest()
{
	List<User> listUsers=userDao.listUsers();
	assertNotNull("Problem in Retrieving:",listUsers);
}
}
