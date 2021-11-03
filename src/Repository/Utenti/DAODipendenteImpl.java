package Repository.Utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Exception.DipendenteNotFoundException;
import Repository.MySQLConnection;
import Utenti.Model.Dipendente;

public class DAODipendenteImpl implements DAODipendente {
	private MySQLConnection connection;

	public DAODipendenteImpl() {
		this.connection = new MySQLConnection();
	}
	public DAODipendenteImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<String, Dipendente> doRetrieveAll() {
		HashMap<String, Dipendente> dipendentiCollection = new HashMap<String, Dipendente>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM DIPENDENTI");

			while (result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				Dipendente dip = new  Dipendente(codf, nome, cognome, telefono, email, username, password);
				dipendentiCollection.put(username, dip);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dipendentiCollection;
	}

	@Override
	public Dipendente doRetrieveByUsername(String username) throws DipendenteNotFoundException {
		Dipendente dip = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM DIPENDENTI WHERE username=\"" + username + "\"");

			while (result.next()) {
				String nickname = result.getString("username");
				String password = result.getString("password");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				dip = new  Dipendente(codf, nome, cognome, telefono, email, nickname, password);
			}
			
			if(dip == null) throw new DipendenteNotFoundException();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dip;
	}

	@Override
	public void delete(String username) {
		try {
			System.out.println(username);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM DIPENDENTI WHERE username=\"" + username + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateDipendente(Dipendente dip) {
		try {
			delete(dip.getUsername());
			
			String query = " insert into DIPENDENTI (Username, Password, CodiceFiscale, Nome, Cognome, Telefono, Email)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setString(1, dip.getUsername());
			preparedStmt.setString(2, dip.getPassword());
			preparedStmt.setString(3, dip.getCodiceFiscale());
			preparedStmt.setString(4, dip.getNome());
			preparedStmt.setString(5, dip.getCognome());
			preparedStmt.setString(6, dip.getTelefono());
			preparedStmt.setString(7, dip.getEmail());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}