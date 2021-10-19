package Utenti.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utenti.Model.Dipendente;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JList;

@SuppressWarnings("serial")
public class VisualizzaClienti extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void display(Dipendente dip) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaClienti frame = new VisualizzaClienti(dip);
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
	public VisualizzaClienti(Dipendente dip) {
		setTitle("Visualizza Clienti");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setBounds(10, 30, 776, 25);
		txtpnSearch.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch.setText("Search");
		contentPane.add(txtpnSearch);
		
		JList list = new JList();
		list.setBounds(713, 111, -621, 395);
		contentPane.add(list);
		
		}
	
}
