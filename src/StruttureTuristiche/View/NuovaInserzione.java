package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.toedter.calendar.JDateChooser;

import Repository.DAOFactory;
import Repository.Utenti.DAOPersonaImpl;
import StruttureTuristiche.Model.Inserzione;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.Model.Persona;
import Util.DateToLocalDate;
import Util.LocalDateToDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class NuovaInserzione extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextPane descrizioneTextField;
	private JComboBox strutturaTuristicaComboBox;
	private JComboBox<Integer> numeroPersoneComboBox;
	private JFormattedTextField prezzoPerNotteTextField;
	private JDateChooser dataInizio;
	private JDateChooser dataFine;
	private JButton confermaButton;
	NuovaInserzione thisNuovaInserzioneUI = this;

	DateToLocalDate dateToLocalDate = new DateToLocalDate();
	LocalDateToDate localDateToDate = new LocalDateToDate();

	private ArrayList<String> inserzioni;
	private ArrayList<String> struttureTuristiche;

	public static void display() {
		try {
			NuovaInserzione dialog = new NuovaInserzione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NuovaInserzione() {
		setTitle("Nuova inserzione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrizione.setBounds(127, 68, 96, 13);
		contentPanel.add(lblDescrizione);

		descrizioneTextField = new JTextPane();
		//descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(127, 91, 235, 105);
		contentPanel.add(descrizioneTextField);

		JLabel lblPrezzoPerNotte = new JLabel("Prezzo per notte");
		lblPrezzoPerNotte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrezzoPerNotte.setBounds(582, 231, 162, 20);
		contentPanel.add(lblPrezzoPerNotte);

		JLabel lblNumeroPersone = new JLabel("Numero persone");
		lblNumeroPersone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPersone.setBounds(127, 233, 128, 20);
		contentPanel.add(lblNumeroPersone);
		inserzioni = getCfInserzionistiOrdered();

		JLabel lblStrutturaTuristica = new JLabel("Struttura turistica");
		lblStrutturaTuristica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStrutturaTuristica.setBounds(582, 68, 186, 13);
		contentPanel.add(lblStrutturaTuristica);

		strutturaTuristicaComboBox = new JComboBox();
		strutturaTuristicaComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		struttureTuristiche = getPIvaOrdered();
		strutturaTuristicaComboBox.setModel(new DefaultComboBoxModel(struttureTuristiche.toArray()));
		strutturaTuristicaComboBox.setBounds(582, 91, 235, 35);
		strutturaTuristicaComboBox.setSelectedIndex(-1);
		contentPanel.add(strutturaTuristicaComboBox);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 451, 936, 124);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);

		confermaButton = new JButton("Conferma");
		confermaButton.setEnabled(false);
		confermaButton.addActionListener(this);
		confermaButton.setBounds(410, 20, 141, 43);
		buttonPane.add(confermaButton);


		numeroPersoneComboBox = new JComboBox();
		numeroPersoneComboBox.setBounds(127, 265, 128, 27);
		for(int i=1; i<11 ;i++) {
			numeroPersoneComboBox.addItem(i);
		}
		numeroPersoneComboBox.setSelectedIndex(-1);
		contentPanel.add(numeroPersoneComboBox);

		try {
			//NumberFormat format = NumberFormat.getInstance();
			NumberFormatter formatter = new NumberFormatter();
			formatter.setValueClass(Float.class);
			formatter.setMinimum(Float.MIN_VALUE);
			formatter.setMaximum(Float.MAX_VALUE);
			formatter.setAllowsInvalid(true);
			// If you want the value to be committed on each keystroke instead of focus lost
			formatter.setCommitsOnValidEdit(false);

			//MaskFormatter formatter = new MaskFormatter("#####.##");
			//formatter.setPlaceholderCharacter('0');
			prezzoPerNotteTextField = new JFormattedTextField(formatter);
			//prezzoPerNotteTextField.setText("00001.00");
		} catch(Exception e) {}

		prezzoPerNotteTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		prezzoPerNotteTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		prezzoPerNotteTextField.setBounds(582, 262, 218, 20);
		contentPanel.add(prezzoPerNotteTextField);

		JLabel lblEuro = new JLabel("\u20AC");
		lblEuro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEuro.setBounds(810, 265, 7, 14);
		contentPanel.add(lblEuro);

		JLabel dataInizioLabel = new JLabel("Inizio validita' inserzione");
		dataInizioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataInizioLabel.setBounds(127, 315, 162, 23);
		contentPanel.add(dataInizioLabel);

		dataInizio = new JDateChooser();
		dataInizio.setBounds(127, 338, 133, 19);
		contentPanel.add(dataInizio);

		JLabel dataFineLabel = new JLabel("Fine validita'  inserzione");
		dataFineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataFineLabel.setBounds(582, 315, 162, 23);
		contentPanel.add(dataFineLabel);

		dataFine = new JDateChooser();
		dataFine.setBounds(582, 338, 133, 19);
		dataFine.setEnabled(false);
		contentPanel.add(dataFine);

		createEvents();
	}

	public void warn() {
		if(!descrizioneTextField.getText().equals("") && strutturaTuristicaComboBox.getEditor().getItem() != null && numeroPersoneComboBox.getEditor().getItem() != null && !prezzoPerNotteTextField.getText().equals("") && dataInizio.getDate() != null && dataFine.getDate() != null) {
			confermaButton.setEnabled(true);
		} else
			confermaButton.setEnabled(false);
	}

	public void warn1() {
		if(dataInizio.getDate() != null) {
			dataFine.setMinSelectableDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataInizio.getDate()).plusDays(1)));
			dataFine.setDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataInizio.getDate()).plusDays(1)));
			dataFine.setEnabled(true);
		}
	}

	private void createEvents() {
		descrizioneTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		final JTextComponent stTC = (JTextComponent) strutturaTuristicaComboBox.getEditor().getEditorComponent();
		stTC.getDocument().addDocumentListener(new DocumentListener() {
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

		final JTextComponent npTC = (JTextComponent) numeroPersoneComboBox.getEditor().getEditorComponent();
		npTC.getDocument().addDocumentListener(new DocumentListener() {
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

		prezzoPerNotteTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		((JTextField) dataInizio.getDateEditor().getUiComponent()).getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
				warn1();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
				warn1();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
				warn1();
			}
		});

		((JTextField) dataFine.getDateEditor().getUiComponent()).getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
		});
	}

	public ArrayList<String> getCfInserzionistiOrdered() {
		HashMap<String, Persona> inserzionisti = new HashMap<String, Persona>(); 
		inserzionisti = DAOFactory.getDAOPersona().doRetrieveAll(DAOPersonaImpl.INSERZIONISTA);

		ArrayList<String> lista = new ArrayList<String>();

		for(Persona p : inserzionisti.values()) {
			lista.add(p.getCodiceFiscale());
		}

		Collections.sort(lista);
		return lista;
	}

	public ArrayList<String> getPIvaOrdered() {
		HashMap<String, StrutturaTuristica> struttureTuristiche = new HashMap<String, StrutturaTuristica>(); 
		struttureTuristiche = DAOFactory.getDAOStrutturaTuristica().doRetrieveAll();

		ArrayList<String> lista = new ArrayList<String>();

		for(StrutturaTuristica s : struttureTuristiche.values()) {
			lista.add(s.getPIva());
		}

		Collections.sort(lista);
		return lista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String descrizione = descrizioneTextField.getText();
		String strutturaTuristica = strutturaTuristicaComboBox.getEditor().getItem().toString();
		String numeroPersone = numeroPersoneComboBox.getEditor().getItem().toString();
		String prezzoPerNotte = prezzoPerNotteTextField.getText();

		DAOFactory.getDAOInserzione().insertInserzione(new Inserzione(descrizione, Double.parseDouble(prezzoPerNotte), Integer.parseInt(numeroPersone), dateToLocalDate.convertToLocalDateViaInstant(dataInizio.getDate()), dateToLocalDate.convertToLocalDateViaInstant(dataFine.getDate()), strutturaTuristica, DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(strutturaTuristica).getInserzionista()));
		JOptionPane.showMessageDialog(null, "Inserzione inserita correttamente.", "Nuova Inserzione", JOptionPane.INFORMATION_MESSAGE);
		thisNuovaInserzioneUI.dispose();
	}
}