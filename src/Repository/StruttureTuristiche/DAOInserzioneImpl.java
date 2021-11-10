package Repository.StruttureTuristiche;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Repository.MySQLConnection;
import StruttureTuristiche.Model.Inserzione;

public class DAOInserzioneImpl implements DAOInserzione {
	private MySQLConnection connection;

	public DAOInserzioneImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOInserzioneImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public HashMap<String, Inserzione> doRetrieveAll() {
		HashMap<String, Inserzione> InserzioneCollection = new HashMap<String, Inserzione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM INSERZIONI");

			while (result.next()) {
				int idInserzione = result.getInt("idInserzione");
				String titolo = result.getString("titolo");
				String descrizione = result.getString("descrizione");
				double prezzoPerNotte = result.getDouble("prezzoPerNotte");
				int numeroPersone = result.getInt("numeroPersone");
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				Inserzione in = new Inserzione(idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, strutturaTuristica, inserzionista);
				InserzioneCollection.put(Integer.toString(idInserzione), in);
			}

		} catch (SQLException e) {  					
			e.printStackTrace();
		}
		return InserzioneCollection;
	}

	@Override
	public Inserzione doRetrieveByIdInserzione(int idInserzione) {
		Inserzione in = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM INSERZIONI WHERE idInserzione=\"" + idInserzione + "\"");

			while (result.next()) {
				idInserzione = result.getInt("idInserzione");
				String titolo = result.getString(" titolo");
				String descrizione = result.getString("descrizione");
				double prezzoPerNotte = result.getDouble("prezzoPerNotte");
				int numeroPersone = result.getInt("numeroPersone");
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				in = new  Inserzione(idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, strutturaTuristica, inserzionista);			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}

	@Override
	public void delete(int idInserzione) {
		try {
			System.out.println(idInserzione);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM INSERZIONI WHERE idInserzione=\"" + idInserzione + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Inserzione updateInserzione(Inserzione in) {
		try {
			delete(in.getIdInserzione());

			String query = " insert into inserzioni (idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, strutturaTuristica, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, in.getIdInserzione());
			preparedStmt.setString(2, in.getTitolo());
			preparedStmt.setString(3, in.getDescrizione());
			preparedStmt.setDouble(4, in.getPrezzoPerNotte());
			preparedStmt.setInt(5, in.getNumeroPersone());
			preparedStmt.setString(6, in.getStrutturaTuristica());
			preparedStmt.setString(7, in.getInserzionista());
			preparedStmt.executeUpdate();
			
			return in;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
} 