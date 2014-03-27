import java.util.Scanner;


public class Blutgruppe {

	/**Mainmethode
	 * @param args
	 */
	public static void main(String[] args) {
		
		einlesen();
		
		
		}

	/**
	 * Liest die Konsole ein
	 * 
	 */
	
	static void einlesen(){
		String mutter = "", vater = "";
		Scanner in = new Scanner(System.in);
		System.out.print("Blutgruppe der Mutter: ");
		if(in.hasNextLine()){mutter=in.nextLine().toUpperCase();}
		System.out.print("Blutgruppe des Vaters: ");
		if(in.hasNextLine()){vater=in.nextLine().toUpperCase();}
		//System.out.println(vater + " " + mutter);
		in.close();
		if(checkInput(vater, mutter)){
			auswertung(vater, mutter);
		}
		
	}

	/**
	 * Kontrolliert ob richtige Eingabe
	 * @param a Blutgruppe Vater
	 * @param b Blutgruppe Mutter
	 * @return true wenn richtig
	 */
	static boolean checkInput(String a, String b){
		if(a.length()!=2||b.length()!=2){System.out.println("Eingabe falsch!");return false;}
		String reg = "[A-B0]*";
		if(!a.matches(reg)||!b.matches(reg)){System.out.println("Eingabe falsch!");return false;}
		return true;
	}

	/**
	 * Werte die Blutruppen aus
	 * 
	 * @param x Blutgruppe Vater
	 * @param y Blutgruppe Mutter
	 */
	
	static void auswertung(String x, String y){
		char[] vater = x.toCharArray();
		char[] mutter = y.toCharArray();
		int a=0,b=0,ab=0,n=0;
		for(int i = 0; i<2;i++){
			for(int j = 0; j<2;j++){
				if(vater[i]=='A'&&mutter[j]=='A'){a++;}
				if(vater[i]=='A'&&mutter[j]=='B'){ab++;}
				if(vater[i]=='A'&&mutter[j]=='0'){a++;}
				if(vater[i]=='B'&&mutter[j]=='A'){ab++;}
				if(vater[i]=='B'&&mutter[j]=='B'){b++;}
				if(vater[i]=='B'&&mutter[j]=='0'){b++;}
				if(vater[i]=='0'&&mutter[j]=='A'){a++;}
				if(vater[i]=='0'&&mutter[j]=='B'){b++;}
				if(vater[i]=='0'&&mutter[j]=='0'){n++;}
			}
		}
		System.out.println("Mit " + a*25 + "% Wahrscheinlichkeit wird das Kind Blutgruppe A haben.");
		System.out.println("Mit " + ab*25 + "% Wahrscheinlichkeit wird das Kind Blutgruppe AB haben.");
		System.out.println("Mit " + b*25 + "% Wahrscheinlichkeit wird das Kind Blutgruppe B haben.");
		System.out.println("Mit " + n*25 + "% Wahrscheinlichkeit wird das Kind Blutgruppe 0 haben.");
		
		
	}
}


