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
	public HashMap<String, Persona> doRetrieveAll(int tipologiaPersona) {
		String tabella = "";

		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "clienti";
			break;
		case INSERZIONISTA:
			tabella = "inserzionisti";
			break;
			//default:
			//	return null;
		}

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

	public HashMap<String, Persona> doRetrieveAllFiltered(int tipologiaPersona, String target) {
		String tabella = "";

		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "clienti";
			break;
		case INSERZIONISTA:
			tabella = "inserzionisti";
			break;
			//default:
			//	return null;
		}

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
	public Persona doRetrieve(int tipologiaPersona, int colonna, String target) {
		Persona pers = null;
		Statement statement = null;
		String filtro = "";
		String tabella = "";

		switch(colonna) {
		case CODICE_FISCALE:
			filtro = "codiceFiscale";
			break;
		case TELEFONO:
			filtro = "telefono";
			break;
		case EMAIL:
			filtro = "email";
			break;
			//default:
			//	return null;
		}

		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "clienti";
			break;
		case INSERZIONISTA:
			tabella = "inserzionisti";
			break;
			//default:
			//	return null;
		}

		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + tabella + " WHERE " + filtro + "=\"" + target + "\"");

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
	public void delete(int tipologiaPersona, String cf) {
		String tabella = "";
		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "clienti";
			break;
		case INSERZIONISTA:
			tabella = "inserzionisti";
			break;
			//default:
			//	return null;
		}

		try {
			System.out.println(cf);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM " + tabella + " WHERE codiceFiscale=\"" + cf + "\"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updatePersona(int tipologiaPersona, Persona pers) {
		String tabella = "";
		switch(tipologiaPersona) {
		case CLIENTE:
			tabella = "clienti";
			break;
		case INSERZIONISTA:
			tabella = "inserzionisti";
			break;
			//default:
			//	return null;
		}

		try {
			delete(tipologiaPersona, pers.getCodiceFiscale());

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

	public static final int CODICE_FISCALE = 0;
	public static final int TELEFONO = 1;
	public static final int EMAIL = 2;

	public static final int CLIENTE = 0;
	public static final int INSERZIONISTA = 1;
}