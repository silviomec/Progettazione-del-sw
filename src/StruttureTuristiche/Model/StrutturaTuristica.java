package StruttureTuristiche.Model;



public class StrutturaTuristica {
	public StrutturaTuristica(int idStruttura, String nome, String stelle, String tipologia, String indirizzo, int inserzionista) {
		this.idStruttura = idStruttura;
		this.nome = nome;
		this.stelle = stelle;
		this.tipologia = tipologia;
		this.indirizzo = indirizzo;
		this.inserzionista = inserzionista;
	}
	
	public int getIdStruttura() { return idStruttura; }
	public void setIdStruttura(int idStruttura) { this.idStruttura = idStruttura; }
	public int getInserzionista() { return inserzionista; }
	public void setInserzionista(int inserzionista) { this.inserzionista = inserzionista; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getStelle() { return stelle; }
	public void setStelle(String stelle) { this.stelle = stelle; }
	public String getTipologia() { return tipologia; }
	public void setTipologia(String tipologia) { this.tipologia = tipologia; }
	public String getIndirizzo() { return indirizzo; }
	public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
	

	private int idStruttura;
	private int inserzionista;
	private String nome;
	private String stelle;
	private String tipologia;
	private String indirizzo;
	
}