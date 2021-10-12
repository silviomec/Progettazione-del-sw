package Repository.Utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import Utenti.Model.Inserzionista;

public class DAOInserzionistaImpl implements DAOInserzionista {
	private MySQLConnection connection;

	public DAOInserzionistaImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOInserzionistaImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<String, Inserzionista> doRetrieveAll() {
		HashMap<String, Inserzionista> inserzionistiCollection = new HashMap<String, Inserzionista>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM INSERZIONISTI");

			while (result.next()) {
				int idInserzionista = result.getInt("idinserzionista");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				Inserzionista i = new  Inserzionista(codf, nome, cognome, telefono, email, idInserzionista);
				inserzionistiCollection.put(Integer.toString(idInserzionista), i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserzionistiCollection;
	}

	@Override
	public Inserzionista doRetrieveByIdInserzionista(int id) {
		Inserzionista i = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM INSERZIONISTI WHERE idinserzionista=\"" + id + "\"");

			while (result.next()) {
				int idInserzionista = result.getInt("idinserzionista");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				i = new  Inserzionista(codf, nome, cognome, telefono, email, idInserzionista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM INSERZIONISTI WHERE idinserzionista=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateInserzionista(Inserzionista i) {
		try {
			delete(i.getIdInserzionista());
			
			String query = " insert into inserzionisti (idInserzionista, CodiceFiscale, Nome, Cognome, Telefono, Email)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, i.getIdInserzionista());
			preparedStmt.setString(2, i.getCodiceFiscale());
			preparedStmt.setString(3, i.getNome());
			preparedStmt.setString(4, i.getCognome());
			preparedStmt.setString(5, i.getTelefono());
			preparedStmt.setString(6, i.getEmail());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}