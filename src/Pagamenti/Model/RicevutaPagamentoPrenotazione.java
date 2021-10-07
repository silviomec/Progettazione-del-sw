package Pagamenti.Model;

import java.sql.Date;

public class RicevutaPagamentoPrenotazione extends RicevutaPagamento {
	public RicevutaPagamentoPrenotazione(int idPagamento, double importo, Date dataPagamento, int idPrenotazione) {
		super(idPagamento, importo, dataPagamento);
		this.idPrenotazione = idPrenotazione;
	}
	
	public int getIdPrenotazione() { return idPrenotazione; }
	public void setPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
	
	private int idPrenotazione;
}