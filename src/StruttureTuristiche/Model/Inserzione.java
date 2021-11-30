package StruttureTuristiche.Model;

import java.time.LocalDate;
import java.util.Date;

public class Inserzione implements Comparable <Inserzione>{
	public Inserzione(int idInserzione, String descrizione, double prezzoPerNotte, int numeroPersone, LocalDate dataInizio, LocalDate dataFine, String strutturaTuristica, String inserzionista) {
		this.idInserzione = idInserzione;
		this.descrizione = descrizione;
		this.prezzoPerNotte = prezzoPerNotte;
		this.numeroPersone = numeroPersone;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.strutturaTuristica = strutturaTuristica;
		this.inserzionista = inserzionista;
	}
	
	public Inserzione(String descrizione, double prezzoPerNotte, int numeroPersone, LocalDate dataInizio, LocalDate dataFine, String strutturaTuristica, String inserzionista) {
		this.descrizione = descrizione;
		this.prezzoPerNotte = prezzoPerNotte;
		this.numeroPersone = numeroPersone;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.strutturaTuristica = strutturaTuristica;
		this.inserzionista = inserzionista;
	}
	
	public int getIdInserzione() { return idInserzione;	}
	public void setIdInserzione(int idInserzione) { this.idInserzione = idInserzione; }
	public String getStrutturaTuristica() { return strutturaTuristica; }
	public void setStrutturaTuristica(String strutturaTuristica) { this.strutturaTuristica = strutturaTuristica; }
	public String getInserzionista() { return inserzionista; }
	public void setInserzionista(String inserzionista) { this.inserzionista = inserzionista; }
	public String getDescrizione() { return descrizione; }
	public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
	public double getPrezzoPerNotte() { return prezzoPerNotte; }
	public void setPrezzoPerNotte(double prezzoPerNotte) { this.prezzoPerNotte = prezzoPerNotte; }
	public int getNumeroPersone() { return numeroPersone; }
	public void setNumeroPersone(int numeroPersone) { this.numeroPersone = numeroPersone; }
	public LocalDate getDataInizio() { return dataInizio; }
	public void setDataInizio(LocalDate dataInizio) { this.dataInizio = dataInizio; }
	public LocalDate getDataFine() {	return dataFine; }
	public void setDataFine(LocalDate dataFine) { this.dataFine = dataFine; }
	
	public int compareTo(Inserzione ins) {
		return getInserzionista().compareTo(ins.getInserzionista());
	}

	private int idInserzione;
	private String strutturaTuristica;
	private String inserzionista;
	private String descrizione;
	private double prezzoPerNotte;
	private int numeroPersone;
	private LocalDate dataInizio;
	private LocalDate dataFine;
}