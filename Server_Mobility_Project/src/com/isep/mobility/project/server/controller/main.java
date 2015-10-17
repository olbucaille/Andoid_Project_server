package com.isep.mobility.project.server.controller;


import com.isep.mobility.project.server.dbmanager.LoaderDB;
import com.tr6.ws.rmv.saam.edona.MainWindow;

/**
 * lance le programme et initialise les principales classes
 */
public class main  {
	
	private static LoaderDB LDB;
	private static MainWindow frame;
	private static Controller controller;
	
	/**
	 * Lance l'appli.
	 */
	public static void main(String[] args) 
	{
		initializeView();
		initializeModel();
		initializeController(LDB,frame);
	}
	
	private static void initializeModel()
	{
	 LDB = new LoaderDB();	
	}
	private static void initializeView()
	{
		frame = new MainWindow();
		frame.setVisible(true);
	}
	
	private static void initializeController(LoaderDB ldb, MainWindow mw)
	{
		controller = new Controller(ldb,mw);
	}
	
	


}