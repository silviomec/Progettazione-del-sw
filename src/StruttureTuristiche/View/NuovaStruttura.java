package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NuovaStruttura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuovaStruttura dialog = new NuovaStruttura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuovaStruttura() {
		setTitle("Nuova Inserzione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 936, 582);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(130, 158, 235, 35);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabel = new JLabel("Nome Struttura");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(130, 125, 134, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblC = new JLabel("Tipologia");
			lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblC.setBounds(130, 212, 134, 29);
			contentPanel.add(lblC);
		}
		{
			JLabel lblEmail = new JLabel("Stelle");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(130, 317, 134, 29);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblCognome = new JLabel("Indirizzo");
			lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCognome.setBounds(526, 125, 134, 29);
			contentPanel.add(lblCognome);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(526, 158, 235, 35);
			contentPanel.add(textField_3);
		}
		{
			JLabel lblTelefono = new JLabel("ID Inserzionista");
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTelefono.setBounds(526, 212, 134, 29);
			contentPanel.add(lblTelefono);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(526, 245, 235, 35);
			contentPanel.add(textField_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Id Struttura");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(526, 317, 134, 29);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblIDStruttura = new JLabel("*****");
			lblIDStruttura.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIDStruttura.setBounds(526, 353, 45, 13);
			contentPanel.add(lblIDStruttura);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 509, 936, 73);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Conferma");
				okButton.setFont(new Font("Dialog", Font.BOLD, 15));
				okButton.setBounds(194, 9, 144, 44);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annulla");
				cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
				cancelButton.setBounds(561, 7, 144, 44);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Dialog", Font.BOLD, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
			comboBox.setBounds(130, 347, 235, 35);
			contentPanel.add(comboBox);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Dialog", Font.BOLD, 13));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "B&B", "Residence", "Ostello"}));
			comboBox.setBounds(130, 245, 235, 35);
			contentPanel.add(comboBox);
		}
	}

}
