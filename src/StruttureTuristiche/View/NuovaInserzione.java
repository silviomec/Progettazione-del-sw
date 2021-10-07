package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NuovaInserzione extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuovaInserzione dialog = new NuovaInserzione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuovaInserzione() {
		setTitle("Nuova Inserzione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Titolo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(127, 68, 96, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(127, 91, 235, 35);
			contentPanel.add(textField);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione");
			lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDescrizione.setBounds(127, 150, 96, 13);
			contentPanel.add(lblDescrizione);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(127, 173, 235, 35);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblNumeroPersone = new JLabel("Numero Persone");
			lblNumeroPersone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNumeroPersone.setBounds(127, 233, 128, 13);
			contentPanel.add(lblNumeroPersone);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(127, 256, 235, 35);
			contentPanel.add(textField_2);
		}
		{
			JLabel lblPrezzoPerNotte = new JLabel("Prezzo Per Notte");
			lblPrezzoPerNotte.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrezzoPerNotte.setBounds(127, 316, 139, 13);
			contentPanel.add(lblPrezzoPerNotte);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(127, 339, 235, 35);
			contentPanel.add(textField_3);
		}
		{
			JLabel lblEmailInserzionista = new JLabel("Email Inserzionista");
			lblEmailInserzionista.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmailInserzionista.setBounds(127, 403, 162, 13);
			contentPanel.add(lblEmailInserzionista);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(127, 426, 235, 35);
			contentPanel.add(textField_4);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(582, 91, 235, 35);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblStrutturaTuristica = new JLabel("Struttura Turistica");
			lblStrutturaTuristica.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblStrutturaTuristica.setBounds(582, 68, 186, 13);
			contentPanel.add(lblStrutturaTuristica);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 506, 936, 69);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Conferma");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				okButton.setBounds(238, 14, 144, 44);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annulla");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				cancelButton.setBounds(610, 14, 144, 44);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Id Inserzione");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(582, 412, 134, 29);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblIDStruttura = new JLabel("*****");
			lblIDStruttura.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIDStruttura.setBounds(582, 448, 45, 13);
			contentPanel.add(lblIDStruttura);
		}
	}
}
