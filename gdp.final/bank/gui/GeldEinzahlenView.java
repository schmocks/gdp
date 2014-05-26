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


public class GeldEinzahlenView extends JFrame implements Observer{

	/**
	 * Geld auszahlen Fenster
	 */
	private static final long serialVersionUID = 1L;
	Bank model;
	JLabel title,ktdata;
	JButton ok,exit;
	JTextField t;
	Konto konto;
	
	public GeldEinzahlenView(Bank b, Konto k){
		super("Geld auf Konto "+k.getKontonummer()+" einzahlen");
		model=b;
		konto=k;
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(1,2));
		ok = new JButton("OK");ok.addActionListener(this.new Controller());
		exit = new JButton("Abbruch");exit.addActionListener(this.new Controller());
		title = new JLabel("Betrag");
		ktdata = new JLabel("Guthaben: " + k.getSaldo() + " €");
		t = new JTextField();t.addActionListener(this.new Controller());
		panel.add(ok);panel.add(exit);
		getContentPane().add(ktdata, BorderLayout.NORTH);
		getContentPane().add(t, BorderLayout.CENTER);
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
	
	
	/**
	 * Controller
	 * @author Stephan
	 *
	 */
	public class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exit) {
				setVisible(false);
				model.act();
				model.notifyObservers();
				
				}
			if (e.getSource() == ok) {
				String ktnrstr = t.getText();
				ktnrstr=ktnrstr.replace(',','.');
				try{
					
				
					
					konto.einzahlen(new BigDecimal(ktnrstr));
					setVisible(false);
					model.act();
					model.notifyObservers();
					
					}
				catch(NumberFormatException ex){
						return;
					}
			
				}
			if (e.getSource() == t) {
				String ktnrstr = t.getText();
				ktnrstr=ktnrstr.replace(',','.');
				try{
					
				
					
					konto.einzahlen(new BigDecimal(ktnrstr));
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
