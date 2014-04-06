package de.Kassenbon;

import java.text.DecimalFormat;

public class Produkt {
	private int mwst;
	private double preis;
	private String name;
	private int menge;
	
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.00");
		String p = df.format(preis);
		String m = Integer.toString(mwst);
		return name + " - " + p + " € - MwSt: " + m + " %";
				
	}
	
	/**
	 * Ein einzelnes Produkt
	 * 
	 * @param name Produktname
	 * @param preis Einzelpreis
	 * @param mwst MwSt Satz in %
	 */
	
	Produkt(String name, double preis, int mwst){
		this.name=name; this.preis=preis; this.mwst=mwst;		
	}
	
	/**
	 * identische Produkte zusammenfassen
	 * 
	 * @param name Produktname
	 * @param preis Einzelpreis
	 * @param mwst MwSt Satz in %
	 * @param menge Anzahl der Produkte
	 */
	
	Produkt(String name, double preis, int mwst, int menge){
		this.name=name; this.preis=preis; this.mwst=mwst; this.menge=menge;		
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
	

}
