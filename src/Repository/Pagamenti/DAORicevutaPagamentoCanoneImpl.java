package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import Repository.MySQLConnection;
import Pagamenti.Model.RicevutaPagamentoCanone;
import Pagamenti.Model.RicevutaPagamentoPrenotazione;

public class DAORicevutaPagamentoCanoneImpl implements DAORicevutaPagamentoCanone {
	private MySQLConnection connection;

	public DAORicevutaPagamentoCanoneImpl() {
		this.connection = new MySQLConnection();
	}
	public DAORicevutaPagamentoCanoneImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<Integer, RicevutaPagamentoCanone> doRetrieveAll() {
		HashMap<Integer, RicevutaPagamentoCanone> ricevutePagamentoCanoneCollection = new HashMap<Integer, RicevutaPagamentoCanone>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOCANONI");

			while (result.next()) {
				int idPagamentoCanone = result.getInt("idPagamentoCanone");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idCanone = result.getInt("CANONE");
				String cfInserzionista = result.getString("INSERZIONISTA");
				String pIva = result.getString("STRUTTURATURISTICA");
				RicevutaPagamentoCanone rpc = new RicevutaPagamentoCanone(idPagamentoCanone, importo, dataPagamento, idCanone, cfInserzionista, pIva);
				ricevutePagamentoCanoneCollection.put(idPagamentoCanone, rpc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ricevutePagamentoCanoneCollection;
	}
	
	@Override
	public HashMap<Integer, RicevutaPagamentoCanone> doRetrieveAllFiltered(String target) {
		HashMap<Integer, RicevutaPagamentoCanone> ricevutePagamentoCanoneCollection = new HashMap<Integer, RicevutaPagamentoCanone>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM ricevutePagamentoCanoni, struttureTuristiche "
					+ "WHERE idPagamentoCanone LIKE '%" + target + "%' "
					+ "OR importo LIKE '%" + target + "%' "
					+ "OR dataPagamento LIKE '%" + target + "%' "
					+ "OR CANONE LIKE '%" + target + "%' "
					+ "OR ricevutePagamentoCanoni.INSERZIONISTA LIKE '%" + target + "%' "
					+ "OR STRUTTURATURISTICA LIKE '%" + target + "%' "
					+ "OR struttureTuristiche.nome LIKE '%" + target + "%' "
					+ "AND STRUTTURATURISTICA = struttureTuristiche.PartitaIva");

			while (result.next()) {
				int idPagamentoCanone = result.getInt("idPagamentoCanone");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idCanone = result.getInt("CANONE");
				String cfInserzionista = result.getString("INSERZIONISTA");
				String pIva = result.getString("STRUTTURATURISTICA");
				RicevutaPagamentoCanone rpc = new RicevutaPagamentoCanone(idPagamentoCanone, importo, dataPagamento, idCanone, cfInserzionista, pIva);
				ricevutePagamentoCanoneCollection.put(idPagamentoCanone, rpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ricevutePagamentoCanoneCollection;
	}

	@Override
	public RicevutaPagamentoCanone doRetrieveByIdPagamentoCanone(int id) {
		RicevutaPagamentoCanone rpc = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOCANONI WHERE idpagamentocanone=\"" + id + "\"");

			while (result.next()) {
				int idPagamentoCanone = result.getInt("idPagamentoCanone");
				double importo = result.getDouble("importo");
				LocalDate dataPagamento = LocalDate.parse(result.getDate("dataPagamento").toString());
				int idCanone = result.getInt("canone");
				String cfInserzionista = result.getString("INSERZIONISTA");
				String pIva = result.getString("STRUTTURATURISTICA");
				rpc = new RicevutaPagamentoCanone(idPagamentoCanone, importo, dataPagamento, idCanone, cfInserzionista, pIva);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rpc;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM RICEVUTEPAGAMENTOCANONI WHERE idpagamentocanone=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insertRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc) {
		try {
			String query = "INSERT INTO ricevutepagamentocanoni (importo, dataPagamento, CANONE, INSERZIONISTA, STRUTTURATURISTICA)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setDouble(1, rpc.getImporto());
			preparedStmt.setDate(2, Date.valueOf(rpc.getDataPagamento()));
			preparedStmt.setInt(3, rpc.getIdCanone());
			preparedStmt.setString(4, rpc.getCfInserzionista());
			preparedStmt.setString(5, rpc.getPIva());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc) {
		try {
			String query = "UPDATE ricevutepagamentocanoni SET idPagamentoCanone = ?, importo = ?, dataPagamento = ?, CANONE = ?, INSERZIONISTA = ?, STUTTURATURISTICA = ? WHERE idPagamentoCanone = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, rpc.getIdPagamento());
			preparedStmt.setDouble(2, rpc.getImporto());
			preparedStmt.setDate(3, Date.valueOf(rpc.getDataPagamento()));
			preparedStmt.setInt(4, rpc.getIdCanone());
			preparedStmt.setString(5, rpc.getCfInserzionista());
			preparedStmt.setString(6, rpc.getPIva());
			preparedStmt.setInt(7, rpc.getIdPagamento());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}