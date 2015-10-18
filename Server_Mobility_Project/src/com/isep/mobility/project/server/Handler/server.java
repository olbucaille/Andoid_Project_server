package com.isep.mobility.project.server.Handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread{

	private ServerSocket s;
	final int port = 4242;

	public  void Boucle() {

	
		
		try {
			s = new ServerSocket(port);
			this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Server started. Listening to the port 4242");

	}

	

	// run de test écoute sur le 4242 et ecris ce qu'il reçoit
	public void run()
	{
		


		
		try {

		Socket soc = s.accept();

		// Un BufferedReader permet de lire par ligne.
		BufferedReader plec = new BufferedReader(
				new InputStreamReader(soc.getInputStream())
				);

		// Un PrintWriter possède toutes les opérations print classiques.
		// En mode auto-flush, le tampon est vidé (flush) à l'appel de println.
		PrintWriter pred = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(soc.getOutputStream())), 
						true);
		

		while (true) {
			String str = plec.readLine();          // lecture du message
			if (str.equals("END")) break;
			System.out.println("ECHO = " + str);   // trace locale
			pred.println("recu");                     // renvoi d'un écho
		}
		plec.close();
		pred.close();
		soc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


