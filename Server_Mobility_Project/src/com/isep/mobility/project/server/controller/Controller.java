package com.isep.mobility.project.server.controller;




import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTable;

import com.isep.mobility.project.server.dbmanager.LoaderDB;
import com.isep.mobility.project.server.dbmanager.db.Activity;
import com.isep.mobility.project.server.dbmanager.db.HeartBeat;
import com.isep.mobility.project.server.dbmanager.db.User;

/*
 * Controleur du logiciel, il possède un LoaderDB appartenant au "modele" et un MainWindow qui est la vue principale
 */
public class Controller extends Thread {

	public static LoaderDB LDB;
	private static HeartBeat HB;

	public static boolean init = false;

	public Controller(LoaderDB ldb) {
		LDB = ldb;
	//	HB = HB.getInstance();

	}
	public static void AddUserTodb(String id, String name)
	{
		User u = new User(id,name);
		u.AddUserToDatabase();
	}
	
	public static void AddActivityTodb(String Id,String IdOwner,String Date,Float Distance,ArrayList<HeartBeat> ListeHeartBeat)
	{
	
		Activity a = new Activity(Id, IdOwner, Date, Distance, ListeHeartBeat);
		a.AddActivityToDb();
	}


}
