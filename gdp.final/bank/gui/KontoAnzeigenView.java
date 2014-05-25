package bank.gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import bank.app.Bank;
import bank.app.Konto;
import bank.app.Kunde;

public class KontoAnzeigenView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bank model;
	JTable table;
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
	
	
	
	
	
	public KontoAnzeigenView(Bank b){
		super ("Kontenübersicht");
		model=b;
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(table());
		pack();
		//setSize(getPreferredSize());
		setSize(500, 300);
		setLocationRelativeTo(null);
		setAlwaysOnTop(false);
		setResizable(false);
		setVisible(true);
		
	}
	
	private JScrollPane table(){
		table = new JTable(deftable()){
			private static final long serialVersionUID = 6738844632488030201L;
			public boolean isCellEditable(int x, int y){
				return false;
				}
			};
        table.setColumnSelectionAllowed(false);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(getPreferredSize());
		table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		table.setRowSelectionAllowed(true);table.setAutoCreateRowSorter(true);
		table.setFocusable(false);
		return jsp;
	}
	/**
	 * Erzeugt Tabelle	
	 * 
	 * @return Tabelle
	 */
	private DefaultTableModel deftable(){
		data.removeAllElements();
		Konto[] k = model.getKonten().toArray(new Konto[model.getKonten().size()]);
			for(int i = 0; i<k.length;i++){
				Kunde ku = k[i].getKunde();
				Vector<String> row = new Vector<String>();
				row.add(String.valueOf(k[i].getKontonummer()));
				row.add(ku.getVorname());row.add(ku.getNachname());
				
				
				row.add(String.valueOf(k[i].getSaldo()).replace('.', ','));
				row.add(k[i].getClass().getSimpleName());
				data.add(row);
				}
			Vector<String> title = new Vector<String>();
			title.add("Kontonummer"); title.add("Vorname");
			title.add("Nachname"); title.add("Saldo");title.add("Typ");
			DefaultTableModel dft = new DefaultTableModel(data, title);
			
			return dft;
	}
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		//deftable().fireTableDataChanged();
		table.setModel(deftable());	
		//repaint();
		
	}
	
	
}
