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

import com.tr6.ws.rmv.saam.edona.controller.Controller;
import com.tr6.ws.rmv.saam.edona.dbmanager.LoaderDB;



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

	public SQLitemanager(String jdbcDriver, String dbPath, String user,	String pass) {
		
		JDBCDRIVER = jdbcDriver;
		DBPATH = dbPath; 
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
	    	connexion = DriverManager.getConnection("jdbc:sqlite:"+DBPATH);
	       statement = connexion.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	   
	     
	      ResultSet rs = statement.executeQuery("select * from enregnav limit 0,10");
	    
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	  //    System.err.println(e.getMessage());
	      return false;
	    }
	    
	    return true;
	}

	@Override
	public void dropAllTables() {
		try {	
			if (connexion == null)
				ConnectDB();
			
		
			statement.executeUpdate("drop table IF EXISTS  "+LoaderDB.DBENREG+" ;");		
			statement.executeUpdate("drop table IF EXISTS  "+LoaderDB.DBSYNTHESEENREG+" ;");
			statement.executeUpdate("DROP INDEX IF EXISTS index_enregnav_IdMessage ;");
			statement.executeUpdate("DROP INDEX IF EXISTS index_enregnav_MessageDate ;");
			statement.executeUpdate("DROP INDEX IF EXISTS index_enregnav_MessageType ;");
		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
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

	@Override
	public void createTablesEnreg() {
		try {
			 
			if (connexion == null)
				ConnectDB();
		    
			statement = connexion.createStatement();
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS ENREGNAV"
					+ "	(IdMessage BIGINT,"
					+ " MessageDate BIGINT,"
					+ "	MessageType VARCHAR(10),"
					+ "	EnTete BIGINT,"
					+ "	MotEtat BIGINT,"
					+ "	DateDonnee BIGINT,"
					+ "	HeureDonnee BIGINT,"
					+ "	ViellissementDonnee BIGINT,"
					+ "	CapK REAL, "
					+ "	RoulisRr REAL,"
					+ "	TanguageTa REAL,"
					+ "	Latitude REAL,"
					+ "	Longitude REAL,"
					+ "	Pilonnement_10ms REAL,"
					+ "	Pilonnement_1s REAL,"
					+ "	VitesseVerticale REAL,"
					+ "	VitesseLoch REAL,"
					+ "	VitesseNord REAL,"
					+ "	VitesseOuest REAL,"
					+ "	EcartTypeLatitude REAL, "
					+ "	EcartTypeLongitude REAL,"
					+ "	EcartTypeCapK REAL,"
					+ "	ErreurCirculairePosition REAL)");
			
			statement.executeUpdate("CREATE  TABLE IF NOT EXISTS SYNTHESEENREGNAV "
					+ "	(statDureeNav BIGINT,"
					+ "	nbMessageRecu BIGINT,"
					
					+ "	statNbrMsg10msNbrLost BIGINT,"
					+ "	statNbrMsg10msTimeLost BIGINT,"
				
					+ "	statNbrMsg100msNbrLost BIGINT,"
					+ "	statNbrMsg100msTimeLost BIGINT,"
				
					+ "	statNbrMsg1sNbrLost BIGINT,"
					+ "	statNbrMsg1sTimeLost BIGINT"
					
					+")");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public Long countAllEnreg() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT count(*) from enregnav ");
		return rs.getLong(1);
	}

	public Long countTimeEnreg() throws SQLException {
		long nbenreg = 0;
		ResultSet rs = statement.executeQuery("select MessageDate from enreGNAV where IdMessage = 0 ");
		long deb = rs.getLong(1);
		rs = statement.executeQuery("select MessageDate from enreGNAV where IdMessage = "+(nbenreg-1));	
		long fin = rs.getLong(1);
		
		return fin-deb;
	}

	public void computeDelay() throws SQLException {
		
		ResultSet rs = statement.executeQuery("select MessageDate,IdMessage,MessageType from enreGNAV ");
	
	}

	public void prepareVisualization(HashMap<Long,Integer> tabRetardNormal, HashMap<Long,Integer> tabMessageManquant) throws SQLException {
		
		tabRetardTotal = new ArrayList<Long>();
		tabRetardTotal.addAll(tabMessageManquant.keySet());
		tabRetardTotal.addAll(tabRetardNormal.keySet());
		
		statement.executeUpdate("DROP VIEW IF EXISTS enreg_view ;");
		 String requete = "CREATE VIEW  enreg_view AS SELECT * from enreGNAV WHERE enregNAV.IdMessage IN ( ";
		 if(tabRetardTotal == null)
			 requete = requete.concat(" ");
		 else
		 {
			
			 for(int i=0;i<tabRetardTotal.size();i++)
			 {
			 		if(i==0)
			 		requete = requete.concat(""+tabRetardTotal.get(i));
			 		else
			 		requete = requete.concat(","+tabRetardTotal.get(i) );
			 }
		 }
		 
		 //requete = requete.concat(""+tabRetard.get(0) );
		 	requete = requete.concat(");");
			//	System.out.println(requete);
		 
		  statement.executeUpdate(requete);
			
	}
	
	public void ShowVisualization() throws SQLException {
	ResultSet rs =  statement.executeQuery("SELECT * FROM enreg_view");
	ModelEnreg me = null;

	while(rs.next())
	{
		int res; 
		}
	
	Hashtable<Integer, Integer> arrayRetard10Msg = DelayComputation.tabSuivitRetard10ms;
	
	Enumeration<Integer> itr = arrayRetard10Msg.keys();
	  while(itr.hasMoreElements())
	  {
		  Integer i = itr.nextElement(); 
	 
	    }
	
	  ArrayList<Long> al =  computederiveeTemps();
		 for (int i=0;i<al.size();i++)
	}

	public ArrayList<Long> computederiveeTemps() throws SQLException {
		Long NumberOfHourProvider = (long) 0;
		Long LastValOfHour = null;
		ArrayList<Long> deriveeArray = new ArrayList<Long>();
		ResultSet rs = statement.executeQuery("select HeureDonnee from enregNAV where MessageType = \"Msg100ms\" OR MessageType = \"Msg1s\" ");
		
		while(rs.next())
		{
			if(LastValOfHour == null)
			{
				NumberOfHourProvider++;
				LastValOfHour = rs.getLong(1);
			}
			else
			{
				NumberOfHourProvider++;
				deriveeArray.add(((rs.getLong(1)-100)-LastValOfHour)/NumberOfHourProvider);
				LastValOfHour = rs.getLong(1);
			}
			
	
			
		}
		//Iterator<Long> it = deriveeArray.iterator();
		//while(it.hasNext())
		//{
			
		//	System.out.println("derivee : "+ it.next());
			
		//}
		return deriveeArray;
	}
	

	
	
		
		
	

}
