package com.isep.mobility.project.server.controller;




import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTable;

import com.isep.mobility.project.server.dbmanager.LoaderDB;
import com.isep.mobility.project.server.dbmanager.db.Activity;
import com.isep.mobility.project.server.dbmanager.db.HeartBeat;

/*
 * Controleur du logiciel, il possède un LoaderDB appartenant au "modele" et un MainWindow qui est la vue principale
 */
public class Controller extends Thread {

	private static LoaderDB LDB;
	private static HeartBeat HB;

	public static boolean init = false;

	public Controller(LoaderDB ldb) {
		LDB = ldb;
		
	//	HB = HB.getInstance();

	}

	public static HeartBeat getME() {
		return HB;
	}

	public static void setME(HeartBeat mE) {
		HB = mE;
	}
//pas optimisé
	public static void setDatabase(String path)
	{
		
	}

	public static void ShowError(String message)
	{
		
	}

	public static void unsetDatabase()
	{
		

	}
	//pour lanfer le calcul de synthse on lance un thread de Loader DB, avant nous aurons mit une variable static à true ou false
	// selon cette valeur LDB fera une synthese ou une visualisation. 
	


}
