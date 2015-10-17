package com.isep.mobility.project.server.controller;




import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTable;

import com.isep.mobility.project.server.dbmanager.LoaderDB;
import com.isep.mobility.project.server.dbmanager.db.ModelEnreg;
import com.isep.mobility.project.server.dbmanager.db.ModelEnregSynthesis;
import com.tr6.ws.rmv.saam.edona.EnregCellRenderer;
import com.tr6.ws.rmv.saam.edona.MainWindow;
/*
 * Controleur du logiciel, il possède un LoaderDB appartenant au "modele" et un MainWindow qui est la vue principale
 */
public class Controller extends Thread {

	private static LoaderDB LDB;
	private static MainWindow MW;
	private static ModelEnregSynthesis ME;

	public static boolean init = false;

	public Controller(LoaderDB ldb, MainWindow mw) {
		LDB = ldb;
		MW = mw;
		ME = ME.getInstance();

	}

	public static ModelEnregSynthesis getME() {
		return ME;
	}

	public static void setME(ModelEnregSynthesis mE) {
		ME = mE;
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
	
	public static void computeSynthese()
	{
		
	}

	//même principe que la methode précédente, la valeur est ici à false.
	public static void LoadVisualization()
	{		
		

	}
	//appelle ModelEnreg, une classe de stokage( mais qui ne stocke pas toutes les données)
	public static void setNbTotalMessage(long nb) {
	
	}

	public static void setSyntheseReady(Boolean isReady)
	{
	
	}






}
