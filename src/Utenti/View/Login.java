package Utenti.View;

import Facade.UtenteFacade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Exception.DipendenteNotFoundException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JButton confirmButton = new JButton("CONFIRM");
	private JLabel lbl_error_username;
	private JLabel lbl_error_password;

	UtenteFacade uf = UtenteFacade.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomePleaseLogin = new JLabel("Welcome! Please login to use the application.");
		lblWelcomePleaseLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseLogin.setBounds(155, 125, 450, 150);
		lblWelcomePleaseLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblWelcomePleaseLogin);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(236, 300, 97, 13);
		contentPane.add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(236, 323, 307, 19);
		contentPane.add(usernameTextField);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(236, 360, 83, 13);
		contentPane.add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(236, 383, 307, 19);
		contentPane.add(passwordTextField);

		confirmButton.addActionListener(this)/*new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					uf.getDipendenteController().doLogin(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
				} catch (DipendenteNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		})*/;

		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setEnabled(false);
		confirmButton.setBounds(315, 443, 141, 21);
		contentPane.add(confirmButton);

		lbl_error_username = new JLabel("");
		lbl_error_username.setBounds(323, 125, 25, 25);
		lbl_error_username.setIcon(new ImageIcon("res/dialog-error.png"));
		lbl_error_username.setVisible(false);
		this.getContentPane().add(lbl_error_username);

		lbl_error_password = new JLabel();
		lbl_error_password.setBounds(323, 180, 25, 25);
		//lbl_error_password.setIcon(new ImageIcon(new ImageIcon("dialog-error.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		lbl_error_password.setIcon(new ImageIcon("res/dialog-error.png"));
		lbl_error_password.setVisible(false);
		this.getContentPane().add(lbl_error_password);

		createEvents();
	}

	/*public void display() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}*/

	public void warn() {
		if(!usernameTextField.getText().equals("") && !String.valueOf(passwordTextField.getPassword()).equals(""))
			confirmButton.setEnabled(true);
		else
			confirmButton.setEnabled(false);
	}

	private void createEvents() {
		usernameTextField.getDocument().addDocumentListener(new DocumentListener() {
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

		passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
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

	private void endLoginProcessing(String msg, boolean usn, boolean pwd) {
		JOptionPane.showMessageDialog(this, msg, "Errore", 0);
		lbl_error_username.setVisible(usn);
		lbl_error_password.setVisible(pwd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = usernameTextField.getText().toString();
		String password = String.valueOf(passwordTextField.getPassword());
		String msg = "";
		boolean error_username = true;
		boolean error_password = true;

		/* Controllo validità  inserimento */
		if(username.length() < 3) msg = "Username di almeno 3 caratteri\n";
		else if(username.length() > 16) msg = "Username di massimo 16 caratteri\n";
		else error_username = false;

		if(password.length() < 4) msg += "Password di almeno 4 caratteri";
		else if(password.length() > 30) msg += "Password di massimo 30 caratteri";
		else error_password = false;	

		if(!msg.equals("")) { 
			endLoginProcessing(msg, error_username, error_password);
			return;
		}
		
		try {
			boolean passMatch = uf.getDipendenteController().doLogin(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
			if(passMatch)
				this.dispose();
		} catch (DipendenteNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}