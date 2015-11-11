package com.isep.mobility.project.server.Handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.isep.mobility.project.server.controller.StringProvider;

public class server extends Thread{

	private ServerSocket s;


	public  void Boucle() {

	
		
		try {
			s = new ServerSocket(StringProvider.PORT);
			this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Server started. Listening to the port "+StringProvider.PORT);

	}

	

	// run de test écoute sur le 4242 et ecris ce qu'il reçoit
	public void run()
	{		
		try {

		
		
		
		

		while (true) {
			  while (true) // attente en boucle de connexion (bloquant sur ss.accept)
		      {
		        new RunnableServer(s.accept(),this); // un client se connecte, un nouveau thread client est lancé
		      }
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
}


