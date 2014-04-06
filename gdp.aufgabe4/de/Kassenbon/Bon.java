package de.Kassenbon;

import java.util.ArrayList;
import java.util.Scanner;

public class Bon {
	static ArrayList<Produkt> Produkte = new ArrayList<Produkt>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		einlesen();
		System.out.println(Produkte);
	}
	
	/**
	 * Einlese Methode
	 * liest Produkte ein und schreibt sie der Menge entsprechend in die Produktliste
	 * 
	 * beendet durch Produkt==exit(ignoreCase)
	 */
	
	static void einlesen(){
		String name;
		double preis=0;
		int mwst=0;
		int menge=0;
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
				if(in.hasNextInt()){
					menge=in.nextInt();
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
			
			for(int i = 0 ; i<menge;i++){
				Produkte.add(new Produkt(name, preis, mwst));
			}
			bmenge=true;bpreis=true;bmwst=true;
			
			
		}while(bprod);
		
		in.close();
		
	}

	/**
	 * fast gleiche Produktpositionen zu einer zusammen
	 */
	
	static void zusammenfassen(){
		
	}
}
