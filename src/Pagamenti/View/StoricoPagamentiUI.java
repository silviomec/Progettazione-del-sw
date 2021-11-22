package Pagamenti.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Repository.DAOFactory;
import Repository.Pagamenti.DAOCanoneImpl;
import StruttureTuristiche.Model.StrutturaTuristica;
import StruttureTuristiche.View.StruttureTuristicheUI;
import Utenti.View.Home;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JList;

public class StoricoPagamentiUI extends JFrame {

	private JPanel contentPane;
	private JTextField cercaTextField;
	private JButton btnCerca;
	private JTable tablePrenotazioni;
	private JTable tableCanoni;
	private static DefaultTableModel dtm = new DefaultTableModel();

	public static void display() {
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

	public StoricoPagamentiUI() {
		StoricoPagamentiUI thisStoricoPagamentiUI = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.display();
				thisStoricoPagamentiUI.dispose();
			}
		});
		btnIndietro.setBounds(10, 10, 85, 21);
		contentPane.add(btnIndietro);
		
		cercaTextField = new JTextField();
		cercaTextField.setBounds(27, 47, 716, 25);
		cercaTextField.setFont(new Font("Dialog", Font.ITALIC, 14));
		contentPane.add(cercaTextField);
		
		btnCerca = new JButton("Cerca");
		btnCerca.setEnabled(false);
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca(cercaTextField.getText());
				//rimuoviStrutturaButton.setEnabled(false);
				//modificaStrutturaButton.setEnabled(false);
			}
		});
		btnCerca.setBounds(753, 47, 85, 21);
		contentPane.add(btnCerca);
		
		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerca("");
				//rimuoviStrutturaButton.setEnabled(false);
				//modificaStrutturaButton.setEnabled(false);
				//gestisciCanoneButton.setEnabled(false);
				cercaTextField.setText("");
			}
		});
		btnRipristina.setBounds(841, 47, 85, 21);
		contentPane.add(btnRipristina);
		
		tablePrenotazioni = new JTable();
		tablePrenotazioni.setBounds(344, 322, 314, -206);
		tablePrenotazioni.setModel(dtm);
		tablePrenotazioni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPanePrenotazioni = new JScrollPane(tablePrenotazioni);
		scrollPanePrenotazioni.setBounds(483, 83, 443, 521);
		contentPane.add(scrollPanePrenotazioni);
		
		tableCanoni = new JTable();
		tableCanoni.setBounds(344, 322, 314, -206);
		tableCanoni.setModel(dtm);
		tableCanoni.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneCanoni = new JScrollPane(tableCanoni);
		scrollPaneCanoni.setBounds(27, 83, 443, 521);
		contentPane.add(scrollPaneCanoni);
	}
	
	public static DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		StoricoPagamentiUI.dtm = dtm;
	}
	
	public static void cerca(String target) {
		int i, j;

		for(i = 0, j = getDtm().getRowCount(); i < j; i++)
			getDtm().removeRow(0);

		struttureTuristiche = new ArrayList<StrutturaTuristica>();
		for (StrutturaTuristica s : DAOFactory.getDAOStrutturaTuristica().doRetrieveAllFiltered(target).values()) {
			struttureTuristiche.add(s);
		}
		Collections.sort(struttureTuristiche);
		for(StrutturaTuristica s : struttureTuristiche) {
			getDtm().addRow(new Object[]{s.getPIva(), s.getNome(), s.getIndirizzo(), s.getTipologia(), s.getStelle(), s.getInserzionista(), DAOFactory.getDAOCanone().doRetrieve(DAOCanoneImpl.STRUTTURA_TURISTICA, s.getPIva()).getScadenza()});
		}
		
		//rimuoviStrutturaButton.setEnabled(false);
		//modificaStrutturaButton.setEnabled(false);
		//gestisciCanoneButton.setEnabled(false);
	}
}
