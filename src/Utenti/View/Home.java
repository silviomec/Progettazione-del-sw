package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Strutture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBounds(37, 140, 261, 97);
		contentPane.add(btnNewButton);
		
		JButton btnInserzioni = new JButton("Inserzioni");
		btnInserzioni.setFont(new Font("Dialog", Font.BOLD, 18));
		btnInserzioni.setBounds(333, 229, 261, 97);
		contentPane.add(btnInserzioni);
		
		JButton btnPrenotazioni = new JButton("Prenotazioni");
		btnPrenotazioni.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPrenotazioni.setBounds(37, 315, 261, 97);
		contentPane.add(btnPrenotazioni);
		
		JButton btnClienti = new JButton("Utenti");
		btnClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClienti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnClienti.setBounds(333, 395, 261, 97);
		contentPane.add(btnClienti);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(645, 31, 102, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnPagamenti = new JButton("Pagamento \r\nPrenotazioni");
		btnPagamenti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPagamenti.setBounds(333, 62, 261, 97);
		contentPane.add(btnPagamenti);
	}
}
