package com.isep.mobility.project.server.Handler;


import java.net.*;
import java.io.*;

import com.isep.mobility.project.server.controller.StringProvider;

//** Classe associ�e � chaque client **
class RunnableServer implements Runnable
{
  private Thread _t; // contiendra le thread du client
  private Socket _s; // recevra le socket liant au client
  private PrintWriter _out; // pour gestion du flux de sortie
  private BufferedReader _in; // pour gestion du flux d'entr�e
  private server Serv; // pour utilisation des m�thodes de la classe principale
  private int _numClient=0; // contiendra le num�ro de client g�r� par ce thread
  private BusinessServer bs;
  //** Constructeur : cr�e les �l�ments n�cessaires au dialogue avec le client **
  RunnableServer(Socket s, server server) // le param s est donn�e dans BlablaServ par ss.accept()
  {
	  Serv=server; // passage de local en global (pour gestion dans les autres m�thodes)
	  bs = new BusinessServer();
    _s=s; // passage de local en global
    try
    {
      _out =new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(s.getOutputStream())), 
						true);
      _in = new BufferedReader(new InputStreamReader(_s.getInputStream()));
      
    }
    catch (IOException e){ }

    _t = new Thread(this); // instanciation du thread
    _t.start(); // demarrage du thread, la fonction run() est ici lanc�e
  }

  public void run()
  {
	  try {
	  while (true) {
			String str;
			  
				str = _in.readLine();
		    // lecture du message
			System.out.println("ECHO = " + str);   // trace locale*
			//System.out.println(str.split("_")[0]);
			switch (str.split("_")[0]) {
	         case StringProvider.REQ_GIVE_NAME:
	        	 bs.HandleGIVENAME(str, this);
	             break;
	         case StringProvider.REQ_GIVE_FULL_ACTIVITY:
	        	 bs.HandleActivity(str,this);
	             break;
	         case StringProvider.REQ_GIVE_HEARTBEAT:
	        	 bs.HandleHB(str,this);
	             break;
	    
			
			 }
			 
			if (str.equals(StringProvider.END)) break;
		}
	
			_in.close();
			_in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		_out.close();
  }
  
  public  void BASIC_ANSWER()
	{
		_out.println(StringProvider.AQUITEMENT);                     // renvoi d'un �cho
	}
}
