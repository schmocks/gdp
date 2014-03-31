import java.util.Scanner;


public class Pruefnummer {


	/**Mainmethode
	 * @param args
	 */
	public static void main(String[] args) {
		
		einlesen();
		
		}

	/**
	 * Seriennummer einlesen
	 * 
	 */
	static void einlesen(){
		Scanner in = new Scanner(System.in);
		System.out.print("Bitte die Seriennummer eingeben: ");
		String input=in.nextLine();
		input=input.toUpperCase();
		in.close();
		
		if(checkInput(input)){check(input);}
		
	}
	/**
	 * Überprüfen ob Seriennummer den Regeln entspricht
	 * @param s Seriennummer
	 * @return true wenn ok
	 */
	static boolean checkInput(String s){
		if(s.length()!=12){System.out.println("!Länge!");return false;}
		String Buchstabe = s.substring(0, 1);
		String Zahlen = s.substring(1);
		String regA = "[A-Z]";
		String regB = "[0-9]*";
		if(!Buchstabe.matches(regA)){System.out.println("!Buchstabe!");return false;}
		if(!Zahlen.matches(regB)){System.out.println("!Zahlen!");return false;}
		
		return true;
		
	}
	
	/**
	 * Überprüfen der Nummer
	 * @param x Seriennnummer
	 * @return true wenn ok
	 */
	static boolean check(String x){
		int z = CharToInt(x.charAt(0));
		
		String zahlen = x.substring(1, 11);
		for(int i = 0; i<zahlen.length(); i++){
			z=z + Integer.parseInt(zahlen.substring(i,i+1));
		}
		if(8-z%9==Integer.parseInt(x.substring(11))){
			System.out.println("Prüfziffer: " + x.substring(11));
			System.out.println("Die Seriennummer entspricht den Regeln!");
			return true;
			}
		System.out.println("Seriennummer falsch!");
		return false;
	}
	/**
	 * Wandel Buchstabe in Quersumme
	 * @return Quersumme des Alphabet-Index
	 */
	static int CharToInt(char s){
		int z = 0 , zz = 0;
		String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = alphabetString.toCharArray();
		for(int i = 0; i<alphabet.length;i++){
			if(alphabet[i]==s){z =  i+1;}
			}
		
		while(0!=z){
			zz = zz +(z%10);
			z = z/10;
		}
		
		return zz;
		
	}


}
