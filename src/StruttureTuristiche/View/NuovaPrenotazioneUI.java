package StruttureTuristiche.View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Repository.DAOFactory;
import StruttureTuristiche.Model.Inserzione;
import StruttureTuristiche.Model.Prenotazione;

import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import Util.*;

public class NuovaPrenotazioneUI extends JDialog {
	private Inserzione inserzione;

	private JTextField codiceClienteField;
	private JTextField numeroPersoneField;
	private JTextField disponibilitaField;
	private JTextField prezzoTotaleField;
	private JDateChooser dataArrivo;
	private JDateChooser dataPartenza;

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

		JButton prenotaButton = new JButton("PRENOTA");
		prenotaButton.setBounds(115, 538, 141, 25);
		prenotaButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		prenotaButton.setEnabled(false);
		configuraPrenotazionePanel.add(prenotaButton);

		JLabel codiceClienteLabel = new JLabel("Codice cliente");
		codiceClienteLabel.setBounds(10, 10, 86, 17);
		codiceClienteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		configuraPrenotazionePanel.add(codiceClienteLabel);

		codiceClienteField = new JTextField();
		codiceClienteField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codiceClienteField.setColumns(10);
		codiceClienteField.setBounds(10, 33, 319, 19);
		configuraPrenotazionePanel.add(codiceClienteField);

		JLabel dataPartenzaLabel = new JLabel("Data partenza");
		dataPartenzaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataPartenzaLabel.setBounds(174, 67, 110, 23);
		configuraPrenotazionePanel.add(dataPartenzaLabel);

		JLabel lblNumeroDiPersone = new JLabel("Numero di persone:");
		lblNumeroDiPersone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDiPersone.setBounds(10, 364, 138, 23);
		configuraPrenotazionePanel.add(lblNumeroDiPersone);

		numeroPersoneField = new JTextField();
		numeroPersoneField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numeroPersoneField.setEnabled(false);
		numeroPersoneField.setEditable(false);
		numeroPersoneField.setColumns(10);
		numeroPersoneField.setBounds(188, 366, 96, 19);
		configuraPrenotazionePanel.add(numeroPersoneField);

		dataArrivo = new JDateChooser(calendarioDisponibilita(), null, null, null);
		dataArrivo.setBounds(10, 90, 133, 19);
		configuraPrenotazionePanel.add(dataArrivo);

		dataPartenza = new JDateChooser(calendarioDisponibilita(), null, null, null);
		dataPartenza = new JDateChooser();
		dataPartenza.setBounds(171, 90, 133, 19);
		dataPartenza.setEnabled(false);
		configuraPrenotazionePanel.add(dataPartenza);

		JLabel dataArrivoLabel = new JLabel("Data arrivo");
		dataArrivoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataArrivoLabel.setBounds(10, 65, 110, 23);
		configuraPrenotazionePanel.add(dataArrivoLabel);

		JLabel disponibilitaLabel = new JLabel("Disponibilità:");
		disponibilitaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disponibilitaLabel.setBounds(10, 297, 138, 23);
		configuraPrenotazionePanel.add(disponibilitaLabel);

		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleLabel.setBounds(10, 443, 138, 23);
		configuraPrenotazionePanel.add(prezzoTotaleLabel);

		disponibilitaField = new JTextField();
		disponibilitaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disponibilitaField.setEnabled(false);
		disponibilitaField.setEditable(false);
		disponibilitaField.setColumns(10);
		disponibilitaField.setBounds(188, 299, 96, 19);
		configuraPrenotazionePanel.add(disponibilitaField);

		prezzoTotaleField = new JTextField();
		prezzoTotaleField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleField.setEnabled(false);
		prezzoTotaleField.setEditable(false);
		prezzoTotaleField.setColumns(10);
		prezzoTotaleField.setBounds(188, 445, 96, 19);
		configuraPrenotazionePanel.add(prezzoTotaleField);

		createEvents();
	}

	public void warn() {

		if(dataArrivo.getDate() != null) {
			DateToLocalDate dateToLocalDate = new DateToLocalDate();
			LocalDateToDate localDateToDate = new LocalDateToDate();
			dataPartenza.setMinSelectableDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataArrivo.getDate()).plusDays(1)));
			dataPartenza.setDate(localDateToDate.convertToDateViaInstant(dateToLocalDate.convertToLocalDateViaInstant(dataArrivo.getDate()).plusDays(1)));
			dataPartenza.setEnabled(true);
		}

		/*if(!cercaTextField.getText().equals(""))
			btnCerca.setEnabled(true);
		else
			btnCerca.setEnabled(false);

		if(table.isRowSelected(table.getSelectedRow())) {
			rimuoviStrutturaButton.setEnabled(true);
			modificaStrutturaButton.setEnabled(true);
			gestisciCanoneButton.setEnabled(true);
		}*/
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

		/*cercaTextField.getDocument().addDocumentListener(new DocumentListener() {
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
		});*/
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
}