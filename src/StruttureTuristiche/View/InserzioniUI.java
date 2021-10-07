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

public class InserzioniUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserzioniUI frame = new InserzioniUI();
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
	public InserzioniUI() {
		setTitle("Inerzioni");
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
		
		JButton btnInserisciInserzione = new JButton("Inserisci Inserzione");
		btnInserisciInserzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserisciInserzione.setFont(new Font("Dialog", Font.BOLD, 18));
		btnInserisciInserzione.setBounds(27, 100, 207, 97);
		contentPane_1.add(btnInserisciInserzione);
		
		JButton btnNewButton_1 = new JButton("Rimuovi Inserzione");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(27, 217, 207, 97);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifica Inserzione");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(27, 336, 207, 97);
		contentPane_1.add(btnNewButton_2);
		
		JList list = new JList();
		list.setBounds(293, 559, 585, -424);
		contentPane_1.add(list);
		
		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setText("Search...");
		txtpnSearch_1.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch_1.setBounds(210, 30, 716, 25);
		contentPane_1.add(txtpnSearch_1);
	}

}
