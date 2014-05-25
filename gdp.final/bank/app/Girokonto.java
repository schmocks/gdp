package bank.app;

import java.math.BigDecimal;

public class Girokonto extends Konto{

	/**
	 * Klasse der Girokonten
	 * 
	 */
	private BigDecimal saldo;
	Girokonto(Kunde kunde, short kontonummer, BigDecimal saldo) {
		super(kunde, kontonummer, saldo);
		
		
	}
	
	
	/**
	 * Auszahlen mit einem Maximum von 300
	 * 
	 */
	public void auszahlen(BigDecimal summe){
		saldo=getSaldo();
		if(summe.compareTo(new BigDecimal(300))>=0){
			System.out.println(">> Auszahlungsbetrag zu hoch");
			return;
		}
		if(saldo.subtract(summe).compareTo(new BigDecimal(-500))<=0)
		/*if((saldo-summe)<(-500))*/{
			System.out.println(">> Dispolimit erreicht");
			return;
		}
			addBewegung(getKontonummer(), summe, 1);
			setSaldo(saldo.subtract(summe));
			
		
	}
	
}
