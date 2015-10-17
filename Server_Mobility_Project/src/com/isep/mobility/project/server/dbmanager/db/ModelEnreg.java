package com.isep.mobility.project.server.dbmanager.db;



import java.util.ArrayList;

public class ModelEnreg {
	


			private	String IdMessage ;
			private String MessageDate ;
			private	String MessageType ;
			private	String EnTete ;
			private	String MotEtat ;
			private	String DateDonnee; 
			private	String HeureDonnee ;
			private	String ViellissementDonnee; 
			private	String CapK ;
			private	String RoulisRr; 
			private	String TanguageTa; 
			private	String Latitude ;
			private	String Longitude ;
			private	String Pilonnement_10ms ;
			private	String Pilonnement_1s ;
			private	String VitesseVerticale ;
			private String VitesseLoch ;
			private	String VitesseNord ;
			private	String VitesseOuest ;
			private	String EcartTypeLatitude ;
			private	String EcartTypeLongitude ;
			private	String EcartTypeCapK ;
			private	String ErreurCirculairePosition;
			
			private ArrayList<String> liste;
			private int Retard;
			
			public ModelEnreg(String string,int retard, String string2,
					String messageType, String string3, String string4,
					String string5, String string6,
					String string7, String string8, String string9,
					String string10, String string11, String string12,
					String string13, String string14,
					String string15, String string16, String string17,
					String string18, String string19,
					String string20, String string21,
					String string22) {
				
				IdMessage = string;
				Retard = retard;
				MessageDate = string2;
				MessageType = messageType;
				EnTete = string3;
				MotEtat = string4;
				DateDonnee = string5;
				HeureDonnee = string6;
				ViellissementDonnee = string7;
				CapK = string8;
				RoulisRr = string9;
				TanguageTa = string10;
				Latitude = string11;
				Longitude = string12;
				Pilonnement_10ms = string13;
				Pilonnement_1s = string14;
				VitesseVerticale = string15;
				VitesseLoch = string16;
				VitesseNord = string17;
				VitesseOuest = string18;
				EcartTypeLatitude = string19;
				EcartTypeLongitude = string20;
				EcartTypeCapK = string21;
				ErreurCirculairePosition = string22;
				
				liste = new ArrayList<String>();
				liste.add(IdMessage);
				liste.add(String.valueOf(Retard));
				liste.add(MessageDate);
				liste.add(MessageType);
				liste.add(EnTete);
				liste.add(MotEtat);
				liste.add(DateDonnee);
				liste.add(HeureDonnee);
				liste.add(ViellissementDonnee);
				liste.add(CapK);
				liste.add(RoulisRr);
				liste.add(TanguageTa);
				liste.add(Latitude);
				liste.add(Longitude);
				liste.add(Pilonnement_10ms);
				liste.add(Pilonnement_1s);
				liste.add(VitesseVerticale);
				liste.add(VitesseLoch);
				liste.add(VitesseNord);
				liste.add(VitesseOuest);
				liste.add(EcartTypeLatitude);
				liste.add(EcartTypeLongitude);
				liste.add(EcartTypeCapK);
				liste.add(ErreurCirculairePosition);
				
			}

			public String getIdMessage() {
				return IdMessage;
			}

			public void setIdMessage(String idMessage) {
				IdMessage = idMessage;
			}

			public String getMessageDate() {
				return MessageDate;
			}

			public void setMessageDate(String messageDate) {
				MessageDate = messageDate;
			}

			public String getMessageType() {
				return MessageType;
			}

			public void setMessageType(String messageType) {
				MessageType = messageType;
			}

			public String getEnTete() {
				return EnTete;
			}

			public void setEnTete(String enTete) {
				EnTete = enTete;
			}

			public String getMotEtat() {
				return MotEtat;
			}

			public void setMotEtat(String motEtat) {
				MotEtat = motEtat;
			}

			public String getDateDonnee() {
				return DateDonnee;
			}

			public void setDateDonnee(String dateDonnee) {
				DateDonnee = dateDonnee;
			}

			public String getHeureDonnee() {
				return HeureDonnee;
			}

			public void setHeureDonnee(String heureDonnee) {
				HeureDonnee = heureDonnee;
			}

			public String getViellissementDonnee() {
				return ViellissementDonnee;
			}

			public void setViellissementDonnee(String viellissementDonnee) {
				ViellissementDonnee = viellissementDonnee;
			}

			public String getCapK() {
				return CapK;
			}

			public void setCapK(String capK) {
				CapK = capK;
			}

			public String getRoulisRr() {
				return RoulisRr;
			}

			public void setRoulisRr(String roulisRr) {
				RoulisRr = roulisRr;
			}

			public String getTanguageTa() {
				return TanguageTa;
			}

			public void setTanguageTa(String tanguageTa) {
				TanguageTa = tanguageTa;
			}

			public String getLatitude() {
				return Latitude;
			}

			public void setLatitude(String latitude) {
				Latitude = latitude;
			}

			public String getLongitude() {
				return Longitude;
			}

			public void setLongitude(String longitude) {
				Longitude = longitude;
			}

			public String getPilonnement_10ms() {
				return Pilonnement_10ms;
			}

			public void setPilonnement_10ms(String pilonnement_10ms) {
				Pilonnement_10ms = pilonnement_10ms;
			}

			public String getPilonnement_1s() {
				return Pilonnement_1s;
			}

			public void setPilonnement_1s(String pilonnement_1s) {
				Pilonnement_1s = pilonnement_1s;
			}

			public String getVitesseVerticale() {
				return VitesseVerticale;
			}

			public void setVitesseVerticale(String vitesseVerticale) {
				VitesseVerticale = vitesseVerticale;
			}

			public String getVitesseLoch() {
				return VitesseLoch;
			}

			public void setVitesseLoch(String vitesseLoch) {
				VitesseLoch = vitesseLoch;
			}

			public String getVitesseNord() {
				return VitesseNord;
			}

			public void setVitesseNord(String vitesseNord) {
				VitesseNord = vitesseNord;
			}

			public String getVitesseOuest() {
				return VitesseOuest;
			}

			public void setVitesseOuest(String vitesseOuest) {
				VitesseOuest = vitesseOuest;
			}

			public String getEcartTypeLatitude() {
				return EcartTypeLatitude;
			}

			public void setEcartTypeLatitude(String ecartTypeLatitude) {
				EcartTypeLatitude = ecartTypeLatitude;
			}

			public String getEcartTypeLongitude() {
				return EcartTypeLongitude;
			}

			public void setEcartTypeLongitude(String ecartTypeLongitude) {
				EcartTypeLongitude = ecartTypeLongitude;
			}

			public String getEcartTypeCapK() {
				return EcartTypeCapK;
			}

			public void setEcartTypeCapK(String ecartTypeCapK) {
				EcartTypeCapK = ecartTypeCapK;
			}

			public String getErreurCirculairePosition() {
				return ErreurCirculairePosition;
			}

			public void setErreurCirculairePosition(String erreurCirculairePosition) {
				ErreurCirculairePosition = erreurCirculairePosition;
			}

			public ArrayList<String> getListe() {
				return liste;
			}

			public void setListe(ArrayList<String> liste) {
				this.liste = liste;
			}

			
			

}
