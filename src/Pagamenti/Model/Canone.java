package Pagamenti.Model;

import java.sql.Date;

public class Canone {
	public Canone(int idCanone, int idInserzionista, int idStrutturaTuristica, double importoAnnuale, Date scadenza, boolean saldato) {
		this.idCanone = idCanone;
		this.idInserzionista = idInserzionista;
		this.idStrutturaTuristica = idStrutturaTuristica;
		this.importoAnnuale = importoAnnuale;
		this.scadenza = scadenza;
		this.saldato = saldato;
	}
	
	public int getIdCanone() { return idCanone; }
	public void setIdCanone(int idCanone) { this.idCanone = idCanone; }
	public int getIdInserzionista() { return idInserzionista; }
	public void setIdInserzionista(int idInserzionista) { this.idInserzionista = idInserzionista; }
	public int getIdStrutturaTuristica() { return idStrutturaTuristica; }
	public void setIdStrutturaTuristica(int idStrutturaTuristica) { this.idStrutturaTuristica = idStrutturaTuristica; }
	public double getImportoAnnuale() { return importoAnnuale; }
	public void setImportoAnnuale(double importoAnnuale) { this.importoAnnuale = importoAnnuale; }
	public Date getScadenza() { return scadenza; }
	public void setScadenza(Date scadenza) { this.scadenza = scadenza; }
	public boolean isSaldato() { return saldato; }
	public void setSaldato(boolean saldato) { this.saldato = saldato; }
	
	private int idCanone;
	private int idInserzionista;
	private int idStrutturaTuristica;
	private double importoAnnuale;
	private Date scadenza;
	private boolean saldato;
}