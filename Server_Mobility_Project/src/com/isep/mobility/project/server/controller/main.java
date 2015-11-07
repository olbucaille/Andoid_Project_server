package com.isep.mobility.project.server.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.isep.mobility.project.server.Handler.server;
import com.isep.mobility.project.server.dbmanager.LoaderDB;
import com.isep.mobility.project.server.dbmanager.db.HeartBeat;

/**
 * lance le programme et initialise les principales classes
 */
public class main  {
	
	private static LoaderDB LDB;
	private static server SERV;
	
	private static Controller controller;
	
	/**
	 * Lance l'appli.
	 */
	public static void main(String[] args) 
	{
		
		initializeModel();
		//startserv();
		HeartBeat h1 = new HeartBeat("85",42,"05");

		HeartBeat h2 = new HeartBeat("85",85,"06");
		HeartBeat h3 = new HeartBeat("85",110,"07");
		ArrayList<HeartBeat> hlist = new ArrayList<HeartBeat>();
		hlist.add(h1);
		hlist.add(h2);
		hlist.add(h3);
		Controller.AddActivityTodb("85", "12", "42", Float.parseFloat("49"), hlist);
	
	}
	
	private static void startserv() {
	SERV = new server();
	SERV.Boucle();
		
	}

	private static void initializeModel()
	{
	 LDB = new LoaderDB();	
	}
	
	
	
	


}