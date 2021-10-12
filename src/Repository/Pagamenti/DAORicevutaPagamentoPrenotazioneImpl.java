package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import Pagamenti.Model.RicevutaPagamentoPrenotazione;
>>>>>>> Stashed changes
=======
import pagamenti.model.RicevutaPagamentoPrenotazione;
>>>>>>> main

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
	public HashMap<String, RicevutaPagamentoPrenotazione> doRetrieveAll() {
		HashMap<String, RicevutaPagamentoPrenotazione> ricevutePagamentoPrenotazioneCollection = new HashMap<String, RicevutaPagamentoPrenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOPRENOTAZIONE");

			while (result.next()) {
				int idPagamentoPrenotazione = result.getInt("idPagamentoPrenotazione");
				double importo = result.getDouble("importo");
				Date dataPagamento = result.getDate("dataPagamento");
				int idPrenotazione = result.getInt("prenotazione");
				RicevutaPagamentoPrenotazione rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione);
				ricevutePagamentoPrenotazioneCollection.put(Integer.toString(idPagamentoPrenotazione), rpp);
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
				Date dataPagamento = result.getDate("dataPagamento");
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
			preparedStmt.setDate(3, rpp.getDataPagamento());
			preparedStmt.setInt(4, rpp.getIdPrenotazione());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}