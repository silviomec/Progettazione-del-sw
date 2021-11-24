package Repository.StruttureTuristiche;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
				LocalDate dataInizio = LocalDate.parse(result.getDate("dataInizio").toString());
				LocalDate dataFine = LocalDate.parse(result.getDate("dataFine").toString());
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				Inserzione in = new Inserzione(idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista);
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
				String titolo = result.getString("titolo");
				String descrizione = result.getString("descrizione");
				double prezzoPerNotte = result.getDouble("prezzoPerNotte");
				int numeroPersone = result.getInt("numeroPersone");
				LocalDate dataInizio = LocalDate.parse(result.getDate("dataInizio").toString());
				LocalDate dataFine = LocalDate.parse(result.getDate("dataFine").toString());
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				in = new Inserzione(idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista);
			}
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
	public Inserzione insertInserzione(Inserzione in) {
		try {
			String query = "INSERT INTO inserzioni (idInserzione, titolo, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, in.getIdInserzione());
			preparedStmt.setString(2, in.getTitolo());
			preparedStmt.setString(3, in.getDescrizione());
			preparedStmt.setDouble(4, in.getPrezzoPerNotte());
			preparedStmt.setInt(5, in.getNumeroPersone());
			preparedStmt.setDate(6, Date.valueOf(in.getDataInizio()));
			preparedStmt.setDate(7, Date.valueOf(in.getDataFine()));
			preparedStmt.setString(8, in.getStrutturaTuristica());
			preparedStmt.setString(9, in.getInserzionista());
			
			preparedStmt.executeUpdate();

			return in;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Inserzione updateInserzione(Inserzione in) {
		try {
			String query = "UPDATE inserzioni SET idInserzione = ?, titolo = ?, descrizione = ?, prezzoPerNotte = ?, numeroPersone = ?, dataInizio = ?, dataFine = ?, strutturaTuristica = ?, inserzionista = ? WHERE idInserzione = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, in.getIdInserzione());
			preparedStmt.setString(2, in.getTitolo());
			preparedStmt.setString(3, in.getDescrizione());
			preparedStmt.setDouble(4, in.getPrezzoPerNotte());
			preparedStmt.setInt(5, in.getNumeroPersone());
			preparedStmt.setDate(6, Date.valueOf(in.getDataInizio()));
			preparedStmt.setDate(7, Date.valueOf(in.getDataFine()));
			preparedStmt.setString(8, in.getStrutturaTuristica());
			preparedStmt.setString(9, in.getInserzionista());
			preparedStmt.setInt(10, in.getIdInserzione());
			
			preparedStmt.executeUpdate();

			return in;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
} 