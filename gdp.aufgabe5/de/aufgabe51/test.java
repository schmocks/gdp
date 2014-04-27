package de.aufgabe51;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bank vb = new Bank();
		Kunde kunde0 = new Kunde("Karl", "Muster", "Hier", "1000");
		Kunde kunde1 = new Kunde("Max", "Mustertee", "Unten", "2000");
		Kunde kunde2 = new Kunde("Hugo", "Musterzwerg", "Dort", "5000");
		Kunde kunde3 = new Kunde("Susi", "Musterhipster", "Irgendwo", "1300");
		Kunde kunde4 = new Kunde("Tina", "Musterfrau", "Nirgends", "1010");
		vb.kontoeroeffnen(kunde0, 1000);
		vb.kontoeroeffnen(kunde0, 2000);
		vb.kontoeroeffnen(kunde1, 1666.55);
		vb.kontoeroeffnen(kunde1, 10);
		vb.kontoeroeffnen(kunde2, 0);
		vb.kontoeroeffnen(kunde2, 100000);
		vb.kontoeroeffnen(kunde3, 555);
		vb.kontoeroeffnen(kunde3, 232);
		vb.kontoeroeffnen(kunde4, 0.99);
		vb.kontoeroeffnen(kunde4, 20);
		
		
		
		
		vb.menuBank();
		
		
	
	}

}
