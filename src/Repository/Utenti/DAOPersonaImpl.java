package Repository.Utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import Repository.MySQLConnection;
import Utenti.Model.Persona;

public class DAOPersonaImpl implements DAOPersona {
	private MySQLConnection connection;

	public DAOPersonaImpl() {
		this.connection = new MySQLConnection();
	}
	
	public DAOPersonaImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public HashMap<String, Persona> doRetrieveAll(String tabella) {
		HashMap<String, Persona> persone = new HashMap<String, Persona>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + tabella);

			while (result.next()) {
				String cf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				Persona pers = new  Persona(cf, nome, cognome, telefono, email);
				persone.put(cf, pers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persone;
	}

	public HashMap<String, Persona> doRetrieveAllFiltered(String tabella, String target) {
		HashMap<String, Persona> persone = new HashMap<String, Persona>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + tabella  + " "
					+ "WHERE codiceFiscale LIKE '%" + target + "%' "
					+ "OR nome LIKE '%" + target + "%' "
					+ "OR cognome LIKE '%" + target + "%' "
					+ "OR telefono LIKE '%" + target + "%' "
					+ "OR email LIKE '%" + target + "%'");

			while (result.next()) {
				String cf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				Persona pers = new  Persona(cf, nome, cognome, telefono, email);
				persone.put(cf, pers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persone;
	}

	@Override
	public Persona doRetrieve(String tabella, String colonna, String target) {
		Persona pers = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + tabella + " WHERE " + colonna + "=\"" + target + "\"");

			while (result.next()) {
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				pers = new Persona(codf, nome, cognome, telefono, email);

				System.out.println(codf + ", " + nome + ", " + cognome + ", " + telefono + ", " + email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pers;
	}

	@Override
	public void delete(String tabella, String cf) {
		try {
			System.out.println(cf);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM " + tabella + " WHERE codiceFiscale=\"" + cf + "\"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updatePersona(String tabella, Persona pers) {
		try {
			delete(tabella, pers.getCodiceFiscale());

			String query = " INSERT INTO " + tabella + "(CodiceFiscale, Nome, Cognome, Telefono, Email)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setString(1, pers.getCodiceFiscale());
			preparedStmt.setString(2, pers.getNome());
			preparedStmt.setString(3, pers.getCognome());
			preparedStmt.setString(4, pers.getTelefono());
			preparedStmt.setString(5, pers.getEmail());

			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static final String CODICE_FISCALE = "codiceFiscale";
	public static final String TELEFONO = "telefono";
	public static final String EMAIL = "email";

	public static final String CLIENTE = "clienti";
	public static final String INSERZIONISTA = "inserzionisti";
}