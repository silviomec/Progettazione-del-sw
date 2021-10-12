package Repository.Pagamenti;

import java.util.HashMap;

import pagamenti.model.RicevutaPagamentoPrenotazione;

public interface DAORicevutaPagamentoPrenotazione {
	public HashMap<String, RicevutaPagamentoPrenotazione> doRetrieveAll();
	public RicevutaPagamentoPrenotazione doRetrieveByIdPagamentoPrenotazione(int id);
	public void delete(int id);
	public int updateRicevutaPagamentoPrenotazione(RicevutaPagamentoPrenotazione rpp);
}