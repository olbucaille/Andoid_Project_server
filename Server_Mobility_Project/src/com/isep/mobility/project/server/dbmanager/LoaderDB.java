package com.isep.mobility.project.server.dbmanager;




import java.io.IOException;
import java.sql.Statement;
import java.util.List;

import com.isep.mobility.project.server.controller.StringProvider;
import com.isep.mobility.project.server.dbmanager.db.SQLitemanager;


/**
 * Classe de chargement d'enregistrements en base de donn�es et lien entre la couche " bas niveau" ( SQLiteManager) et le controller. 
 * @author Olivier BUCAILLE
 * 
 */
public class LoaderDB extends Thread {

	long tempsDebut = 0;
	long tempsFin = 0;

	public final static String DBENREG = "enregnav";
	public final static String DBSYNTHESEENREG = "syntheseenregnav";
	private static SQLitemanager SQLiteM = null;
	




	/**
	 * insere les donn�es dans une ou plusieurs base de donn�es. 
	 * @param name
	 * 		nom de la base de donn�e		
	 *  
	 * @param listData
	 *          des données à convertir
	 * @param synthese
	 *          de l'enregisterement et surtout statistique associ�es (pertes, duree...)
	 */
	public static void InsertDataToDatabase(final String tablename, final List<Object> listData) {


		System.out.println( ".InsertDataToDatabase()> inserting data into: " + tablename + " start...");


		//ouverture de connexion � la BDD


		//dt.setScriptFormatText();	
		waitAMoment();

		System.out.println("d�but insertion en table");

		//insertion des enregs
		SQLiteM.insertMyInfosDM(listData);

		//fermeture de la BDD    
		SQLiteM.shutdown();




		System.out.println( ".InsertDataToDatabase()> finish! ");

		System.out.println("\n datas ins�r�");
	}

	public static void connect()
	{
		SQLiteM = new SQLitemanager("org.sqlite.JDBC",  "", "");
		SQLiteM.ConnectDB();

	}



	private static void waitAMoment() {
		System.out.println("Appuyer sur la touche entrer pour continuer");
		char c;
		try
		{
			c = (char)System.in.read();
		}
		catch(IOException ioe)
		{
			System.out.println("Erreur");
			return;
		} 
	}



	public static String getNAMEDB() {

		return StringProvider.NAMEDB;
	}
}








