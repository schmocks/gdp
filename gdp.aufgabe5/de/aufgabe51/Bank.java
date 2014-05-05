package de.aufgabe51;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bank Klasse
 * 
 * @author Stephan
 *
 */

public class Bank {

	private ArrayList<Konto> konten = new ArrayList<Konto>();
	private short kontenzähler = 5000;
	Scanner in = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");

	
	
	public String toString(){
		String s = "";
		for(int i=0;i<konten.size();i++){
			s+=konten.get(i);
			s+="\n";
		}
		return s;
	}
	
	/**
	 * Konto eröffnen
	 * 
	 * @param kunde Kontoeigentümer
	 * @param saldo Saldo des Kontos
	 * @return neues Konto
	 */
	
	public Konto kontoeroeffnen(Kunde kunde, double saldo){
		
		Konto a = new Konto(kunde, kontenzähler, saldo);
		konten.add(a);
		kontenzähler++;
		return a;
	}
	
	/**
	 * Konto eröffnen
	 * 
	 * @param kunde Kontoeigentümer
	 * @param saldo Saldo des Kontos
	 * @return neues Konto
	 */
	
	public Konto gkontoeroeffnen(Kunde kunde, double saldo){
		Short x = (short) (kontenzähler+1000);
		Girokonto a = new Girokonto(kunde, x, saldo);
		konten.add(a);
		kontenzähler++;
		return a;
	}
	
	public Konto skontoeroeffnen(Kunde kunde, double saldo){
		Short x = (short) (kontenzähler-1000);
		Sparkonto a = new Sparkonto(kunde, x, saldo);
		konten.add(a);
		kontenzähler++;
		return a;
	}
	/**
	 * Kundensuche über Vor- und Nachname
	 * 
	 * @return Kunde oder falls nicht gefunden null
	 * 
	 */
	
	public Kunde getNameKunde(){
		String vorname; String nachname;
		System.out.println("\n>> Kundensuche über Namen <<\n");
		System.out.print(">> Bitte Vornamen eingeben: ");
		vorname = in.nextLine();
		System.out.print(">> Bitte Nachnamen eingeben: ");
		nachname = in.nextLine();
		
		
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getKunde().getVorname().equals(vorname)
			   &&konten.get(i).getKunde().getNachname().equals(nachname)){
				return konten.get(i).getKunde();
			}
		}
		System.out.println("\n>> Eintrag nicht gefunden!");
		end();
		return null;
	}
	
	/**
	 * 
	 * Kundensuche über Kontonummer
	 * 
	 * @return Kunde oder falls nicht gefunden null
	 * 
	 */
	
	public Kunde getNummerKunde(){
		Short kontonummer = 0;
		boolean ba = true;
		System.out.println("\n>> Kontensuche <<\n");
		do{
			System.out.print(">> Kontonummer: ");
			if(in.hasNextShort()){
				kontonummer=in.nextShort();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getKontonummer()==kontonummer){
				return konten.get(i).getKunde();
			}
		}
		System.out.println("\n>> Eintrag nicht gefunden!");
		end();
		return null;
	
	}
	
	/**
	 * Kontensuche über Kontonummer
	 * 
	 * @return Konto oder falls nicht gefunden null
	 */
	
	
	private Konto getNummerKonto(){
		Short kontonummer = 0;
		boolean ba = true;
		System.out.println("\n>> Kontensuche <<\n");
		do{
			System.out.print(">> Kontonummer: ");
			if(in.hasNextShort()){
				kontonummer=in.nextShort();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getKontonummer()==kontonummer){
				return konten.get(i);
			}
		}
		System.out.println("\n>> Eintrag nicht gefunden!");
		return null;
	}
	
	/**
	 * Neuen Kunden anlegen und gleichzeitig ein Konto auf seinen Namen eröffnen
	 * 
	 */
	
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
		int typ = Kontotyp();
		do{
			System.out.print(">> Saldo: ");
			if(in.hasNextDouble()){
				saldo=in.nextDouble();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		switch(typ){
		case 1: skontoeroeffnen(kunde, saldo);break;
		case 2: gkontoeroeffnen(kunde, saldo);break;
		case 3: kontoeroeffnen(kunde, saldo);}
		
		System.out.println("\n>> Konto erfolgreich eröffnet!\n");
		end();
		
	}
	
	private int Kontotyp(){
		boolean ba = true;
		int i = 0;
		System.out.println(">> Sparkonto (1) | Girokonto (2) | Standardkonto (3)");
		do{
			System.out.print(">> Kontotyp: ");
			if(in.hasNextInt()){
				i=in.nextInt();
				if(i>0&&i<4){ba=false;}
			}
			in.nextLine();
		}while(ba);
		return i;
	}
	
	/**
	 * Hauptmenu der Bank
	 * 
	 */
	
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
				if(menu>0&&menu<8){
					input=false;
				}
				
			}
			in.nextLine();
			
		}while(input);
		menuaufruf(menu);
		
		
	}
	
	/**
	 * Kunden löschen
	 * 
	 */
	private void loescheKunde(){
		Kunde kunde = null;
		ArrayList<Konto> temp = new ArrayList<Konto>();
		System.out.println("\n>> Kunden löschen <<\n");
		kunde=getNameKunde();
		if(kunde==null){menuBank();}
		else{
			for(int x=0; x<konten.size();x++){
				if(!(konten.get(x).getKunde().equals(kunde))){
					temp.add(konten.get(x));
				}
			}
		}
		konten=temp;
		System.out.println("\n>> Kunde gelöscht");
		end();
	}
	
	/**
	 * Geld auf ein Konto einzahlen
	 */
	
	private void geldEinzahlen(){
		double saldo = 0;
		boolean ba = true;
		int merk= 0;
		System.out.println("\n>> Geld einzahlen <<\n");
		Konto konto = getNummerKonto();
		if(konto==null){menuBank();}
		System.out.println(">> Aktueller Kontostand: "+ konto.getSaldo());
		do{
			System.out.print(">> Einzahlbetrag: ");
			if(in.hasNextDouble()){
				saldo=in.nextDouble();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		
		for(int i=0;i<konten.size();i++){
			if(konten.get(i).equals(konto)){
				konten.get(i).einzahlen(saldo);
				merk=i;
			}
		}
		System.out.println(">> Neuer Kontostand: "+df.format(konten.get(merk).getSaldo()));
		end();
			
	}
	
	/**
	 * Geld von einem Konto auszahlen
	 * 
	 */
	private void geldAuszahlen(){
		double saldo = 0;
		boolean ba = true;
		int merk= 0;
		System.out.println("\n>> Geld auszahlen <<\n");
		Konto konto = getNummerKonto();
		if(konto==null){menuBank();}
		System.out.println(">> Aktueller Kontostand: "+ konto.getSaldo());
		do{
			System.out.print(">> Auszahlbetragbetrag: ");
			if(in.hasNextDouble()){
				saldo=in.nextDouble();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		
		for(int i=0;i<konten.size();i++){
			if(konten.get(i).equals(konto)){
				konten.get(i).auszahlen(saldo);
				merk=i;
			}
		}
		System.out.println(">> Neuer Kontostand: "+df.format(konten.get(merk).getSaldo()));
		end();
	}
	
	/**
	 * Kontoauszüge aller Konten eines Kunden
	 * 
	 */
	
	private void kontoauszuege(){
		Kunde kunde = getNameKunde();
		if(kunde==null){menuBank();}
		System.out.println("\n>> Kontosauszüge von "+kunde+"\n");
		for(int i=0;i<konten.size();i++){
			if(konten.get(i).getKunde().equals(kunde)){
				Konto konto = konten.get(i);
				System.out.println(">> Kontonummer: "+ konto.getKontonummer()+ " Saldo: "+konto.getSaldo());
			}
		}
		
		end();
	}
	
	/**
	 * Menuaufruf 
	 * @param i gewünschtes Menu
	 * 
	 */
	
	private void menuaufruf(int i){
		switch(i){
		case 1: neuerKunde();
		case 2: loescheKunde();
		case 3: geldEinzahlen();
		case 4: geldAuszahlen();
		case 5: kontoauszuege();
		case 6: kontenanzeigen();
		case 7: System.out.println("\n\n\n   ...und Tschüss");System.exit(0);	
			
		
		default: System.out.println("default");
		}

	}
		
	/**
	 * Zurück zum Hauptmenü
	 */
	
	private void end(){
		String end = "\nBitte Enter drücken um zum Hauptmenü zu gelangen.";
		System.out.println(end);if(in.hasNextLine()){menuBank();}
	}
	
	/**
	 * Gibt die ArrayList Konten aus
	 */
	
	private void kontenanzeigen(){
		System.out.println("\n>> Alle Konten <<\n");
		for(int x=0;x<konten.size();x++){System.out.println(konten.get(x));}
		end();
	}
}