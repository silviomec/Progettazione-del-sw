package StruttureTuristiche.Controller;

import Facade.StrutturaTuristicaFacade;
import Repository.DAOFactory;
import Repository.StruttureTuristiche.DAOStrutturaTuristicaImpl;
import StruttureTuristiche.Model.StrutturaTuristica;

public class StrutturaTuristicaController {
	private DAOStrutturaTuristicaImpl daoStrutturaTuristicaImpl;
	private StrutturaTuristicaFacade strutturaTuristicaFacade;

	public StrutturaTuristicaController(StrutturaTuristicaFacade stf) {
		strutturaTuristicaFacade = stf;
		//DAOFactory df = new DAOFactory();
		daoStrutturaTuristicaImpl = DAOFactory.getDAOStrutturaTuristica();
	}
	
	public boolean contains(String target) {
		StrutturaTuristica stru = daoStrutturaTuristicaImpl.doRetrieveByPartitaIva(target);

		if(stru == null)
			return false;	// La Struttura Turistica NON è presente nel database
		else {
			//new GenericMessageDialog("Titolo", "Messaggio.", null).display();
			return true;	// La Struttura Turistica è presente nel database
		}
	}
}
