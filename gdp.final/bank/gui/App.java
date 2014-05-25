package bank.gui;


import bank.app.*;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("java.version"));
		Bank b = new KundenGenerator().fuelleBank(new Bank());
		MainView mv = new MainView(b);
		b.addObserver(mv);
		b.menuBank();
		
		
		
		
	
		
		
		
	}
	
	

}
