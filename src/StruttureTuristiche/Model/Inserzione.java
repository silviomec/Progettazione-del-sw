package StruttureTuristiche.Model;


public class Inserzione {
	public Inserzione(int idInserzione, String titolo, String descrizione, double prezzoPerNotte, int numeroPersone, int strutturaTuristica, int inserzionista) {
		this.idInserzione = idInserzione;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.prezzoPerNotte = prezzoPerNotte;
		this.numeroPersone = numeroPersone;
		this.strutturaTuristica = strutturaTuristica;
		this.inserzionista = inserzionista;
	}
	
	public int getIdInserzione() { return idInserzione;	}
	public void setIdInserzione(int idInserzione) { this.idInserzione = idInserzione; }
	public int getStrutturaTuristica() { return strutturaTuristica; }
	public void setStrutturaTuristica(int strutturaTuristica) { this.strutturaTuristica = strutturaTuristica; }
	public int getInserzionista() { return inserzionista; }
	public void setInserzionista(int inserzionista) { this.inserzionista = inserzionista; }
	public String getTitolo() { return titolo; }
	public void setTitolo(String titolo) { this.titolo = titolo; }
	public String getDescrizione() { return descrizione; }
	public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
	public double getPrezzoPerNotte() { return prezzoPerNotte; }
	public void setPrezzoPerNotte(double prezzoPerNotte) { this.prezzoPerNotte = prezzoPerNotte; }
	public int getNumeroPersone() { return numeroPersone; }
	public void setNumeroPersone(int numeroPersone) { this.numeroPersone = numeroPersone; }
	
	private int idInserzione;
	private int strutturaTuristica;
	private int inserzionista;
	private String titolo;
	private String descrizione;
	private double prezzoPerNotte;
	private int numeroPersone;
}