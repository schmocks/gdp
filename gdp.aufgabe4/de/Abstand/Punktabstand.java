package de.Abstand;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Punktabstand {
	static ArrayList<Punkt> Punkte = new ArrayList<Punkt>();
	
	
	public static void main(String[] args) {
	
	//punkteErzeugen();
	punkteEingabe();
	punktePruefen();
	punkteZeichnen(punkteSortieren());
	punkteDistanz();
	
		
	}
	
		
	/**
	 * Punkt eingeben
	 */

	static void punkteEingabe(){
		boolean b1=true;
		int n = 0;
		int x =0;
		int y =0;
		Scanner input = new Scanner(System.in);
		do{
			System.out.print("Bitte Anzahl der Punkte eingeben: ");
			if(input.hasNextInt()){
				b1=false;
				n=input.nextInt();
			}
			input.nextLine();			
		}while(b1);
		
		for(int i=1;i<=n;i++){
			boolean b2=true,b3=true;
			do{
				System.out.print("X-Wert des "+i+". Punktes: ");
				if(input.hasNextInt()){
					b2=false;
					x=input.nextInt();
				}
				input.nextLine();
			}while(b2);
			do{
				System.out.print("Y-Wert des "+i+". Punktes: ");
				if(input.hasNextInt()){
					b3=false;
					y=input.nextInt();
				}
				input.nextLine();
			}while(b3);
			Punkte.add(new Punkt(i, x, y));
			}
		input.close();
	}
	
	/**
	 * Zeichnet Punkte
	 */
	
	static void punkteZeichnen(Punkt[] punkte){
		int xmax=0,ymax=0;
		for(int i=0;i<punkte.length;i++){
			if(punkte[i].getX()>xmax){xmax=punkte[i].getX();}
			if(punkte[i].getY()>ymax){ymax=punkte[i].getY();}
			}
		
		System.out.print("\n [y]");
		for(int i=ymax;i>=0;i--){
			if(i>99){System.out.print("\n"+i);}
			if(i>9&&i<100){System.out.print("\n "+i);}
			if(i<10&&i>0){System.out.print("\n  "+i);}
			zeichneZeile(punkte, i);
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
	static String zeichneZeile(Punkt[] punkte,int i){
		String space = "",sp1 = " ", sp2 = "  ",sp3 = "   ";
		int s=0,anz=0;
		for(int x=0;x<punkte.length;x++){
			
			if(punkte[x].getY()==i){
				//System.out.print("");
				for(int y=s;y<punkte[x].getX();y++){
					if(y==0){space=sp2;}
					if(y>0&&y<10){space=space+sp1+sp2;}
					if(y>=10&&y<100){space=space+sp2+sp2;}
					if(y>=100){space=space+sp3+sp2;}
					
				}
				if(anz!=0){space=space.substring(anz-1);}
				System.out.print(space+"x"/* + punkte[x].getIndex()*/);
				//s=x;
				s=punkte[x].getX();
				//space=space.substring(1);
				anz+=2;
			}
			//s=0;
		}
		return null;
	}
	
	/**
	 * errechnet Punktdistanz
	 */	
	static void punkteDistanz(){
		for(int i=1;i<Punkte.size();i++){
			System.out.print("Entfernung P" + Punkte.get(0).getIndex() + " <-> P" + Punkte.get(i).getIndex() + ": ");
			System.out.println(Punkte.get(0).getAbstand(Punkte.get(i)));
		}
		Punkte.remove(0);
		if(Punkte.size()>1){punkteDistanz();}
		
	}
	
	static Punkt[] punkteSortieren(){
		Punkt[] punkte = Punkte.toArray(new Punkt[Punkte.size()]);
		Punkt temp;
		for(int i=1; i<punkte.length; i++) {
			for(int j=0; j<punkte.length-i; j++) {
				if(punkte[j].getX()>punkte[j+1].getX()) {
					temp=punkte[j]; punkte[j]=punkte[j+1]; punkte[j+1]=temp;
					}
				}
			}
		return punkte;
		
					
	}
		
	static void punktePruefen(){
		System.out.println("\nEingegebene Punkte: " + Punkte);
		boolean is = false;
		Punkt[] punkte = Punkte.toArray(new Punkt[Punkte.size()]);
		ArrayList<Punkt> rem = new ArrayList<Punkt>();
		rem=Punkte;
		for(int i = 0; i<punkte.length;i++){
			for(int j = i+1;j<punkte.length;j++){
				if(punkte[i].getX()==punkte[j].getX()&&punkte[i].getY()==punkte[j].getY()){
					int p1 = punkte[i].getIndex();
					int p2 = punkte[j].getIndex();
					System.out.println("P"+ p1 +" und P"+p2+" sind identisch, P"+p2+" wird entfernt!");
					is = true;
					if(rem.contains(punkte[j])){
						rem.remove(punkte[j]);						
					}
				}
				
			}
		}
		Punkte=rem;
		if(is){
			System.out.println("Folgende Punkte werden gezeichnet: " + Punkte);
		}
			
	}
		
	static void punkteErzeugen(){
		Random r = new Random();
		boolean b1=true;
		int n = 0;
		Scanner input = new Scanner(System.in);
		do{
			System.out.print("Bitte Anzahl der Punkte eingeben: ");
			if(input.hasNextInt()){
				b1=false;
				n=input.nextInt();
			}
			input.nextLine();			
		}while(b1);
		input.close();
		for(int i=1; i<=n;i++){
			Punkte.add(new Punkt(i, r.nextInt(9)+1, r.nextInt(9)+1));
		}
	}
	
	
}
