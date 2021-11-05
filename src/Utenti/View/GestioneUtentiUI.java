package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facade.UtenteFacade;
import Utenti.Model.Dipendente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GestioneUtentiUI extends JFrame {
	UtenteFacade uf = UtenteFacade.getInstance();
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
		
		JButton btnVisualizzaClienti = new JButton("Visualizza Clienti");
		btnVisualizzaClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showVisualizzaPersone(RegistraPersona.CLIENTE, dip);
				//thisGestioneUtentiUI.dispose();
			}
		});
		btnVisualizzaClienti.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVisualizzaClienti.setBounds(104, 182, 217, 97);
		contentPane_1.add(btnVisualizzaClienti);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display(dip);
				//thisGestioneUtentiUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 30, 102, 21);
		contentPane_1.add(btnIndietro);
		
		JButton btnRegistraInserzionista = new JButton("Registra Inserzionisti");
		btnRegistraInserzionista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showRegistraPersona(RegistraPersona.INSERZIONISTA, dip);
				//thisGestioneUtentiUI.dispose();
			}
		});
		btnRegistraInserzionista.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRegistraInserzionista.setBounds(448, 361, 217, 97);
		contentPane_1.add(btnRegistraInserzionista);
		
		JButton btnVisualizzaInserzionisti = new JButton("Visualizza Inserzionisti");
		btnVisualizzaInserzionisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showVisualizzaPersone(RegistraPersona.INSERZIONISTA, dip);
				//thisGestioneUtentiUI.dispose();
			}
		});
		btnVisualizzaInserzionisti.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVisualizzaInserzionisti.setBounds(104, 361, 217, 97);
		contentPane_1.add(btnVisualizzaInserzionisti);
		
		JButton btnRegistraClienti = new JButton("Registra Clienti");
		btnRegistraClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showRegistraPersona(RegistraPersona.CLIENTE, dip);
				//thisGestioneUtentiUI.dispose();
			}
		});
		btnRegistraClienti.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRegistraClienti.setBounds(448, 182, 217, 97);
		contentPane_1.add(btnRegistraClienti);
	}

}
