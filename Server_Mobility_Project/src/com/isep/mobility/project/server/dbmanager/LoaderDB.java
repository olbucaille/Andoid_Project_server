package com.isep.mobility.project.server.dbmanager;




import java.io.IOException;
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
	
	


		//utilis� en d�bug
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



		public boolean setDatabase(String path) {
		//� updater si besoin de faire tourner sur Fedora
		if(System.getProperty("os.name").equals("Windows XP"))
			path = path.replaceAll("\\\\", "/");
		else
			path = path.replaceAll("\\\\", "/");
		
			NAMEDB = path ;
		
			SQLiteM = new SQLitemanager("org.sqlite.JDBC", NAMEDB, "", "");
			
			
			if(SQLiteM.ConnectDB())
				return true;
			
			else return false;
			
			
		}
		
		 
		



		
}
