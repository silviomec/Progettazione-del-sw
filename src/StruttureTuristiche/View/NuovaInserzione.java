package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repository.DAOFactory;
import Repository.Utenti.DAOPersonaImpl;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.Model.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NuovaInserzione extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField descrizioneTextField;
	private JTextField prezzoPerNotteTextField;
	private JTextField numeroPersoneTextField;
	private JComboBox inserzionistaComboBox;
	private JComboBox strutturaTuristicaComboBox;
	
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

		descrizioneTextField = new JTextField();
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(127, 91, 235, 35);
		contentPanel.add(descrizioneTextField);

		JLabel lblPrezzoPerNotte = new JLabel("Prezzo per notte");
		lblPrezzoPerNotte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrezzoPerNotte.setBounds(127, 150, 162, 13);
		contentPanel.add(lblPrezzoPerNotte);

		prezzoPerNotteTextField = new JTextField();
		prezzoPerNotteTextField.setColumns(10);
		prezzoPerNotteTextField.setBounds(127, 173, 235, 35);
		contentPanel.add(prezzoPerNotteTextField);

		JLabel lblNumeroPersone = new JLabel("Numero persone");
		lblNumeroPersone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPersone.setBounds(127, 233, 128, 13);
		contentPanel.add(lblNumeroPersone);

		numeroPersoneTextField = new JTextField();
		numeroPersoneTextField.setColumns(10);
		numeroPersoneTextField.setBounds(127, 256, 235, 35);
		contentPanel.add(numeroPersoneTextField);

		JLabel lblInserzionista = new JLabel("Inserzionista");
		lblInserzionista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserzionista.setBounds(127, 316, 139, 13);
		contentPanel.add(lblInserzionista);

		inserzionistaComboBox = new JComboBox();
		inserzionistaComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		inserzioni = getCfInserzionistiOrdered();
		inserzionistaComboBox.setModel(new DefaultComboBoxModel(inserzioni.toArray()));
		inserzionistaComboBox.setBounds(127, 339, 235, 35);
		inserzionistaComboBox.setSelectedIndex(-1);
		contentPanel.add(inserzionistaComboBox);

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
		buttonPane.setBounds(0, 506, 936, 69);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);

		JButton okButton = new JButton("Conferma");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		okButton.setBounds(238, 14, 144, 44);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
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
}