package com.isep.mobility.project.server.dbmanager;




import java.io.IOException;
import java.sql.Statement;
import java.util.List;

import com.isep.mobility.project.server.dbmanager.db.SQLitemanager;


/**
 * Classe de chargement d'enregistrements en base de donn�es et lien entre la couche " bas niveau" ( SQLiteManager) et le controller. 
 * @author Olivier BUCAILLE
 * 
 */
public class LoaderDB extends Thread {
	
	long tempsDebut = 0;
	long tempsFin = 0;
	private static String NAMEDB = "";
	public final static String DBENREG = "enregnav";
	public final static String DBSYNTHESEENREG = "syntheseenregnav";
	private SQLitemanager SQLiteM = null;
		

	

	
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
	public void InsertDataToDatabase(final String name, final List<Object> listData) {
		tempsDebut=System.currentTimeMillis();
		NAMEDB = name;
		System.out.println(this.getClass().getSimpleName() + ".InsertDataToDatabase()> inserting data into: " + name + " start...");

			// on pr�pare la barre de progression
			//ProgressBarMonitor progressUI = new ProgressBarMonitor("Converting data", listData.size()); // FIXME fonctionne très bien mais sale, code Swing dans le kernel

			// --------------------------------------------------------------------
		

			// on ecrit la phrase de stat
			//fwriter.write("Resume: " + synthese.NavStatToString() + "\r\n");
			//FIXME pas d'enreg de synthese impl�ment� 
			
			
			//ouverture de connexion � la BDD
			SQLitemanager dt = new SQLitemanager("org.sqlite.JDBC", "jdbc:sqlite:"+"./db/"+NAMEDB, "", "");

			
			//dt.ConnectDB();
			//mise � 0 des Tables

			// suite...
			Statement statement;
			System.out.println("\nnombre d'enregistrements � ins�rer : "+listData.size());  

			//pr�paration de la table
			dt.dropAllTables();
			dt.createTablesEnreg();
			//dt.setScriptFormatText();	
			waitAMoment();

			System.out.println("d�but insertion en table");

		
		
			//insertion des enregs
			//dt.insertMyInfosDM(listData);
			
			//fermeture de la BDD    
			dt.shutdown();
			
		

		
		System.out.println(this.getClass().getSimpleName() + ".InsertDataToDatabase()> finish! ");
		ComputeTime();
		System.out.println("\n datas ins�r�");
	}
	
	

		private void ComputeTime()
		{
		 tempsFin  = System.currentTimeMillis();
		float seconds = (tempsFin - tempsDebut) / 1000F;
		
		
		System.out.println("Op�ration effectu�e en: "+ seconds + " secondes.");

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
			
			return NAMEDB;
		}
}

		 
		



		

