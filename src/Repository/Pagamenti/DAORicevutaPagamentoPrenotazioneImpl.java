package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import Repository.DAOFactory;
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
				int idPrenotazione = result.getInt("PRENOTAZIONE");
				String cfCliente = result.getString("CLIENTE");
				String pIva = result.getString("STRUTTURATURISTICA");
				RicevutaPagamentoPrenotazione rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione, cfCliente, pIva);
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
			ResultSet result = statement.executeQuery("SELECT * FROM ricevutePagamentoPrenotazioni, struttureTuristiche "
					+ "WHERE idPagamentoPrenotazione LIKE '%" + target + "%' "
					+ "OR importo LIKE '%" + target + "%' "
					+ "OR dataPagamento LIKE '%" + target + "%' "
					+ "OR PRENOTAZIONE LIKE '%" + target + "%'"
					+ "OR CLIENTE LIKE '%" + target + "%') "
					//+ "OR STRUTTURATURISTICA LIKE '%" + target + "%') "
					+ "OR nome LIKE '%" + target + "%')");

			while (result.next()) {
				int idPagamentoPrenotazione = result.getInt("idPagamentoPrenotazione");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idPrenotazione = result.getInt("PRENOTAZIONE");
				String cfCliente = result.getString("CLIENTE");
				String pIva = DAOFactory.getDAOStrutturaTuristica().doRetrieveByPartitaIva(result.getString("PartitaIva"));
				RicevutaPagamentoPrenotazione rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione, cfCliente, pIva);
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
				String cfCliente = result.getString("CLIENTE");
				String pIva = result.getString("STRUTTURATURISTICA");
				rpp = new RicevutaPagamentoPrenotazione(idPagamentoPrenotazione, importo, dataPagamento, idPrenotazione, cfCliente, pIva);
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
	public int insertRicevutaPagamentoPrenotazione(RicevutaPagamentoPrenotazione rpp) {
		try {
			String query = "INSERT INTO ricevutepagamentoprenotazione (idPagamentoPrenotazione, importo, dataPagamento, PRENOTAZIONE, CLIENTE, STRUTTURATURISTICA)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, rpp.getIdPagamento());
			preparedStmt.setDouble(2, rpp.getImporto());
			preparedStmt.setDate(3, Date.valueOf(rpp.getDataPagamento()));
			preparedStmt.setInt(4, rpp.getIdPrenotazione());
			preparedStmt.setString(5, rpp.getCfCliente());
			preparedStmt.setString(6, rpp.getPIva());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateRicevutaPagamentoPrenotazione(RicevutaPagamentoPrenotazione rpp) {
		try {
			String query = "UPDATE ricevutepagamentoprenotazione SET idPagamentoPrenotazione = ?, importo = ?, dataPagamento = ?, PRENOTAZIONE = ?, CLIENTE = ?, STRUTTURATURISTICA = ? WHERE idPagamentoPrenotazione = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, rpp.getIdPagamento());
			preparedStmt.setDouble(2, rpp.getImporto());
			preparedStmt.setDate(3, Date.valueOf(rpp.getDataPagamento()));
			preparedStmt.setInt(4, rpp.getIdPrenotazione());
			preparedStmt.setString(5, rpp.getCfCliente());
			preparedStmt.setString(6, rpp.getPIva());
			preparedStmt.setInt(7, rpp.getIdPagamento());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}