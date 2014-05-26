package bank.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bank.app.Bank;
import bank.app.Konto;
import bank.app.Kunde;


public class KundenAnlegenView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bank model;
	JLabel title,ktdata;
	JButton ok,exit;
	JTextField vn,nn,ad,tel,sl;
	Konto konto;
	
	public KundenAnlegenView(Bank b){
		super("Neues Konto anlegen");
		model=b;
		
		getContentPane().setLayout(new BorderLayout());
		JPanel tpanel = new JPanel(new GridLayout(5,1));
		JPanel panel = new JPanel(new GridLayout(1,2));
		ok = new JButton("OK");ok.addActionListener(this.new Controller());
		exit = new JButton("Abbruch");exit.addActionListener(this.new Controller());
		title = new JLabel("Kundendaten");
		
		vn = new JTextField("Vorname");
		nn = new JTextField("Nachname");
		ad  = new JTextField("Adresse");
		tel = new JTextField("Telefon");
		sl = new JTextField("Saldo");
		panel.add(ok);panel.add(exit);
		tpanel.add(vn);tpanel.add(nn);tpanel.add(ad);tpanel.add(tel);tpanel.add(sl);
		getContentPane().add(title, BorderLayout.NORTH);
		getContentPane().add(tpanel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		//JPanel 
	
	
	
		pack();
		setSize(getPreferredSize());
	//setSize(400, 200);
		setLocationRelativeTo(null);
		setAlwaysOnTop(false);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exit) {
				setVisible(false);
				model.act();
				model.notifyObservers();
				
				}
			if (e.getSource() == ok) {
				String vorname = vn.getText();
				String nachname = nn.getText();
				String adresse = ad.getText();
				String telNr = tel.getText();
				String saltx = sl.getText();
				try{
					BigDecimal saldo = new BigDecimal(saltx);
					model.gkontoeroeffnen(new Kunde(vorname, nachname, adresse, telNr), saldo);
					setVisible(false);
					model.act();
					model.notifyObservers();
					
					}
				catch(NumberFormatException ex){
						return;
					}
			
				}
		}
		
	}

}
