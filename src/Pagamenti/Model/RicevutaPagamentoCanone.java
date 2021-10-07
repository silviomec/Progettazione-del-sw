package Pagamenti.Model;

import java.sql.Date;

public class RicevutaPagamentoCanone extends RicevutaPagamento {
	public RicevutaPagamentoCanone(int idPagamento, double importo, Date dataPagamento, int idCanone) {
		super(idPagamento, importo, dataPagamento);
		this.idCanone = idCanone;
	}
	
	public int getIdCanone() { return idCanone; }
	public void setIdCanone(int idCanone) { this.idCanone = idCanone; }
	
	private int idCanone;
}