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

	public static DAODipendenteImpl getDAODipendente() {
		return new DAODipendenteImpl();
	}

	public static DAOPersonaImpl getDAOPersona() {
		return new DAOPersonaImpl();
	}
	
	public static DAOCanoneImpl getDAOCanone() {
		return new DAOCanoneImpl();
	}
	
	public static DAORicevutaPagamentoCanoneImpl getDAORicevutaPagamentoCanone() {
		return new DAORicevutaPagamentoCanoneImpl();
	}
	
	public static DAORicevutaPagamentoPrenotazioneImpl getDAORicevutaPagamentoPrenotazione() {
		return new DAORicevutaPagamentoPrenotazioneImpl();
	}
	public static DAOStrutturaTuristicaImpl getDAOStrutturaTuristica() {
		return new DAOStrutturaTuristicaImpl();
	}
	public static DAOInserzioneImpl getDAOInserzione() {
		return new DAOInserzioneImpl();
	}
	public static DAOPrenotazioneImpl getDAOPrenotazione() {
		return new DAOPrenotazioneImpl();
	}
}