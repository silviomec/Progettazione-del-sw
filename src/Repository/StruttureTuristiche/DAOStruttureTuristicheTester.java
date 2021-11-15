package Repository.StruttureTuristiche;

import java.util.HashMap;

import Repository.DAOFactory;
import StruttureTuristiche.Model.StrutturaTuristica;

public class DAOStruttureTuristicheTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String,StrutturaTuristica> struttureTuristiche = df.getDAOStrutturaTuristica().doRetrieveAll();

		if (!struttureTuristiche.isEmpty())
			for (StrutturaTuristica s : struttureTuristiche.values())
				System.out.println(s.getPIva());
		
		//StrutturaTuristica s1 = new StrutturaTuristica(5, "Rituccia", "5", "B&B", "Benevento", 15);
		//Cliente c2 = df.getDAOCliente().doRetrieveByIdCliente(1);
		//df.getDAOStrutturaTuristica().updateStrutturaTuristica(s1);
	}
}