import java.util.Scanner;

/**
 * 
 * 
 * @author Stephan
 *
 */
public class Collatz {

	/**
	 * Main Methode
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collatz();
	}

	/**
	 * Collatz Folge Methode
	 * 
	 */
	
	static void collatz(){
		long z=0, z0 = 0, zmin = Integer.MAX_VALUE, zmax = 0, co = 1;
		Scanner in = new Scanner(System.in);
		System.out.print("Bitte eine ganze Zahl eingeben: ");
		if(in.hasNextInt()){z=in.nextInt();z0=z;}
		else{System.out.println("Ungültige Eingabe!");in.close();return;}
		System.out.print("\nCollatz Folge:\n\n" + z);
		
		do{
			if(z%2==0&&z!=1&&z!=0){
				z=z/2;
				System.out.print(" -> " + z);
				co++;
				if(z<zmin&&z!=z0&&z!=1){zmin=z;}
				if(z>zmax&&z!=z0&&z!=1){zmax=z;}
				
			}
			if(z%2==1&&z!=1&&z!=0){
				z=(3*z)+1;
				System.out.print(" -> " + z);
				co++;
				if(z<zmin&&z!=z0&&z!=1){zmin=z;}
				if(z>zmax&&z!=z0&&z!=1){zmax=z;}
			}
			if(z==1&&zmax!=0&&zmin!=Integer.MAX_VALUE){
				System.out.println("\n\nDer Größte Wert ist: " + zmax);
				System.out.println("Der Kleinste Wert ist: " + zmin);
				System.out.println("Anzahl der Elemente : " + co);
			}
		}while(z!=1&&z!=0);
		in.close();
	}
}
