package Facade;


import Utenti.Controller.DipendenteController;
import Utenti.Model.Dipendente;
import Utenti.View.Home;

public class UtenteFacade {
	private DipendenteController dipendenteController;
	private static UtenteFacade instance;
	
	public static UtenteFacade getInstance() {
		if (instance == null) {
			instance = new UtenteFacade();
			instance.setDipendenteController(new DipendenteController(instance));
		}
		return instance;
	}
	
	public void showHome(Dipendente dip) {
		Home.display(dip);
	}

	public DipendenteController getDipendenteController() {
		return dipendenteController;
	}
	
	public void setDipendenteController(DipendenteController dipendenteController) {
		this.dipendenteController = dipendenteController;
	}
}
