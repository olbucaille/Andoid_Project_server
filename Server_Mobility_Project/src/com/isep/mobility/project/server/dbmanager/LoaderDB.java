package com.isep.mobility.project.server.dbmanager;




import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import com.isep.mobility.project.server.controller.Controller;
import com.isep.mobility.project.server.dbmanager.db.DelayComputation;
import com.isep.mobility.project.server.dbmanager.db.ModelEnregSynthesis;
import com.isep.mobility.project.server.dbmanager.db.SQLitemanager;
import com.tr6.ws.rmv.saam.edona.EnregCellRenderer;



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
	
	JProgressBar bar;
	 JPanel jf;
	 int avancement =0;
		HashMap<Long, Integer> tabRetardNormal ;
		HashMap<Long, Integer> tabMessageManquant ;
		
		boolean isCompleteSynthesis = false;
		
	
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
	public boolean ComputeSynthesis() {
		 isCompleteSynthesis = false;
		
		tempsDebut = System.currentTimeMillis();
		if (NAMEDB == null||NAMEDB.trim() ==""  )
		{
			Controller.setDatabase(null);
				
			return false;
		}
		
		prepareProgress();
		ActionRealized();
		computeNbTotalMessage();
		ActionRealized();
		computeTimeEnreg();
		ActionRealized();
		computeDelay();
		tabMessageManquant = DelayComputation.gettabMessagesManquants();
		tabRetardNormal = DelayComputation.gettabRetardNormal();
		ActionRealized();
		 prepareProgress();
		 ActionRealized();
			//prepareVisualization(tabRetard);
			ActionRealized();
			isCompleteSynthesis = true;
			Controller.setSyntheseReady(isCompleteSynthesis);
			//ShowVisualization();
			ActionFinished();
			ComputeTime();
		return true;
		
	}
	
	 private boolean LoadVisualization() {
		 boolean isok = false;
		 tempsDebut = System.currentTimeMillis();
		 if(!isCompleteSynthesis) 
			{
				Controller.ShowError("la synthese n'as pas été calculée...");
				Controller.setLoadVisualisationReady(false);
				return false;
			}
	
		 prepareProgress();
		 ActionRealized();
			
		
		
		 ActionRealized();
			prepareVisualization(tabRetardNormal, tabMessageManquant);
			ActionRealized();
			ActionRealized();
		
			ShowVisualization();
			ActionRealized();
			ActionRealized();
			isok = true;
			Controller.setLoadVisualisationReady(isok);
			ActionFinished();
			ComputeTime();
			return true;
		}
	
	 //besoin de connaitre les enregistrements de messages manquant pour pouvoire colorer correctement 
	 // ici contruction d'un tableau contenant les n° de ligne à colorer en rouge.
		public void getRowNumberForIHM(JTable dtm) {


			HashMap<Long,Integer> tabretard = DelayComputation.gettabMessagesManquants();
		if(tabretard.size()!= EnregCellRenderer.arrayRow.size())
		{
				for(int i = 0;i<dtm.getModel().getRowCount();++i)
				{
					for(int j = 0;j<tabretard.size();j++)
					{
						if(tabretard.keySet().toArray()[j].toString().trim().equals(dtm.getModel().getValueAt(i, 0).toString()))
							EnregCellRenderer.arrayRow.add((long) i);
						
					}
				}
		}
	}

		private void ShowVisualization()  {
		try {
			Controller.EraseTable();
			SQLiteM.ShowVisualization();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



		private void prepareVisualization(HashMap<Long,Integer> tabRetardNormal, HashMap<Long,Integer> tabMessageManquant) {
			try {
				  SQLiteM.prepareVisualization(tabRetardNormal,tabMessageManquant);
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				Controller.ShowError("échec préparation visualisations");
				
			}
		
	}



		private boolean computeDelay() {
		
			try {
				 SQLiteM.computeDelay();
				 return true;
			} catch (SQLException e) {
				Controller.ShowError("échec calcul Retards");
				return false;
			}
			
		
	}



		private void computeTimeEnreg() {
			Long timeEnreg = (long) 0;
			try {
				timeEnreg = SQLiteM.countTimeEnreg();
			} catch (SQLException e) {
				Controller.ShowError("échec calcul Duree Enreg");
			}
			Controller.setTimeEnreg(timeEnreg);
		
	}



		private void computeNbTotalMessage() {
			Long nbEnreg = (long) 0;
			try {
			 nbEnreg = SQLiteM.countAllEnreg();
		} catch (SQLException e) {
			Controller.ShowError("échec calcul Nb TotalSynthese");
		}
		Controller.setNbTotalMessage(nbEnreg);
	}



		private void ComputeTime()
		{
		 tempsFin  = System.currentTimeMillis();
		float seconds = (tempsFin - tempsDebut) / 1000F;
		
		
		System.out.println("Opération effectuée en: "+ seconds + " secondes.");

		}
		//utilisé en débug
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
		//à updater si besoin de faire tourner sur Fedora
		if(System.getProperty("os.name").equals("Windows XP"))
			path = path.replaceAll("\\\\", "/");
		else
			path = path.replaceAll("\\\\", "/");
		
			NAMEDB = path ;
		
			SQLiteM = new SQLitemanager("org.sqlite.JDBC", NAMEDB, "", "");
			isCompleteSynthesis = false;
			
			if(SQLiteM.ConnectDB())
				return true;
			
			else return false;
			
			
		}
		 public  void run() {
			 if(ModelEnregSynthesis.getInstance().isToDo())
				 ComputeSynthesis();
			 else
				 LoadVisualization();
		 
		
		 }
		 
		



		public void prepareProgress()
		 {
			//  jf = Controller.getpanelProgessBar();
			 // jf.setVisible(true);
			 //jf.setSize(300, 80);
			// jf.setTitle("* EDONA : Compute Synthesis *");
			 //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 //jf.setLocationRelativeTo(null);      
			      
			  
			     bar = Controller.getProgessBar();
			    bar.setMaximum(500);
			    bar.setMinimum(0);
			    bar.setStringPainted(true);
			      bar.setVisible(true);
			 //   jf.add(bar);
			      
			    
			       avancement = 0;
			    
			 //   jf.setVisible(true);      
		 }
		 
		 public void ActionRealized()
		 {
			 avancement = avancement +100;
			 bar.setValue(avancement);
		 }
		 
		 public void ActionFinished()
		 {
			// jf.setVisible(false);
			 bar.setVisible(false);
		 }

		

		
}
