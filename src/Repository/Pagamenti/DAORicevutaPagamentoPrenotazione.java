package Repository.Pagamenti;

import java.util.HashMap;

import Pagamenti.Model.RicevutaPagamentoPrenotazione;

public interface DAORicevutaPagamentoPrenotazione {
	public HashMap<Integer, RicevutaPagamentoPrenotazione> doRetrieveAll();
	public HashMap<Integer, RicevutaPagamentoPrenotazione> doRetrieveAllFiltered(String target);
	public RicevutaPagamentoPrenotazione doRetrieveByIdPagamentoPrenotazione(int id);
	public void delete(int id);
	public int updateRicevutaPagamentoPrenotazione(RicevutaPagamentoPrenotazione rpp);
}