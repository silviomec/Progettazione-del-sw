package Repository.Pagamenti;

import java.util.HashMap;

import Pagamenti.Model.RicevutaPagamentoCanone;

public interface DAORicevutaPagamentoCanone {
	public HashMap<Integer, RicevutaPagamentoCanone> doRetrieveAll();
	public HashMap<Integer, RicevutaPagamentoCanone> doRetrieveAllFiltered(String target);
	public RicevutaPagamentoCanone doRetrieveByIdPagamentoCanone(int id);
	public void delete(int id);
	public int insertRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc);
	public int updateRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc);
}