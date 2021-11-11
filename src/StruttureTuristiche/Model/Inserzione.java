package StruttureTuristiche.Model;

import java.time.LocalDate;
import java.util.Date;

public class Inserzione {
	public Inserzione(int idInserzione, String titolo, String descrizione, double prezzoPerNotte, int numeroPersone, LocalDate dataInizio, LocalDate dataFine, String strutturaTuristica, String inserzionista) {
		this.idInserzione = idInserzione;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.prezzoPerNotte = prezzoPerNotte;
		this.numeroPersone = numeroPersone;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.strutturaTuristica = strutturaTuristica;
		this.inserzionista = inserzionista;
	}
	
	public Inserzione(String titolo, String descrizione, double prezzoPerNotte, int numeroPersone, LocalDate dataInizio, LocalDate dataFine, String strutturaTuristica, String inserzionista) {
		this.titolo = titolo;
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
	public String getTitolo() { return titolo; }
	public void setTitolo(String titolo) { this.titolo = titolo; }
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

	private int idInserzione;
	private String strutturaTuristica;
	private String inserzionista;
	private String titolo;
	private String descrizione;
	private double prezzoPerNotte;
	private int numeroPersone;
	private LocalDate dataInizio;
	private LocalDate dataFine;
}