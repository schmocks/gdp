package de.Kassenbon;

import java.text.DecimalFormat;

public class Produkt {
	private int mwst;
	private double preis;
	private String name;
	private double menge;
	
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.00");
		String p = df.format(preis);
		return ">> " +name + " " + menge +" x " + p ;
				
	}
	

	/**
	 * identische Produkte zusammenfassen
	 * 
	 * @param name Produktname
	 * @param preis Einzelpreis
	 * @param mwst MwSt Satz in %
	 * @param menge Anzahl der Produkte
	 */
	
	Produkt(String name, double preis, int mwst, double menge){
		this.name=name; this.preis=preis; this.mwst=mwst; this.menge=menge;		
	}

	public double getMenge() {
		return menge;
	}

	public void setMenge(double menge) {
		this.menge = menge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMwst() {
		return mwst;
	}

	public void setMwst(int mwst) {
		this.mwst = mwst;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	

}
