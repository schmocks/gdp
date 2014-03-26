import java.util.Scanner;

/**
 * 
 * @author Stephan
 * 
 * Teilt ein Float durch einen andern Float
 *
 */
public class Divide {

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		divisor();
	}
	
	/**
	 * Einlese/Rechenmethode
	 * 
	 */
	static void divisor(){
		
		float x = 0, y = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie den Dividenden ein: ");
		if(input.hasNextFloat()){x = input.nextFloat();}
		else{System.out.println("Ungültige Eingabe!");divisor();}
		
		System.out.print("Bitte geben Sie den Divisor ein: ");
		if(input.hasNextFloat()){y = input.nextFloat();}
		else{System.out.println("Ungültige Eingabe!");divisor();}
		
		if(y!=0){System.out.println(x + " / " + y + " = " + (x/y));}
		else{System.out.println("Nicht möglich");divisor();}
		
		input.close();
	}
	
}
