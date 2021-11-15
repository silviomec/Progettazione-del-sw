package Repository.StruttureTuristiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import StruttureTuristiche.Model.StrutturaTuristica;

public class DAOStrutturaTuristicaImpl implements DAOStrutturaTuristica {
	private MySQLConnection connection;

	public DAOStrutturaTuristicaImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOStrutturaTuristicaImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<String, StrutturaTuristica> doRetrieveAll() {
		HashMap<String, StrutturaTuristica> StrutturaTuristicaCollection = new HashMap<String, StrutturaTuristica>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM STRUTTURETURISTICHE");

			while (result.next()) {
				String pIva = result.getString("PartitaIva");
				String nome = result.getString("nome");
				String stelle = result.getString("stelle");
				String tipologia = result.getString("tipologia");
				String indirizzo = result.getString("indirizzo");
				String inserzionista = result.getString("inserzionista");
				StrutturaTuristica s = new  StrutturaTuristica(pIva, nome, stelle, tipologia, indirizzo, inserzionista);
				StrutturaTuristicaCollection.put(pIva, s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return StrutturaTuristicaCollection;
	}

	@Override
	public StrutturaTuristica doRetrieveByPartitaIva(String pIva) {
		StrutturaTuristica s = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM STRUTTURETURISTICHE WHERE PartitaIva=\"" + pIva + "\"");

			while (result.next()) {
				String partitaIva = result.getString("PartitaIva");
				String nome = result.getString("nome");
				String stelle = result.getString("stelle");
				String tipologia = result.getString("tipologia");
				String indirizzo = result.getString("indirizzo");
				String inserzionista = result.getString("inserzionista");
				s = new  StrutturaTuristica(partitaIva, nome, stelle, tipologia, indirizzo, inserzionista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void delete(String string) {
		try {
			System.out.println(string);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM STRUTTURETURISTICHE WHERE partitaIva=\"" + string + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public StrutturaTuristica updateStrutturaTuristica(StrutturaTuristica s) {
		try {
			delete(s.getPIva());
			
			String query = "INSERT INTO struttureturistiche (PartitaIva, Nome, Stelle, Tipologia, Indirizzo, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setString(1, s.getPIva());
			preparedStmt.setString(2, s.getNome());
			preparedStmt.setString(3, s.getStelle());
			preparedStmt.setString(4, s.getTipologia());
			preparedStmt.setString(5, s.getIndirizzo());
			preparedStmt.setString(6, s.getInserzionista());
			preparedStmt.executeUpdate();
			
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
} 