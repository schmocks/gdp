package bank.gui;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import bank.app.Bank;
import bank.app.Konto;
import bank.app.Kunde;

public class KundenGenerator {
	

	
	
	public Bank fuelleBank(Bank b){
		
		Random rand = new Random();
		String[] vorname = {"Karl","Milo","Susi","Max","Johanne","Benjamin","Sebastian","Stephan","Novus","Eva"};
		String[] nachname = {"Zwerg","Hipster","Wurst","Node","Dell","Meier","Mustermann","Zwerg","Müller","Schmidt"};
		
		for(int i = 0; i < 5000 ;i++){
			switch(rand.nextInt(3)){
			case 0: b.kontoeroeffnen(new Kunde(vorname[rand.nextInt(vorname.length)], nachname[rand.nextInt(nachname.length)],
					"adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			case 1: b.skontoeroeffnen(new Kunde(vorname[rand.nextInt(vorname.length)], nachname[rand.nextInt(nachname.length)],
					"adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			case 2: b.gkontoeroeffnen(new Kunde(vorname[rand.nextInt(vorname.length)], nachname[rand.nextInt(nachname.length)],
					"adresse", "telNr"), new BigDecimal(rand.nextInt(2000)+rand.nextDouble()));break;
			}
		}
	
		ArrayList<Konto> konto = b.getKonten();
		for(int xx = 0; xx < konto.size(); xx++){
			for(int i = 0; i < rand.nextInt(50) ; i++){
				int ir = rand.nextInt();
				if(ir%2==0){
					konto.get(xx).einzahlen(new BigDecimal(rand.nextInt(1000)+rand.nextDouble()));
				}
				else{
					konto.get(xx).auszahlen(new BigDecimal(rand.nextInt(1000)+rand.nextDouble()));
				}
			}
		}
		
		
		return b;
	}
	
 
}
