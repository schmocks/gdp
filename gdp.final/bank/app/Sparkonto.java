package bank.app;

import java.math.BigDecimal;

public class Sparkonto extends Konto {

	Sparkonto(Kunde kunde, short kontonummer, BigDecimal saldo) {
		super(kunde, kontonummer, saldo);
		// TODO Auto-generated constructor stub
	}
	
	
	public void auszahlen(BigDecimal summe){
		System.out.println(">> Auszahlung von Sparkonto nicht möglich!");
		
	}

}
