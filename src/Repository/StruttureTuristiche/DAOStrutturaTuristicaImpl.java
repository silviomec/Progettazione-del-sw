package Repository.StruttureTuristiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import StruttureTuristiche.Model.StrutturaTuristica;
import Utenti.Model.Persona;

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
				String indirizzo = result.getString("indirizzo");
				String tipologia = result.getString("tipologia");
				String stelle = result.getString("stelle");
				String inserzionista = result.getString("inserzionista");
				StrutturaTuristica s = new  StrutturaTuristica(pIva, nome, indirizzo, tipologia, stelle, inserzionista);
				StrutturaTuristicaCollection.put(pIva, s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return StrutturaTuristicaCollection;
	}
	
	public HashMap<String, StrutturaTuristica> doRetrieveAllFiltered(String target) {
		HashMap<String, StrutturaTuristica> struttureTuristiche = new HashMap<String, StrutturaTuristica>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM struttureTuristiche "
					+ "WHERE partitaIva LIKE '%" + target + "%' "
					+ "OR nome LIKE '%" + target + "%' "
					+ "OR indirizzo LIKE '%" + target + "%' "
					+ "OR tipologia LIKE '%" + target + "%' "
					+ "OR stelle LIKE '%" + target + "%' "
					+ "OR INSERZIONISTA LIKE '%" + target + "%'");

			while (result.next()) {
				String pIva = result.getString("partitaIva");
				String nome = result.getString("nome");
				String indirizzo = result.getString("indirizzo");
				String tipologia = result.getString("tipologia");
				String stelle = result.getString("stelle");
				String inserzionista = result.getString("INSERZIONISTA");
				StrutturaTuristica str = new  StrutturaTuristica(pIva, nome, indirizzo, tipologia, stelle, inserzionista);
				struttureTuristiche.put(pIva, str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return struttureTuristiche;
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
				String indirizzo = result.getString("indirizzo");
				String tipologia = result.getString("tipologia");
				String stelle = result.getString("stelle");
				String inserzionista = result.getString("inserzionista");
				s = new  StrutturaTuristica(partitaIva, nome, indirizzo, tipologia, stelle, inserzionista);
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
			
			String query = "INSERT INTO struttureturistiche (PartitaIva, Nome, Indirizzo, Tipologia, Stelle, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setString(1, s.getPIva());
			preparedStmt.setString(2, s.getNome());
			preparedStmt.setString(3, s.getIndirizzo());
			preparedStmt.setString(4, s.getTipologia());
			preparedStmt.setString(5, s.getStelle());
			preparedStmt.setString(6, s.getInserzionista());
			preparedStmt.executeUpdate();
			
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
} 