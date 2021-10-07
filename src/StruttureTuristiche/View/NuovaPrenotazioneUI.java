package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

public class NuovaPrenotazioneUI extends JDialog {
	private JTextField codiceClienteField;
	private JTextField numeroPersoneField;
	private JTextField disponibilitaField;
	private JTextField prezzoTotaleField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuovaPrenotazioneUI dialog = new NuovaPrenotazioneUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuovaPrenotazioneUI() {
		setTitle("Nuova Prenotazione");
		setBounds(100, 100, 950, 650);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 604, 558, -590);
		getContentPane().add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 17, 48);
		scrollPane.add(scrollBar);
		
		JList list = new JList();
		list.setForeground(Color.BLACK);
		list.setBounds(0, 0, 488, 1);
		scrollPane.add(list);
		
		JPanel configuraPrenotazionePanel = new JPanel();
		configuraPrenotazionePanel.setBounds(578, 10, 348, 593);
		getContentPane().add(configuraPrenotazionePanel);
		configuraPrenotazionePanel.setLayout(null);
		
		JButton prenotaButton = new JButton("PRENOTA");
		prenotaButton.setBounds(115, 538, 141, 25);
		prenotaButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		prenotaButton.setEnabled(false);
		configuraPrenotazionePanel.add(prenotaButton);
		
		JLabel codiceClienteLabel = new JLabel("Codice cliente");
		codiceClienteLabel.setBounds(10, 10, 86, 17);
		codiceClienteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		configuraPrenotazionePanel.add(codiceClienteLabel);
		
		codiceClienteField = new JTextField();
		codiceClienteField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codiceClienteField.setColumns(10);
		codiceClienteField.setBounds(10, 33, 319, 19);
		configuraPrenotazionePanel.add(codiceClienteField);
		
		JLabel dataArrivoLabel = new JLabel("Data arrivo");
		dataArrivoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataArrivoLabel.setBounds(174, 67, 110, 23);
		configuraPrenotazionePanel.add(dataArrivoLabel);
		
		JLabel lblNumeroDiPersone = new JLabel("Numero di persone:");
		lblNumeroDiPersone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDiPersone.setBounds(10, 364, 138, 23);
		configuraPrenotazionePanel.add(lblNumeroDiPersone);
		
		numeroPersoneField = new JTextField();
		numeroPersoneField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numeroPersoneField.setEnabled(false);
		numeroPersoneField.setEditable(false);
		numeroPersoneField.setColumns(10);
		numeroPersoneField.setBounds(188, 366, 96, 19);
		configuraPrenotazionePanel.add(numeroPersoneField);
		
		JDateChooser dataArrivo = new JDateChooser();
		dataArrivo.setBounds(10, 90, 133, 19);
		configuraPrenotazionePanel.add(dataArrivo);
		
		JDateChooser dataPartenza = new JDateChooser();
		dataPartenza.setBounds(171, 90, 133, 19);
		configuraPrenotazionePanel.add(dataPartenza);
		
		JLabel dataPartenzaLabel = new JLabel("Data partenza");
		dataPartenzaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataPartenzaLabel.setBounds(10, 65, 110, 23);
		configuraPrenotazionePanel.add(dataPartenzaLabel);
		
		JLabel disponibilitaLabel = new JLabel("Disponibilit\u00E0:");
		disponibilitaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disponibilitaLabel.setBounds(10, 297, 138, 23);
		configuraPrenotazionePanel.add(disponibilitaLabel);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleLabel.setBounds(10, 443, 138, 23);
		configuraPrenotazionePanel.add(prezzoTotaleLabel);
		
		disponibilitaField = new JTextField();
		disponibilitaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disponibilitaField.setEnabled(false);
		disponibilitaField.setEditable(false);
		disponibilitaField.setColumns(10);
		disponibilitaField.setBounds(188, 299, 96, 19);
		configuraPrenotazionePanel.add(disponibilitaField);
		
		prezzoTotaleField = new JTextField();
		prezzoTotaleField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezzoTotaleField.setEnabled(false);
		prezzoTotaleField.setEditable(false);
		prezzoTotaleField.setColumns(10);
		prezzoTotaleField.setBounds(188, 445, 96, 19);
		configuraPrenotazionePanel.add(prezzoTotaleField);
	}
}
