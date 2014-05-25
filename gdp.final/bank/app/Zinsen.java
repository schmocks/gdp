package bank.app;

public enum Zinsen {
	Sparkonto(3.0), Girokonto(1.25), Konto(0.25);
	
	private final double zinsen;
	
	Zinsen(double zinsen){this.zinsen=zinsen;}
	
	public double Verzinsung(){return zinsen;}
	
	public double Zins(double Saldo){
		double saldo;
		if(Saldo<0){
			saldo=Saldo*(-1);
			saldo=((saldo/100)*117.5);
			return saldo*(-1);
		}
		
		saldo=((Saldo/100)*(100+zinsen));
		
		return saldo;
	}
}
