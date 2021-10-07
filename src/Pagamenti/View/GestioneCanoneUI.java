package Pagamenti.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class GestioneCanoneUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestioneCanoneUI dialog = new GestioneCanoneUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestioneCanoneUI() {
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 493, 936, 120);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			contentPanel.setBounds(812, 15, 1, 1);
			buttonPane.add(contentPanel);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				okButton.setBounds(295, 47, 144, 44);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				cancelButton.setBounds(483, 47, 144, 44);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JList list = new JList();
			list.setBounds(243, 458, 398, -230);
			getContentPane().add(list);
		}
		{
			JButton btnNewButton = new JButton("PAGA");
			btnNewButton.setEnabled(false);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(38, 39, 144, 44);
			getContentPane().add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(286, 41, 404, 42);
			getContentPane().add(lblNewLabel);
		}
		{
			JTextPane txtpnCvbhj = new JTextPane();
			txtpnCvbhj.setEditable(false);
			txtpnCvbhj.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			txtpnCvbhj.setText("cvbhj");
			txtpnCvbhj.setBounds(298, 123, 188, 44);
			getContentPane().add(txtpnCvbhj);
		}
	}

}
