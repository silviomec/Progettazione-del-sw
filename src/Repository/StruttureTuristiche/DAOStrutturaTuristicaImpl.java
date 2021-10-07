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
				int idStrutturaTuristica = result.getInt("idStruttura");
				String nome = result.getString("nome");
				String stelle = result.getString("stelle");
				String tipologia = result.getString("tipologia");
				String indirizzo = result.getString("indirizzo");
				int inserzionista = result.getInt("inserzionista");
				StrutturaTuristica s = new  StrutturaTuristica(idStrutturaTuristica, nome, stelle, tipologia, indirizzo, inserzionista);
				StrutturaTuristicaCollection.put(Integer.toString(idStrutturaTuristica), s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return StrutturaTuristicaCollection;
	}

	@Override
	public StrutturaTuristica doRetrieveByIdStrutturaTuristica(int idStruttura) {
		StrutturaTuristica s = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM STRUTTURETURISTICHE WHERE idstrutturaTuristica=\"" + idStruttura + "\"");

			while (result.next()) {
				int idStrutturaTuristica = result.getInt("idstruttura");
				String nome = result.getString("nome");
				String stelle = result.getString("stelle");
				String tipologia = result.getString("tipologia");
				String indirizzo = result.getString("indirizzo");
				int inserzionista = result.getInt("inserzionista");
				 s = new  StrutturaTuristica(idStrutturaTuristica, nome, stelle, tipologia, indirizzo, inserzionista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM STRUTTURETURISTICHE WHERE idstrutturaTuristica=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateStrutturaTuristica(StrutturaTuristica s) {
		try {
			delete(s.getIdStruttura());
			
			String query = " insert into struttureturistiche (idstrutturaTuristica, Nome, Stelle, Tipologia, Indirizzo, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, s.getIdStruttura());
			preparedStmt.setString(2, s.getNome());
			preparedStmt.setString(3, s.getStelle());
			preparedStmt.setString(4, s.getTipologia());
			preparedStmt.setString(5, s.getIndirizzo());
			preparedStmt.setInt(6, s.getInserzionista());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
} 