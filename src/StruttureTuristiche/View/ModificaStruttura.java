package StruttureTuristiche.View;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaStruttura extends JDialog {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaStruttura dialog = new ModificaStruttura();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ModificaStruttura() {
		setTitle("Modifica Struttura");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBounds(0, 10, 936, 593);
		getContentPane().add(contentPanel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 158, 235, 35);
		contentPanel.add(textField);
		
		JLabel lblNewLabel = new JLabel("Nome Struttura");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(130, 125, 134, 29);
		contentPanel.add(lblNewLabel);
		
		JLabel lblC = new JLabel("Tipologia");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC.setBounds(130, 212, 134, 29);
		contentPanel.add(lblC);
		
		JLabel lblEmail = new JLabel("Stelle");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(130, 317, 134, 29);
		contentPanel.add(lblEmail);
		
		JLabel lblCognome = new JLabel("Indirizzo");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCognome.setBounds(526, 125, 134, 29);
		contentPanel.add(lblCognome);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(526, 158, 235, 35);
		contentPanel.add(textField_2);
		
		JLabel lblTelefono = new JLabel("ID Inserzionista");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(526, 212, 134, 29);
		contentPanel.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(526, 245, 235, 35);
		contentPanel.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("Id Struttura");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(526, 317, 134, 29);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblIDStruttura = new JLabel("*****");
		lblIDStruttura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIDStruttura.setBounds(526, 353, 45, 13);
		contentPanel.add(lblIDStruttura);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(null);
		buttonPane.setBounds(0, 509, 936, 73);
		contentPanel.add(buttonPane);
		
		JButton okButton = new JButton("Modifica");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		okButton.setFont(new Font("Dialog", Font.BOLD, 15));
		okButton.setActionCommand("OK");
		okButton.setBounds(195, 9, 153, 41);
		buttonPane.add(okButton);
		
		JButton cancelButton = new JButton("Annulla");
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBounds(561, 7, 144, 44);
		buttonPane.add(cancelButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(130, 347, 235, 35);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "B&B", "Residence", "Ostello"}));
		comboBox_1.setBounds(130, 251, 235, 35);
		contentPanel.add(comboBox_1);

	}

}
