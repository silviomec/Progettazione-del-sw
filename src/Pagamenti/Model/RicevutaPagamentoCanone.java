package Pagamenti.Model;

import java.time.LocalDate;

public class RicevutaPagamentoCanone extends RicevutaPagamento implements Comparable<RicevutaPagamentoCanone> {
	public RicevutaPagamentoCanone(int idPagamento, double importo, LocalDate dataPagamento, int idCanone) {
		super(idPagamento, importo, dataPagamento);
		this.idCanone = idCanone;
	}
	
	@Override
	public int compareTo(RicevutaPagamentoCanone rpc) {
		return Integer.toString(getIdPagamento()).compareTo(Integer.toString(rpc.getIdPagamento()));
	}
	
	public int getIdCanone() { return idCanone; }
	public void setIdCanone(int idCanone) { this.idCanone = idCanone; }
	
	private int idCanone;
}