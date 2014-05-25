package bank.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



/**
 * Konto Klasse
 * 
 * @author Stephan
 *
 */

public class Konto {

	private Kunde kunde;
	private short kontonummer;
	private BigDecimal saldo;
	
	DecimalFormat df = new DecimalFormat("0.00");
	private List<Vorgang> Auszug = new ArrayList<Vorgang>();
	
	
	/**
	 * to String
	 */
	
	public String toString(){
		
		return "Kunde: "+kunde+" Ktnr: "+kontonummer+ " Saldo: "+df.format(saldo);
	}
	
	Konto(Kunde kunde, short kontonummer, BigDecimal saldo){
		this.kunde=kunde;this.kontonummer=kontonummer;this.saldo=saldo;
		Auszug.add(new Vorgang(new BigDecimal(0), saldo, saldo));
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public short getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(short kontonummer) {
		this.kontonummer = kontonummer;
	}

	public void setSaldo(BigDecimal saldo){
		this.saldo=saldo;
	}
	public BigDecimal getSaldo() {
		BigDecimal temp = new BigDecimal(0);
		temp = saldo;
		return temp.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	
	
	/**
	 * Einzahl Methode
	 * 
	 * @param summe
	 */
	
	public void einzahlen(BigDecimal summe){
		
		addBewegung(kontonummer, summe, 0);
		this.saldo=saldo.add(summe);
	}
	
	
	/**
	 * Auszahl Methode
	 * 
	 * negatives Saldo nicht möglich
	 * 
	 * @param summe gewünschte Auszahlsumme
	 */
	
	public void auszahlen(BigDecimal summe){
		
		if(summe.compareTo(saldo)>=0){
			System.out.println(">> Auszahlung nicht möglich");
			return;
		}else{
			addBewegung(kontonummer, summe, 1);
			this.saldo=saldo.subtract(summe);
		}
	}
	/**
	 * 
	 * @param kontonummer des Kontos
	 * @param summe 
	 * @param i 0=einzahlen, 1=auszahlen
	 */
	public void addBewegung(short kontonummer, BigDecimal summe, int i){
		BigDecimal temp = saldo;
		
		switch(i){
		case 0: temp=temp.add(summe);Auszug.add(new Vorgang(saldo, summe, temp));break;
		case 1: temp=temp.subtract(summe);Auszug.add(new Vorgang(saldo, summe.negate(), temp));break;
		}
	}
	
	/**
	 * Gibt Auszug als String auf der Konsole aus
	 * @return Auszug als String
	 */
	public Vorgang[] getAuszug(){
		Vorgang[] x = Auszug.toArray(new Vorgang[Auszug.size()]); 
		
		return x;
	}
	
	/**
	 * Kontoauszug als XML Datei ausgeben
	 */
	
	public void write(){
		OutputStream out = null;
		try {
			out = new FileOutputStream(getKontonummer()+".xml");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Element root = new Element("Kontoauszug");
		Document doc = new Document(root);
		Date nowdate = new Date();
		for(int i=0;i<Auszug.size();i++){
			Vorgang v = Auszug.get(i);
			Element Vorgang = new Element("Vorgang");
			Element Datum = new Element("Datum");
			Element SaldoAlt = new Element("SaldoAlt");
			Element Buchung = new Element("Buchung");
			Element SaldoNeu = new Element ("SaldoNeu");
			nowdate.setTime(v.getDatum());
			Datum.addContent(nowdate.toString());
			SaldoAlt.addContent(String.valueOf(v.getSaldoAlt()));
			Buchung.addContent(String.valueOf(v.getBuchung()));
			SaldoNeu.addContent(String.valueOf(v.getSaldoNeu()));
			Vorgang.addContent(Datum);Vorgang.addContent(SaldoAlt);Vorgang.addContent(Buchung);
			Vorgang.addContent(SaldoNeu);			
			root.addContent(Vorgang);
		}
		XMLOutputter outer = new XMLOutputter();
		outer.setFormat(Format.getPrettyFormat());
		try {
			outer.output(doc, out);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


}
