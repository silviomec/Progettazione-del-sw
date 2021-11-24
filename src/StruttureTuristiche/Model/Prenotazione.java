package StruttureTuristiche.Model;

import java.sql.Date;
import java.time.LocalDate;

public class Prenotazione implements Comparable<Prenotazione> {
	public Prenotazione(LocalDate dataArrivo, LocalDate dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
		this.dataArrivo = dataArrivo;
		this.dataPartenza = dataPartenza;
		this.prezzoTot = prezzoTot;
		this.cfCliente = cfCliente;
		this.idInserzione = idInserzione;
		this.pIva = pIva;
	}
	
	public Prenotazione(int idPrenotazione, LocalDate dataArrivo, LocalDate dataPartenza, double prezzoTot, String cfCliente, int idInserzione, String pIva) {
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
	public LocalDate getDataArrivo() { return dataArrivo; }
	public void setDataArrivo(LocalDate dataArrivo) { this.dataArrivo = dataArrivo; }
	public LocalDate getDataPartenza() { return dataPartenza; }
	public void setDataPartenza(LocalDate dataPartenza) { this.dataPartenza = dataPartenza; }
	public double getPrezzoTot() { return prezzoTot; }
	public void setPrezzoTot(double prezzoTot) { this.prezzoTot = prezzoTot; }

	@Override
	public int compareTo(Prenotazione p) {
		return Integer.toString(getIdPrenotazione()).compareTo(Integer.toString(p.getIdPrenotazione()));
	}
	
	private int idPrenotazione;
	private String cfCliente;
	private int idInserzione;
	private String pIva;
	private LocalDate dataArrivo;
	private LocalDate dataPartenza;
	private double prezzoTot;
}