package com.isep.mobility.project.server.dbmanager.db;

import java.sql.SQLException;

import com.isep.mobility.project.server.controller.Controller;



public class HeartBeat {
	

	private String ActivityId;
	private int value;
	private String Date;
	
	public HeartBeat(String A_Id,int value, String date) {
		super();
		this.value = value;
		Date = date;
		ActivityId = A_Id;
	}
	
	
	public String getActivityId() {
		return ActivityId;
	}


	public void setActivityId(String activityId) {
		ActivityId = activityId;
	}


	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	} 	
	public void AddHeartBeatToDb()
	{
		Controller.LDB.connect();
		
	      String sql = "INSERT INTO HeartBeat (A_iD,value, Time) " +
                  "VALUES ('"+ActivityId+"','"+value+"','"+Date+" ');"; 
	      System.out.println(sql);
	      try {
			SQLitemanager.statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}