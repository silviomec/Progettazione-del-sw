package StruttureTuristiche.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Facade.StrutturaTuristicaFacade;
import Facade.UtenteFacade;
import Pagamenti.Model.Canone;
import Repository.DAOFactory;
import Repository.Pagamenti.DAOCanoneImpl;
import Repository.StruttureTuristiche.DAOStrutturaTuristica;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.View.Home;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StruttureTuristicheUI extends JFrame {
	UtenteFacade uf = UtenteFacade.getInstance();
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();

	private JPanel contentPane;
	private ArrayList<StrutturaTuristica> struttureTuristiche = new ArrayList<StrutturaTuristica>();
	private JTextField cercaTextField;
	private JButton btnCerca;
	private JButton rimuoviStrutturaButton;
	private JButton modificaStrutturaButton;
	private JButton gestisciCanoneButton;
	private JTable table;
	private static DefaultListModel<StrutturaTuristica> listmodel;
	DefaultTableModel dtm = new DefaultTableModel() {
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
					StruttureTuristicheUI frame = new StruttureTuristicheUI();
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
	public StruttureTuristicheUI() {
		StruttureTuristicheUI thisStruttureTuristicheUI = this;

		setTitle("Strutture Turistiche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cercaTextField = new JTextField();
		cercaTextField.setBounds(27, 47, 716, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		contentPane.add(cercaTextField);

		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
				rimuoviStrutturaButton.setEnabled(false);
				modificaStrutturaButton.setEnabled(false);
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);

		JButton inserisciStrutturaButton = new JButton("Inserisci Struttura");
		inserisciStrutturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stf.showUpdateStruttura(UpdateStruttura.AGGIUNGI, null);
				//thisStruttureTuristicheUI.dispose();
			}
		});
		inserisciStrutturaButton.setFont(new Font("Dialog", Font.BOLD, 18));
		inserisciStrutturaButton.setBounds(27, 100, 193, 97);
		contentPane.add(inserisciStrutturaButton);

		DAOStrutturaTuristica daoStrutturaTuristica = DAOFactory.getDAOStrutturaTuristica();

		rimuoviStrutturaButton = new JButton("Rimuovi Struttura");
		rimuoviStrutturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int scelta = JOptionPane.showConfirmDialog(thisStruttureTuristicheUI, "Vuoi rimuovere la struttura selezionata?", "Rimuovi struttura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(scelta == 0) {
					daoStrutturaTuristica.delete(struttureTuristiche.get(table.getSelectedRow()).getPIva());
					cerca(cercaTextField.getText());
					JOptionPane.showMessageDialog(thisStruttureTuristicheUI, "Rimozione avvenuta con successo!", "Messaggio", JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(table.getSelectionModel().getLeadSelectionIndex());;
			}
		});
		rimuoviStrutturaButton.setEnabled(false);
		rimuoviStrutturaButton.setFont(new Font("Dialog", Font.BOLD, 18));
		rimuoviStrutturaButton.setBounds(27, 217, 193, 97);
		contentPane.add(rimuoviStrutturaButton);

		modificaStrutturaButton = new JButton("Modifica Struttura");
		modificaStrutturaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pIva = struttureTuristiche.get(table.getSelectedRow()).getPIva();
				stf.showUpdateStruttura(UpdateStruttura.MODIFICA, pIva);
			}
		});
		modificaStrutturaButton.setEnabled(false);
		modificaStrutturaButton.setFont(new Font("Dialog", Font.BOLD, 18));
		modificaStrutturaButton.setBounds(27, 336, 193, 97);
		contentPane.add(modificaStrutturaButton);

		gestisciCanoneButton = new JButton("Gestisci Canone");
		gestisciCanoneButton.setEnabled(false);
		gestisciCanoneButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gestisciCanoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Canone canone = DAOFactory.getDAOCanone().doRetrieve(DAOCanoneImpl.STRUTTURA_TURISTICA, struttureTuristiche.get(table.getSelectedRow()).getPIva());
				stf.showGestisciCanone(canone);
			}
		});
		gestisciCanoneButton.setBounds(54, 524, 166, 35);
		contentPane.add(gestisciCanoneButton);

		JList list = new JList();
		list.setBounds(230, 559, 706, -458);
		contentPane.add(list);

		listmodel = new DefaultListModel<StrutturaTuristica>();

		dtm.setColumnIdentifiers(new String[]{"Partita IVA", "Nome", "Indirizzo", "Tipologia", "Stelle", "Inserzionista", "Scadenza canone"});

		cerca("");

		table = new JTable() {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				LocalDate data = (LocalDate) getModel().getValueAt(row, 6);
				//if (getSelectedRow() == row) {
					if (data.isBefore(LocalDate.now())) {
						comp.setBackground(Color.red);
					}
				//}
				else {
					comp.setBackground(Color.white);
				}
				return comp;
			}
		};
		table.setBounds(344, 322, 314, -206);
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table.getSelectionModel().addListSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(252, 82, 674, 521);
		contentPane.add(scrollPane);

		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
				rimuoviStrutturaButton.setEnabled(false);
				modificaStrutturaButton.setEnabled(false);
				gestisciCanoneButton.setEnabled(false);
				cercaTextField.setText("");
			}
		});
		btnRipristina.setBounds(841, 47, 85, 21);
		contentPane.add(btnRipristina);

		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisStruttureTuristicheUI.dispose();
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
			rimuoviStrutturaButton.setEnabled(true);
			modificaStrutturaButton.setEnabled(true);
			gestisciCanoneButton.setEnabled(true);
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

	public void cerca(String target) {
		int i, j;

		for(i = 0, j = dtm.getRowCount(); i < j; i++)
			dtm.removeRow(0);

		struttureTuristiche = new ArrayList<StrutturaTuristica>();
		for (StrutturaTuristica s : DAOFactory.getDAOStrutturaTuristica().doRetrieveAllFiltered(target).values()) {
			struttureTuristiche.add(s);
		}
		Collections.sort(struttureTuristiche);
		for(StrutturaTuristica s : struttureTuristiche) {
			dtm.addRow(new Object[]{s.getPIva(), s.getNome(),  s.getIndirizzo(), s.getTipologia(), s.getStelle(), s.getInserzionista(), DAOFactory.getDAOCanone().doRetrieve(DAOCanoneImpl.STRUTTURA_TURISTICA, s.getPIva()).getScadenza()});
		}
	}
}