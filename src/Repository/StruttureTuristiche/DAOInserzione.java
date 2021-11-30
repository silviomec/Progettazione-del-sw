package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.Inserzione;


public interface DAOInserzione {
	public HashMap<Integer, Inserzione> doRetrieveAll();
	public HashMap<Integer, Inserzione> doRetrieveAllFiltered(String target);
	public Inserzione doRetrieveByIdInserzione(int idInserzione);
	public void delete(int idInserzione);
	public Inserzione insertInserzione(Inserzione in);
	public Inserzione updateInserzione(Inserzione in);
}

