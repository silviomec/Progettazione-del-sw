package Pagamenti.Model;

import java.time.LocalDate;

public class RicevutaPagamentoPrenotazione extends RicevutaPagamento implements Comparable<RicevutaPagamentoPrenotazione> {
	public RicevutaPagamentoPrenotazione(int idPagamento, double importo, LocalDate dataPagamento, int idPrenotazione) {
		super(idPagamento, importo, dataPagamento);
		this.idPrenotazione = idPrenotazione;
	}
	
	@Override
	public int compareTo(RicevutaPagamentoPrenotazione rpp) {
		return Integer.toString(getIdPagamento()).compareTo(Integer.toString(rpp.getIdPagamento()));
	}
	
	public int getIdPrenotazione() { return idPrenotazione; }
	public void setPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
	
	private int idPrenotazione;
}