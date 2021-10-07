package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblWelcomePleaseLogin = new JLabel("Welcome. Please login to use the application");
		lblWelcomePleaseLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseLogin.setBounds(155, 125, 450, 150);
		lblWelcomePleaseLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblWelcomePleaseLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(236, 300, 97, 13);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(236, 323, 307, 19);
		contentPane.add(textField);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passLabel.setBounds(236, 360, 83, 13);
		contentPane.add(passLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(236, 383, 307, 19);
		contentPane.add(textField_1);
		
		JButton confirmButton = new JButton("CONFIRM");
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setEnabled(false);
		confirmButton.setBounds(315, 443, 141, 21);
		contentPane.add(confirmButton);
	}
}
