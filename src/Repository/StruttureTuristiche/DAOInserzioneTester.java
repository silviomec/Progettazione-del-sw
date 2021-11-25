package Repository.StruttureTuristiche;

import java.util.HashMap;

import Repository.DAOFactory;
import StruttureTuristiche.Model.Inserzione;

public class DAOInserzioneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<Integer,Inserzione> inserzione = df.getDAOInserzione().doRetrieveAll();

		if (!inserzione.isEmpty())
			for (Inserzione in : inserzione.values())
				System.out.println(in.getIdInserzione());
		
		//Inserzione in1 = new Inserzione (15, "marta", "ampia camera",60, 3, 5, 15);
		//Cliente c2 = df.getDAOCliente().doRetrieveByIdCliente(1);
		//df.getDAOInserzione().updateInserzione(in1);
	}
}