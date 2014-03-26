import java.util.Scanner;

/**
 * 
 * @author Stephan
 *
 * Liest den Namen eines Nutzers ein und gibt ihn
 * mit einer Begrüßung wieder aus
 * 
 */

public class Username {

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
	
	String name = "";
	Scanner input = new Scanner(System.in);
	
	System.out.print("Bitte geben Sie ihren Namen ein: ");
	name = input.nextLine(); 
	
	System.out.println("Willkommen " + name + "!");
	
	input.close();	
	}

}
