package com.isep.mobility.project.server.dbmanager.db;

import java.sql.SQLException;
import java.sql.Statement;

import com.isep.mobility.project.server.controller.Controller;

public class User {

	String id;
	String user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public User(String id, String user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	public void AddUserToDatabase()
	{
		Controller.LDB.connect();
		
	      String sql = "INSERT INTO User (U_iD,U_name) " +
                  "VALUES ('"+id+"','"+user+ "');"; 
	      try {
			SQLitemanager.statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
