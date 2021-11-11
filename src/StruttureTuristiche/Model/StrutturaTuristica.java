package StruttureTuristiche.Model;

public class StrutturaTuristica {
	public StrutturaTuristica(String pIva, String nome, String stelle, String tipologia, String indirizzo, String inserzionista) {
		this.pIva = pIva;
		this.nome = nome;
		this.stelle = stelle;
		this.tipologia = tipologia;
		this.indirizzo = indirizzo;
		this.inserzionista = inserzionista;
	}
	
	public String getPIva() { return pIva; }
	public void setPIva(String pIva) { this.pIva = pIva; }
	public String getInserzionista() { return inserzionista; }
	public void setInserzionista(String inserzionista) { this.inserzionista = inserzionista; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getStelle() { return stelle; }
	public void setStelle(String stelle) { this.stelle = stelle; }
	public String getTipologia() { return tipologia; }
	public void setTipologia(String tipologia) { this.tipologia = tipologia; }
	public String getIndirizzo() { return indirizzo; }
	public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
	

	private String pIva;
	private String nome;
	private String stelle;
	private String tipologia;
	private String indirizzo;
	private String inserzionista;
	
}