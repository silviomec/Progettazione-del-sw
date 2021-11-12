package Utenti.Model;
public class Persona {
	public Persona(String codiceFiscale, String nome, String cognome, String telefono, String email) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Persona() {}
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