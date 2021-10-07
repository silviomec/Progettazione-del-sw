package Utenti.model;
public class Inserzionista extends Persona {
	public Inserzionista(String codiceFiscale, String nome, String cognome, String telefono, String email, int idInserzionista) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.idInserzionista = idInserzionista;
	}

	public int getIdInserzionista() { return idInserzionista; }
	public void setIdInserzionista(int idInserzionista) { this.idInserzionista = idInserzionista; }

	private int idInserzionista;
}