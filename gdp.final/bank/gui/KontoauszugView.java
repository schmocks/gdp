package bank.gui;

import java.awt.BorderLayout;
import java.util.Date;
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

import bank.app.Vorgang;

public class KontoauszugView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bank model;
	JTable table;
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
	Konto konto;
	
	
	
	
	public KontoauszugView(Bank b, Konto k){
		super ("Kontoauszug Konto: " +k.getKontonummer());
		model=b;
		konto=k;
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
		Date d = new Date();
		data.removeAllElements();
		Vorgang[] vorgaenge = konto.getAuszug();
			for(int i = 0; i<vorgaenge.length;i++){
				Vorgang v = vorgaenge[i];
				Vector<String> row = new Vector<String>();
				d.setTime(v.getDatum());
				row.add(d.toString());
				row.add(String.valueOf(v.getSaldoAlt()));
				row.add(String.valueOf(v.getBuchung()));
				row.add(String.valueOf(v.getSaldoNeu()));
				data.add(row);
				}
			Vector<String> title = new Vector<String>();
			title.add("Datum"); title.add("Saldo alt");
			title.add("Buchung"); title.add("Saldo");
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
