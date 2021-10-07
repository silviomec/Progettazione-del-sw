package StruttureTuristiche.Model;

import java.sql.*;



public class Prenotazione {
	public Prenotazione(int idPrenotazione, Date dataArrivo, Date dataPartenza, double prezzoTot, int idCliente, int idInserzione, int idStrutturaTuristica) {
		this.idPrenotazione = idPrenotazione;
		this.dataArrivo = dataArrivo;
		this.dataPartenza = dataPartenza;
		this.prezzoTot = prezzoTot;
		this.idCliente = idCliente;
		this.idInserzione = idInserzione;
		this.idStrutturaTuristica = idStrutturaTuristica;
	}
	
	public int getIdPrenotazione() { return idPrenotazione; }
	public void setIdPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
	public int getIdInserzione() { return idInserzione; }
	public void setIdInserzione(int idInserzione) { this.idInserzione = idInserzione; }
	public int getIdStrutturaTuristica() { return idStrutturaTuristica; }
	public void setIdStrutturaTuristica(int idStrutturaTuristica) { this.idStrutturaTuristica = idStrutturaTuristica; }
	public Date getDataArrivo() { return dataArrivo; }
	public void setDataArrivo(Date dataArrivo) { this.dataArrivo = dataArrivo; }
	public Date getDataPartenza() { return dataPartenza; }
	public void setDataPartenza(Date dataPartenza) { this.dataPartenza = dataPartenza; }
	public double getPrezzoTot() { return prezzoTot; }
	public void setPrezzoTot(double prezzoTot) { this.prezzoTot = prezzoTot; }

	private int idPrenotazione;
	private int idCliente;
	private int idInserzione;
	private int idStrutturaTuristica;
	private Date dataArrivo;
	private Date dataPartenza;
	private double prezzoTot;
	
}