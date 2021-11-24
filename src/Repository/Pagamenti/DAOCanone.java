package Repository.Pagamenti;

import java.util.HashMap;

import Pagamenti.Model.Canone;

public interface DAOCanone {
	public HashMap<String, Canone> doRetrieveAll();
	public Canone doRetrieve(String colonna, String target);
	public void delete(int id);
	public int insertCanone(Canone c);
	public int updateCanone(Canone c);
}