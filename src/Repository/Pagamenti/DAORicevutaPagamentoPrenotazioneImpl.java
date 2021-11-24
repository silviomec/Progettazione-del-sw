package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import Repository.MySQLConnection;
import StruttureTuristiche.Model.StrutturaTuristica;
import Pagamenti.Model.RicevutaPagamentoPrenotazione;

public class DAORicevutaPagamentoPrenotazioneImpl implements DAORicevutaPagamentoPrenotazione {
	private MySQLConnection connection;

	public DAORicevutaPagamentoPrenotazioneImpl() {
		this.connection = new MySQLConnection();
	}
	public DAORicevutaPagamentoPrenotazioneImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<Integer, RicevutaPagamentoPrenotazione> doRetrieveAll() {
		HashMap<Integer, RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazioneCollection = new HashMap<Integer, RicevutaPagamentoPrenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOPRENOTAZIONE");

			while (result.next()) {
				int idPagamentoPrenotazione = result.getInt("idPagamentoPrenotazione");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idPrenotazione = result.getInt("prenotazione");
				RicevutaPagamentoPrenotazione rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione);
				ricevutePagamentoPrenotazioneCollection.put(idPagamentoPrenotazione, rpp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ricevutePagamentoPrenotazioneCollection;
	}
	
	@Override
	public HashMap<Integer, RicevutaPagamentoPrenotazione> doRetrieveAllFiltered(String target) {
		HashMap<Integer, RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazioneCollection = new HashMap<Integer, RicevutaPagamentoPrenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM ricevutePagamentoPrenotazioni "
					+ "WHERE idPagamentoPrenotazione LIKE '%" + target + "%' "
					+ "OR importo LIKE '%" + target + "%' "
					+ "OR dataPagamento LIKE '%" + target + "%' "
					+ "OR PRENOTAZIONE LIKE '%" + target + "%'");

			while (result.next()) {
				int idPagamentoPrenotazione = result.getInt("idPagamentoPrenotazione");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int prenotazione = result.getInt("PRENOTAZIONE");
				RicevutaPagamentoPrenotazione rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, prenotazione);
				ricevutePagamentoPrenotazioneCollection.put(idPagamentoPrenotazione, rpp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ricevutePagamentoPrenotazioneCollection;
	}

	@Override
	public RicevutaPagamentoPrenotazione doRetrieveByIdPagamentoPrenotazione(int id) {
		RicevutaPagamentoPrenotazione rpp = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOPRENOTAZIONE WHERE idpagamentoprenotazione=\"" + id + "\"");

			while (result.next()) {
				int idPagamentoPrenotazione = result.getInt("idPagamentoPrenotazione");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idPrenotazione = result.getInt("prenotazione");
				rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rpp;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM RICEVUTEPAGAMENTOPRENOTAZIONE WHERE idpagamentoprenotazione=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateRicevutaPagamentoPrenotazione(RicevutaPagamentoPrenotazione rpp) {
		try {
			delete(rpp.getIdPagamento());
			
			String query = " insert into ricevutepagamentoprenotazione (idPagamentoPrenotazione, importo, dataPagamento, prenotazione)"
					+ " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, rpp.getIdPagamento());
			preparedStmt.setDouble(2, rpp.getImporto());
			preparedStmt.setDate(3, Date.valueOf(rpp.getDataPagamento()));
			preparedStmt.setInt(4, rpp.getIdPrenotazione());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}