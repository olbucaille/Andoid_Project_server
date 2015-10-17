package com.isep.mobility.project.server.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread{

		    private  ServerSocket serverSocket;
	    private  Socket clientSocket;
	    private  PrintStream sortie;
	    private  BufferedReader entree;
	    private static String message;
	    
	    
	    

	    public  void Boucle() {
	    	
	    	 try {
	    	serverSocket = new ServerSocket(4242); 
	    	  clientSocket = serverSocket.accept();
	    	entree = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			sortie = new PrintStream(clientSocket.getOutputStream());
	    	 } catch (IOException e) {
		            System.out.println("Could not listen on port: 4242");
		        }
	        this.start();

	        System.out.println("Server started. Listening to the port 4444");

	             

	    }
	    
	    // run de test écoute sur le 4242 et ecris ce qu'il reçoit
	    public void run()
	    {
	    	 while (true) {
		            try {
		           //     clientSocket = serverSocket.accept();   //accept the client connection
		               
		                //recevoir
		                message = entree.readLine();
		                System.out.println(message);
		               
		                //ecrire
		                sortie.println("bien recu");
		                
		                //all close
		                sortie.close();
		    			entree.close();
		                clientSocket.close();

		            } catch (IOException ex) {
		                System.out.println("Problem in message reading");
		            }
		        }
	    }
	
}
