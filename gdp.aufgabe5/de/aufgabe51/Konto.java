package de.aufgabe51;

import java.text.DecimalFormat;

/**
 * Konto Klasse
 * 
 * @author Stephan
 *
 */

public class Konto {

	private Kunde kunde;
	private short kontonummer;
	private double saldo;
	DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * 
	 */
	
	public String toString(){
		
		return "Kunde: "+kunde+" Ktnr: "+kontonummer+ " Saldo: "+df.format(saldo);
	}
	
	Konto(Kunde kunde, short kontonummer, double saldo){
		this.kunde=kunde;this.kontonummer=kontonummer;this.saldo=saldo;
		}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public short getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(short kontonummer) {
		this.kontonummer = kontonummer;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	/**
	 * Einzahl Methode
	 * 
	 * @param summe
	 */
	
	public void einzahlen(double summe){
		saldo+=summe;
	}
	
	
	/**
	 * Auszahl Methode
	 * 
	 * negatives Saldo nicht möglich
	 * 
	 * @param summe gewünschte Auszahlsumme
	 */
	
	public void auszahlen(double summe){
		if(summe>saldo){
			System.out.println(">> Auszahlung nicht möglich");
			return;
		}else{
			saldo-=summe;
		}
	}
	
	
}
