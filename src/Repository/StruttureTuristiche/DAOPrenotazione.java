package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.Prenotazione;

public interface DAOPrenotazione {
	public HashMap<String, Prenotazione> doRetrieveAll();
	public Prenotazione doRetrieveByIdPrenotazione(int idPrenotazione);
	public void delete(int id);
	public int updatePrenotazione(Prenotazione p);
}

