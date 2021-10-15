package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utenti.Model.Dipendente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestioneUtentiUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void display(Dipendente dip) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneUtentiUI frame = new GestioneUtentiUI(dip);
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
	
	public GestioneUtentiUI(Dipendente dip) {
		GestioneUtentiUI thisGestioneUtentiUI = this;
		
		setTitle("Gestione Utenti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String marco = new String ("ciao \n come '\n' va");
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Visualizza Clienti");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(104, 182, 217, 97);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display(dip);
				thisGestioneUtentiUI.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 30, 102, 21);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registra Inserzionisti");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.setBounds(448, 361, 217, 97);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnVisualizzaInserzionisti = new JButton("Visualizza Inserzionisti");
		btnVisualizzaInserzionisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizzaInserzionisti.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVisualizzaInserzionisti.setBounds(104, 361, 217, 97);
		contentPane_1.add(btnVisualizzaInserzionisti);
		
		JButton btnNewButton_4 = new JButton("Registra Clienti");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistraCliente.display(dip);
				thisGestioneUtentiUI.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_4.setBounds(448, 182, 217, 97);
		contentPane_1.add(btnNewButton_4);
	}

}
