package Facade;

import java.time.LocalDate;

import Pagamenti.Model.Canone;
import Repository.DAOFactory;
import StruttureTuristiche.Controller.StrutturaTuristicaController;
import StruttureTuristiche.Model.*;
import StruttureTuristiche.View.*;

public class StrutturaTuristicaFacade {
	private StrutturaTuristicaController strutturaTuristicaController;
	private static StrutturaTuristicaFacade instance;

	public static StrutturaTuristicaFacade getInstance() {
		if(instance == null) {
			instance = new StrutturaTuristicaFacade();
			instance.setStrutturaTuristicaController(new StrutturaTuristicaController(instance));
		}
		return instance;
	}

	public StrutturaTuristica creaStrutturaTuristica(String pIva, String nome, String stelle, String tipologia, String indirizzo, String cfInserzionista) {
		StrutturaTuristica s = new StrutturaTuristica(pIva, nome, stelle, tipologia, indirizzo, cfInserzionista);
		return DAOFactory.getDAOStrutturaTuristica().updateStrutturaTuristica(s);
	}

	public void modificaStrutturaTuristica(StrutturaTuristica s) {
		DAOFactory.getDAOStrutturaTuristica().updateStrutturaTuristica(s);
	}

	public void rimuoviStrutturaTuristica(StrutturaTuristica s) {
		DAOFactory.getDAOStrutturaTuristica().delete(s.getPIva());
	}

	public Inserzione creaInserzione(String descrizione, double prezzoPerNotte, int numeroPersone, LocalDate dataInizio, LocalDate dataFine, String pIva, String cfInserzionista) {
		Inserzione in = new Inserzione(descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, pIva, cfInserzionista);
		return DAOFactory.getDAOInserzione().updateInserzione(in);
	}

	public void modificaInserzione(Inserzione in) {
		DAOFactory.getDAOInserzione().updateInserzione(in);
	}

	public void rimuoviInserzione(Inserzione in) {
		DAOFactory.getDAOInserzione().delete(in.getIdInserzione());
	}

	public void updateInserzione(Inserzione in) {
		// Cosa fa di diverso rispetto a modificaInserzione() ?
	}

	public Prenotazione creaPrenotazione(LocalDate dataArrivo, LocalDate dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
		Prenotazione p = new Prenotazione(dataArrivo, dataPartenza, prezzoTot, cfCliente, idInserzione, pIva);
		return DAOFactory.getDAOPrenotazione().updatePrenotazione(p);
	}

	public void modificaPrenotazione(Prenotazione p) {
		DAOFactory.getDAOPrenotazione().updatePrenotazione(p);
	}

	public void rimuoviPrenotazione(Prenotazione p) {
		DAOFactory.getDAOPrenotazione().delete(p.getIdPrenotazione());
	}

	public boolean controlloDisponibilita(Inserzione in, LocalDate dataArrivo, LocalDate dataPartenza) {
		return DAOFactory.getDAOPrenotazione().controlloDisponibilita(in, dataArrivo, dataPartenza);
	}

	public StrutturaTuristicaController getStrutturaTuristicaController() {
		return strutturaTuristicaController;
	}

	public void setStrutturaTuristicaController(StrutturaTuristicaController strutturaTuristicaController) {
		this.strutturaTuristicaController = strutturaTuristicaController;
	}

	public void showStruttureTuristicheUI() {
		StruttureTuristicheUI.display();
	}

	public void showUpdateStruttura(int operazione, String pIva) {
		UpdateStruttura.display(operazione, pIva);
	}
	
	public void showGestisciCanone(Canone canone) {
		GestisciCanone.display(canone);
	}
	
	public void showPrenotazioneUI() {
		PrenotazioniUI.display();
	}
	
	public void showInserzioniUI() {
		InserzioniUI.display();
	}
	
	public void showNuovaInserzione() {
		NuovaInserzione.display();
	}

	public void showNuovaPrenotazioneUI(Inserzione inserzione) {
		NuovaPrenotazioneUI.display(inserzione);
	}
}