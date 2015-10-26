package com.isep.mobility.project.server.dbmanager;




import java.io.IOException;
import java.sql.Statement;
import java.util.List;

import com.isep.mobility.project.server.dbmanager.db.SQLitemanager;


/**
 * Classe de chargement d'enregistrements en base de données et lien entre la couche " bas niveau" ( SQLiteManager) et le controller. 
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
	 * insere les données dans une ou plusieurs base de données. 
	 * @param name
	 * 		nom de la base de donnée		
	 *  
	 * @param listData
	 *          des donnÃ©es Ã  convertir
	 * @param synthese
	 *          de l'enregisterement et surtout statistique associées (pertes, duree...)
	 */
	public void InsertDataToDatabase(final String name, final List<Object> listData) {
		tempsDebut=System.currentTimeMillis();
		NAMEDB = name;
		System.out.println(this.getClass().getSimpleName() + ".InsertDataToDatabase()> inserting data into: " + name + " start...");

			// on prépare la barre de progression
			//ProgressBarMonitor progressUI = new ProgressBarMonitor("Converting data", listData.size()); // FIXME fonctionne trÃ¨s bien mais sale, code Swing dans le kernel

			// --------------------------------------------------------------------
		

			// on ecrit la phrase de stat
			//fwriter.write("Resume: " + synthese.NavStatToString() + "\r\n");
			//FIXME pas d'enreg de synthese implémenté 
			
			
			//ouverture de connexion à la BDD
			SQLitemanager dt = new SQLitemanager("org.sqlite.JDBC", "jdbc:sqlite:"+"./db/"+NAMEDB, "", "");

			
			//dt.ConnectDB();
			//mise à 0 des Tables

			// suite...
			Statement statement;
			System.out.println("\nnombre d'enregistrements à insérer : "+listData.size());  

			//préparation de la table
			dt.dropAllTables();
			dt.createTablesEnreg();
			//dt.setScriptFormatText();	
			waitAMoment();

			System.out.println("début insertion en table");

		
		
			//insertion des enregs
			//dt.insertMyInfosDM(listData);
			
			//fermeture de la BDD    
			dt.shutdown();
			
		

		
		System.out.println(this.getClass().getSimpleName() + ".InsertDataToDatabase()> finish! ");
		ComputeTime();
		System.out.println("\n datas inséré");
	}
	
	

		private void ComputeTime()
		{
		 tempsFin  = System.currentTimeMillis();
		float seconds = (tempsFin - tempsDebut) / 1000F;
		
		
		System.out.println("Opération effectuée en: "+ seconds + " secondes.");

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

		 
		



		

