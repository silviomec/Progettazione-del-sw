package Facade;

import Utenti.Controller.DipendenteController;
import Utenti.Controller.PersonaController;
import Utenti.Model.Dipendente;
import Utenti.View.*;

public class UtenteFacade {
	private DipendenteController dipendenteController;
	private PersonaController personaController;
	private static UtenteFacade instance;
	
	public static UtenteFacade getInstance() {
		if (instance == null) {
			instance = new UtenteFacade();
			instance.setDipendenteController(new DipendenteController(instance));
			instance.setPersonaController(new PersonaController(instance));
		}
		return instance;
	}
	
	public void showHome(Dipendente dip) {
		Home.display(dip);
	}
	
	public void showGestioneUtenti(Dipendente dip) {
		GestioneUtentiUI.display(dip);
	}
	
	public void showVisualizzaPersone(int tipologia, Dipendente dip) {
		VisualizzaPersone.display(tipologia, dip);
	}
	
	public void showRegistraPersona(int tipologia, Dipendente dip) {
		RegistraPersona.display(tipologia, dip);
	}
	
	public DipendenteController getDipendenteController() {
		return dipendenteController;
	}
	
	public void setDipendenteController(DipendenteController dipendenteController) {
		this.dipendenteController = dipendenteController;
	}
	
	public PersonaController getPersonaController() {
		return personaController;
	}
	
	public void setPersonaController(PersonaController personaController) {
		this.personaController = personaController;
	}
}