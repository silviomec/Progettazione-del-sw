package Utenti.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facade.*;
import Pagamenti.View.StoricoPagamentiUI;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Home extends JFrame {
	UtenteFacade uf = UtenteFacade.getInstance();
	StrutturaTuristicaFacade stf = StrutturaTuristicaFacade.getInstance();
	PagamentoFacade pf = PagamentoFacade.getInstance();

	private JPanel contentPane;

	public static void display() {
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

	public Home() {
		Home thisHome = this;
		
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
				stf.showStruttureTuristicheUI();
				thisHome.dispose();
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
				uf.showGestioneUtenti();
				thisHome.dispose();
			}
		});
		btnUtenti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnUtenti.setBounds(333, 395, 261, 97);
		contentPane.add(btnUtenti);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				thisHome.dispose();
			}
		});
		btnLogout.setBounds(645, 96, 102, 30);
		contentPane.add(btnLogout);
		
		JButton btnRicevutePagamenti = new JButton("Ricevute pagamenti");
		btnRicevutePagamenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.showStoricoPagamentiUI(StoricoPagamentiUI.CANONI_PRENOTAZIONI, "");
				thisHome.dispose();
			}
		});
		btnRicevutePagamenti.setFont(new Font("Dialog", Font.BOLD, 18));
		btnRicevutePagamenti.setBounds(333, 62, 261, 97);
		contentPane.add(btnRicevutePagamenti);
		
		JLabel utenteLabel = new JLabel("" + uf.getDipendenteController().getDipendenteAttivo().getNome() + " " + uf.getDipendenteController().getDipendenteAttivo().getCognome());
		utenteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		utenteLabel.setBounds(645, 62, 102, 30);
		contentPane.add(utenteLabel);
		
		this.setVisible(true);
	}
}
