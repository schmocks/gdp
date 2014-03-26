import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Errechnet den Abstand zwischen 2 Punkten
 * im zweidimensionalen reelen Raum.
 * 
 * @author Stephan
 *
 */

public class XYPos {

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		xyInput();
			
	}
	
	/**
	 * Liest die Koordinaten von der Konsole ein
	 * 
	 */
	static void xyInput(){
		
		double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie den X-WERT der ERSTEN Koordinate ein: ");
		if(input.hasNextDouble()){x1=input.nextDouble();}
		else{System.out.println("Ungültige Eingabe!");xyInput();}
		
		System.out.print("Bitte geben Sie den Y-WERT der ERSTEN Koordinate ein: ");
		if(input.hasNextDouble()){y1=input.nextDouble();}
		else{System.out.println("Ungültige Eingabe!");xyInput();}
		
		System.out.print("Bitte geben Sie den X-WERT der ZWEITEN Koordinate ein: ");
		if(input.hasNextDouble()){x2=input.nextDouble();}
		else{System.out.println("Ungültige Eingabe!");xyInput();}
		
		System.out.print("Bitte geben Sie den Y-WERT der ZWEITEN Koordinate ein: ");
		if(input.hasNextDouble()){y2=input.nextDouble();}
		else{System.out.println("Ungültige Eingabe!");xyInput();}  
				
		System.out.println("Die Abstand zwischen den zwei Punkten beträgt: " + xyDistance(x1, y1, x2, y2));
		
		input.close();
	}
	
	/**
	 * Errechnet den Abstand
	 * 
	 * @param x1 X-Wert Koordinate 1
	 * @param y1 Y-Wert Koordinate 1
	 * @param x2 X-Wert Koordinate 2
	 * @param y2 X-Wert Koordinate 2
	 * @return Gekürztes Ergebnis als String
	 */
	
	static String xyDistance(double x1, double y1, double x2, double y2){
		
		DecimalFormat df = new DecimalFormat("0.00");
		double d = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return df.format(d);
	}

}
