package Pagamenti.Model;

import java.time.LocalDate;

import Repository.DAOFactory;

public class RicevutaPagamentoPrenotazione extends RicevutaPagamento implements Comparable<RicevutaPagamentoPrenotazione> {
	public RicevutaPagamentoPrenotazione(int idPagamento, double importo, LocalDate dataPagamento, int idPrenotazione, String cfCliente, String pIva) {
		super(idPagamento, importo, dataPagamento);
		this.idPrenotazione = idPrenotazione;
		this.cfCliente = cfCliente;
		this.pIva = pIva;
	}
	
	public RicevutaPagamentoPrenotazione(double importo, LocalDate dataPagamento, int idPrenotazione, String cfCliente, String pIva) {
		super(importo, dataPagamento);
		this.idPrenotazione = idPrenotazione;
		this.cfCliente = cfCliente;
		this.pIva = pIva;
	}
	
	@Override
	public int compareTo(RicevutaPagamentoPrenotazione rpp) {
		return getCfCliente().compareTo(rpp.getCfCliente());
	}
	
	public int getIdPrenotazione() { return idPrenotazione; }
	public void setIdPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
	public String getCfCliente() { return cfCliente; }
	public void setCfCliente(String cfCliente) { this.cfCliente = cfCliente; }
	public String getPIva() { return pIva; }
	public void setPIva(String pIva) { this.pIva = pIva; }

	private int idPrenotazione;
	private String cfCliente;
	private String pIva;
}