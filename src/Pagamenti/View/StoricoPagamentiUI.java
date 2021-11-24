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
import Utenti.Model.Persona;
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
	private int modalità = 0;

	private JPanel contentPane;
	private JTextField cercaTextField;
	private JButton btnCerca;
	private JTable tablePrenotazioni;
	private JTable tableCanoni;
	private static DefaultTableModel dtmRicevutePagamentoPrenotazioni = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private static DefaultTableModel dtmRicevutePagamentoCanoni = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private static ArrayList<RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazioni = new ArrayList<RicevutaPagamentoPrenotazione>();
	private static ArrayList<RicevutaPagamentoCanone> ricevutePagamentoCanoni = new ArrayList<RicevutaPagamentoCanone>();

	public static void display(int modalità, String cerca) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoricoPagamentiUI frame = new StoricoPagamentiUI(modalità, cerca);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StoricoPagamentiUI(int modalità, String cerca) {
		StoricoPagamentiUI thisStoricoPagamentiUI = this;
		this.modalità = modalità;

		switch(modalità) {
		case 0:
			setTitle("Storico dei pagamenti");
			break;
		case 1:
			setTitle("Storico dei pagamenti dei canoni");
			break;
		}
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
		cercaTextField.setText(cerca);

		btnCerca = new JButton("Cerca");
		if(cercaTextField.getText().equals(""))
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

		dtmRicevutePagamentoCanoni.setColumnIdentifiers(new String[]{"Inserzionista", "Importo", "Data pagamento", "Struttura turistica", "Partita IVA", "ID pagamento"});
		tableCanoni = new JTable();
		tableCanoni.setBounds(344, 322, 314, -206);
		tableCanoni.setModel(dtmRicevutePagamentoCanoni);
		tableCanoni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneCanoni = new JScrollPane(tableCanoni);
		contentPane.add(scrollPaneCanoni);

		dtmRicevutePagamentoPrenotazioni.setColumnIdentifiers(new String[]{"Cliente", "Importo", "Data pagamento", "Struttura Turistica", "Partita IVA", "ID pagamento"});
		tablePrenotazioni = new JTable();
		tablePrenotazioni.setBounds(344, 322, 314, -206);
		tablePrenotazioni.setModel(dtmRicevutePagamentoPrenotazioni);
		tablePrenotazioni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPanePrenotazioni = new JScrollPane(tablePrenotazioni);
		contentPane.add(scrollPanePrenotazioni);

		switch(modalità) {
		case 0:
			scrollPaneCanoni.setBounds(27, 83, 886, 250);
			scrollPanePrenotazioni.setBounds(27, 343, 886, 250);
			break;
		case 1:
			scrollPaneCanoni.setBounds(27, 83, 886, 521);
			//scrollPanePrenotazioni.setBounds(483, 83, 443, 521);
			scrollPanePrenotazioni.setVisible(false);
			break;
		}

		cerca(cercaTextField.getText());
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

	public void cerca(String target) {
		cercaRicevutePagamentoCanoni(target);
		cercaRicevutePagamentoPrenotazioni(target);
	}

	public void cercaRicevutePagamentoCanoni(String target) {
		int i, j;

		for(i = 0, j = getDtmRicevutePagamentoCanoni().getRowCount(); i < j; i++)
			getDtmRicevutePagamentoCanoni().removeRow(0);

		ricevutePagamentoCanoni = new ArrayList<RicevutaPagamentoCanone>();
		for (RicevutaPagamentoCanone rpc : DAOFactory.getDAORicevutaPagamentoCanone().doRetrieveAllFiltered(target).values()) {
			ricevutePagamentoCanoni.add(rpc);
		}
		Collections.sort(ricevutePagamentoCanoni);

		for(RicevutaPagamentoCanone rpc : ricevutePagamentoCanoni) {
			getDtmRicevutePagamentoCanoni().addRow(new Object[]{rpc.getCfInserzionista(), rpc.getImporto(), rpc.getDataPagamento(), DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(rpc.getPIva()).getNome(), rpc.getPIva(), rpc.getIdPagamento()});
		}
	}

	public void cercaRicevutePagamentoPrenotazioni(String target) {
		int i, j;

		for(i = 0, j = getDtmRicevutePagamentoPrenotazioni().getRowCount(); i < j; i++)
			getDtmRicevutePagamentoPrenotazioni().removeRow(0);

		ricevutePagamentoPrenotazioni = new ArrayList<RicevutaPagamentoPrenotazione>();
		for (RicevutaPagamentoPrenotazione rpp : DAOFactory.getDAORicevutaPagamentoPrenotazione().doRetrieveAllFiltered(target).values()) {
			ricevutePagamentoPrenotazioni.add(rpp);
		}
		Collections.sort(ricevutePagamentoPrenotazioni);
		for(RicevutaPagamentoPrenotazione rpp : ricevutePagamentoPrenotazioni) {
			getDtmRicevutePagamentoPrenotazioni().addRow(new Object[]{rpp.getCfCliente(), rpp.getImporto(), rpp.getDataPagamento(), DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(rpp.getPIva()).getNome(), rpp.getPIva(), rpp.getIdPagamento()});
		}
	}

	public static int CANONI_PRENOTAZIONI = 0;
	public static int SOLO_CANONI = 1;
}