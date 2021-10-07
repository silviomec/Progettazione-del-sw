package Utenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JList;

public class VisualizzaInserzionisti extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaInserzionisti frame = new VisualizzaInserzionisti();
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
	public VisualizzaInserzionisti() {
		setTitle("Visualizza Inserzionisti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 786, 563);
		contentPane.add(contentPane_1);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setText("Search");
		txtpnSearch.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch.setBounds(10, 30, 776, 25);
		contentPane_1.add(txtpnSearch);
		
		JList list = new JList();
		list.setBounds(713, 111, -621, 395);
		contentPane_1.add(list);
	}
}
