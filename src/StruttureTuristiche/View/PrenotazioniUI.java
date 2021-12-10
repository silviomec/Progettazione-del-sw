package StruttureTuristiche.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Facade.StrutturaTuristicaFacade;
import Repository.DAOFactory;
import StruttureTuristiche.Model.Prenotazione;
import Utenti.View.Home;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class PrenotazioniUI extends JFrame {
	private JPanel contentPane;
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();
	private static ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	private JButton btnCerca;
	private JTextField cercaTextField;
	private JTable table;
	private static JButton rimuoviPrenotazioneButton;
	private static DefaultListModel<Prenotazione> listmodel;
	private static DefaultTableModel dtm = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotazioniUI frame = new PrenotazioniUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrenotazioniUI() {
		PrenotazioniUI thisPrenotazioniUI = this;
		
		setTitle("Prenotazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rimuoviPrenotazioneButton = new JButton("Rimuovi prenotazione");
		rimuoviPrenotazioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int scelta = JOptionPane.showConfirmDialog(thisPrenotazioniUI, "Vuoi rimuovere la prenotazione selezionata?", "Rimuovi prenotazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(scelta == 0) {
					DAOFactory.getDAOInserzione().delete(prenotazioni.get(table.getSelectedRow()).getIdPrenotazione());
					cerca(cercaTextField.getText());
					JOptionPane.showMessageDialog(thisPrenotazioniUI, "Rimozione avvenuta con successo!", "Messaggio", JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(table.getSelectionModel().getLeadSelectionIndex());;
			}
		});
		rimuoviPrenotazioneButton.setFont(new Font("Dialog", Font.BOLD, 18));
		rimuoviPrenotazioneButton.setEnabled(false);
		rimuoviPrenotazioneButton.setBounds(27, 94, 207, 97);
		contentPane.add(rimuoviPrenotazioneButton);

		table = new JTable();
		table.setBounds(344, 322, 314, -206);
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(252, 82, 674, 521);
		contentPane.add(scrollPane);
		
		dtm.setColumnIdentifiers(new String[]{"ID", "Data arrivo", "Data partenza", "Prezzo totale", "Cliente", "Inserzione", "Struttura turistica", "Partita IVA"});

		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
				rimuoviPrenotazioneButton.setEnabled(false);
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);
		
		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
				rimuoviPrenotazioneButton.setEnabled(false);
				cercaTextField.setText("");
			}
		});
		btnRipristina.setBounds(841, 47, 85, 21);
		contentPane.add(btnRipristina);

		cercaTextField = new JTextField();
		cercaTextField.setBounds(252, 47, 491, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		contentPane.add(cercaTextField);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisPrenotazioniUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 10, 85, 21);
		contentPane.add(btnIndietro);

		cerca("");
		createEvents();
	}

	public void warn() {
		if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);

		if(table.isRowSelected(table.getSelectedRow())) {
			rimuoviPrenotazioneButton.setEnabled(true);
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
		PrenotazioniUI.dtm = dtm;
	}

	public static void cerca(String target) {
		int i, j;

		for(i = 0, j = getDtm().getRowCount(); i < j; i++)
			getDtm().removeRow(0);

		prenotazioni = new ArrayList<Prenotazione>();
		for (Prenotazione p : DAOFactory.getDAOPrenotazione().doRetrieveAllFiltered(target).values()) {
			prenotazioni.add(p);
		}
		Collections.sort(prenotazioni);
		for(Prenotazione p : prenotazioni) {
			getDtm().addRow(new Object[]{p.getIdPrenotazione(), p.getDataArrivo(), p.getDataPartenza(), p.getPrezzoTot(), p.getCfCliente(), p.getIdInserzione(), DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(p.getPIva()).getNome(), p.getPIva()});
		}

		rimuoviPrenotazioneButton.setEnabled(false);
	}
}