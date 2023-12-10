package com.web.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.resort.dao.MyConnection;
import com.web.resort.entity.User;

public class UserDaoImpl implements IUserDao 
{
	private PreparedStatement preparedStatement;
	private Connection connection;
	private ResultSet resultSet;
	private String sql;
	public UserDaoImpl() throws SQLException,ClassNotFoundException
	{
		connection=MyConnection.getConnection();
	}
	@Override
	public String validateUser(User user) throws SQLException
	{
		sql="select * from login where email=? and password=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,user.getEmail());
		preparedStatement.setString(2,user.getPassword());
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
			return "Registration.html";
		else
			return "login.html";
	}
	@Override
	public String registerUser(User user) throws SQLException
	{
		sql="insert into login values(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		Integer count=preparedStatement.executeUpdate();
		if(count>0)
		{
			return "registration.html";
		}
		else
		{
			return "login.html";
		}
	}

}
