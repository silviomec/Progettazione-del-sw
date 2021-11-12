package Repository.Utenti;

import java.util.HashMap;

import Utenti.Model.Persona;

public interface DAOPersona {
	public HashMap<String, Persona> doRetrieveAll(int tipologiaPersona);
	public HashMap<String, Persona> doRetrieveAllFiltered(int tipologiaPersona, String target);
	public Persona doRetrieve(int tipologiaPersona, int colonna, String filtro);
	public void delete(int tipologiaPersona, String cf);
	public int updatePersona(int tipologiaPersona, Persona pers);
}