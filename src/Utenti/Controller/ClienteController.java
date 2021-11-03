package Utenti.Controller;

import java.sql.SQLException;

import Exception.DipendenteNotFoundException;
import Exception.GenericMessageDialog;
//import Exception.DipendenteNotFoundException;
import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.Utenti.DAOCliente;
import Repository.Utenti.DAOClienteImpl;
import Utenti.Model.Cliente;
import Utenti.Model.Dipendente;

public class ClienteController {
	private DAOClienteImpl daoClienteImpl;
	private UtenteFacade utenteFacade;

	public ClienteController(UtenteFacade uf) {
		utenteFacade = uf;
		//DAOFactory df = new DAOFactory();
		daoClienteImpl = DAOFactory.getDAOCliente();
	}

	public boolean checkCf(String cf) {
		Cliente c = null;

		c = daoClienteImpl.doRetrieveByCf(cf);

		if(c == null)
			return false;
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;
		}
	}
}
