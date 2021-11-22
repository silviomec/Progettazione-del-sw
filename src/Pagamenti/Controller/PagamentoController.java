package Pagamenti.Controller;

import Facade.PagamentoFacade;
import Pagamenti.Model.*;
import Repository.DAOFactory;
import Repository.Pagamenti.*;

public class PagamentoController {
	private DAORicevutaPagamentoCanoneImpl daoRicevutaPagamentoCanoneImpl;
	private DAORicevutaPagamentoPrenotazioneImpl daoRicevutaPagamentoPrenotazioneImpl;
	private PagamentoFacade pagamentoFacade;

	public PagamentoController(PagamentoFacade pf) {
		pagamentoFacade = pf;
		daoRicevutaPagamentoCanoneImpl = DAOFactory.getDAORicevutaPagamentoCanone();
		daoRicevutaPagamentoPrenotazioneImpl = DAOFactory.getDAORicevutaPagamentoPrenotazione();
	}

	public boolean containsRicevutaPagamentoCanone(int target) {
		RicevutaPagamentoCanone rpc = daoRicevutaPagamentoCanoneImpl.doRetrieveByIdPagamentoCanone(target);

		if(rpc == null)
			return false;	// La ricevuta pagamento canone NON è presente nel database
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;	// La ricevuta pagamento canone è presente nel database
		}
	}
	
	public boolean containsRicevutaPagamentoPrenotazione(int target) {
		RicevutaPagamentoPrenotazione rpp = daoRicevutaPagamentoPrenotazioneImpl.doRetrieveByIdPagamentoPrenotazione(target);

		if(rpp == null)
			return false;	// La ricevuta pagamento canone NON è presente nel database
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;	// La ricevuta pagamento canone è presente nel database
		}
	}
}