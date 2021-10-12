package Repository.Pagamenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Util.NewDate;
import pagamenti.model.RicevutaPagamentoCanone;

public class DAORicevutaPagamentoCanoneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String, RicevutaPagamentoCanone> ricevutePagamentoCanone = df.getDAORicevutaPagamentoCanone().doRetrieveAll();

		if (!ricevutePagamentoCanone.isEmpty())
			for (RicevutaPagamentoCanone rpc : ricevutePagamentoCanone.values())
				System.out.println(rpc.getIdCanone());
		
		RicevutaPagamentoCanone rpc1 = new RicevutaPagamentoCanone(1, 257, (new NewDate(2021, 9, 30).getSqlDate()), 2);
		df.getDAORicevutaPagamentoCanone().updateRicevutaPagamentoCanone(rpc1);
	}
}