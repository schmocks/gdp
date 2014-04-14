package de.Kassenbon;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bon {
	static ArrayList<Produkt> Produkte = new ArrayList<Produkt>();
	static String MWST = "";
	static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		einlesen();
		sortiereListe();
		ausgabeProdukte();
		zusammenrechnen(Produkte);
		
	}
	
	/**
	 * Einlese Methode
	 * liest Produkte 
	 * 
	 * beendet durch Produkt==exit(ignoreCase)
	 */
	
	static void einlesen(){
		String name;
		double preis=0;
		int mwst=0;
		double menge=0;
		boolean bprod=true,bpreis=true,bmwst=true,bmenge=true;
		
		
		Scanner in = new Scanner(System.in);
		
		do{
			System.out.print(">> Produkt: ");
			name = in.nextLine();
			if(name.equalsIgnoreCase("Exit")){
				bprod=false;
				in.close();
				return;
			}
			
			do{
				System.out.print(">> Menge: ");
				if(in.hasNextDouble()){
					menge=in.nextDouble();
					bmenge=false;
				}
				in.nextLine();
				
			}while(bmenge);
			
			do{
				System.out.print(">> Preis: ");
				if(in.hasNextDouble()){
					preis=in.nextDouble();
					bpreis=false;
				}
				in.nextLine();
				
			}while(bpreis);
			
			do{
				System.out.print(">> MwSt (%): ");
				if(in.hasNextInt()){
					mwst=in.nextInt();
					if(mwst==7||mwst==19){
					bmwst=false;
					}
				}
				in.nextLine();
				
			}while(bmwst);
			
			schreibProdukt(new Produkt(name, preis, mwst, menge));
			
			bmenge=true;bpreis=true;bmwst=true;
			
			
		}while(bprod);
		
		in.close();
		
	}

	/**
	 * Schreibt Produkt auf Liste falls vorhanden ändert es die Menge sonst neues Produkt
	 * 	
	 * @param produkt neues Produkt
	 */
	
	static void schreibProdukt(Produkt produkt){
		Produkt p = null;
		int pi = 0;
		boolean pb = false;
		for(int i = 0; i< Produkte.size();i++){
			if(Produkte.get(i).getName().equals(produkt.getName())){
				if(Produkte.get(i).getPreis()==produkt.getPreis()){
					if(Produkte.get(i).getMwst()==produkt.getMwst()){
						p = Produkte.get(i);
						double m = p.getMenge();
						p.setMenge(m+=produkt.getMenge());
						pi=i;
						pb=true;
					}
				}
			}
		}
		if(pb){
			Produkte.remove(pi);
			Produkte.add(p);
		}
		else{
			Produkte.add(produkt);
		}
	}
	
	static void sortiereListe(){
		ArrayList<Produkt> pro7 = new ArrayList<Produkt>();
		ArrayList<Produkt> pro19 = new ArrayList<Produkt>();
		for(int i = 0; i<Produkte.size();i++){
			if(Produkte.get(i).getMwst()==7){
				pro7.add(Produkte.get(i));
			}
			else{
				pro19.add(Produkte.get(i));
			}
		}
		Produkte.clear();
		Produkte.addAll(sortierePreis(pro7));
		Produkte.addAll(sortierePreis(pro19));
		
	}
	
	static ArrayList<Produkt> sortierePreis(ArrayList<Produkt> p){
		Produkt[] produkt = p.toArray(new Produkt[p.size()]);
		
		Produkt temp = null;
		for(int i=1;i<p.size();i++){
			for(int j=0;j<p.size()-i;j++){
				if(produkt[j].getPreis()>produkt[j+1].getPreis()){
					temp=produkt[j];produkt[j]=produkt[j+1];produkt[j+1]=temp;
				}
			}
		}
		ArrayList<Produkt> sort = new ArrayList<Produkt>(Arrays.asList(produkt)); 
		return sort;
	}
	
	static void zusammenrechnen(ArrayList<Produkt> p){
		double mwst7 = 0;
		double mwst19 = 0;
		double gpreis = 0;
		
		for(int i=0;i<Produkte.size();i++){
			Produkt temp = Produkte.get(i);
			double ppreis = (temp.getPreis()*temp.getMenge());
			if(temp.getMwst()==7){
				mwst7+=(ppreis/107)*7;
			}
			else{
				mwst19+=(ppreis/119)*19;
			}
			gpreis+=ppreis;
		}
		System.out.println(">> Gesamtpreis: " + df.format(gpreis) + " €");
		System.out.print(">> Darin enthalten: " + df.format(mwst7) + " € MwSt zu 7% + ");
		System.out.println(df.format(mwst19) + " € MwSt zu 19 %");
	}

	static void ausgabeProdukte(){
		boolean m = true;
		System.out.println("\n\n\n>> Kassenbon folgt...");
		for(int i = 0;i<Produkte.size();i++){
			Produkt p = Produkte.get(i);
			double preis = (p.getPreis()*p.getMenge());
			if(i==0&&p.getMwst()==7){
				System.out.println(">> Produkte mit 7% MwSt:");
			}
			if(p.getMwst()==19&&m){
				System.out.println(">> Produkte mit 19% MwSt:");
				m=false;
			}
			System.out.println(p + " = " + df.format(preis) + " €");
		}
	}
	}

