package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import Facade.StrutturaTuristicaFacade;
import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.StruttureTuristiche.DAOStrutturaTuristica;
import Repository.Utenti.DAOPersona;
import Repository.Utenti.DAOPersonaImpl;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.Controller.PersonaController;
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

public class UpdateStruttura extends JFrame implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextField nomeTextField;
	private JTextField indirizzoTextField;
	private JComboBox hotelComboBox;
	private JComboBox cfInserzionistaComboBox;
	private JComboBox stelleComboBox;
	private JTextField pIvaTextField;
	private JComboBox pIvaComboBox;
	private JButton confermaButton;

	private int operazione;

	UtenteFacade uf = UtenteFacade.getInstance();
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();

	/**
	 * Launch the application.
	 */
	public static void display(int operazione) {
		try {
			UpdateStruttura frame = new UpdateStruttura(operazione);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public UpdateStruttura(int operazione) {
		this.operazione = operazione;
		String operazioneString = "";
		switch(this.operazione) {
		case AGGIUNGI:
			operazioneString = "Aggiungi";
			break;
		case MODIFICA:
			operazioneString = "Modifica";
			break;
		}

		setTitle("" + operazioneString + " struttura turistica");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 936, 582);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(130, 158, 235, 35);
		contentPanel.add(nomeTextField);

		JLabel lblNome = new JLabel("Nome Struttura");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(130, 125, 134, 29);
		contentPanel.add(lblNome);

		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipologia.setBounds(130, 212, 134, 29);
		contentPanel.add(lblTipologia);


		JLabel lblStelle = new JLabel("Stelle");
		lblStelle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStelle.setBounds(130, 317, 134, 29);
		contentPanel.add(lblStelle);

		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIndirizzo.setBounds(526, 212, 134, 29);
		contentPanel.add(lblIndirizzo);

		indirizzoTextField = new JTextField();
		indirizzoTextField.setColumns(10);
		indirizzoTextField.setBounds(526, 246, 235, 35);
		contentPanel.add(indirizzoTextField);

		JLabel lblCFInserzionista = new JLabel("CF Inserzionista");
		lblCFInserzionista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCFInserzionista.setBounds(526, 317, 134, 29);
		contentPanel.add(lblCFInserzionista);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 509, 936, 73);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);

		confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(this);
		confermaButton.setFont(new Font("Dialog", Font.BOLD, 15));
		confermaButton.setBounds(194, 9, 144, 44);
		confermaButton.setActionCommand("OK");
		confermaButton.setEnabled(false);
		buttonPane.add(confermaButton);
		getRootPane().setDefaultButton(confermaButton);

		JButton cancelButton = new JButton("Annulla");
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
		cancelButton.setBounds(561, 7, 144, 44);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		stelleComboBox = new JComboBox();
		stelleComboBox.setFont(new Font("Dialog", Font.BOLD, 14));
		stelleComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		stelleComboBox.setBounds(130, 347, 235, 35);
		contentPanel.add(stelleComboBox);

		hotelComboBox = new JComboBox();
		hotelComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		hotelComboBox.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "B&B", "Residence", "Ostello"}));
		hotelComboBox.setBounds(130, 245, 235, 35);
		contentPanel.add(hotelComboBox);

		cfInserzionistaComboBox = new JComboBox();
		cfInserzionistaComboBox.setEditable(true);
		cfInserzionistaComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		cfInserzionistaComboBox.setModel(new DefaultComboBoxModel(getCfInserzionistiOrdered()));
		cfInserzionistaComboBox.setBounds(526, 348, 235, 35);
		cfInserzionistaComboBox.setSelectedItem(null);
		contentPanel.add(cfInserzionistaComboBox);

		JLabel lblPIva = new JLabel("Partita IVA");
		lblPIva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPIva.setBounds(526, 125, 134, 29);
		contentPanel.add(lblPIva);

		pIvaTextField = new JTextField();
		pIvaTextField.setColumns(10);
		pIvaTextField.setBounds(526, 158, 235, 35);
		contentPanel.add(pIvaTextField);

		pIvaComboBox = new JComboBox();
		pIvaComboBox.setFont(new Font("Dialog", Font.BOLD, 13));
		pIvaComboBox.setModel(new DefaultComboBoxModel(getPIvaOrdered()));
		pIvaComboBox.setBounds(526, 158, 235, 35);
		pIvaComboBox.setSelectedItem(null);
		contentPanel.add(pIvaComboBox);

		switch(this.operazione) {
		case AGGIUNGI:
			pIvaTextField.setVisible(true);
			pIvaComboBox.setVisible(false);
			break;
		case MODIFICA:
			pIvaTextField.setVisible(false);
			pIvaComboBox.setVisible(true);
			break;
		}

		createEvents();
	}

	public void warn() {
		switch(operazione) {
		case AGGIUNGI:
			if(cfInserzionistaComboBox.getEditor().getItem() != null) {
				if(!nomeTextField.getText().equals("") && !pIvaTextField.getText().equals("") && !indirizzoTextField.getText().equals("") && !cfInserzionistaComboBox.getEditor().getItem().toString().equals(""))
					confermaButton.setEnabled(true);
				else
					confermaButton.setEnabled(false);
				break;
			}
		case MODIFICA:
			if(cfInserzionistaComboBox.getEditor().getItem() != null && pIvaComboBox.getEditor().getItem() != null) {
				if(!nomeTextField.getText().equals("") && !pIvaComboBox.getEditor().getItem().toString().equals("") && !indirizzoTextField.getText().equals("") && !cfInserzionistaComboBox.getEditor().getItem().toString().equals(""))
					confermaButton.setEnabled(true);
				else
					confermaButton.setEnabled(false);
				break;
			}
		}
	}

	private void createEvents() {
		nomeTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		switch(operazione) {
		case AGGIUNGI:
			pIvaTextField.getDocument().addDocumentListener(new DocumentListener() {
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
			break;
		case MODIFICA:
			DAOStrutturaTuristica daoStrutturaTuristica = DAOFactory.getDAOStrutturaTuristica();
			
			final JTextComponent pIvaTC = (JTextComponent) pIvaComboBox.getEditor().getEditorComponent();
			pIvaTC.getDocument().addDocumentListener(new DocumentListener() {
				private int x, y;
				private StrutturaTuristica s;
				public void changedUpdate(DocumentEvent e) {
					s = daoStrutturaTuristica.doRetrieveByPartitaIva(pIvaComboBox.getEditor().getItem().toString());
					nomeTextField.setText(s.getNome());
					indirizzoTextField.setText(s.getIndirizzo());
					final JTextComponent cfInserzionistaTC = (JTextComponent) cfInserzionistaComboBox.getEditor().getEditorComponent();
					cfInserzionistaTC.setText(s.getInserzionista());
					switch(s.getTipologia()) {
					case "Hotel":
						x = 0;
						break;
					case "B&B":
						x = 1;
						break;
					case "Residence":
						x = 2;
						break;
					case "Ostello":
						x = 3;
						break;
					} hotelComboBox.setSelectedIndex(x);
					switch(s.getStelle()) {
					case "1":
						y = 0;
						break;
					case "2":
						y = 1;
						break;
					case "3":
						y = 2;
						break;
					case "4":
						y = 3;
						break;
					case "5":
						y = 4;
						break;
					} stelleComboBox.setSelectedIndex(y);
					
					warn();
				}
				public void removeUpdate(DocumentEvent e) {
					s = daoStrutturaTuristica.doRetrieveByPartitaIva(pIvaComboBox.getEditor().getItem().toString());
					nomeTextField.setText(s.getNome());
					indirizzoTextField.setText(s.getIndirizzo());
					final JTextComponent cfInserzionistaTC = (JTextComponent) cfInserzionistaComboBox.getEditor().getEditorComponent();
					cfInserzionistaTC.setText(s.getInserzionista());
					switch(s.getTipologia()) {
					case "Hotel":
						x = 0;
						break;
					case "B&B":
						x = 1;
						break;
					case "Residence":
						x = 2;
						break;
					case "Ostello":
						x = 3;
						break;
					} hotelComboBox.setSelectedIndex(x);
					switch(s.getStelle()) {
					case "1":
						y = 0;
						break;
					case "2":
						y = 1;
						break;
					case "3":
						y = 2;
						break;
					case "4":
						y = 3;
						break;
					case "5":
						y = 4;
						break;
					} stelleComboBox.setSelectedIndex(y);
					
					warn();
				}
				public void insertUpdate(DocumentEvent e) {
					s = daoStrutturaTuristica.doRetrieveByPartitaIva(pIvaComboBox.getEditor().getItem().toString());
					nomeTextField.setText(s.getNome());
					indirizzoTextField.setText(s.getIndirizzo());
					final JTextComponent cfInserzionistaTC = (JTextComponent) cfInserzionistaComboBox.getEditor().getEditorComponent();
					cfInserzionistaTC.setText(s.getInserzionista());
					switch(s.getTipologia()) {
					case "Hotel":
						x = 0;
						break;
					case "B&B":
						x = 1;
						break;
					case "Residence":
						x = 2;
						break;
					case "Ostello":
						x = 3;
						break;
					} hotelComboBox.setSelectedIndex(x);
					switch(s.getStelle()) {
					case "1":
						y = 0;
						break;
					case "2":
						y = 1;
						break;
					case "3":
						y = 2;
						break;
					case "4":
						y = 3;
						break;
					case "5":
						y = 4;
						break;
					} stelleComboBox.setSelectedIndex(y);
					
					warn();
				}
			});
			break;
		}

		indirizzoTextField.getDocument().addDocumentListener(new DocumentListener() {
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
		
		final JTextComponent cfTC = (JTextComponent) cfInserzionistaComboBox.getEditor().getEditorComponent();
		cfTC.getDocument().addDocumentListener(new DocumentListener() {
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

		// Andrebbe aggiunto un DocumentListener (?) ai due JComboBox
	}

	public String[] getPIvaOrdered() {
		HashMap<String, StrutturaTuristica> strutture = new HashMap<String, StrutturaTuristica>(); 
		strutture = DAOFactory.getDAOStrutturaTuristica().doRetrieveAll();

		String[] lista = new String[strutture.size()];
		int i = 0;

		for(StrutturaTuristica s : strutture.values()) {
			lista[i] = s.getPIva();
			i++;
		}

		Arrays.sort(lista);
		return lista;
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

		if(!msg.equals("")) {	// La partita IVA e/o il codice fiscale dell'inserzionista non rispettano il pattern giusto
			JOptionPane.showMessageDialog(this, msg, "Errore", 0);
		}
		else {	// La partita IVA e il codice fiscale dell'inserzionista rispettano il pattern giusto
			String nome = nomeTextField.getText().toString();
			String pIva = "";
			switch(operazione) {
			case AGGIUNGI:
				pIva = pIvaTextField.getText().toString();
				break;
			case MODIFICA:
				pIva = pIvaComboBox.getEditor().getItem().toString();
				break;
			}
			String indirizzo = indirizzoTextField.getText().toString();
			String hotel = hotelComboBox.getEditor().getItem().toString();
			String cfInserzionista = cfInserzionistaComboBox.getEditor().getItem().toString().toUpperCase();
			String stelle = stelleComboBox.getEditor().getItem().toString();

			DAOStrutturaTuristica daoStrutturaTuristica = DAOFactory.getDAOStrutturaTuristica();

			msg = contains();

			if(!msg.equals("")) {
				switch(operazione) {
				case AGGIUNGI:
					JOptionPane.showMessageDialog(this, msg, "Errore", 0);
					break;
				case MODIFICA:
					daoStrutturaTuristica.updateStrutturaTuristica(new StrutturaTuristica(pIva, nome, stelle, hotel, indirizzo, cfInserzionista));
					System.out.println("Struttura turistica modificata con successo!");
					JOptionPane.showMessageDialog(this, "Modifica avvenuta con successo!", "Messaggio", 1);
					nomeTextField.setText("");
					pIvaTextField.setText("");
					pIvaComboBox.setSelectedIndex(-1);
					indirizzoTextField.setText("");
					hotelComboBox.setSelectedIndex(0);;
					cfInserzionistaComboBox.setSelectedIndex(-1);
					stelleComboBox.setSelectedIndex(0);
					break;
				}
			}
			else {
				switch(operazione) {
				case AGGIUNGI:
					daoStrutturaTuristica.updateStrutturaTuristica(new StrutturaTuristica(pIva, nome, stelle, hotel, indirizzo, cfInserzionista));
					System.out.println("Struttura turistica registrata con successo!");
					JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo!", "Messaggio", 1);
					nomeTextField.setText("");
					pIvaTextField.setText("");
					pIvaComboBox.setSelectedIndex(-1);
					indirizzoTextField.setText("");
					hotelComboBox.setSelectedIndex(0);;
					cfInserzionistaComboBox.setSelectedIndex(-1);
					stelleComboBox.setSelectedIndex(0);
					break;
				case MODIFICA:
					msg = "Partita IVA non ancora registrata.";
					JOptionPane.showMessageDialog(this, msg, "Errore", 0);
					break;
				}
			}
		}
	}

	public String checkPIvaTextField() {
		String pIva = "";

		switch(operazione) {
		case AGGIUNGI:
			pIva = pIvaTextField.getText();
			break;
		case MODIFICA:
			pIva = pIvaComboBox.getEditor().getItem().toString();
			break;
		}
		String msg = "";

		String pIvaPattern = "^[0-9]{11}$";
		Pattern pattern = Pattern.compile(pIvaPattern);
		if(!pattern.matcher(pIva).matches()) {
			System.out.println("Partita IVA " + pIva + " non valida.");
			msg = "Partita IVA non valida.\n";
			return msg;
		}
		else {
			//System.out.println("");
			return msg;
		}
	}

	public String checkCfInserzionistaTextField() {
		String cf = cfInserzionistaComboBox.getEditor().getItem().toString().toUpperCase();
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

	public String contains() {
		String target = "";
		String msg = "";

		switch(operazione) {
		case AGGIUNGI:
			target = pIvaTextField.getText().toString();
			break;
		case MODIFICA:
			target = pIvaComboBox.getEditor().getItem().toString();
			break;
		}

		if(stf.getStrutturaTuristicaController().contains(target) == true) {
			System.out.println("Partita IVA " + target + " già registrata.");
			msg = "Partita IVA già registrata.";
		}

		return msg;
	}

	public static final int AGGIUNGI = 0;
	public static final int MODIFICA = 1;
}
