package Pagamenti.Model;

import java.time.LocalDate;

public class Canone {
	public Canone(int idCanone, String cfInserzionista, String pIva, double importoAnnuale, LocalDate scadenza, boolean saldato) {
		this.idCanone = idCanone;
		this.cfInserzionista = cfInserzionista;
		this.pIva = pIva;
		this.importoAnnuale = importoAnnuale;
		this.scadenza = scadenza;
		this.saldato = saldato;
	}
	
	public Canone(String cfInserzionista, String pIva, double importoAnnuale, LocalDate scadenza, boolean saldato) {
		this.cfInserzionista = cfInserzionista;
		this.pIva = pIva;
		this.importoAnnuale = importoAnnuale;
		this.scadenza = scadenza;
		this.saldato = saldato;
	}

	public int getIdCanone() { return idCanone; }
	public void setIdCanone(int idCanone) { this.idCanone = idCanone; }
	public String getCfInserzionista() { return cfInserzionista; }
	public void setCfInserzionista(String cfInserzionista) { this.cfInserzionista = cfInserzionista; }
	public String getPIva() { return pIva; }
	public void setPIva(String pIva) { this.pIva = pIva; }
	public double getImportoAnnuale() { return importoAnnuale; }
	public void setImportoAnnuale(double importoAnnuale) { this.importoAnnuale = importoAnnuale; }
	public LocalDate getScadenza() { return scadenza; }
	public void setScadenza(LocalDate scadenza) { this.scadenza = scadenza; }
	public boolean isSaldato() { return saldato; }
	public void setSaldato(boolean saldato) { this.saldato = saldato; }

	private int idCanone;
	private String cfInserzionista;
	private String pIva;
	private double importoAnnuale;
	private LocalDate scadenza;
	private boolean saldato;
}