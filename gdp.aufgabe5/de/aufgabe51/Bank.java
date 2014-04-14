package de.aufgabe51;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private ArrayList<Konto> konten = new ArrayList<Konto>();
	private short kontenzähler = 5000;
	Scanner in = new Scanner(System.in);
	
	public String toString(){
		String s = "";
		for(int i=0;i<konten.size();i++){
			s+=konten.get(i);
			s+="\n";
		}
		return s;
	}
	
	public Konto kontoeroeffnen(Kunde kunde, double saldo){
		
		Konto a = new Konto(kunde, kontenzähler, saldo);
		konten.add(a);
		kontenzähler++;
		return a;
	}
	
	public Kunde getKunde(String vorname, String nachname){
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getKunde().getVorname().equals(vorname)
			   &&konten.get(i).getKunde().getNachname().equals(nachname)){
				return konten.get(i).getKunde();
			}
		}
		System.out.println("Eintrag nicht gefunden!");
		return null;
	}
	
	public Kunde getKunde(Short kontonummer){
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getKontonummer()==kontonummer){
				return konten.get(i).getKunde();
			}
		}
		System.out.println("Eintrag nicht gefunden!");
		return null;
	
	}
	
	public void neuerKunde(){
		String vorname; String nachname; double saldo = 0;
		String adresse; String telNr;
		boolean ba = true;
		System.out.println("\n>> Neuen Kunden anlegen <<\n");
		System.out.print(">> Vorname: ");vorname=in.nextLine();
		System.out.print(">> Nachname: ");nachname=in.nextLine();
		System.out.print(">> Adresse: ");adresse=in.nextLine();
		System.out.print(">> Telefonnummer: ");telNr=in.nextLine();
		Kunde kunde = new Kunde(vorname, nachname, adresse, telNr);		
		do{
			System.out.print(">> Saldo: ");
			if(in.hasNextDouble()){
				saldo=in.nextDouble();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		
		kontoeroeffnen(kunde, saldo);
		menuBank();
		
	}
	
	public void menuBank(){
		boolean input = true;
		int menu = 0;
		do{
		System.out.println("\n>> Bank Hauptmenü <<\n");
		System.out.println(">> Kunden anlegen   		(1) <<");
		System.out.println(">> Kunden löschen   		(2) <<");
		System.out.println(">> Geld einzahlen   		(3) <<");
		System.out.println(">> Geld auszahlen   		(4) <<");
		System.out.println(">> Kontoauszug      		(5) <<");
		System.out.println(">> Alle Konten anzeigen   	(6) <<");
		System.out.println(">> Beenden             		(7) <<\n");
		
		
			System.out.print(">> gewünschte Aktion: ");
			if(in.hasNextInt()){
				menu=in.nextInt();
				if(menu>0&&menu<7){
					input=false;
				}
			}
			in.nextLine();
			
		}while(input);
		menuaufruf(menu);
		
		
	}
	
	private void menuaufruf(int i){
		if(i==1){neuerKunde();}
		if(i==2){};
		if(i==3){};
		if(i==4){};
		if(i==5){};
		if(i==6){System.out.println(toString());if(in.hasNextLine()){menuBank();}};
		if(i==7){in.close();}
	}
}
