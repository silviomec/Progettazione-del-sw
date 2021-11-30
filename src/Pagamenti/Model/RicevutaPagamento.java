package Pagamenti.Model;

import java.time.LocalDate;

public class RicevutaPagamento {
	public RicevutaPagamento(int idPagamento, double importo, LocalDate dataPagamento) {
		this.idPagamento = idPagamento;
		this.importo = importo;
		this.dataPagamento = dataPagamento;
	}
	public RicevutaPagamento(double importo, LocalDate dataPagamento) {
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
	public LocalDate getDataPagamento() { return dataPagamento; }
	public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }

	private int idPagamento;
	private double importo;
	private LocalDate dataPagamento;
}