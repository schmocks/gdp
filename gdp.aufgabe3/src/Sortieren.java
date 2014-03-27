import java.util.Random;
import java.util.Scanner;


public class Sortieren {

	/**
	 * Main Methode
	 */
	public static void main(String[] args) {
		int a=0,b=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Bitte den Zahlenbereich angeben: ");
		if(in.hasNextInt()){a=in.nextInt();}
		System.out.print("Bitte Anzahl der Zufallszahlen eingeben: ");
		if(in.hasNextInt()){b=in.nextInt();}
		in.close();
		int[] xx = generate(a,b);
		System.out.print("Zufallszahlen: ");
		for(int i = 0;i<xx.length;i++){
			System.out.print(xx[i] + ", ");
		}
		System.out.println("\nAufwärts sortiert: "+sort(xx, 1));
		System.out.println("Abwärts sortiert: "+sort(xx, 2));
	}

	/**
	 * 
	 * @param m Größte Zahl
	 * @param n Anzahl der Zahlen
	 * @return Array von Zufallszahlen
	 * 
	 */
	static int[] generate(int m, int n){
		
		int[] a = new int[n];
		
		for(int i = 0;i<n;i++){
			a[i] = check(a,m);
			}
		return a;
	}
	/**
	 * liefert eine in dem Array noch nicht vorhandene Zufallszahl 
	 * @param Array
	 * @param m Zahlenbereich
	 * @return Zufallszahl
	 */
	static int check(int[] x, int m){
		Random random = new Random();
		int rand = (random.nextInt(m))+1;
		for(int i = 0; i<x.length;i++){
			if(x[i]==rand){rand=check(x,m);}
		}
		return rand;
	}
	
	/**Sortiermethode
	 * 
	 * @param x zu sortierendes Array
	 * @param t 1=aufwärts 2=abwärts sortieren
	 * @return String mit dem sortiertem Inhalt des Arrays
	 */
	static String sort(int[] x, int t){
		int temp;
		String back = "";
		
		if(t==1){
			for(int i=1; i<x.length; i++) {
				for(int j=0; j<x.length-i; j++) {
					if(x[j]>x[j+1]) {
						temp=x[j]; x[j]=x[j+1]; x[j+1]=temp;
					}
				
				}
			}
			for(int i=0; i<x.length;i++){
				back = back + x[i] + ", ";
			}
		
		}
		if(t==2){
			for(int i=1; i<x.length; i++) {
				for(int j=0; j<x.length-i; j++) {
					if(x[j]<x[j+1]) {
						temp=x[j]; x[j]=x[j+1]; x[j+1]=temp;
					}
				
				}
			}
			for(int i=0; i<x.length;i++){
				back = back + x[i] + ", ";
			}
		
		}
	return back;
	
	
	}
}
