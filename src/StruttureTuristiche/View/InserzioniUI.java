package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Facade.StrutturaTuristicaFacade;
import Repository.DAOFactory;
import Repository.Pagamenti.DAOCanoneImpl;
import StruttureTuristiche.Model.Inserzione;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.View.Home;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class InserzioniUI extends JFrame {

	private JPanel contentPane;
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();
	private static ArrayList<Inserzione> inserzioni = new ArrayList<Inserzione>();
	private JButton btnCerca;
	private JTextPane cercaTextField;
	private JTable table;
	private static JButton rimuoviInserzioneButton;
	private static JButton modificaInserzioneButton;
	private static DefaultListModel<Inserzione> listmodel;
	private static DefaultTableModel dtm = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};


	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserzioniUI frame = new InserzioniUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InserzioniUI() {
		InserzioniUI thisInserzioniUI = this;
		setTitle("Inerzioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 936, 613);
		contentPane.add(contentPane_1);

		JButton btnInserisciInserzione = new JButton("Inserisci Inserzione");
		btnInserisciInserzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stf.showNuovaInserzione();
			}
		});
		btnInserisciInserzione.setFont(new Font("Dialog", Font.BOLD, 18));
		btnInserisciInserzione.setBounds(27, 100, 207, 97);
		contentPane_1.add(btnInserisciInserzione);

		JButton rimuoviInserzioneButton = new JButton("Rimuovi Inserzione");
		rimuoviInserzioneButton.setFont(new Font("Dialog", Font.BOLD, 18));
		rimuoviInserzioneButton.setEnabled(false);
		rimuoviInserzioneButton.setBounds(27, 217, 207, 97);
		contentPane_1.add(rimuoviInserzioneButton);

		JButton modificaInserzioneButton = new JButton("Modifica Inserzione");
		modificaInserzioneButton.setFont(new Font("Dialog", Font.BOLD, 18));
		modificaInserzioneButton.setEnabled(false);
		modificaInserzioneButton.setBounds(27, 336, 207, 97);
		contentPane_1.add(modificaInserzioneButton);

		table = new JTable();
		table.setBounds(344, 322, 314, -206);
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(252, 82, 674, 521);
		contentPane.add(scrollPane);

		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	cerca(cercaTextField.getText());
				rimuoviInserzioneButton.setEnabled(false);
				modificaInserzioneButton.setEnabled(false);
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);



		JList list = new JList();
		list.setBounds(293, 559, 585, -424);
		contentPane_1.add(list);


		cercaTextField.setText("Search...");
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		cercaTextField.setBounds(210, 30, 716, 25);
		contentPane_1.add(cercaTextField);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisInserzioniUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 10, 85, 21);
		contentPane.add(btnIndietro);

		createEvents();

	}

	public void warn() {
		if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);

		if(table.isRowSelected(table.getSelectedRow())) {
			rimuoviInserzioneButton.setEnabled(true);
			modificaInserzioneButton.setEnabled(true);

		}
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
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				warn();
			}
		});


	}
	
	

public static DefaultTableModel getDtm() {
	return dtm;
}

public void setDtm(DefaultTableModel dtm) {
	InserzioniUI.dtm = dtm;
}

public static void cerca(String target) {
	int i, j;

	for(i = 0, j = getDtm().getRowCount(); i < j; i++)
		getDtm().removeRow(0);

	inserzioni = new ArrayList<Inserzione>();
	for (Inserzione ins : DAOFactory.getDAOInserzione().doRetrieveAllFiltered(target).values()) {
		inserzioni.add(ins);
	}
	Collections.sort(inserzioni);
	for(Inserzione ins : inserzioni) {
		getDtm().addRow(new Object[]{ins.getIdInserzione(), ins.getTitolo(), ins.getDescrizione(), ins.getPrezzoPerNotte(),ins.getNumeroPersone(), ins.getDataInizio(), ins.getDataFine() , ins.getStrutturaTuristica(), ins.getInserzionista()});
	}

	rimuoviInserzioneButton.setEnabled(false);
	modificaInserzioneButton.setEnabled(false);
	
}

}


