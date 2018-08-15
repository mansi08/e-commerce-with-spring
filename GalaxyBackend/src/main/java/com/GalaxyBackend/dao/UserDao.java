package com.GalaxyBackend.dao;

import java.util.List;

import com.GalaxyBackend.model.User;

public interface UserDao 
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean delete(int userId); 

	public User getUser(int userId);
	public User getUserByEmail(String userEmail);
	public List<User> listUsers();
}
