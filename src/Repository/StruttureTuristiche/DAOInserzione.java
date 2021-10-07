package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.Inserzione;


public interface DAOInserzione {
	public HashMap<String, Inserzione> doRetrieveAll();
	public Inserzione doRetrieveByIdInserzione(int idInserzione);
	public void delete(int id);
	public int updateInserzione(Inserzione in);
}

