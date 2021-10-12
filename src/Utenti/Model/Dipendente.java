package Utenti.Model;



public class Dipendente extends Persona {
	public Dipendente(String codiceFiscale, String nome, String cognome, String telefono, String email, String username, String password) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	/*public void aggiungiInserzione(Inserzione i) {
		
	}
	
	public void rimuoviInserzione(Inserzione i) {
		
	}

	public void sospendiInserzione(Inserzione i) {
		
	}*/
	
	public void riattivaInserzione() {
		
	}
	
	public boolean controlloDisponibilita() {
		return true;
		// TODO: da implementare
	}
	
	public void cancellaPrenotazione() {
		
	}
	
	public void effettuaPrenotazione() {
		
	}
	
	private String username;
	private String password;
}