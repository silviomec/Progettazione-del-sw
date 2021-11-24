package Repository.Pagamenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Pagamenti.Model.RicevutaPagamentoCanone;

public class DAORicevutaPagamentoCanoneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<Integer, RicevutaPagamentoCanone> ricevutePagamentoCanone = df.getDAORicevutaPagamentoCanone().doRetrieveAll();

		if (!ricevutePagamentoCanone.isEmpty())
			for (RicevutaPagamentoCanone rpc : ricevutePagamentoCanone.values())
				System.out.println(rpc.getIdCanone());
		
		//RicevutaPagamentoCanone rpc1 = new RicevutaPagamentoCanone(1, 257, (new Data(2021, 9, 30).getSqlDate()), 2);
		//df.getDAORicevutaPagamentoCanone().updateRicevutaPagamentoCanone(rpc1);
	}
}