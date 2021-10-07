package Repository.Utenti;

import java.util.HashMap;

import Utenti.model.Inserzionista;

public interface DAOInserzionista {
	public HashMap<String, Inserzionista> doRetrieveAll();
	public Inserzionista doRetrieveByIdInserzionista(int id);
	public void delete(int id);
	public int updateInserzionista(Inserzionista i);
}
 