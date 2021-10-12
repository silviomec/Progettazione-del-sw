package Repository.Utenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Utenti.Model.Dipendente;

public class DAODipendenteTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String,Dipendente> dipendenti = df.getDAODipendente().doRetrieveAll();

		if (!dipendenti.isEmpty())
			for (Dipendente dip : dipendenti.values())
				System.out.println(dip.getUsername());
		
		//Dipendente d1 = new Dipendente("LMPFR","cacca", "Rituccia", "mimmo", "5824", "777", "rita@hot");
		//df.getDAODipendente().updateDipendente(d1);
		//df.getDAODipendente().delete("777");
	}
}
