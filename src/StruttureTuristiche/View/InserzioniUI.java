package StruttureTuristiche.View;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import Facade.StrutturaTuristicaFacade;
import Pagamenti.Model.Canone;
import Repository.DAOFactory;
import Repository.Pagamenti.DAOCanoneImpl;
import StruttureTuristiche.Model.Inserzione;
import Utenti.View.Home;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InserzioniUI extends JFrame {
	private JPanel contentPane;
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();
	private static ArrayList<Inserzione> inserzioni = new ArrayList<Inserzione>();
	private static JComboBox filtroComboBox;
	private JButton btnCerca;
	private JTextField cercaTextField;
	private JTable table;
	private static JButton rimuoviInserzioneButton;
	private static JButton modificaInserzioneButton;
	private static JButton prenotaButton;
	private static DefaultListModel<Inserzione> listmodel;
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
					InserzioniUI frame = new InserzioniUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InserzioniUI() {
		InserzioniUI thisInserzioniUI = this;

		setTitle("Inserzioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInserisciInserzione = new JButton("Inserisci Inserzione");
		btnInserisciInserzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stf.showNuovaInserzione();
			}
		});
		btnInserisciInserzione.setFont(new Font("Dialog", Font.BOLD, 18));
		btnInserisciInserzione.setBounds(27, 100, 207, 97);
		contentPane.add(btnInserisciInserzione);

		rimuoviInserzioneButton = new JButton("Rimuovi inserzione");
		rimuoviInserzioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int scelta = JOptionPane.showConfirmDialog(thisInserzioniUI, "Vuoi rimuovere l'inserzione selezionata?", "Rimuovi inserzione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(scelta == 0) {
					DAOFactory.getDAOInserzione().delete(inserzioni.get(table.getSelectedRow()).getIdInserzione());
					cerca(cercaTextField.getText());
					JOptionPane.showMessageDialog(thisInserzioniUI, "Rimozione avvenuta con successo!", "Messaggio", JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(table.getSelectionModel().getLeadSelectionIndex());;
			}
		});
		rimuoviInserzioneButton.setFont(new Font("Dialog", Font.BOLD, 18));
		rimuoviInserzioneButton.setEnabled(false);
		rimuoviInserzioneButton.setBounds(27, 217, 207, 97);
		contentPane.add(rimuoviInserzioneButton);

		modificaInserzioneButton = new JButton("Modifica inserzione");
		modificaInserzioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: implementare correttamente il bottone
				int idInserzione = inserzioni.get(table.getSelectedRow()).getIdInserzione();
				stf.showNuovaInserzione();
			}
		});
		modificaInserzioneButton.setFont(new Font("Dialog", Font.BOLD, 18));
		modificaInserzioneButton.setEnabled(false);
		modificaInserzioneButton.setBounds(27, 336, 207, 97);
		contentPane.add(modificaInserzioneButton);

		table = new JTable() {
			Color rosso = new Color(247 , 127, 127);
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				boolean saldato = (boolean) (DAOFactory.getDAOCanone().doRetrieve(DAOCanoneImpl.STRUTTURA_TURISTICA, getModel().getValueAt(row, 6).toString())).isSaldato();

				if(!saldato) {
					comp.setBackground(rosso);
				} else {
					comp.setBackground(Color.white);
					comp.setForeground(new Color(51, 51, 51));
				}

				if(this.isRowSelected(row))
					comp.setBackground(new Color(184, 207, 229));

				return comp;
			}
		};
		table.setBounds(344, 322, 314, -206);
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(252, 82, 674, 521);
		contentPane.add(scrollPane);

		dtm.setColumnIdentifiers(new String[]{"Inserzione", "Descrizione", "Prezzo per notte", "Numero persone", "Data inizio", "Data fine", "Struttura turistica", "Inserzionista"});

		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
				rimuoviInserzioneButton.setEnabled(false);
				modificaInserzioneButton.setEnabled(false);
				prenotaButton.setEnabled(false);
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);

		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
				rimuoviInserzioneButton.setEnabled(false);
				modificaInserzioneButton.setEnabled(false);
				prenotaButton.setEnabled(false);
				cercaTextField.setText("");
			}
		});
		btnRipristina.setBounds(841, 47, 85, 21);
		contentPane.add(btnRipristina);

		cercaTextField = new JTextField();
		cercaTextField.setBounds(27, 47, 716, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		contentPane.add(cercaTextField);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisInserzioniUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 10, 85, 21);
		contentPane.add(btnIndietro);

		prenotaButton = new JButton("Prenota");
		prenotaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idInserzione = inserzioni.get(table.getSelectedRow()).getIdInserzione();
				stf.showNuovaPrenotazioneUI(DAOFactory.getDAOInserzione().doRetrieveByIdInserzione(idInserzione));
			}
		});
		prenotaButton.setEnabled(false);
		prenotaButton.setFont(new Font("Dialog", Font.BOLD, 18));
		prenotaButton.setBounds(27, 506, 207, 97);
		contentPane.add(prenotaButton);
		
		filtroComboBox = new JComboBox();
		filtroComboBox.setBounds(753, 14, 173, 22);
		filtroComboBox.setModel(new DefaultComboBoxModel(new String[] {"Inserzioni valide", "Inserzioni scadute", "Canoni scaduti"}));
		filtroComboBox.getEditor().setItem("Inserzioni valide");
		contentPane.add(filtroComboBox);

		cerca("");
		createEvents();
	}

	public void warn() {
		if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);
	}

	public void warn1() {
		if(table.isRowSelected(table.getSelectedRow())) {
			rimuoviInserzioneButton.setEnabled(true);
			modificaInserzioneButton.setEnabled(true);
			if(filtroComboBox.getEditor().getItem().toString().equals((String) "Inserzioni valide"))
				prenotaButton.setEnabled(true);
			else
				prenotaButton.setEnabled(false);
			
			/*Canone canone = DAOFactory.getDAOCanone().doRetrieve(DAOCanoneImpl.STRUTTURA_TURISTICA, table.getModel().getValueAt(table.getSelectedRow(), 6).toString());
			if(canone.isSaldato() && (LocalDate.parse((table.getModel().getValueAt(table.getSelectedRow(), 5)).toString()).isBefore(LocalDate.now())))
				prenotaButton.setEnabled(true);
			else
				prenotaButton.setEnabled(false);*/
		}
	}
	
	public void warn2() {
		cerca("");
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
				warn1();
			}
		});
		
		final JTextComponent fTC = (JTextComponent) filtroComboBox.getEditor().getEditorComponent();
		fTC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn2();
			}
			public void removeUpdate(DocumentEvent e) {
				warn2();
			}
			public void insertUpdate(DocumentEvent e) {
				warn2();
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
		for(Inserzione ins : DAOFactory.getDAOInserzione().doRetrieveAllFiltered(target).values()) {
			switch(filtroComboBox.getEditor().getItem().toString()) {
			case "Inserzioni valide":
			default:
				if(DAOFactory.getDAOCanone().doRetrieve("STRUTTURATURISTICA", ins.getStrutturaTuristica()).isSaldato() && ins.getDataFine().isAfter(LocalDate.now()))
					inserzioni.add(ins);
				break;
			case "Inserzioni scadute":
				if(DAOFactory.getDAOCanone().doRetrieve("STRUTTURATURISTICA", ins.getStrutturaTuristica()).isSaldato() && ins.getDataFine().isBefore(LocalDate.now()))
					inserzioni.add(ins);
				break;
			case "Canoni scaduti":
				if(!DAOFactory.getDAOCanone().doRetrieve("STRUTTURATURISTICA", ins.getStrutturaTuristica()).isSaldato())
					inserzioni.add(ins);
				break;
			}
		}
		Collections.sort(inserzioni);
		for(Inserzione ins : inserzioni) {
			getDtm().addRow(new Object[]{ins.getIdInserzione(), ins.getDescrizione(), ins.getPrezzoPerNotte(),ins.getNumeroPersone(), ins.getDataInizio(), ins.getDataFine() , ins.getStrutturaTuristica(), ins.getInserzionista()});
		}

		rimuoviInserzioneButton.setEnabled(false);
		modificaInserzioneButton.setEnabled(false);
		prenotaButton.setEnabled(false);
	}
}