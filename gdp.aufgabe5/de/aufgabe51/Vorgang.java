package de.aufgabe51;

import java.math.BigDecimal;
import java.util.Date;

public class Vorgang {

	private long Datum;
	private BigDecimal SaldoAlt;
	private BigDecimal Buchung;
	private BigDecimal SaldoNeu;
	
	/**
	 * Klasse eines Vorgangs (eine Kontobewegung)
	 * 
	 * @param SaldoAlt
	 * @param Buchung
	 * @param SaldoNeu
	 */
	Vorgang(BigDecimal SaldoAlt, BigDecimal Buchung, BigDecimal SaldoNeu){
		this.Datum=new Date().getTime();this.SaldoAlt=SaldoAlt.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.Buchung=Buchung.setScale(2, BigDecimal.ROUND_HALF_UP);this.SaldoNeu=SaldoNeu.setScale(2, BigDecimal.ROUND_HALF_UP);
	}


	/**
	 * @return the datum
	 */
	public long getDatum() {
		return Datum;
	}


	/**
	 * @return the saldoAlt
	 */
	public BigDecimal getSaldoAlt() {
		return SaldoAlt;
	}


	/**
	 * @return the buchung
	 */
	public BigDecimal getBuchung() {
		return Buchung;
	}


	/**
	 * @return the saldoNeu
	 */
	public BigDecimal getSaldoNeu() {
		return SaldoNeu;
	}

}