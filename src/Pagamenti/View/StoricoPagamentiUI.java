package Pagamenti.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JList;

public class StoricoPagamentiUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoricoPagamentiUI frame = new StoricoPagamentiUI();
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
	public StoricoPagamentiUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setText("Search");
		txtpnSearch.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtpnSearch.setBounds(58, 91, 776, 25);
		contentPane.add(txtpnSearch);
		
		JList list = new JList();
		list.setBounds(811, 534, -729, -374);
		contentPane.add(list);
	}
}
