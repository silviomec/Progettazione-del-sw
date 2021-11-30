package Pagamenti.Model;

import java.time.LocalDate;

import Repository.DAOFactory;

public class RicevutaPagamentoCanone extends RicevutaPagamento implements Comparable<RicevutaPagamentoCanone> {
	public RicevutaPagamentoCanone(int idPagamento, double importo, LocalDate dataPagamento, int idCanone, String cfInserzionista, String pIva) {
		super(idPagamento, importo, dataPagamento);
		this.idCanone = idCanone;
		this.cfInserzionista = cfInserzionista;
		this.pIva = pIva;
	}
	public RicevutaPagamentoCanone(double importo, LocalDate dataPagamento, int idCanone, String cfInserzionista, String pIva) {
		super(importo, dataPagamento);
		this.idCanone = idCanone;
		this.cfInserzionista = cfInserzionista;
		this.pIva = pIva;
	}

	@Override
	public int compareTo(RicevutaPagamentoCanone rpc) {
		return getCfInserzionista().compareTo(rpc.getCfInserzionista());
	}

	public int getIdCanone() { return idCanone; }
	public void setIdCanone(int idCanone) { this.idCanone = idCanone; }
	public String getCfInserzionista() { return cfInserzionista; }
	public void setCfInserzionista(String cfInserzionista) { this.cfInserzionista = cfInserzionista; }
	public String getPIva() { return pIva; }
	public void setPIva(String pIva) { this.pIva = pIva; }

	private int idCanone;
	private String cfInserzionista;
	private String pIva;
}