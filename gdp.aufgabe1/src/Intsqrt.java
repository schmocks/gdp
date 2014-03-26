import java.util.Scanner;

/**
 * 
 * @author Stephan
 *
 * Gibt das Quadrat einer Ganzzahl aus
 * 
 */

public class Intsqrt {

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		intSquare();
		
	}
	
	/**
	 * Einlese/Rechenmethode
	 * 
	 */
	static void intSquare(){
		long x = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Ganze Zahl ein: ");
		if(input.hasNextInt()){
			x = input.nextInt();
			System.out.println(x +"² = " + x*x);
			}
		
		else{
			System.out.println("Ungültige Eingabe!");
			intSquare();
			}
		
		input.close();
	}

}

