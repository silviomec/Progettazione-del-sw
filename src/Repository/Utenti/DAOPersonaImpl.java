package Repository.Utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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
	public HashMap<String, Persona> doRetrieveAll() {
		HashMap<String, Persona> persone = new HashMap<String, Persona>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CLIENTI");

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
	public Persona doRetrieve(String target, int tipologia) {
		Persona pers = null;
		Statement statement = null;
		String filtro = "";

		switch(tipologia) {
		case CODICE_FISCALE:
			filtro = "codiceFiscale";
		case TELEFONO:
			filtro = "telefono";
		case EMAIL:
			filtro = "email";
		//default:
		//	return pers;
		}

		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CLIENTI WHERE " + filtro + "=\"" + target + "\"");
			
			while (result.next()) {
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				pers = new Persona(codf, nome, cognome, telefono, email);
				
				System.out.println(codf + nome + cognome + telefono + email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pers;
	}

	@Override
	public void delete(String cf) {
		try {
			System.out.println(cf);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM CLIENTI WHERE codiceFiscale=\"" + cf + "\"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updatePersona(Persona pers) {
		try {
			delete(pers.getCodiceFiscale());

			String query = " insert into clienti (CodiceFiscale, Nome, Cognome, Telefono, Email)"
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
}