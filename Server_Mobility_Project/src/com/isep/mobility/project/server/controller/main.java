package com.isep.mobility.project.server.controller;


import com.isep.mobility.project.server.dbmanager.LoaderDB;

/**
 * lance le programme et initialise les principales classes
 */
public class main  {
	
	private static LoaderDB LDB;
	
	private static Controller controller;
	
	/**
	 * Lance l'appli.
	 */
	public static void main(String[] args) 
	{
		
		initializeModel();
	
	}
	
	private static void initializeModel()
	{
	 LDB = new LoaderDB();	
	}
	
	
	
	


}