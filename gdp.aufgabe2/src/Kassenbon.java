import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Kassenbon einlesen und ausgeben
 * 
 * @author Stephan
 *
 */
public class Kassenbon {

	static String bon = "";
	static boolean run = true;
	/**
	 * Main Methode
	 * @param args
	 */
	public static void main(String[] args) {
		boolean x = true;
		Scanner in  = new Scanner(System.in);
		while(x){
			x=einlesen(in);
		}
		
		System.out.print("\nKassenbon wird ausgegeben....\n"+bon);
		
		in.close();
		
		
	}
	/**
	 * 
	 * @param in Scanner
	 * @return false falls exit eingeben wurde
	 */
	static boolean einlesen(Scanner in){
		String prod = "";
		double anz = 0, pre = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		
		in.reset();
		System.out.print(">> Produkt: "); 
		if(in.hasNext()){prod= in.next();}
		else{return true;}
		if(prod.equalsIgnoreCase("Exit")){in.close();return false;}
		System.out.print(">> Anzahl: "); 
		if(in.hasNextFloat()){anz=in.nextFloat();}
		else{return true;}
		System.out.print(">> Preis: ");
		if(in.hasNextFloat()){pre=in.nextFloat();}
		else{return true;}
		
		bon = bon + prod + " " + df.format(anz) + " x " + df.format(pre) + " € = "+ df.format(anz*pre) + " €\n";
		//System.out.println(bon);
		return true;
		}
	
	
}
