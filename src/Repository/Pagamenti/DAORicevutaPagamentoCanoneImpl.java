package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import pagamenti.model.RicevutaPagamentoCanone;

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
	public HashMap<String, RicevutaPagamentoCanone> doRetrieveAll() {
		HashMap<String, RicevutaPagamentoCanone> ricevutePagamentoCanoneCollection = new HashMap<String, RicevutaPagamentoCanone>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOCANONE");

			while (result.next()) {
				int idPagamentoCanone = result.getInt("idPagamentoCanone");
				double importo = result.getDouble("importo");
				Date dataPagamento = result.getDate("dataPagamento");
				int idCanone = result.getInt("canone");
				RicevutaPagamentoCanone rpc = new RicevutaPagamentoCanone(idPagamentoCanone, importo, dataPagamento, idCanone);
				ricevutePagamentoCanoneCollection.put(Integer.toString(idPagamentoCanone), rpc);
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
			ResultSet result = statement.executeQuery("SELECT * FROM RICEVUTEPAGAMENTOCANONE WHERE idpagamentocanone=\"" + id + "\"");

			while (result.next()) {
				int idPagamentoCanone = result.getInt("idPagamentoCanone");
				double importo = result.getDouble("importo");
				Date dataPagamento = result.getDate("dataPagamento");
				int idCanone = result.getInt("canone");
				rpc = new RicevutaPagamentoCanone(idPagamentoCanone, importo, dataPagamento, idCanone);
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
			int result = statement.executeUpdate("DELETE FROM RICEVUTEPAGAMENTOCANONE WHERE idpagamentocanone=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateRicevutaPagamentoCanone(RicevutaPagamentoCanone rpc) {
		try {
			delete(rpc.getIdPagamento());
			
			String query = " insert into ricevutepagamentocanone (idPagamentoCanone, importo, dataPagamento, canone)"
					+ " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, rpc.getIdPagamento());
			preparedStmt.setDouble(2, rpc.getImporto());
			preparedStmt.setDate(3, rpc.getDataPagamento());
			preparedStmt.setInt(4, rpc.getIdCanone());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}