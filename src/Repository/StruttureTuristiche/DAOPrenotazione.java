package Repository.StruttureTuristiche;

import java.time.LocalDate;
import java.util.HashMap;

import StruttureTuristiche.Model.*;

public interface DAOPrenotazione {
	public HashMap<String, Prenotazione> doRetrieveAll();
	public HashMap<String, Prenotazione> doRetrieveAllByIdInserzione(int id);
	public Prenotazione doRetrieveByIdPrenotazione(int idPrenotazione);
	public void delete(int id);
	public Prenotazione insertPrenotazione(Prenotazione p);
	public Prenotazione updatePrenotazione(Prenotazione p);
	public boolean controlloDisponibilità(Inserzione in, LocalDate dataArrivo, LocalDate dataPartenza);
}

