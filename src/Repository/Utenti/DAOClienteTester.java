package Repository.Utenti;

import java.util.HashMap;

import Repository.DAOFactory;
import Utenti.model.Cliente;

public class DAOClienteTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String,Cliente> clienti = df.getDAOCliente().doRetrieveAll();

		if (!clienti.isEmpty())
			for (Cliente c : clienti.values())
				System.out.println(c.getCodiceFiscale());
		
		//Cliente c1 = new Cliente("LMPFR", "Rituccia", "mimmo", "5824", "rita@hot", 15);
		//Cliente c2 = df.getDAOCliente().doRetrieveByIdCliente(1);
		//df.getDAOCliente().updateCliente(c1);
	}
}