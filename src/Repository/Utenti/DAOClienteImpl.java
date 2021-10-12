package Repository.Utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import Utenti.Model.Cliente;

public class DAOClienteImpl implements DAOCliente {
	private MySQLConnection connection;

	public DAOClienteImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOClienteImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public HashMap<String, Cliente> doRetrieveAll() {
		HashMap<String, Cliente> clientiCollection = new HashMap<String, Cliente>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CLIENTI");

			while (result.next()) {
				int idCliente = result.getInt("idcliente");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				Cliente c = new  Cliente(codf, nome, cognome, telefono, email, idCliente);
				clientiCollection.put(Integer.toString(idCliente), c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientiCollection;
	}

	@Override
	public Cliente doRetrieveByIdCliente(int id) {
		Cliente c = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CLIENTI WHERE idcliente=\"" + id + "\"");

			while (result.next()) {
				int idCliente = result.getInt("idcliente");
				String codf = result.getString("codiceFiscale");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String telefono = result.getString("telefono");
				String email = result.getString("email");
				c = new  Cliente(codf, nome, cognome, telefono, email, idCliente);
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
			int result = statement.executeUpdate("DELETE FROM CLIENTI WHERE idcliente=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateCliente(Cliente c) {
		try {
			delete(c.getIdCliente());
			
			String query = " insert into clienti (idCliente, CodiceFiscale, Nome, Cognome, Telefono, Email)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, c.getIdCliente());
			preparedStmt.setString(2, c.getCodiceFiscale());
			preparedStmt.setString(3, c.getNome());
			preparedStmt.setString(4, c.getCognome());
			preparedStmt.setString(5, c.getTelefono());
			preparedStmt.setString(6, c.getEmail());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}