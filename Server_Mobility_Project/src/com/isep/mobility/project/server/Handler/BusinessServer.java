package com.isep.mobility.project.server.Handler;

import java.util.ArrayList;

import org.omg.CORBA.Request;

import com.isep.mobility.project.server.controller.Controller;
import com.isep.mobility.project.server.dbmanager.db.HeartBeat;
import com.isep.mobility.project.server.dbmanager.db.User;

public class BusinessServer {
	
	public  void HandleGIVENAME(String reuquest, RunnableServer rs)//GIVENAME_Olivierbucaille_01542102145
	{
		String[] rq = reuquest.split("_"); //rq[1] name, rq[2] = id
		Controller.AddUserTodb(rq[2], rq[1]);
		rs.BASIC_ANSWER();
	}

	public  void HandleActivity(String request, RunnableServer rs) {//GIVEACTIVITY_U_id_A_Id_Date_Distance
		String[] rq = request.split("_"); //rq[1] userid, rq[2] activity_Id, rq[3] date, rq[4] distance
		Controller.AddActivityTodb(rq[2], rq[1],rq[3],Float.valueOf(rq[4]), new ArrayList<HeartBeat>());
		rs.BASIC_ANSWER();
		
	}

	public  void HandleHB(String request, RunnableServer rs) {////GIVEHBA_IdActivity_Value_Time
		String[] rq = request.split("_"); //rq[1] idAct, rq[2]value, rq[3] time
		Controller.AddHeartBeatTodb(rq[1], rq[2], rq[3]);
		rs.BASIC_ANSWER();
		
		
	}
	
	

}
