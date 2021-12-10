package Repository.Pagamenti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import Repository.MySQLConnection;
import Pagamenti.Model.Canone;

public class DAOCanoneImpl implements DAOCanone {
	private MySQLConnection connection;

	public DAOCanoneImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOCanoneImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<String, Canone> doRetrieveAll() {
		HashMap<String, Canone> canoniCollection = new HashMap<String, Canone>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CANONI");

			while (result.next()) {
				int idCanone = result.getInt("idcanone");
				double importoAnnuale = result.getDouble("importoAnnuale");
				LocalDate scadenza = LocalDate.parse(result.getDate("scadenza").toString());
				boolean saldato = result.getBoolean("saldato");
				String cfInserzionista = result.getString("inserzionista");
				String pIva = result.getString("strutturaTuristica");
				Canone c = new Canone(idCanone, cfInserzionista, pIva, importoAnnuale, scadenza, saldato);
				canoniCollection.put(Integer.toString(idCanone), c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return canoniCollection;
	}

	@Override
	public Canone doRetrieve(String colonna, String target) {
		Canone c = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CANONI WHERE " + colonna + "=\"" + target + "\"");

			while (result.next()) {
				int idCanone = result.getInt("idcanone");
				double importoAnnuale = result.getDouble("importoAnnuale");
				LocalDate scadenza = LocalDate.parse(result.getDate("scadenza").toString());
				boolean saldato = result.getBoolean("saldato");
				String cfInserzionista = result.getString("inserzionista");
				String pIva = result.getString("strutturaTuristica");
				c = new Canone(idCanone, cfInserzionista, pIva, importoAnnuale, scadenza, saldato);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM CANONI WHERE idcanone=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insertCanone(Canone c) {
		try {
			String query = "INSERT INTO canoni (idCanone, importoAnnuale, scadenza, saldato, inserzionista, strutturaTuristica)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, c.getIdCanone());
			preparedStmt.setDouble(2, c.getImportoAnnuale());
			preparedStmt.setDate(3, Date.valueOf(c.getScadenza()));
			preparedStmt.setBoolean(4, c.isSaldato());
			preparedStmt.setString(5, c.getCfInserzionista());
			preparedStmt.setString(6, c.getPIva());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateCanone(Canone c) {
		try {
			String query = "UPDATE canoni SET idCanone = ?, importoAnnuale = ?, scadenza = ?, saldato = ?, inserzionista = ?, strutturaTuristica = ? WHERE idCanone = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, c.getIdCanone());
			preparedStmt.setDouble(2, c.getImportoAnnuale());
			preparedStmt.setDate(3, Date.valueOf(c.getScadenza()));
			preparedStmt.setBoolean(4, c.isSaldato());
			preparedStmt.setString(5, c.getCfInserzionista());
			preparedStmt.setString(6, c.getPIva());
			preparedStmt.setInt(7, c.getIdCanone());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int lastInsertId() {
		Statement statement = null;
		int idCanone = 0;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT MAX(idcanone) AS id FROM db_pds.canoni;");
			while (result.next()) {
			idCanone = result.getInt("id");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return idCanone;
	}
	
	public static final String ID_CANONE = "idCanone";
	public static final String STRUTTURA_TURISTICA = "STRUTTURATURISTICA";
}