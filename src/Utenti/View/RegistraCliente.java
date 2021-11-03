package Utenti.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.Utenti.DAOCliente;
import Utenti.Model.Cliente;
import Utenti.Model.Dipendente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegistraCliente extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField cfTextField;
	private JTextField telefonoTextField;
	private JTextField emailTextField;
	private JButton btnRegistra = new JButton("Registra");
	private JLabel lblCognome;
	private JLabel lblTelefono;
	private JLabel lblCf;
	private JLabel lblEmail;

	UtenteFacade uf = UtenteFacade.getInstance();

	/**
	 * Launch the application.
	 */
	public static void display(Dipendente dip) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistraCliente frame = new RegistraCliente(dip);
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
	public RegistraCliente(Dipendente dip) {
		setTitle("Registra Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(46, 54, 134, 29);
		contentPane.add(lblNome);

		nomeTextField = new JTextField();
		nomeTextField.setBounds(46, 87, 235, 35);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);

		cfTextField = new JTextField();
		cfTextField.setColumns(10);
		cfTextField.setBounds(46, 174, 235, 35);
		contentPane.add(cfTextField);

		cognomeTextField = new JTextField();
		cognomeTextField.setColumns(10);
		cognomeTextField.setBounds(442, 87, 235, 35);
		contentPane.add(cognomeTextField);

		telefonoTextField = new JTextField();
		telefonoTextField.setColumns(10);
		telefonoTextField.setBounds(442, 174, 235, 35);
		contentPane.add(telefonoTextField);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(46, 271, 235, 35);
		contentPane.add(emailTextField);


		btnRegistra.addActionListener(this);
		/*(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		}); */
		btnRegistra.setEnabled(false);
		btnRegistra.setFont(new Font("Dialog", Font.BOLD, 18));
		btnRegistra.setBounds(253, 389, 212, 67);
		contentPane.add(btnRegistra);

		lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCognome.setBounds(442, 54, 134, 29);
		contentPane.add(lblCognome);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(442, 141, 134, 29);
		contentPane.add(lblTelefono);

		lblCf = new JLabel("Codice Fiscale");
		lblCf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCf.setBounds(46, 141, 134, 29);
		contentPane.add(lblCf);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(46, 246, 134, 29);
		contentPane.add(lblEmail);

		createEvents();
	}
	
	public void warn() {
		if(!nomeTextField.getText().equals("") && !cognomeTextField.getText().equals("") && !cfTextField.getText().equals("") && !telefonoTextField.getText().equals("") && !emailTextField.getText().equals(""))
			btnRegistra.setEnabled(true);
		else
			btnRegistra.setEnabled(false);
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

	public void warn() {
		if(!nomeTextField.getText().equals("") && !cognomeTextField.getText().equals("") && !cfTextField.getText().equals("") && !telefonoTextField.getText().equals("") && !emailTextField.getText().equals(""))
			btnRegistra.setEnabled(true);
		else
			btnRegistra.setEnabled(false);
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

		cognomeTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		cfTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		telefonoTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		emailTextField.getDocument().addDocumentListener(new DocumentListener() {
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

	public String checkCf() {
		String cf = cfTextField.getText().toUpperCase();
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
				System.out.println("Codice fiscale non valido.");
				msg = "Codice fiscale non valido.\n";
				return msg;
			}
			else {
				if(uf.getClienteController().checkCf(cf)) {
					System.out.println("Codice fiscale gi� registrato.");
					msg = "Codice fiscale gi� registrato.\n";
					return msg;
				}
				else {
					//System.out.println("Codice fiscale corretto e non ancora registrato.");
					return msg;
				}
			}
		}
	}
	
	public String checkEmail() {
		String email = emailTextField.getText();
		String msg = "";
		
		String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		if(!pattern.matcher(email).matches()) {
			System.out.println("Indirizzo email non valido.");
			msg = "Indirizzo email non valido.";
			return msg;
		}
		else {
			//System.out.println("Indirizzo email valido.");
			return msg;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg;
		
		msg = checkCf();
		msg += checkEmail();
		
		if(!msg.equals("")) {
			JOptionPane.showMessageDialog(this, msg, "Errore", 0);
		}
		else {
			String nome = nomeTextField.getText().toString();
			String cognome = cognomeTextField.getText().toString();
			String cf = cfTextField.getText().toString();
			String telefono = telefonoTextField.getText().toString();
			String email = emailTextField.getText().toString();
			
			DAOCliente daoCliente = DAOFactory.getDAOCliente();
			if(daoCliente.updateCliente(new Cliente(cf, nome, cognome, telefono, email)) == 0)
				System.out.println("Errore nell'aggiornamento del cliente!");
			
			System.out.println("Cliente registrato con successo!");
			JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo!", "Messaggio", 1);
		}
	}
}
