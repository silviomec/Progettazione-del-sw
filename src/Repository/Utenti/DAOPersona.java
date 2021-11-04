package Repository.Utenti;

import java.util.HashMap;

import Utenti.Model.Persona;

public interface DAOPersona {
	public HashMap<String, Persona> doRetrieveAll();
	public Persona doRetrieve(String filtro, int tipologia);
	public void delete(String cf);
	public int updatePersona(Persona pers);
}