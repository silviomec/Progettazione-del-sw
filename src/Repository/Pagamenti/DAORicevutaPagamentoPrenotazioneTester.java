package Repository.Pagamenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Util.NewDate;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import Pagamenti.Model.RicevutaPagamentoPrenotazione;
>>>>>>> Stashed changes
=======
import pagamenti.model.RicevutaPagamentoPrenotazione;
>>>>>>> main

public class DAORicevutaPagamentoPrenotazioneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String, RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazione = df.getDAORicevutaPagamentoPrenotazione().doRetrieveAll();

		if (!ricevutePagamentoPrenotazione.isEmpty())
			for (RicevutaPagamentoPrenotazione rpp : ricevutePagamentoPrenotazione.values())
				System.out.println(rpp.getIdPrenotazione());
		
		RicevutaPagamentoPrenotazione rpp1 = new RicevutaPagamentoPrenotazione(1, 700, (new NewDate(2020, 1, 1).getSqlDate()), 1);
		df.getDAORicevutaPagamentoPrenotazione().updateRicevutaPagamentoPrenotazione(rpp1);
	}
}