package Repository.StruttureTuristiche;

import java.time.LocalDate;
import java.util.HashMap;

import StruttureTuristiche.Model.*;

public interface DAOPrenotazione {
	public HashMap<Integer, Prenotazione> doRetrieveAll();
	public HashMap<Integer, Prenotazione> doRetrieveAllByIdInserzione(int id);
	public HashMap<Integer, Prenotazione> doRetrieveAllFiltered(String target);
	public Prenotazione doRetrieveByIdPrenotazione(int idPrenotazione);
	public void delete(int id);
	public Prenotazione insertPrenotazione(Prenotazione p);
	public Prenotazione updatePrenotazione(Prenotazione p);
	public boolean controlloDisponibilita(Inserzione in, LocalDate dataArrivo, LocalDate dataPartenza);
	public int lastInsertId();
}