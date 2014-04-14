package de.aufgabe51;

public class Kunde {
	
	private String vorname;
	private String nachname;
	private String adresse;
	private String telNr;
	
	
	public String toString(){
		return vorname + " " + nachname;
	}
	
	
	Kunde(String vorname, String nachname, String adresse, String telNr){
		this.vorname=vorname;this.nachname=nachname;this.adresse=adresse;this.telNr=telNr;
		
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelNr() {
		return telNr;
	}


	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}

}
