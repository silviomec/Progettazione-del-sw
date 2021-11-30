package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import Repository.DAOFactory;
import Repository.Utenti.DAOPersonaImpl;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.Model.Persona;

import javax.swing.JLabel;
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

public class NuovaInserzione extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField descrizioneTextField;
	private JComboBox strutturaTuristicaComboBox;
	private JComboBox<Integer> numeroPersoneComboBox;
	private JFormattedTextField prezzoPerNotteTextField;

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

		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

		JLabel lblNewLabel = new JLabel("\u20AC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(810, 265, 7, 14);
		contentPanel.add(lblNewLabel);
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

	public String checkPrezzoPerNotte() {
		String prezzoPerNotte = prezzoPerNotteTextField.getText();
		String msg = "";

		String prezzoPerNottePattern = "^[0-9]+,+[0-9]{2}$";
		Pattern pattern = Pattern.compile(prezzoPerNottePattern, Pattern.CASE_INSENSITIVE);
		if(!pattern.matcher(prezzoPerNotte).matches()) {
			System.out.println("Prezzo per notte non valido.");
			msg = "Prezzo per notte non valido.";
			return msg;
		}
		else {
			//System.out.println("Prezzo per notte valido.");
			return msg;
		}
	}
}