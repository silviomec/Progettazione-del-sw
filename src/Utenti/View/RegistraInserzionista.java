package Utenti.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utenti.Model.Dipendente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RegistraInserzionista extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void display(Dipendente dip) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistraInserzionista frame = new RegistraInserzionista(dip);
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
	public RegistraInserzionista(Dipendente dip) {
		setTitle("Registra Inserzionista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 786, 563);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 54, 134, 29);
		contentPane_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(46, 87, 235, 35);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(46, 174, 235, 35);
		contentPane_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(442, 87, 235, 35);
		contentPane_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(442, 174, 235, 35);
		contentPane_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(46, 271, 235, 35);
		contentPane_1.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Id Inserzionista");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(442, 246, 134, 29);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblIDInserzionista = new JLabel("*****");
		lblIDInserzionista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIDInserzionista.setBounds(442, 282, 45, 13);
		contentPane_1.add(lblIDInserzionista);
		
		JButton btnNewButton = new JButton("Registra");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(253, 389, 212, 67);
		contentPane_1.add(btnNewButton);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCognome.setBounds(442, 54, 134, 29);
		contentPane_1.add(lblCognome);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(442, 141, 134, 29);
		contentPane_1.add(lblTelefono);
		
		JLabel lblC = new JLabel("Codice Fiscale");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC.setBounds(46, 141, 134, 29);
		contentPane_1.add(lblC);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(46, 246, 134, 29);
		contentPane_1.add(lblEmail);
	}

}
