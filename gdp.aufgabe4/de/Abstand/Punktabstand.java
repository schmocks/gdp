package de.Abstand;

import java.util.ArrayList;
import java.util.Scanner;

public class Punktabstand {
	static ArrayList<Punkt> Punkte = new ArrayList<Punkt>();
	
	public static void main(String[] args) {
		
	PunktEingabe();
	PunkteZeichnen();
	PunktDistanz();
		
	}
	
		
	/**
	 * Punkt eingeben
	 */

	static void PunktEingabe(){
		int n = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Bitte Anzahl der Punkte eingeben: ");
		if(input.hasNextInt()){n=input.nextInt();}
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i=1;i<=n;i++){
			System.out.print("X-Wert des "+i+". Punktes: ");
			if(input.hasNextInt()){x[i-1]=input.nextInt();}
			System.out.print("Y-Wert des "+i+". Punktes: ");
			if(input.hasNextInt()){y[i-1]=input.nextInt();}
			Punkte.add(new Punkt(i, x[i-1], y[i-1]));
			}
		input.close();
	}
	
	/**
	 * Zeichnet Punkte
	 */
	
	static void PunkteZeichnen(){
		int xmax=0,ymax=0;
		for(int i=0;i<Punkte.size();i++){
			if(Punkte.get(i).getX()>xmax){xmax=Punkte.get(i).getX();}
			if(Punkte.get(i).getY()>ymax){ymax=Punkte.get(i).getY();}
			}
		
		System.out.print("\n [y]");
		for(int i=ymax;i>=0;i--){
			if(i>99){System.out.print("\n"+i);}
			if(i>9&&i<100){System.out.print("\n "+i);}
			if(i<10&&i>0){System.out.print("\n  "+i);}
			zeichneZeile(i);
			if(i==0){
				System.out.print("\n  0  ");
				for(int j=1; j<=xmax;j++){
					System.out.print(j+"  ");
					if(j==xmax){System.out.println("[x]\n");}
				}
				
			}
		}
		
		}
	
	/**
	 * Zeichnet Zeile
	 * @param Zeilennummer
	 * @return Zeile als String
	 */
	static String zeichneZeile(int i){
		
		for(int x=0;x<Punkte.size();x++){
			if(Punkte.get(x).getY()==i){
				System.out.print("");
				for(int y=0;y<Punkte.get(x).getX();y++){
					if(y==0){System.out.print("  ");}
					if(y>0&&y<10){System.out.print("   ");}
					if(y>=10&&y<100){System.out.print("    ");}
					if(y>=100){System.out.print("    ");}
				}
				System.out.print("x" + Punkte.get(x).getIndex());
			}
		}
		return null;
	}
	
	/**
	 * errechnet Punktdistanz
	 */	
	static void PunktDistanz(){
		for(int i=1;i<Punkte.size();i++){
			System.out.print("Entfernung P" + Punkte.get(0).getIndex() + " > P" + Punkte.get(i).getIndex() + ": ");
			System.out.println(Punkte.get(0).getAbstand(Punkte.get(i)));
		}
		Punkte.remove(0);
		if(Punkte.size()>1){PunktDistanz();}
		
	}
	
		
		
		
		
	
	
}
