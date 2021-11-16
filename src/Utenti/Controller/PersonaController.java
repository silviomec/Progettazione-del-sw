package Utenti.Controller;

import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.Utenti.DAOPersonaImpl;
import Utenti.Model.Persona;

public class PersonaController {
	private DAOPersonaImpl daoPersonaImpl;
	private UtenteFacade utenteFacade;

	public PersonaController(UtenteFacade uf) {
		utenteFacade = uf;
		//DAOFactory df = new DAOFactory();
		daoPersonaImpl = DAOFactory.getDAOPersona();
	}

	public boolean contains(String tabella, String colonna, String target) {
		Persona pers = daoPersonaImpl.doRetrieve(tabella, colonna, target);

		if(pers == null)
			return false;	// La persona NON è presente nel database
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;	// La persona è presente nel database
		}
	}
}
