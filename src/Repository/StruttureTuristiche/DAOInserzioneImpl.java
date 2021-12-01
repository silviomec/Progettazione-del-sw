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
import StruttureTuristiche.Model.StrutturaTuristica;

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
	public HashMap<Integer , Inserzione> doRetrieveAll() {
		HashMap<Integer, Inserzione> InserzioneCollection = new HashMap<Integer, Inserzione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM INSERZIONI");

			while (result.next()) {
				int idInserzione = result.getInt("idInserzione");
				String descrizione = result.getString("descrizione");
				double prezzoPerNotte = result.getDouble("prezzoPerNotte");
				int numeroPersone = result.getInt("numeroPersone");
				LocalDate dataInizio = LocalDate.parse(result.getDate("dataInizio").toString());
				LocalDate dataFine = LocalDate.parse(result.getDate("dataFine").toString());
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				Inserzione in = new Inserzione(idInserzione, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista);
				InserzioneCollection.put(idInserzione, in);
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
				String descrizione = result.getString("descrizione");
				double prezzoPerNotte = result.getDouble("prezzoPerNotte");
				int numeroPersone = result.getInt("numeroPersone");
				LocalDate dataInizio = LocalDate.parse(result.getDate("dataInizio").toString());
				LocalDate dataFine = LocalDate.parse(result.getDate("dataFine").toString());
				String strutturaTuristica = result.getString("strutturaTuristica");
				String inserzionista = result.getString("inserzionista");
				in = new Inserzione(idInserzione, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}

	@Override
	public HashMap<Integer, Inserzione> doRetrieveAllFiltered(String target) {
		HashMap<Integer, Inserzione> Inserzioni = new HashMap<Integer, Inserzione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM inserzioni "
					+ "WHERE idInserzione LIKE '%" + target + "%' "
					+ "OR descrizione LIKE '%" + target + "%' "
					+ "OR prezzoPerNotte LIKE '%" + target + "%' "
					+ "OR numeroPersone LIKE '%" + target + "%' "
					+ "OR dataInizio LIKE '%" + target + "%'"
					+ "OR dataFine LIKE '%" + target + "%'"
					+ "OR STRUTTURATURISTICA LIKE '%" + target + "%'"
					+ "OR INSERZIONISTA LIKE '%" + target + "%'");

			while (result.next()) {
				int idInserzione = Integer.parseInt(result.getString("idInserzione"));
				String descrizione = result.getString("descrizione");
				Double prezzoPerNotte = Double.parseDouble(result.getString("prezzoPerNotte"));
				int numeroPersone = Integer.parseInt(result.getString("numeroPersone"));
				LocalDate dataInizio = LocalDate.parse(result.getDate("dataInizio").toString());
				LocalDate dataFine = LocalDate.parse(result.getDate("dataFine").toString());
				String strutturaTuristica = result.getString("STRUTTURATURISTICA");
				String inserzionista = result.getString("INSERZIONISTA");

				Inserzione i = new  Inserzione(idInserzione, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista);
				Inserzioni.put(idInserzione, i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Inserzioni;
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
			String query = "INSERT INTO inserzioni (idInserzione, descrizione, prezzoPerNotte, numeroPersone, dataInizio, dataFine, strutturaTuristica, inserzionista)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, in.getIdInserzione());
			preparedStmt.setString(2, in.getDescrizione());
			preparedStmt.setDouble(3, in.getPrezzoPerNotte());
			preparedStmt.setInt(4, in.getNumeroPersone());
			preparedStmt.setDate(5, Date.valueOf(in.getDataInizio()));
			preparedStmt.setDate(6, Date.valueOf(in.getDataFine()));
			preparedStmt.setString(7, in.getStrutturaTuristica());
			preparedStmt.setString(8, in.getInserzionista());

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
			String query = "UPDATE inserzioni SET idInserzione = ?, descrizione = ?, prezzoPerNotte = ?, numeroPersone = ?, dataInizio = ?, dataFine = ?, strutturaTuristica = ?, inserzionista = ? WHERE idInserzione = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, in.getIdInserzione());
			preparedStmt.setString(2, in.getDescrizione());
			preparedStmt.setDouble(3, in.getPrezzoPerNotte());
			preparedStmt.setInt(4, in.getNumeroPersone());
			preparedStmt.setDate(5, Date.valueOf(in.getDataInizio()));
			preparedStmt.setDate(6, Date.valueOf(in.getDataFine()));
			preparedStmt.setString(7, in.getStrutturaTuristica());
			preparedStmt.setString(8, in.getInserzionista());
			preparedStmt.setInt(9, in.getIdInserzione());

			preparedStmt.executeUpdate();

			return in;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
} 