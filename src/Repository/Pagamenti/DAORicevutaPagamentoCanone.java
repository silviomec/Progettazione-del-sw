package Repository.Pagamenti;

import java.util.HashMap;

import pagamenti.model.RicevutaPagamentoCanone;

public interface DAORicevutaPagamentoCanone {
	public HashMap<String, RicevutaPagamentoCanone> doRetrieveAll();
	public RicevutaPagamentoCanone doRetrieveByIdPagamentoCanone(int id);
	public void delete(int id);
	public int updateRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc);
}