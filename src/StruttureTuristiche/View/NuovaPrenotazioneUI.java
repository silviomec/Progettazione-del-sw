package StruttureTuristiche.View;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Pagamenti.Model.RicevutaPagamentoPrenotazione;
import Repository.DAOFactory;
import Repository.Utenti.DAOPersonaImpl;
import StruttureTuristiche.Model.Inserzione;
import StruttureTuristiche.Model.Prenotazione;
import Utenti.Model.Persona;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import Util.*;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.time.*;


public class NuovaPrenotazioneUI extends JDialog {
	private Inserzione inserzione;
	private JTextField prezzoTotaleField;
	private JDateChooser dataArrivo;
	private JDateChooser dataPartenza;
	private ArrayList<String> clienti;
	private JTextField descrizioneTextField;
	private JTextField prezzoPerNotteTextField;
	private JTextField numeroPersonetextField;
	private JTextField strutturaTuristicaTextField;
	private double prezzoTotale;
	private JButton prenotaButton;
	private JComboBox CodiceClientecomboBox;
	NuovaPrenotazioneUI thisNuovaPrenotazioneUI = this;
	DateToLocalDate dateToLocalDate = new DateToLocalDate();
	LocalDateToDate localDateToDate = new LocalDateToDate();

	public static void display(Inserzione inserzione) {
		try {
			NuovaPrenotazioneUI dialog = new NuovaPrenotazioneUI(inserzione);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuovaPrenotazioneUI(Inserzione inserzione) {
		this.inserzione = inserzione;

		setTitle("Nuova Prenotazione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 604, 558, -590);
		getContentPane().add(scrollPane);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 17, 48);
		scrollPane.add(scrollBar);

		JPanel configuraPrenotazionePanel = new JPanel();
		configuraPrenotazionePanel.setBounds(578, 10, 348, 593);
		getContentPane().add(configuraPrenotazionePanel);
		configuraPrenotazionePanel.setLayout(null);

		prenotaButton = new JButton("PRENOTA E PAGA");
		prenotaButton.setBounds(104, 481, 156, 44);
		prenotaButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		prenotaButton.setEnabled(false);
		prenotaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DAOFactory.getDAOPrenotazione().insertPrenotazione(new Prenotazione(dateToLocalDate.convertToLocalDateViaInstant(dataArrivo.getDate()), dateToLocalDate.convertToLocalDateViaInstant(dataPartenza.getDate()), prezzoTotale, CodiceClientecomboBox.getEditor().getItem().toString(), inserzione.getIdInserzione(), inserzione.getStrutturaTuristica()) );	
				DAOFactory.getDAORicevutaPagamentoPrenotazione().insertRicevutaPagamentoPrenotazione(new RicevutaPagamentoPrenotazione(prezzoTotale, LocalDate.now(), DAOFactory.getDAOPrenotazione().lastInsertId(), CodiceClientecomboBox.getEditor().getItem().toString(), inserzione.getStrutturaTuristica())) ;
				JOptionPane.showMessageDialog(null, "Prenotazione e Pagamento effettuati correttamente.", "Prenotazione e Pagamento", JOptionPane.INFORMATION_MESSAGE);
				thisNuovaPrenotazioneUI.dispose();
			}
		});
		configuraPrenotazionePanel.add(prenotaButton);

		JLabel codiceClienteLabel = new JLabel("Codice cliente");
		codiceClienteLabel.setBounds(15, 10, 86, 17);
		codiceClienteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		configuraPrenotazionePanel.add(codiceClienteLabel);

		JLabel dataPartenzaLabel = new JLabel("Data partenza");
		dataPartenzaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataPartenzaLabel.setBounds(15, 216, 110, 23);
		configuraPrenotazionePanel.add(dataPartenzaLabel);

		dataArrivo = new JDateChooser(calendarioDisponibilita(), null, null, null);
		dataArrivo.setBounds(15, 127, 133, 19);
		configuraPrenotazionePanel.add(dataArrivo);

		dataPartenza = new JDateChooser(calendarioDisponibilita(), null, null, null);
		dataPartenza = new JDateChooser();
		dataPartenza.setBounds(15, 251, 133, 19);
		dataPartenza.setEnabled(false);
		configuraPrenotazionePanel.add(dataPartenza);

		JLabel dataArrivoLabel = new JLabel("Data arrivo");
		dataArrivoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataArrivoLabel.setBounds(15, 92, 110, 23);
		configuraPrenotazionePanel.add(dataArrivoLabel);

		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale");
		prezzoTotaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleLabel.setBounds(15, 371, 138, 23);
		configuraPrenotazionePanel.add(prezzoTotaleLabel);

		prezzoTotaleField = new JTextField();
		prezzoTotaleField.setEditable(false);
		prezzoTotaleField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleField.setColumns(10);
		prezzoTotaleField.setBounds(15, 405, 96, 19);
		configuraPrenotazionePanel.add(prezzoTotaleField);

		CodiceClientecomboBox = new JComboBox();
		CodiceClientecomboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		CodiceClientecomboBox.setBounds(15, 39, 236, 27);
		clienti = getCfClientiOrdered();
		CodiceClientecomboBox.setModel(new DefaultComboBoxModel(clienti.toArray()));
		CodiceClientecomboBox.setSelectedItem(null);
		configuraPrenotazionePanel.add(CodiceClientecomboBox);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBounds(0, 6, 500, 610);
		getContentPane().add(contentPanel);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrizione.setBounds(60, 105, 96, 13);
		contentPanel.add(lblDescrizione);

		descrizioneTextField = new JTextField();
		descrizioneTextField.setText(inserzione.getDescrizione());
		descrizioneTextField.setEditable(false);
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(60, 130, 348, 129);
		contentPanel.add(descrizioneTextField);

		JLabel lblPrezzoPerNotte = new JLabel("Prezzo per notte");
		lblPrezzoPerNotte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrezzoPerNotte.setBounds(60, 287, 162, 25);
		contentPanel.add(lblPrezzoPerNotte);

		prezzoPerNotteTextField = new JTextField();
		prezzoPerNotteTextField.setText(Double.toString(inserzione.getPrezzoPerNotte()));
		prezzoPerNotteTextField.setEditable(false);
		prezzoPerNotteTextField.setColumns(10);
		prezzoPerNotteTextField.setBounds(60, 312, 235, 35);
		contentPanel.add(prezzoPerNotteTextField);

		JLabel lblNumeroPersone = new JLabel("Numero persone");
		lblNumeroPersone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPersone.setBounds(60, 392, 128, 20);
		contentPanel.add(lblNumeroPersone);

		numeroPersonetextField = new JTextField();
		numeroPersonetextField.setText(Integer.toString(inserzione.getNumeroPersone()));
		numeroPersonetextField.setEditable(false);
		numeroPersonetextField.setColumns(10);
		numeroPersonetextField.setBounds(60, 417, 235, 35);
		contentPanel.add(numeroPersonetextField);

		JLabel lblStrutturaTuristica = new JLabel("Struttura turistica");
		lblStrutturaTuristica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStrutturaTuristica.setBounds(60, 6, 186, 13);
		contentPanel.add(lblStrutturaTuristica);

		strutturaTuristicaTextField = new JTextField();
		strutturaTuristicaTextField.setText((DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(inserzione.getStrutturaTuristica())).getNome());
		strutturaTuristicaTextField.setEditable(false);
		strutturaTuristicaTextField.setColumns(10);
		strutturaTuristicaTextField.setBounds(60, 31, 235, 35);
		contentPanel.add(strutturaTuristicaTextField);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(512, 0, 12, 633);
		getContentPane().add(separator);

		createEvents();
	}

	public void warn() {

		if(dataArrivo.getDate() != null) {
			dataPartenza.setMinSelectableDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataArrivo.getDate()).plusDays(1)));
			dataPartenza.setDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataArrivo.getDate()).plusDays(1)));
			dataPartenza.setEnabled(true);


			prezzoTotale = this.calcolaPrezzoTotale(inserzione.getPrezzoPerNotte(), dataArrivo.getDate(), dataPartenza.getDate());
			prezzoTotaleField.setText(Double.toString(prezzoTotale)+" €");

		}

		if(!CodiceClientecomboBox.getEditor().getItem().toString().equals("")) {
			prenotaButton.setEnabled(true);
		}
	}

	public void warn1() {
		if(dataPartenza.getDate() != null) {
			prezzoTotale = this.calcolaPrezzoTotale(inserzione.getPrezzoPerNotte(), dataArrivo.getDate(), dataPartenza.getDate());
			prezzoTotaleField.setText(Double.toString(prezzoTotale)+" €");
		}
	}

	public void warn2() {
		if(!CodiceClientecomboBox.getEditor().getItem().toString().equals("") && dataArrivo.getDate() !=null && dataPartenza.getDate() !=null) {
			prenotaButton.setEnabled(true);
		}
	}

	private void createEvents() {
		((JTextField) dataArrivo.getDateEditor().getUiComponent()).getDocument().addDocumentListener(new DocumentListener() {
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

		((JTextField) dataPartenza.getDateEditor().getUiComponent()).getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				warn1();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				warn1();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				warn1();
			}


		}); 

		Component editor = CodiceClientecomboBox.getEditor().getEditorComponent();
		if (editor instanceof JTextField) {
			((JTextField) editor).getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent documentEvent) {
					warn2();
				}

				@Override
				public void removeUpdate(DocumentEvent documentEvent) {
					warn2();
				}

				@Override
				public void changedUpdate(DocumentEvent documentEvent) {
					warn2();
				}
			});   
		}
	}

	public JCalendar calendarioDisponibilita() {
		JCalendar calendario = new JCalendar();
		RangeEvaluator rangeEvaluator = new RangeEvaluator();
		HashMap<Integer, Prenotazione> prenotazioni = DAOFactory.getDAOPrenotazione().doRetrieveAllByIdInserzione(inserzione.getIdInserzione());

		LocalDate dataMinima = LocalDate.now();
		if(inserzione.getDataInizio().isAfter(dataMinima))
			dataMinima = inserzione.getDataInizio();

		for(Prenotazione p : prenotazioni.values()) {
			rangeEvaluator.setStartDate(Date.from(p.getDataArrivo().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
			rangeEvaluator.setEndDate(Date.from(p.getDataPartenza().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));

			calendario.getDayChooser().addDateEvaluator(rangeEvaluator);
		}

		calendario.setMinSelectableDate(Date.from(dataMinima.atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
		calendario.setMaxSelectableDate(Date.from(inserzione.getDataFine().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
		return calendario;
	}

	public ArrayList<String> getCfClientiOrdered() {
		HashMap<String, Persona> clienti = new HashMap<String, Persona>(); 
		clienti = DAOFactory.getDAOPersona().doRetrieveAll(DAOPersonaImpl.CLIENTE);

		ArrayList<String> lista = new ArrayList<String>();

		for(Persona p : clienti.values()) {
			lista.add(p.getCodiceFiscale());
		}

		Collections.sort(lista);
		return lista;
	}

	public double calcolaPrezzoTotale(double prezzoPerNotte, Date dataArrivo , Date dataPartenza) {

		LocalDate dataA = dateToLocalDate.convertToLocalDateViaInstant(dataArrivo);
		LocalDate dataP = dateToLocalDate.convertToLocalDateViaInstant(dataPartenza);

		long giorni;
		double prezzoTotale;
		giorni = ChronoUnit.DAYS.between(dataA, dataP);

		prezzoTotale = giorni* prezzoPerNotte;

		return prezzoTotale;
	}
}