package de.aufgabe51;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("java.version"));
		Random rand = new Random();
		Bank vb = new Bank();
		String[] vorname = {"Karl","Milo","Susi","Max","Johanne","Benjamin","Sebastian","Stephan","Novus","Eva"};
		String[] nachname = {"Zwerg","Hipster","Wurst","Node","Dell","Meier","Mustermann","Zwerg","Müller","Schmidt"};
	
		for(int i = 0; i < 5000 ;i++){
			switch(rand.nextInt(3)){
			case 0: vb.kontoeroeffnen(new Kunde(vorname[rand.nextInt(10)], nachname[rand.nextInt(10)], "adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			case 1: vb.skontoeroeffnen(new Kunde(vorname[rand.nextInt(10)], nachname[rand.nextInt(10)], "adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			case 2: vb.gkontoeroeffnen(new Kunde(vorname[rand.nextInt(10)], nachname[rand.nextInt(10)], "adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			}
		}
	
		ArrayList<Konto> konto = vb.getKonten();
		for(int xx = 0; xx < konto.size(); xx++){
			for(int i = 0; i < 50 ; i++){
				if(i%2==0){
					konto.get(xx).einzahlen(new BigDecimal(rand.nextInt(1000)+rand.nextDouble()));
				}
				else{
					konto.get(xx).auszahlen(new BigDecimal(rand.nextInt(1000)+rand.nextDouble()));
				}
			}
		}
		
		
		vb.menuBank();
		
	
	}

}
