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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Home extends JFrame {
	UtenteFacade uf = UtenteFacade.getInstance();
	Dipendente dip;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void display(Dipendente dip) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(dip);
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
	public Home(Dipendente dip) {
		this.dip = dip;
		
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStrutture = new JButton("Strutture");
		btnStrutture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStrutture.setFont(new Font("Dialog", Font.BOLD, 18));
		btnStrutture.setBounds(37, 140, 261, 97);
		contentPane.add(btnStrutture);
		
		JButton btnInserzioni = new JButton("Inserzioni");
		btnInserzioni.setFont(new Font("Dialog", Font.BOLD, 18));
		btnInserzioni.setBounds(333, 229, 261, 97);
		contentPane.add(btnInserzioni);
		
		JButton btnPrenotazioni = new JButton("Prenotazioni");
		btnPrenotazioni.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPrenotazioni.setBounds(37, 315, 261, 97);
		contentPane.add(btnPrenotazioni);
		
		JButton btnUtenti = new JButton("Utenti");
		btnUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUtenti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnUtenti.setBounds(333, 395, 261, 97);
		contentPane.add(btnUtenti);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Home thisHome = this;
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				thisHome.dispose();
			}
		});
		btnLogout.setBounds(645, 96, 102, 30);
		contentPane.add(btnLogout);
		
		JButton btnPagamenti = new JButton("Pagamento \r\nPrenotazioni");
		btnPagamenti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPagamenti.setBounds(333, 62, 261, 97);
		contentPane.add(btnPagamenti);
		
		JLabel utenteLabel = new JLabel("" + dip.getNome() + " " + dip.getCognome());
		utenteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		utenteLabel.setBounds(645, 62, 102, 30);
		contentPane.add(utenteLabel);
		
		this.setVisible(true);
	}
}
