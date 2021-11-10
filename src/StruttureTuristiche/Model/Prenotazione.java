package StruttureTuristiche.Model;

import java.sql.Date;

public class Prenotazione {
	public Prenotazione(Date dataArrivo, Date dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
		this.dataArrivo = dataArrivo;
		this.dataPartenza = dataPartenza;
		this.prezzoTot = prezzoTot;
		this.cfCliente = cfCliente;
		this.idInserzione = idInserzione;
		this.pIva = pIva;
	}
	
	public Prenotazione(int idPrenotazione, Date dataArrivo, Date dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
		this.idPrenotazione = idPrenotazione;
		this.dataArrivo = dataArrivo;
		this.dataPartenza = dataPartenza;
		this.prezzoTot = prezzoTot;
		this.cfCliente = cfCliente;
		this.idInserzione = idInserzione;
		this.pIva = pIva;
	}
	
	public int getIdPrenotazione() { return idPrenotazione; }
	public void setIdPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
	public String getCfCliente() { return cfCliente; }
	public void setCfCliente(String cfCliente) { this.cfCliente = cfCliente; }
	public int getIdInserzione() { return idInserzione; }
	public void setIdInserzione(int idInserzione) { this.idInserzione = idInserzione; }
	public String getPIva() { return pIva; }
	public void setPIva(String pIva) { this.pIva = pIva; }
	public Date getDataArrivo() { return dataArrivo; }
	public void setDataArrivo(Date dataArrivo) { this.dataArrivo = dataArrivo; }
	public Date getDataPartenza() { return dataPartenza; }
	public void setDataPartenza(Date dataPartenza) { this.dataPartenza = dataPartenza; }
	public double getPrezzoTot() { return prezzoTot; }
	public void setPrezzoTot(double prezzoTot) { this.prezzoTot = prezzoTot; }

	private int idPrenotazione;
	private String cfCliente;
	private int idInserzione;
	private String pIva;
	private Date dataArrivo;
	private Date dataPartenza;
	private double prezzoTot;
	
}