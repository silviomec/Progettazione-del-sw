package Repository.Utenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Utenti.model.Inserzionista;

public class DAOInserzionistaTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String,Inserzionista> inserzionisti = df.getDAOInserzionista().doRetrieveAll();

		if (!inserzionisti.isEmpty())
			for (Inserzionista i : inserzionisti.values())
				System.out.println(i.getCodiceFiscale());
		
	    //	Inserzionista i1 = new Inserzionista("LMPFR", "Rituccia", "mimmo", "5824", "rita@hot", 15);
		// df.getDAOInserzionista().delete(15);
	}
}
