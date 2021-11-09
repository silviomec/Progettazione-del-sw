package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facade.UtenteFacade;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class StruttureTuristicheUI extends JFrame {
	UtenteFacade uf = UtenteFacade.getInstance();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StruttureTuristicheUI frame = new StruttureTuristicheUI();
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
	public StruttureTuristicheUI() {
		StruttureTuristicheUI thisStruttureTuristicheUI = this;
		
		setTitle("Strutture Turistiche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton btnNewButton = new JButton("Inserisci Struttura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showNuovaStruttura();
				thisStruttureTuristicheUI.dispose();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBounds(27, 100, 193, 97);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rimuovi Struttura");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uf.showModificaStruttura();
				thisStruttureTuristicheUI.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_1.setBounds(27, 217, 193, 97);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifica Struttura");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_2.setBounds(27, 336, 193, 97);
		contentPane.add(btnNewButton_2);
		
		JList list = new JList();
		list.setBounds(293, 559, 585, -424);
		contentPane.add(list);
		
		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setText("Search...");
		txtpnSearch_1.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch_1.setBounds(210, 30, 716, 25);
		contentPane.add(txtpnSearch_1);
		
		JButton btnNewButton_3 = new JButton("Gestisci Canone");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(54, 524, 166, 35);
		contentPane.add(btnNewButton_3);
	}
}
