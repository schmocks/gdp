package bank.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




import bank.app.Bank;
import bank.app.Konto;



public class KundenSucheView extends JFrame implements Observer{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bank model;
	int aufruf = 0 ;
	JTextField t;
	JButton ok,exit;
	JLabel title;
	//static String[] se = {"Kundensuche"};
	
	public KundenSucheView(Bank b, int k ){
		super("Test");
		model=b;
		aufruf=k;
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(1,2));
		ok = new JButton("OK");ok.addActionListener(this.new Controller());
		exit = new JButton("Abbruch");exit.addActionListener(this.new Controller());
		title = new JLabel("Kontonnummer:");
		t = new JTextField();t.addActionListener(this.new Controller());
		panel.add(ok);panel.add(exit);
		getContentPane().add(title, BorderLayout.NORTH);
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				String ktnrstr = t.getText();
				try{
					Short ktsh = Short.parseShort(ktnrstr);
					if(!model.tryktnr(ktsh)){return;}
					Konto kt = model.getkt(ktsh);
					
					//model.notifyObservers();
					setVisible(false);
					switch(aufruf){
					case 0: model.addObserver(new GeldEinzahlenView(model,kt));break;
					case 1: model.addObserver(new GeldAuszahlenView(model, kt));break;
					case 2: model.addObserver(new KontoauszugView(model, kt));model.act();model.notifyObservers();break;
					}
					}
				catch(NumberFormatException ex){
						return;
					}
			
				}
			if (e.getSource() == t) {
				String ktnrstr = t.getText();
				try{
					Short ktsh = Short.parseShort(ktnrstr);
					if(!model.tryktnr(ktsh)){return;}
					Konto kt = model.getkt(ktsh);
					
					//model.notifyObservers();
					setVisible(false);
					switch(aufruf){
					case 0: model.addObserver(new GeldEinzahlenView(model,kt));break;
					case 1: model.addObserver(new GeldAuszahlenView(model, kt));break;
					case 2: model.addObserver(new KontoauszugView(model, kt));model.act();model.notifyObservers();break;
					}
					}
				catch(NumberFormatException ex){
						return;
					}
			
				}
		}
		
	}
	
}	
		
		
		
		
		
		
		
		
		
		
		
		
	

	
