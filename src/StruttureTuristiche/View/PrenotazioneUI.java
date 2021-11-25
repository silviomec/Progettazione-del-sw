package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrenotazioneUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotazioneUI frame = new PrenotazioneUI();
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
	public PrenotazioneUI() {
		setTitle("Prenotazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 936, 613);
		contentPane.add(contentPane_1);
		
		JButton btnNuovaPrenotazione = new JButton("Nuova Prenotazione");
		btnNuovaPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuovaPrenotazione.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNuovaPrenotazione.setBounds(27, 99, 243, 97);
		contentPane_1.add(btnNuovaPrenotazione);
		
		JButton btnNewButton_1 = new JButton("Cancella Prenotazione");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(27, 217, 243, 97);
		contentPane_1.add(btnNewButton_1);
		
		JList list = new JList();
		list.setBounds(322, 581, 556, -446);
		contentPane_1.add(list);
		
		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setText("Search...");
		txtpnSearch_1.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch_1.setBounds(284, 30, 642, 25);
		contentPane_1.add(txtpnSearch_1);
	}

}
