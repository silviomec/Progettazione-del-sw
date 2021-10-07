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
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Gestisci Canone");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(695, 355, 210, 217);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			contentPanel.setBounds(812, 15, 1, 1);
			buttonPane.add(contentPanel);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(null);
			{
				JButton cancelButton = new JButton("Chiudi");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				cancelButton.setBounds(48, 130, 144, 44);
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
			}
			
			JButton btnNewButton = new JButton("PAGA");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(48, 42, 144, 44);
			buttonPane.add(btnNewButton);
		}
		{
			JList list = new JList();
			list.setBounds(75, 541, 535, -474);
			getContentPane().add(list);
		}
		{
			JLabel lblNewLabel = new JLabel("STATO :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(668, 117, 73, 42);
			getContentPane().add(lblNewLabel);
		}
		
		JFormattedTextField frmtdtxtfldPagato = new JFormattedTextField();
		frmtdtxtfldPagato.setBackground(Color.GREEN);
		frmtdtxtfldPagato.setText("PAGATO");
		frmtdtxtfldPagato.setEditable(false);
		frmtdtxtfldPagato.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldPagato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmtdtxtfldPagato.setBounds(751, 122, 126, 33);
		getContentPane().add(frmtdtxtfldPagato);
		
		JLabel lblScadenza = new JLabel("SCADENZA:");
		lblScadenza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblScadenza.setBounds(657, 180, 94, 42);
		getContentPane().add(lblScadenza);
		
		JLabel lblDataScadenza = new JLabel("");
		lblDataScadenza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataScadenza.setBounds(752, 180, 125, 42);
		getContentPane().add(lblDataScadenza);
	}
}
