package de.aufgabe51;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bank vb = new Bank();
		Kunde a = new Kunde("Max", "Hase", "Dort", "123");
		Konto k = vb.kontoeroeffnen(a, 200);
		Konto kk =  vb.kontoeroeffnen(a, 250);
		Konto kkk =  vb.kontoeroeffnen(a, 0);
		vb.menuBank();
		
		
	
	}

}
