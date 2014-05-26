package bank.app;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Observable;
import java.util.Scanner;



/**
 * Bank Klasse
 * 
 * @author Stephan
 *
 */

public class Bank extends Observable {

	private ArrayList<Konto> konten = new ArrayList<Konto>();
	private short skontenz�hler = 4000;
	private short kontenz�hler = 5000;
	private short gkontenz�hler = 6000;
	
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
	 * Konto er�ffnen
	 * 
	 * @param kunde Kontoeigent�mer
	 * @param saldo Saldo des Kontos
	 * @return neues Konto
	 */
	
	public Konto kontoeroeffnen(Kunde kunde, BigDecimal saldo){
		
		Konto a = new Konto(kunde, kontenz�hler, saldo);
		
		konten.add(a);
		checkNr(2);
		kontenz�hler++;
		return a;
	}
	
	/**
	 * Konto er�ffnen
	 * 
	 * @param kunde Kontoeigent�mer
	 * @param saldo Saldo des Kontos
	 * @return neues Konto
	 */
	private void checkNr(int i){
		switch(i){
		case 1: if(((skontenz�hler+1)%1000)==0){skontenz�hler+=2000;};break;
		case 2:	if(((kontenz�hler+1)%1000)==0){kontenz�hler+=2000;};break;
		case 3: if(((gkontenz�hler+1)%1000)==0){gkontenz�hler+=2000;};break;
		default: break;
		}
		
		
		
	}
	
	/**
	 * Girokonto er�ffnen
	 * @param kunde
	 * @param saldo
	 * @return er�ffnetes Konto
	 */
	
	public Konto gkontoeroeffnen(Kunde kunde, BigDecimal saldo){
		Girokonto a = new Girokonto(kunde, gkontenz�hler, saldo);
		konten.add(a);
		checkNr(3);
		gkontenz�hler++;
		return a;
	}
	/**
	 * Sparkonto er�ffnen
	 * @param kunde
	 * @param saldo
	 * @return er�ffnetes Konto
	 */
	
	public Konto skontoeroeffnen(Kunde kunde,  BigDecimal saldo){
		Sparkonto a = new Sparkonto(kunde, skontenz�hler, saldo);
		konten.add(a);
		checkNr(1);
		skontenz�hler++;
		return a;
	}
	/**
	 * Kundensuche �ber Vor- und Nachname
	 * 
	 * @return Kunde oder falls nicht gefunden null
	 * 
	 */
	
	public Kunde getNameKunde(){
		String vorname; String nachname;
		System.out.println("\n>> Kundensuche �ber Namen <<\n");
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
	 * Kundensuche �ber Kontonummer
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
	 * Kontensuche �ber Kontonummer
	 * 
	 * @return Konto oder falls nicht gefunden null
	 */
	
	
	public Konto getNummerKonto(){
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
	 * Neuen Kunden anlegen und gleichzeitig ein Konto auf seinen Namen er�ffnen
	 * 
	 */
	
	public void neuerKunde(){
		String vorname; String nachname; BigDecimal saldo = new BigDecimal(0);
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
			if(in.hasNextBigDecimal()){
				saldo=in.nextBigDecimal();
				ba=false;
			}
			in.nextLine();
		}while(ba);
		switch(typ){
		case 1: skontoeroeffnen(kunde, saldo);break;
		case 2: gkontoeroeffnen(kunde, saldo);break;
		case 3: kontoeroeffnen(kunde, saldo);}
		
		System.out.println("\n>> Konto erfolgreich er�ffnet!\n");
		end();
		
	}
	
	
	/**
	 * Abfrage welcher Kontotyp
	 *
	 * @return int f�r Kontotyp
	 */
	
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
		System.out.println("\n>> Bank Hauptmen� <<\n");
		System.out.println(">> Kunden anlegen   		(1) <<");
		System.out.println(">> Kunden l�schen   		(2) <<");
		System.out.println(">> Geld einzahlen   		(3) <<");
		System.out.println(">> Geld auszahlen   		(4) <<");
		System.out.println(">> Kontoauszug      		(5) <<");
		System.out.println(">> Alle Konten anzeigen   	(6) <<");
		System.out.println(">> Beenden             		(7) <<\n");
		
		
			System.out.print(">> gew�nschte Aktion: ");
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
	 * Kunden l�schen
	 * 
	 */
	private void loescheKunde(){
		Kunde kunde = null;
		ArrayList<Konto> temp = new ArrayList<Konto>();
		System.out.println("\n>> Kunden l�schen <<\n");
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
		System.out.println("\n>> Kunde gel�scht");
		end();
	}
	
	/**
	 * Geld auf ein Konto einzahlen
	 */
	
	private void geldEinzahlen(){
		BigDecimal saldo = new BigDecimal(0);
		boolean ba = true;
		int merk= 0;
		System.out.println("\n>> Geld einzahlen <<\n");
		Konto konto = getNummerKonto();
		if(konto==null){menuBank();}
		System.out.println(">> Aktueller Kontostand: "+ konto.getSaldo());
		do{
			System.out.print(">> Einzahlbetrag: ");
			if(in.hasNextBigDecimal()){
				saldo=in.nextBigDecimal();
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
		BigDecimal saldo = new BigDecimal(0);
		boolean ba = true;
		int merk= 0;
		System.out.println("\n>> Geld auszahlen <<\n");
		Konto konto = getNummerKonto();
		if(konto==null){menuBank();}
		System.out.println(">> Aktueller Kontostand: "+ konto.getSaldo());
		do{
			System.out.print(">> Auszahlbetragbetrag: ");
			if(in.hasNextBigDecimal()){
				saldo=in.nextBigDecimal();
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
	 * Kontoausz�ge aller Konten eines Kunden
	 * 
	 */
	
	/**private void kontoauszuege(){
		Kunde kunde = getNameKunde();
		if(kunde==null){menuBank();}
		System.out.println("\n>> Kontosausz�ge von "+kunde+"\n");
		for(int i=0;i<konten.size();i++){
			if(konten.get(i).getKunde().equals(kunde)){
				Konto  konto = konten.get(i);
				System.out.println(">> Kontonummer: "+ konto.getKontonummer()+ " Saldo: "+konto.getSaldo());
			}
		}
		
		end();
	}*/
	
	/**
	 * Menuaufruf 
	 * @param i gew�nschtes Menu
	 * 
	 */
	
	private void menuaufruf(int i){
		switch(i){
		case 1: neuerKunde();break;
		case 2: loescheKunde();break;
		case 3: geldEinzahlen();break;
		case 4: geldAuszahlen();break;
		case 5: kontoauszug();break;
		case 6: kontenanzeigen();break;
		case 7: System.out.println("\n\n\n   ...und Tsch�ss");System.exit(0);	
			
		
		default: System.out.println("default");
		}

	}
		
	/**
	 * Zur�ck zum Hauptmen�
	 */
	
	private void end(){
		String end = "\nBitte Enter dr�cken um zum Hauptmen� zu gelangen.";
		System.out.println(end);if(in.hasNextLine()){menuBank();}
	}
	
	/**
	 * Gibt die ArrayList Konten aus
	 */
	
	private void kontenanzeigen(){
		Konto[] konto = konten.toArray(new Konto[konten.size()]);
		
		System.out.println("\n>> Alle Konten <<\n");
		Konto temp=null;
		for(int i=1; i<konto.length; i++) {
			for(int j=0; j<konto.length-i; j++) {
				if(konto[j].getKontonummer()>konto[j+1].getKontonummer()) {
					temp=konto[j]; konto[j]=konto[j+1]; konto[j+1]=temp;
					}
				}
			}
		for(int x=0;x<konto.length;x++){System.out.println(konto[x]);}
		end();
	}
	
	/**
	 * Ruft die f�r Kontonummer abfrage auf und schreibt Kontoausz�ge
	 */
	
	private void kontoauszug(){
		getNummerKonto().write();
		/**String[] x = (getNummerKonto().getAuszug());
		for(int i = 0; i<x.length;i++){
			System.out.println(x[i]);
		}*/
		end();
	}
	
	/**
	 * gibt den Betrag des gesamten eingelagert Geldes zur�vck
	 * 
	 * @return
	 */
	public BigDecimal getGesamtBetrag(){
		BigDecimal s = new BigDecimal(0);
		for(int i = 0; i<konten.size();i++){
			s=s.add(konten.get(i).getSaldo());
		}
		return s;
	}
	
	/**
	 * Gibt Kunden mit negativen Guthaben zur�ck
	 * @return
	 */
	
	public int getMieseKunden(){
		int x = 0; 
		for(int i = 0; i<konten.size();i++){
			if(konten.get(i).getSaldo().compareTo(new BigDecimal(0))==(-1)){
				x++;
			}
		}
		return x;
	}
	
	/**
	 * Gibt sortierte Arraylist zur�ck
	 * @return
	 */
	public ArrayList<Konto> getKonten(){
		Konto[] konto = konten.toArray(new Konto[konten.size()]);
		Konto temp=null;
		for(int i=1; i<konto.length; i++) {
			for(int j=0; j<konto.length-i; j++) {
				if(konto[j].getKontonummer()>konto[j+1].getKontonummer()) {
					temp=konto[j]; konto[j]=konto[j+1]; konto[j+1]=temp;
					}
				}
			}
		ArrayList<Konto> k = new ArrayList<Konto>();
		for(int x=0;x<konto.length;x++){k.add(konto[x]);}
		
		
		return k;
	}
	
	/**
	 * Gibt das Konto mit ktnr zur�ck
	 * @param ktnr
	 * @return
	 */
	public Konto getkt(short ktnr){
		for(int i = 0; i<konten.size();i++){
			if(ktnr==konten.get(i).getKontonummer()){return konten.get(i);};
		}
		return null;
	}
	/**
	 * Checkt ob die Kontonummer vorhanden ist
	 * @param ktnr
	 * @return
	 */
	public boolean tryktnr(short ktnr){
		for(int i = 0; i<konten.size();i++){
			if(ktnr==konten.get(i).getKontonummer()){return true;};
		}
		return false;
	}
	
	public void act(){
		setChanged();
	}
	
	/**
	 * L�scht das Konto mit folgenden Daten
	 * @param vorname
	 * @param nachname
	 * @param adresse
	 */
	public void KundenLoeschen(String vorname, String nachname, String adresse){
		ArrayList<Konto> temp = new ArrayList<Konto>();
		
		
		for(int i=0;i<konten.size();i++){
			Kunde kt = konten.get(i).getKunde();
			if(vorname.equals(kt.getVorname())&&nachname.equals(kt.getNachname())&&adresse.equals(kt.getAdresse())){
				temp.add(konten.get(i));
			}
		}
		konten.removeAll(temp);
		
	}
}

