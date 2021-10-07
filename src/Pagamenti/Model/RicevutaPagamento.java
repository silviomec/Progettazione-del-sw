package Pagamenti.Model;

import java.sql.Date;

public class RicevutaPagamento {
	public RicevutaPagamento(int idPagamento, double importo, Date dataPagamento) {
		this.idPagamento = idPagamento;
		this.importo = importo;
		this.dataPagamento = dataPagamento;
	}
	
	public boolean verificaPagamento(RicevutaPagamento p) {
		return true;
		// TODO: da implementare
	}
	
	public int getIdPagamento() { return idPagamento; }
	public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }
	public double getImporto() { return importo; }
	public void setImporto(double importo) { this.importo = importo; }
	public Date getDataPagamento() { return dataPagamento; }
	public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }

	private int idPagamento;
	private double importo;
	private Date dataPagamento;
}