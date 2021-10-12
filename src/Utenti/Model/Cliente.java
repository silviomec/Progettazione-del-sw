package Utenti.Model;
public class Cliente extends Persona {
	public Cliente(String codiceFiscale, String nome, String cognome, String telefono, String email, int idCliente) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

	private int idCliente;
}