package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class RegistraCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JLabel lblIDCliente;
	private JButton btnNewButton;
	private JLabel lblCognome;
	private JLabel lblTelefono;
	private JLabel lblC;
	private JLabel lblEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistraCliente frame = new RegistraCliente();
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
	public RegistraCliente() {
		setTitle("Registra Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 54, 134, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(46, 87, 235, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(46, 174, 235, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(442, 87, 235, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(442, 174, 235, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(46, 271, 235, 35);
		contentPane.add(textField_4);
		
		lblNewLabel_5 = new JLabel("Id Cliente");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(442, 246, 134, 29);
		contentPane.add(lblNewLabel_5);
		
		lblIDCliente = new JLabel("*****");
		lblIDCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIDCliente.setBounds(442, 282, 45, 13);
		contentPane.add(lblIDCliente);
		
		btnNewButton = new JButton("Registra");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBounds(253, 389, 212, 67);
		contentPane.add(btnNewButton);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCognome.setBounds(442, 54, 134, 29);
		contentPane.add(lblCognome);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(442, 141, 134, 29);
		contentPane.add(lblTelefono);
		
		lblC = new JLabel("Codice Fiscale");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC.setBounds(46, 141, 134, 29);
		contentPane.add(lblC);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(46, 246, 134, 29);
		contentPane.add(lblEmail);
	}

}
