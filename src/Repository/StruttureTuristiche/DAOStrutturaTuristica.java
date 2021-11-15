package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.StrutturaTuristica;

public interface DAOStrutturaTuristica {
	public HashMap<String, StrutturaTuristica> doRetrieveAll();
	public StrutturaTuristica doRetrieveByPartitaIva(String pIva);
	public void delete(String pIva);
	public StrutturaTuristica updateStrutturaTuristica(StrutturaTuristica s);
}