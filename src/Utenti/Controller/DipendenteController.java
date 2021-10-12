package Utenti.Controller;

import java.sql.SQLException;

import Exception.GenericMessageDialog;
import Exception.DipendenteNotFoundException;
import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.Utenti.DAODipendente;
import Repository.Utenti.DAODipendenteImpl;
import Utenti.Model.Dipendente;

public class DipendenteController {
	private DAODipendente daoDipendente;
	private UtenteFacade utenteFacade;

	public DipendenteController(UtenteFacade uf) {
		utenteFacade = uf;
		//DAOFactory df = new DAOFactory();
		daoDipendente = DAOFactory.getDAODipendente();
	}

	/**
	 * Questa funzione effettua il login. In caso di successo restituisce un Cliente/Amm/Autista
	 * @param username
	 * @param password
	 * @return void 
	 * @throws SQLException 
	 */
	public void doLogin(String username, String password) throws SQLException {
		Dipendente dip = null;
		try {
			dip = daoDipendente.doRetrieveByUsername(username);

			boolean passMatch = password.equals(dip.getPassword());
			if (passMatch) {
				System.out.println("Login successful for user: " + dip.getUsername());
				if (dip instanceof Dipendente) {
					Dipendente d = (Dipendente) dip;
					utenteFacade.showHome(dip);
				}
			} else {
				new GenericMessageDialog("Login fallito", "La password inserita non è corretta per l'utente " + username, null).display();
			}
		} catch (DipendenteNotFoundException e) {
			e.printStackTrace();
			new GenericMessageDialog("Login fallito", "Dipendente " + username + " non trovato", null).display();
		}

	}

	public void showAutistaHomeUI(Autista a) {
		utenteFacade.disposeAll();
		utenteFacade.showAutistaHome(a);
	}
}
