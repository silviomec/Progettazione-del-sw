package Repository.Pagamenti;

import java.util.HashMap;

import Pagamenti.Model.RicevutaPagamentoCanone;

public interface DAORicevutaPagamentoCanone {
	public HashMap<String, RicevutaPagamentoCanone> doRetrieveAll();
	public RicevutaPagamentoCanone doRetrieveByIdPagamentoCanone(int id);
	public void delete(int id);
	public int updateRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc);
}