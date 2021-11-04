package Repository.Utenti;

import java.util.ArrayList;
import java.util.HashMap;

import Repository.DAOFactory;
import Utenti.Model.Persona;

public class DAOPersonaTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String, Persona> persone = df.getDAOPersona().doRetrieveAll();

		if (!persone.isEmpty())
			for (Persona pers : persone.values())
				System.out.println(pers.getCodiceFiscale());
		
		//Persona pers1 = new Persona("LMPFR", "Rituccia", "mimmo", "5824", "rita@hot", 15);
		//Persona pers2 = df.getDAOPersona().doRetrieveByIdCliente(1);	// C'è ancora il vecchio metodo
		//df.getDAOPersona().updatePersona(c1);
	}
}