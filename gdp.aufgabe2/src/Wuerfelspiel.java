import java.util.Calendar;
import java.util.Random;

/**
 * 
 * Ein Würfelspiel
 * 
 * @author Stephan
 *
 */

public class Wuerfelspiel {

	/**
	 * Main Methode
	 */
	public static void main(String[] args) {
		
		simulation(20000,0.5);
		
	}

	/**
	 * Eine Runde Spielen
	 * @param einsatz Einsatz für diese Runde
	 * @return Gewinn / Verlust
	 */
	
	static double spielen(double einsatz){
		int augen;
		for(int i=1;i<51;i++){
			augen = wuerfel() + wuerfel();
			if(augen==12){einsatz = einsatz + 1;}
			if(augen==11){einsatz = einsatz +0.5;}
			if(augen==10){einsatz = einsatz +0.25;}
			if(augen<7){einsatz = einsatz -0.5;}
			//System.out.println(augen + "   " + einsatz);
			}
		return einsatz;
	}
	
	/**
	 * Wuerfel
	 * @return eine Zufallszahl zwischen 1 bis 6
	 * 
	 */
	static int wuerfel(){
		Calendar time = Calendar.getInstance();
		Random random = new Random();
		int i = (int) ((time.getTimeInMillis()/random.nextInt(Integer.MAX_VALUE))%6)+1;		
		return i;
	}
	
	/**
	 * Simuliert n Runden des Spiels
	 * 
	 * @param n anzahl der Runden
	 * @param einsatz Einsatz für jede Runde
	 */
	static void simulation(int n, double einsatz){
		double ergebnis;
		double min=Double.MAX_VALUE,max=Double.MAX_VALUE*(-1);
		int dmin=0,dmax=0;
		for(int i = 1; i<=n;i++){
			ergebnis=spielen(einsatz);
			if(ergebnis<min){min=ergebnis;dmin=i;}
			if(ergebnis>max){max=ergebnis;dmax=i;}
			
		}
		
		System.out.println("Anzahl der Durchläufe = " + n);
		System.out.println("Bestes Ergebnis: " + max + " im " + dmax +". Durchlauf");
		System.out.println("Schlechtestes Ergebnis: " + min + " im " + dmin + ". Durchlauf");
	}
	
}
