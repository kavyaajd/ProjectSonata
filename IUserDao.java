package com.web.resort.dao;

import java.sql.SQLException;

import com.web.resort.entity.User;

public interface IUserDao 
{
	String validateUser(User user) throws SQLException;
	String registerUser(User user) throws SQLException;
}
