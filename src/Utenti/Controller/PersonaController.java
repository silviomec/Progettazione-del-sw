package Utenti.Controller;

import java.sql.SQLException;

import Exception.DipendenteNotFoundException;
import Exception.GenericMessageDialog;
//import Exception.DipendenteNotFoundException;
import Facade.UtenteFacade;
import Repository.DAOFactory;
import Repository.Utenti.DAOPersona;
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

	public boolean contains(String target, int tipologia) {
		String filtro = "";
		Persona pers = daoPersonaImpl.doRetrieve(target, tipologia);

		if(pers == null)
			return false;	// La persona NON è presente nel database
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;	// La persona è presente nel database
		}
	}
	
	public static final int CODICE_FISCALE = 0;
	public static final int TELEFONO = 1;
	public static final int EMAIL = 2;
}
