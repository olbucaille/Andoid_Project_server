
package com.isep.mobility.project.server.dbmanager.db;




/**
 * Interface pour la gestion de BDD
 *  @author Olivier BUCAILLE
 * 
 */

public interface IObjectStoringManager {
	
	public boolean ConnectDB();
	
	public void dropAllTables();
	
	//juste close la connection
	public void close();
	
	//close + deco de la DB
	public void shutdown();
	
	//creation des tables utile pour l'appli
	public void createTablesEnreg();
	
	
	
	

}
