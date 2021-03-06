package com.isep.mobility.project.server.dbmanager.db;



import java.sql.SQLException;
import java.util.ArrayList;

import com.isep.mobility.project.server.controller.Controller;

public class Activity {
	


			
			private	String Id ;
			private String IdOwner;
			private String Date ;
			private	Float Distance ;
			private	ArrayList<HeartBeat> ListeHeartBeat ;
			
			
			
			public Activity(String id, String idOwner, String date,
					Float distance, ArrayList<HeartBeat> listeHeartBeat) {
				super();
				Id = id;
				IdOwner = idOwner;
				Date = date;
				Distance = distance;
				ListeHeartBeat = listeHeartBeat;
			}
			
			
			
			public Activity(String id, String idOwner, String date,
					Float distance) {
				super();
				Id = id;
				IdOwner = idOwner;
				Date = date;
				Distance = distance;
				ListeHeartBeat = new ArrayList<HeartBeat>();
			}

			public void AddActivityToDb()
			{
				Controller.LDB.connect();
				
			      String sql = "INSERT INTO Activity (A_iD,U_iD, Date, Distance) " +
		                  "VALUES ('"+Id+"','"+IdOwner+"','"+Date+"','"+Distance+" ');"; 
			      System.out.println(sql);
			      try {
					SQLitemanager.statement.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			    
				
			for (HeartBeat elem : ListeHeartBeat) {
				elem.AddHeartBeatToDb();
			}
			}

			public String getId() {
				return Id;
			}
			public void setId(String id) {
				Id = id;
			}
			public String getIdOwner() {
				return IdOwner;
			}
			public void setIdOwner(String idOwner) {
				IdOwner = idOwner;
			}
			public String getDate() {
				return Date;
			}
			public void setDate(String date) {
				Date = date;
			}
			public Float getDistance() {
				return Distance;
			}
			public void setDistance(Float distance) {
				Distance = distance;
			}
			public ArrayList<HeartBeat> getListeHeartBeat() {
				return ListeHeartBeat;
			}
			public void setListeHeartBeat(ArrayList<HeartBeat> listeHeartBeat) {
				ListeHeartBeat = listeHeartBeat;
			}
			
			
			

			

}
