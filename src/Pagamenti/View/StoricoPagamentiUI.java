package Pagamenti.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Pagamenti.Model.*;
import Repository.DAOFactory;
import Repository.Pagamenti.DAOCanoneImpl;
import StruttureTuristiche.Model.*;
import StruttureTuristiche.View.StruttureTuristicheUI;
import Utenti.View.Home;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JList;

public class StoricoPagamentiUI extends JFrame {

	private JPanel contentPane;
	private JTextField cercaTextField;
	private JButton btnCerca;
	private JTable tablePrenotazioni;
	private JTable tableCanoni;
	private static DefaultTableModel dtmRicevutePagamentoPrenotazioni = new DefaultTableModel();
	private static DefaultTableModel dtmRicevutePagamentoCanoni = new DefaultTableModel();
	private static ArrayList<RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazioni = new ArrayList<RicevutaPagamentoPrenotazione>();
	private static ArrayList<RicevutaPagamentoCanone> ricevutePagamentoCanoni = new ArrayList<RicevutaPagamentoCanone>();

	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoricoPagamentiUI frame = new StoricoPagamentiUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StoricoPagamentiUI() {
		StoricoPagamentiUI thisStoricoPagamentiUI = this;

		setTitle("Storico dei pagamenti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisStoricoPagamentiUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 10, 85, 21);
		contentPane.add(btnIndietro);

		cercaTextField = new JTextField();
		cercaTextField.setBounds(27, 47, 716, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		contentPane.add(cercaTextField);

		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);

		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
				cercaTextField.setText("");
			}
		});
		btnRipristina.setBounds(841, 47, 85, 21);
		contentPane.add(btnRipristina);
		
		dtmRicevutePagamentoCanoni.setColumnIdentifiers(new String[]{"Inserzionista", "Importo", "Data pagamento", "Struttura turistica", "ID pagamento"});
		tableCanoni = new JTable();
		tableCanoni.setBounds(344, 322, 314, -206);
		tableCanoni.setModel(dtmRicevutePagamentoCanoni);
		tableCanoni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneCanoni = new JScrollPane(tableCanoni);
		scrollPaneCanoni.setBounds(27, 83, 443, 521);
		contentPane.add(scrollPaneCanoni);
		
		dtmRicevutePagamentoPrenotazioni.setColumnIdentifiers(new String[]{"Cliente", "Importo", "Data pagamento", "Struttura Turistica", "ID pagamento"});
		tablePrenotazioni = new JTable();
		tablePrenotazioni.setBounds(344, 322, 314, -206);
		tablePrenotazioni.setModel(dtmRicevutePagamentoPrenotazioni);
		tablePrenotazioni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPanePrenotazioni = new JScrollPane(tablePrenotazioni);
		scrollPanePrenotazioni.setBounds(483, 83, 443, 521);
		contentPane.add(scrollPanePrenotazioni);

		cerca("");
		createEvents();
	}
	
	private void createEvents() {
		cercaTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}
		});
	}
	
	public void warn() {
		if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);
	}

	public static DefaultTableModel getDtmRicevutePagamentoPrenotazioni() {
		return dtmRicevutePagamentoPrenotazioni;
	}

	public void setDtmRicevutePagamentoPrenotazioni(DefaultTableModel dtm) {
		StoricoPagamentiUI.dtmRicevutePagamentoPrenotazioni = dtm;
	}

	public static DefaultTableModel getDtmRicevutePagamentoCanoni() {
		return dtmRicevutePagamentoCanoni;
	}

	public void setDtmRicevutePagamentoCanoni(DefaultTableModel dtm) {
		StoricoPagamentiUI.dtmRicevutePagamentoCanoni = dtm;
	}

	public static void cerca(String target) {
		int i, j;
		
		{
			for(i = 0, j = getDtmRicevutePagamentoCanoni().getRowCount(); i < j; i++)
				getDtmRicevutePagamentoCanoni().removeRow(0);

			ricevutePagamentoCanoni = new ArrayList<RicevutaPagamentoCanone>();
			for (RicevutaPagamentoCanone rpc : DAOFactory.getDAORicevutaPagamentoCanone().doRetrieveAllFiltered(target).values()) {
				ricevutePagamentoCanoni.add(rpc);
			}
			Collections.sort(ricevutePagamentoCanoni);
			for(RicevutaPagamentoCanone rpc : ricevutePagamentoCanoni) {
				getDtmRicevutePagamentoCanoni().addRow(new Object[]{rpc.getCfInserzionista(), rpc.getImporto(), rpc.getDataPagamento(), DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(rpc.getPIva()).getNome(), rpc.getIdPagamento()});
			}
		}
		
		{
			for(i = 0, j = getDtmRicevutePagamentoPrenotazioni().getRowCount(); i < j; i++)
				getDtmRicevutePagamentoPrenotazioni().removeRow(0);

			ricevutePagamentoPrenotazioni = new ArrayList<RicevutaPagamentoPrenotazione>();
			for (RicevutaPagamentoPrenotazione rpp : DAOFactory.getDAORicevutaPagamentoPrenotazione().doRetrieveAllFiltered(target).values()) {
				ricevutePagamentoPrenotazioni.add(rpp);
			}
			Collections.sort(ricevutePagamentoPrenotazioni);
			for(RicevutaPagamentoPrenotazione rpp : ricevutePagamentoPrenotazioni) {
				getDtmRicevutePagamentoPrenotazioni().addRow(new Object[]{rpp.getCfCliente(), rpp.getImporto(), rpp.getDataPagamento(), DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(rpp.getPIva()).getNome(), rpp.getIdPagamento()});
			}
		}
	}
}