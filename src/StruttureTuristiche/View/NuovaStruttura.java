package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Repository.DAOFactory;
import Repository.Utenti.DAOPersona;
import Repository.Utenti.DAOPersonaImpl;
import Utenti.Model.Persona;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuovaStruttura extends JFrame implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextField nomeTextField;
	private JTextField indirizzoTextField;
	private JComboBox hotelComboBox;
	private JComboBox cfInserzionistaComboBox;
	private JComboBox stelleComboBox;

	/**
	 * Launch the application.
	 */
	public static void display() {
		try {
			NuovaStruttura frame = new NuovaStruttura();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public NuovaStruttura() {
		setTitle("Nuova Inserzione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 936, 582);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			nomeTextField = new JTextField();
			nomeTextField.setColumns(10);
			nomeTextField.setBounds(130, 158, 235, 35);
			contentPanel.add(nomeTextField);
		}
		{
			JLabel lblNome = new JLabel("Nome Struttura");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNome.setBounds(130, 125, 134, 29);
			contentPanel.add(lblNome);
		}
		{
			JLabel lblTipologia = new JLabel("Tipologia");
			lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTipologia.setBounds(130, 212, 134, 29);
			contentPanel.add(lblTipologia);
		}
		{
			JLabel lblStelle = new JLabel("Stelle");
			lblStelle.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblStelle.setBounds(130, 317, 134, 29);
			contentPanel.add(lblStelle);
		}
		{
			JLabel lblIndirizzo = new JLabel("Indirizzo");
			lblIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIndirizzo.setBounds(526, 125, 134, 29);
			contentPanel.add(lblIndirizzo);
		}
		{
			indirizzoTextField = new JTextField();
			indirizzoTextField.setColumns(10);
			indirizzoTextField.setBounds(526, 158, 235, 35);
			contentPanel.add(indirizzoTextField);
		}
		{
			JLabel lblCFInserzionista = new JLabel("CF Inserzionista");
			lblCFInserzionista.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCFInserzionista.setBounds(526, 212, 134, 29);
			contentPanel.add(lblCFInserzionista);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 509, 936, 73);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Conferma");
				okButton.setFont(new Font("Dialog", Font.BOLD, 15));
				okButton.setBounds(194, 9, 144, 44);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annulla");
				cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
				cancelButton.setBounds(561, 7, 144, 44);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			stelleComboBox = new JComboBox();
			stelleComboBox.setFont(new Font("Dialog", Font.BOLD, 14));
			stelleComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
			stelleComboBox.setBounds(130, 347, 235, 35);
			contentPanel.add(stelleComboBox);
		}
		{
			hotelComboBox = new JComboBox();
			hotelComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
			hotelComboBox.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "B&B", "Residence", "Ostello"}));
			hotelComboBox.setBounds(130, 245, 235, 35);
			contentPanel.add(hotelComboBox);
		}

		cfInserzionistaComboBox = new JComboBox();
		cfInserzionistaComboBox.setEditable(true);
		cfInserzionistaComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		cfInserzionistaComboBox.setModel(new DefaultComboBoxModel(getCfInserzionistiOrdered()));
		cfInserzionistaComboBox.setBounds(526, 245, 235, 35);
		cfInserzionistaComboBox.setSelectedItem(null);
		contentPanel.add(cfInserzionistaComboBox);
	}




	public String[] getCfInserzionistiOrdered() {
		HashMap<String, Persona> inserzionisti = new HashMap<String, Persona>(); 
		inserzionisti = DAOFactory.getDAOPersona().doRetrieveAll(DAOPersonaImpl.INSERZIONISTA);

		String[] lista = new String[inserzionisti.size()];
		int i = 0;

		for(Persona p : inserzionisti.values()) {
			lista[i] = p.getCodiceFiscale();
			i++;
		}

		Arrays.sort(lista);
		return lista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg;

		msg = checkPIvaTextField();
		msg += checkCfInserzionistaTextField();

		if(!msg.equals("")) {	// La Partita Iva o il Codice Fiscale inseriti non rispettano il pattern giusto
			JOptionPane.showMessageDialog(this, msg, "Errore", 0);
		}
		else {	// La Partita Iva e il Codice Fiscale inseriti rispettano il pattern giusto
			String nome = nomeTextField.getText().toString();
			String indirizzo = indirizzoTextField.getText().toString();
			String hotel = hotelComboBox.getText().toString();
			String cfInserzionista = cfInserzionistaComboBox.getText().toString().toUpperCase();
			String stelle = stelleComboBox.getText().toString();

			DAOPersona daoPersona = DAOFactory.getDAOPersona();

			msg = contains();

			if(!msg.equals("")) {	// Codice fiscale, telefono e/o email sono gi� inseriti nel database
				JOptionPane.showMessageDialog(this, msg, "Errore", 0);
			}
			else {
				daoPersona.updatePersona(tipologiaPersona, new Persona(cf, nome, cognome, telefono, email));
				System.out.println(tabella + " registrato con successo!");
				JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo!", "Messaggio", 1);
				nomeTextField.setText("");
				cognomeTextField.setText("");
				cfTextField.setText("");
				telefonoTextField.setText("");
				emailTextField.setText("");
			}
		}
	}

	public String checkPIvaTextField() {
		String pIva = pIvaTextField.getText();
		String msg = "";

		String pIvaPattern = "^[0-9]{11}$";
		Pattern pattern = Pattern.compile(pIvaPattern, Pattern.CASE_INSENSITIVE);
		if(!pattern.matcher(pIva).matches()) {
			System.out.println("");
			msg = "";
			return msg;
		}
		else {
			//System.out.println("");
			return msg;
		}
	}

	public String checkCfInserzionistaTextField() {
		String cf = cfInserzionistaTextField.getText().toUpperCase();
		String msg = "";

		if(cf.length() != 16) {
			System.out.println("Codice fiscale della lunghezza sbagliata.");
			msg = "Codice fiscale della lunghezza sbagliata.\n";
			return msg;
		}
		else {
			String cfPattern = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";
			Pattern pattern = Pattern.compile(cfPattern);
			if(!pattern.matcher(cf).matches()) {
				System.out.println("Codice fiscale " + cf + " non valido.");
				msg = "Codice fiscale non valido.\n";
				return msg;
			}
			else
				return msg;
		}
	}

}
