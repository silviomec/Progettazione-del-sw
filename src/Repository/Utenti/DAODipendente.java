package Repository.Utenti;

import java.util.HashMap;

import Exception.DipendenteNotFoundException;
import Utenti.Model.Dipendente;

public interface DAODipendente {
	public HashMap<String, Dipendente> doRetrieveAll();
	public Dipendente doRetrieveByUsername(String username) throws DipendenteNotFoundException;
	public void delete(String username);
	public int updateDipendente(Dipendente dip);
}