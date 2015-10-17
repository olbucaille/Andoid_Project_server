package com.isep.mobility.project.server.dbmanager.db;



public class ModelEnregSynthesis {
	
	private static ModelEnregSynthesis instance;
	
	private long NbTotalMessage;
	private long DureeEnregistrement; 
	private long NbRetard;
	private long NbRetardsCaracterise;
	private long NbRetardsMessage10ms;
	private long NbRetardsMessage100ms;
	private long NbRetardsMessage1S;
	
	private float SeuilRetard = (float) 0.00;
	private float SeuilRetardCaracterise = (float) 0.20;
	
	private boolean ToDo = false;
	
	public boolean isToDo() {
		return ToDo;
	}


	public void setToDo(boolean toDo) {
		ToDo = toDo;
	}


	private ModelEnregSynthesis()
	{
	
	}
	

	public static ModelEnregSynthesis getInstance()
	{
		if (instance == null)
			instance = new ModelEnregSynthesis();
		return instance;
	}
	

	public long getNbTotalMessage() {
		return NbTotalMessage;
	}

	public void setNbTotalMessage(long nbTotalMessage) {
		NbTotalMessage = nbTotalMessage;
	}

	public long getDureeEnregistrement() {
		return DureeEnregistrement;
	}

	public void setDureeEnregistrement(long dureeEnregistrement) {
		DureeEnregistrement = dureeEnregistrement;
	}

	public long getNbRetard() {
		return NbRetard;
	}

	public void setNbRetard(long nbRetard) {
		NbRetard = nbRetard;
	}

	public long getNbRetardsCaracterise() {
		return NbRetardsCaracterise;
	}

	public void setNbRetardsCaracterise(long nbRetardsCaracterise) {
		NbRetardsCaracterise = nbRetardsCaracterise;
	}

	public long getNbRetardsMessage10ms() {
		return NbRetardsMessage10ms;
	}

	public void setNbRetardsMessage10ms(long nbRetardsMessage10ms) {
		NbRetardsMessage10ms = nbRetardsMessage10ms;
	}

	public long getNbRetardsMessage100ms() {
		return NbRetardsMessage100ms;
	}

	public void setNbRetardsMessage100ms(long nbRetardsMessage100ms) {
		NbRetardsMessage100ms = nbRetardsMessage100ms;
	}

	public long getNbRetardsMessage1S() {
		return NbRetardsMessage1S;
	}

	public void setNbRetardsMessage1S(long nbRetardsMessage1S) {
		NbRetardsMessage1S = nbRetardsMessage1S;
	}

	public float getSeuilRetard() {
		return SeuilRetard;
	}

	public void setSeuilRetard(float seuilRetard) {
		SeuilRetard = seuilRetard;
	}

	public float getSeuilRetardCaracterise() {
		return SeuilRetardCaracterise;
	}

	public void setSeuilRetardCaracterise(float seuilRetardCaracterise) {
		SeuilRetardCaracterise = seuilRetardCaracterise;
	}


	
	

}
