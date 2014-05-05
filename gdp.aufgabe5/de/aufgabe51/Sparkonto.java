package de.aufgabe51;

public class Sparkonto extends Konto {

	Sparkonto(Kunde kunde, short kontonummer, double saldo) {
		super(kunde, kontonummer, saldo);
		// TODO Auto-generated constructor stub
	}
	
	
	public void auszahlen(double summe){
		System.out.println(">> Auszahlung von Sparkonto nicht möglich!");
		
	}

}
