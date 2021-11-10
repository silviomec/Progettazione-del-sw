package Facade;

import java.util.Date;

import Repository.DAOFactory;
import StruttureTuristiche.Controller.StrutturaTuristicaController;
import StruttureTuristiche.Model.*;
import StruttureTuristiche.View.*;
import Utenti.Model.Persona;
import Util.NewDate;

public class StrutturaTuristicaFacade {
	private StrutturaTuristicaController strutturaTuristicaController;
	private static StrutturaTuristicaFacade instance;

	public static StrutturaTuristicaFacade getInstance() {
		if (instance == null) {
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

	public Inserzione creaInserzione(String titolo, String descrizione, double prezzoPerNotte, int numeroPersone, Date dataInizio, Date dataFine, String pIva, String cfInserzionista) {
		Inserzione in = new Inserzione(titolo, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, pIva, cfInserzionista);
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

	public Prenotazione creaPrenotazione(NewDate dataArrivo, NewDate dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
		Prenotazione p = new Prenotazione(dataArrivo.getSqlDate(), dataPartenza.getSqlDate(), prezzoTot, cfCliente, idInserzione, pIva);
		return DAOFactory.getDAOPrenotazione().updatePrenotazione(p);
	}

	public void modificaPrenotazione(Prenotazione p) {
		DAOFactory.getDAOPrenotazione().updatePrenotazione(p);
	}

	public void rimuoviPrenotazione(Prenotazione p) {
		DAOFactory.getDAOPrenotazione().delete(p.getIdPrenotazione());
	}

	public boolean controlloDisponibilità(Inserzione in, NewDate dataArrivo, NewDate dataPartenza) {
		return DAOFactory.getDAOPrenotazione().controlloDisponibilità(in, dataArrivo, dataPartenza);
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

	public void showNuovaStruttura() {
		NuovaStruttura.display();
	}

	public void showModificaStruttura() {
		ModificaStruttura.display();
	}
}