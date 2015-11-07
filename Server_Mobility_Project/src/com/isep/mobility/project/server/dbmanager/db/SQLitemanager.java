package com.isep.mobility.project.server.dbmanager.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.isep.mobility.project.server.controller.StringProvider;
import com.isep.mobility.project.server.dbmanager.LoaderDB;



/**
 * Classe de gestion de base de donnée SQLite
 *  @author Olivier BUCAILLE
 * 
 */
public class SQLitemanager implements IObjectStoringManager{

	public static Connection connexion = null;
	public static Statement statement = null;
	private static String JDBCDRIVER; 
	private static String DBPATH; 
	private static String USER ; 
	private static String PASS ;
	private long tempsDebut= System.currentTimeMillis();
	private long tempsFin = 0;
	private ArrayList<Long> tabRetardTotal;

	public SQLitemanager(String jdbcDriver,  String user,	String pass){
		
		JDBCDRIVER = jdbcDriver;
	
		USER = user; 
		PASS = pass;
	}

	@Override
	public boolean ConnectDB() {
		// load the sqlite-JDBC driver using the current class loader
	    try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    connexion = null;
	    try
	    {
	      // create a database connection
	    	connexion = DriverManager.getConnection("jdbc:sqlite:"+StringProvider.DBPATH);
	       statement = connexion.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	 
	     
	      ResultSet rs = statement.executeQuery("select * from user limit 0,10");
	      System.out.println("db : connected");
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	      return false;
	    }
	    
	    return true;
	}



	@Override
	public void close() {
		try {
			if (statement != null )
				statement.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void shutdown() {
		try {
			if (statement != null && connexion != null)
			{
				
				statement.close();				
				connexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	public void insertMyInfosDM(List<Object> listData) {
		
	      String sql = "INSERT INTO User (U_iD,U_name) " +
	                   "VALUES (\"01\",\"toto\");"; 
	      Statement stmt;
		try {
			stmt = connexion.createStatement();
			   
		      stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

	@Override
	public void dropAllTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTablesEnreg() {
		// TODO Auto-generated method stub
		
	}
	
			
		
		//Iterator<Long> it = deriveeArray.iterator();
		//while(it.hasNext())
		//{
			
		//	System.out.println("derivee : "+ it.next());
			
		//}


	
	
		
		
	

}
