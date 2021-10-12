package Repository.Pagamenti;

import java.util.HashMap;

import pagamenti.model.Canone;

public interface DAOCanone {
	public HashMap<String, Canone> doRetrieveAll();
	public Canone doRetrieveByIdCanone(int id);
	public void delete(int id);
	public int updateCanone(Canone c);
}