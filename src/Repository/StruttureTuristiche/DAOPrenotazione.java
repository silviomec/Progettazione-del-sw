package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.*;
import Util.NewDate;

public interface DAOPrenotazione {
	public HashMap<String, Prenotazione> doRetrieveAll();
	public Prenotazione doRetrieveByIdPrenotazione(int idPrenotazione);
	public void delete(int id);
	public Prenotazione updatePrenotazione(Prenotazione p);
	public boolean controllaDisponibilità(Inserzione in, NewDate dataArrivo, NewDate dataPartenza);
}

