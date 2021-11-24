package Repository.StruttureTuristiche;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import StruttureTuristiche.Model.StrutturaTuristica;

public interface DAOStrutturaTuristica {
	public HashMap<String, StrutturaTuristica> doRetrieveAll();
	public HashMap<String, StrutturaTuristica> doRetrieveAllFiltered(String target);
	public StrutturaTuristica doRetrieveByPartitaIva(String pIva);
	public void delete(String pIva);
	public StrutturaTuristica insertStrutturaTuristica(StrutturaTuristica s);
	public StrutturaTuristica updateStrutturaTuristica(StrutturaTuristica s);
}