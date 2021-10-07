package Repository.StruttureTuristiche;

import java.util.HashMap;

import StruttureTuristiche.Model.StrutturaTuristica;

public interface DAOStrutturaTuristica {
	public HashMap<String, StrutturaTuristica> doRetrieveAll();
	public StrutturaTuristica doRetrieveByIdStrutturaTuristica(int idStruttura);
	public void delete(int id);
	public int updateStrutturaTuristica(StrutturaTuristica s);
}