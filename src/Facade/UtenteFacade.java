package Facade;

import StruttureTuristiche.View.*;
import Utenti.Controller.DipendenteController;
import Utenti.Controller.PersonaController;
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
	
	public void showHome() {
		Home.display();
	}
	
	public void showGestioneUtenti() {
		GestioneUtentiUI.display();
	}
	
	public void showVisualizzaPersone(String tabella) {
		VisualizzaPersone.display(tabella);
	}
	
	public void showRegistraPersona(String tabella) {
		RegistraPersona.display(tabella);
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