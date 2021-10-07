package Utenti.model;
public class Persona {
	public String getCodiceFiscale() { return codiceFiscale; }
	public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getCognome() { return cognome; }
	public void setCognome(String cognome) { this.cognome = cognome; }
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	protected String codiceFiscale;
	protected String nome;
	protected String cognome;
	protected String telefono;
	protected String email;
}