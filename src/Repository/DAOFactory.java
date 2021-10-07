package Repository;

import Repository.Utenti.*;
import Repository.Pagamenti.*;
import Repository.StruttureTuristiche.DAOInserzione;
import Repository.StruttureTuristiche.DAOInserzioneImpl;
import Repository.StruttureTuristiche.DAOPrenotazione;
import Repository.StruttureTuristiche.DAOPrenotazioneImpl;
import Repository.StruttureTuristiche.DAOStrutturaTuristica;
import Repository.StruttureTuristiche.DAOStrutturaTuristicaImpl;

public class DAOFactory {

	public DAOFactory() { }

	public static DAODipendente getDAODipendente() {
		return new DAODipendenteImpl();
	}

	public static DAOCliente getDAOCliente() {
		return new DAOClienteImpl();
	}

	public static DAOInserzionista getDAOInserzionista() {
		return new DAOInserzionistaImpl();
	}
	
	public static DAOCanone getDAOCanone() {
		return new DAOCanoneImpl();
	}
	
	public static DAORicevutaPagamentoCanone getDAORicevutaPagamentoCanone() {
		return new DAORicevutaPagamentoCanoneImpl();
	}
	
	public static DAORicevutaPagamentoPrenotazione getDAORicevutaPagamentoPrenotazione() {
		return new DAORicevutaPagamentoPrenotazioneImpl();
	}
	public static DAOStrutturaTuristica getDAOStrutturaTuristica() {
		return new DAOStrutturaTuristicaImpl();
	}
	public static DAOInserzione getDAOInserzione() {
		return new DAOInserzioneImpl();
	}
	public static DAOPrenotazione getDAOPrenotazione() {
		return new DAOPrenotazioneImpl();
	}
	
	
}