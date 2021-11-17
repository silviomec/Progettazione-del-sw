package StruttureTuristiche.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Pagamenti.Model.Canone;

public class GestisciCanone {

	public static void display(Canone canone) {
		try {
			GestisciCanone gestisciCanone = new GestisciCanone(canone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestisciCanone(Canone canone) {
		long giorni = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), canone.getScadenza());
		String label;
		JButton pagaButton = new JButton("Paga");
		pagaButton.setEnabled(false);
		JButton storicoButton = new JButton("Storico pagamenti");
		
		JLabel jLabel;
		if(giorni > 0)
			jLabel = new JLabel("<html><center>Il canone scadrà il " + canone.getScadenza().toString() + ".<br/>(tra " + giorni + " giorn" + (giorni==1 ? "o" : "i") + ")</center></html>");
		else {
			jLabel = new JLabel("<html><center>Il canone è scaduto il " + canone.getScadenza().toString() + ".<br/>(" + (giorni*-1) + " giorn" + (giorni==1 ? "o" : "i") + " fa)</center></html>");
			pagaButton.setEnabled(true);
		}
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Object[] options = {pagaButton, storicoButton};
		JOptionPane.showOptionDialog(null, jLabel, "Gestisci canone", JOptionPane.YES_NO_OPTION, (giorni>0 ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE), null, options, options[0]);
	}
}
