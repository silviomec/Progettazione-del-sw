package Repository.Utenti;

import java.util.HashMap;

import Utenti.model.Dipendente;

public interface DAODipendente {
	public HashMap<String, Dipendente> doRetrieveAll();
	public Dipendente doRetrieveByUsername(String username);
	public void delete(String username);
	public int updateDipendente(Dipendente dip);
}