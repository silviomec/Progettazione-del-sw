package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.*;
import Repository.DAOFactory;

public class DAOPrenotazioneTester {
	public static void main(String[] args) {
		DAOFactory df = new DAOFactory();
		HashMap<String, Prenotazione> prenotazioni = df.getDAOPrenotazione().doRetrieveAll();

		if (!prenotazioni.isEmpty())
			for (Prenotazione p : prenotazioni.values())
				System.out.println(p.getIdPrenotazione());
		
	//	Prenotazione p1 = new Prenotazione(2, (new NewDate(2021, 1, 10).getSqlDate()), (new NewDate(2021, 1, 17).getSqlDate()), 600, 1, 1, 6);
		
	//	df.getDAOPrenotazione().updatePrenotazione(p1);
		
		df.getDAOPrenotazione().delete(2);
	}
}



//(new NewDate(2021, 9, 30).getSqlDate())