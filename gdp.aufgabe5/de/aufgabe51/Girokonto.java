package de.aufgabe51;

public class Girokonto extends Konto{

	
	private double saldo;
	Girokonto(Kunde kunde, short kontonummer, double saldo) {
		super(kunde, kontonummer, saldo);
		
		
	}
	
	public void auszahlen(double summe){
		saldo=getSaldo();
		if(summe>300){
			System.out.println(">> Auszahlungsbetrag zu hoch");
			return;
		}
		if((saldo-summe)<(-500)){
			System.out.println(">> Dispolimit erreicht");
			return;
		}
			
			setSaldo(saldo-summe);
			
		
	}
	
}
