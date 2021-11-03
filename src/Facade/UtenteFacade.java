package Facade;

import Utenti.Controller.ClienteController;
import Utenti.Controller.DipendenteController;
import Utenti.Model.Dipendente;
import Utenti.View.*;

public class UtenteFacade {
	private DipendenteController dipendenteController;
	private ClienteController clienteController;
	private static UtenteFacade instance;
	
	public static UtenteFacade getInstance() {
		if (instance == null) {
			instance = new UtenteFacade();
			instance.setDipendenteController(new DipendenteController(instance));
			instance.setClienteController(new ClienteController(instance));
		}
		return instance;
	}
	
	public void showHome(Dipendente dip) {
		Home.display(dip);
	}
	
	public void showGestioneUtenti(Dipendente dip) {
		GestioneUtentiUI.display(dip);
	}
	
	public void showVisualizzaClienti(Dipendente dip) {
		VisualizzaClienti.display(dip);
	}
	
	public void showRegistraCliente(Dipendente dip) {
		RegistraCliente.display(dip);
	}
	
	public void showVisualizzaInserzionisti(Dipendente dip) {
		VisualizzaInserzionisti.display(dip);
	}
	
	public void showRegistraInserzionista(Dipendente dip) {
		RegistraInserzionista.display(dip);
	}

	public DipendenteController getDipendenteController() {
		return dipendenteController;
	}
	
	public void setDipendenteController(DipendenteController dipendenteController) {
		this.dipendenteController = dipendenteController;
	}
	
	public ClienteController getClienteController() {
		return clienteController;
	}
	
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
}
