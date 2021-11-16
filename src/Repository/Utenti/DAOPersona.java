package Repository.Utenti;

import java.util.HashMap;

import Utenti.Model.Persona;

public interface DAOPersona {
	public HashMap<String, Persona> doRetrieveAll(String tabella);
	public HashMap<String, Persona> doRetrieveAllFiltered(String tabella, String target);
	public Persona doRetrieve(String tabella, String colonna, String target);
	public void delete(String tabella, String cf);
	public int updatePersona(String tabella, Persona pers);
}