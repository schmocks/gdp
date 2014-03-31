package de.Abstand;

import java.util.ArrayList;
import java.util.Scanner;

public class Punktabstand {

	
	public static void main(String[] args) {
	Punkt[] p = PunktKoord();
	for(int i = 0; i<p.length;i++){
		System.out.println(p[i]);
		
		if(i>0){System.out.println(p[i].getAbstand(p[i-1]));}
	}
	
		
	}
	

	static Punkt[] PunktKoord(){
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
			}
		input.close();
		return PunktErstellen(x, y);
		
	}
	
	static Punkt[] PunktErstellen(int[] x, int[] y){
		Punkt[] punkte = new Punkt[x.length];
		for(int i = 0 ; i < x.length; i++){
			punkte[i]= new Punkt(i+1, x[i], y[i]);
		}
		
		return punkte;
		
	
		
		
		
		
	}
	
}
