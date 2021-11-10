package Utenti.View;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Repository.DAOFactory;
import Utenti.Model.Dipendente;
import Utenti.Model.Persona;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VisualizzaPersone extends JFrame {
	private int tipologiaPersona;
	private ArrayList<Persona> persone = new ArrayList<Persona>();
	private JTable table;
	private static DefaultListModel<Persona> listmodel;
	private JTextField cercaTextField;
	private JButton btnCerca;
	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void display(int tipologia) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaPersone frame = new VisualizzaPersone(tipologia);
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
	public VisualizzaPersone(int tipologia) {
		tipologiaPersona = tipologia;
		String tabella = "";

		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "Cliente";
			break;
		case INSERZIONISTA:
			tabella = "Inserzionista";
			break;
			//default:
			//	return null;
		}

		setTitle("Visualizza " + tabella);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cercaTextField = new JTextField();
		cercaTextField.setBounds(10, 30, 776, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		cercaTextField.setText("Cerca");
		contentPane.add(cercaTextField);

		JList list = new JList();
		list.setBounds(713, 111, -621, 395);
		contentPane.add(list);

		listmodel = new DefaultListModel<Persona>();

		dtm.setColumnIdentifiers(new String[]{"CF", "Nome", "Cognome", "Telefono", "Email"});

		persone = new ArrayList<Persona>();
		for (Persona p : DAOFactory.getDAOPersona().doRetrieveAll(tipologiaPersona).values()) {
			persone.add(p);
		}
		for(Persona p : persone) {
			dtm.addRow(new Object[]{p.getCodiceFiscale(), p.getNome(),  p.getCognome(), p.getTelefono(), p.getEmail()});
		}

		table = new JTable();
		table.setBounds(344, 322, 314, -206);
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table.getSelectionModel().addListSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 157, 766, 396);
		contentPane.add(scrollPane);

		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
			}
		});
		btnCerca.setBounds(49, 65, 85, 21);
		contentPane.add(btnCerca);

		btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
			}
		});
		btnRipristina.setBounds(144, 65, 85, 21);
		contentPane.add(btnRipristina);

		createEvents();
	}

	public void warn() {
		if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);
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

	public void cerca(String target) {
		int i, j;

		for(i = 0, j = dtm.getRowCount(); i < j; i++)
			dtm.removeRow(0);

		persone = new ArrayList<Persona>();
		for (Persona p : DAOFactory.getDAOPersona().doRetrieveAllFiltered(tipologiaPersona, target).values()) {
			persone.add(p);
		}
		for(Persona p : persone) {
			dtm.addRow(new Object[]{p.getCodiceFiscale(), p.getNome(),  p.getCognome(), p.getTelefono(), p.getEmail()});
		}
	}

	public static final int CLIENTE = 0;
	public static final int INSERZIONISTA = 1;
	private JButton btnRipristina;
}