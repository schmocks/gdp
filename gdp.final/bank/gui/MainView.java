package bank.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import bank.app.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MainView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 100;
	Bank model;
	JTextField tf1;
	JButton kua,kul,kaus,alko,exit,ge,ga;
	JLabel gkunden,gsaldo,mkunden,status;
	BigDecimal Betrag;
	int regkonto;
	int miese;
	
	public MainView(Bank b){
		super("Die Super Bank App");
		model = b;
		miese = b.getMieseKunden();
		Betrag = b.getGesamtBetrag();
		regkonto = b.getKonten().size();
		getContentPane().setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(4,1));
		JPanel bpanel = new JPanel(new GridLayout(7, 1));
		kua = new JButton("Kunden anlegen");kua.addActionListener(this.new Controller());
		kul = new JButton("Kunden löschen");kul.addActionListener(this.new Controller());
		ge = new JButton("Geld einzahlen");ge.addActionListener(this.new Controller());
		ga = new JButton("Geld auszahlen");ga.addActionListener(this.new Controller());
		kaus = new JButton("Kontoauszug anzeigen");kaus.addActionListener(this.new Controller());
		alko = new JButton("Alle Konten anzeigen");alko.addActionListener(this.new Controller());
		exit = new JButton("Exit");exit.addActionListener(this.new Controller());
		status = new JLabel(" " + "Status:");
		gkunden = new JLabel(" " + regkonto + " Konten registriert");
		gsaldo = new JLabel(" " + Betrag + " € eingelagert");
		mkunden = new JLabel(" " + miese + " Kunden mit negativem Saldo");
		System.out.println(Betrag);
		/*t = new JTextField(ti);
		m = new JTextField(mi);
		j = new JTextField(ji);
		ok = new JButton("OK");
		input.add(new JLabel("     Tag"));
		input.add(new JLabel("  Monat"));
		input.add(new JLabel("   Jahr"));
		input.add(t);input.add(m);input.add(j);
		//tutton.add(text, BorderLayout.SOUTH);tutton.add(button, BorderLayout.SOUTH);
		getContentPane().add(input, BorderLayout.NORTH);
		getContentPane().add(ok, BorderLayout.SOUTH); ok.addActionListener(this.new Controller());
		*/
		panel.add(status);panel.add(gkunden);panel.add(gsaldo);panel.add(mkunden);
		
		tf1 = new JTextField(b.getKonten().size());
		bpanel.add(kua);bpanel.add(kul);bpanel.add(ge);bpanel.add(ga);bpanel.add(kaus);bpanel.add(alko);bpanel.add(exit);
		getContentPane().add(bpanel, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.CENTER);
		
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
		setVisible(true);
		gkunden.setText(" " + model.getKonten().size() + " Konten registriert");
		gsaldo.setText(" " + model.getGesamtBetrag() + " € eingelagert");
		mkunden.setText(" " + model.getMieseKunden() + " Kunden mit negativem Saldo");
		repaint();
		
	}
	
	
	public class Controller implements ActionListener {
		/**
		 * action performed 
		 * 
		 * @param e Event
		 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == exit) {
				setVisible(false);
				dispose();
				}
				if(e.getSource() == alko){
					model.addObserver(new KontoAnzeigenView(model));
					
				}
				
				if(e.getSource() == ge){
					setVisible(false);
					model.addObserver(new KundenSuche(model,0));
				}
				if(e.getSource() == ga){
					setVisible(false);
					model.addObserver(new KundenSuche(model,1));
				}
				if(e.getSource() == kaus){
					setVisible(false);
					model.addObserver(new KundenSuche(model,2));
				}
				
				
			}
	}
}
