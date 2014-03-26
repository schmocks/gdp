import java.util.Scanner;
import java.lang.String;

/**
 * Verschl�sselung und Entschl�sselungs Programm
 * 
 * @author Stephan
 *
 */

public class Kryptographie {

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	
		String wort = "";
		String wort2 = "";
		Scanner input = new Scanner(System.in);
		System.out.print("Bitte geben Sie ein Wort ein: ");
		wort = input.nextLine();
		
		System.out.println(code(wort));
		
		wort2 = code(wort);
		
		System.out.println(decode(wort2));
		
		input.close();

	}
	
	/**
	 * Codiermethode
	 * 
	 * @param wort Unverschl�sselt
	 * @return Verschl�sselt
	 */
	static String code(String wort){
		
		byte[] bytes = wort.getBytes();
		int l = wort.length();
		for(int i= 0; i<l; i++){
			bytes[i]++;
		}
		return new String(bytes);
	}

	/**
	 * Decodiermethode
	 * 
	 * @param wort Verschl�sselt
	 * @return Unverschl�sselt
	 */
	static String decode(String wort){
		
		byte[] bytes = wort.getBytes();
		int l = wort.length();
		for(int i= 0; i<l; i++){
			bytes[i]--;
		}
		return new String(bytes);
		
	}
}
