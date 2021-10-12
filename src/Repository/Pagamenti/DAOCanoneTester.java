package Repository.Pagamenti;

import java.util.HashMap;

import Pagamenti.Model.Canone;
import Repository.DAOFactory;
import Util.NewDate;
<<<<<<< Updated upstream
=======
import Pagamenti.Model.Canone;
>>>>>>> Stashed changes

public class DAOCanoneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String, Canone> canoni = df.getDAOCanone().doRetrieveAll();

		if (!canoni.isEmpty())
			for (Canone c : canoni.values())
				System.out.println(c.getImportoAnnuale());
		
		Canone c1 = new Canone(1, 2, 2, 4.5, (new NewDate(2021, 12, 31).getSqlDate()), false);
		df.getDAOCanone().updateCanone(c1);
	}
}