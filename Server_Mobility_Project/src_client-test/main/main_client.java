package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class main_client {
	   static final int port = 4242;

	   public static void main(String[] args) throws Exception {
	        Socket socket = new Socket("localhost", port);
	        System.out.println("SOCKET = " + socket);

	        BufferedReader plec = new BufferedReader(
	                               new InputStreamReader(socket.getInputStream())
	                               );

	        PrintWriter pred = new PrintWriter(
	                             new BufferedWriter(
	                                new OutputStreamWriter(socket.getOutputStream())),
	                             true);
	        String str = "bonjourettralalalal";
	       
	           pred.println(str);          // envoi d'un message
	           str = plec.readLine();  // lecture de l'écho
	           System.out.println(str);
	        
	        System.out.println("END");     // message de terminaison
	        pred.println("END") ;
	        plec.close();
	        pred.close();
	        socket.close();
	   }
	}