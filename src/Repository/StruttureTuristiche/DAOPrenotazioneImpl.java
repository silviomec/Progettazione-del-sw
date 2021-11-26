package Repository.StruttureTuristiche;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import StruttureTuristiche.Model.*;
import Repository.DAOFactory;
import Repository.MySQLConnection;

public class DAOPrenotazioneImpl implements DAOPrenotazione {
	private MySQLConnection connection;

	public DAOPrenotazioneImpl() {
		this.connection = new MySQLConnection();
	}
	public DAOPrenotazioneImpl(MySQLConnection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public HashMap<Integer, Prenotazione> doRetrieveAll() {
		HashMap<Integer, Prenotazione> prenotazioni = new HashMap<Integer, Prenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM PRENOTAZIONI");

			while (result.next()) {
				int idPrenotazione = result.getInt("idprenotazione");
				LocalDate dataArrivo = LocalDate.parse(result.getDate("dataArrivo").toString());
				LocalDate dataPartenza = LocalDate.parse(result.getDate("dataPartenza").toString());
				double prezzoTot = result.getDouble("prezzoTotale");
				String cfCliente = result.getString("cliente");
				int idInserzione = result.getInt("inserzione");
				String pIva = result.getString("strutturaTuristica");
				Prenotazione p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, cfCliente, idInserzione, pIva);
				prenotazioni.put(idPrenotazione, p);
			}     

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenotazioni;
	}

	@Override
	public HashMap<Integer, Prenotazione> doRetrieveAllByIdInserzione(int id) {
		HashMap<Integer, Prenotazione> prenotazioni = new HashMap<Integer, Prenotazione>();
		Prenotazione p = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM PRENOTAZIONI WHERE INSERZIONE=\"" + id + "\"");

			while (result.next()) {
				int idPrenotazione = result.getInt("idprenotazione");
				LocalDate dataArrivo = LocalDate.parse(result.getDate("dataArrivo").toString());
				LocalDate dataPartenza = LocalDate.parse(result.getDate("dataPartenza").toString());
				double prezzoTot = result.getDouble("prezzoTotale");
				String cfCliente = result.getString("cliente");
				int idInserzione = result.getInt("inserzione");
				String pIva = result.getString("strutturaTuristica");
				p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, cfCliente, idInserzione, pIva);
				prenotazioni.put(idPrenotazione, p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenotazioni;
	}

	@Override
	public HashMap<Integer, Prenotazione> doRetrieveAllFiltered(String target) {
		HashMap<Integer, Prenotazione> prenotazioni = new HashMap<Integer, Prenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM prenotazioni, struttureTuristiche "
					+ "WHERE idPrenotazione LIKE '%" + target + "%' "
					+ "OR dataArrivo LIKE '%" + target + "%' "
					+ "OR dataPartenza LIKE '%" + target + "%' "
					+ "OR prezzoTotale LIKE '%" + target + "%' "
					+ "OR CLIENTE LIKE '%" + target + "%' "
					+ "OR INSERZIONE LIKE '%" + target + "%'"
					+ "OR STRUTTURATURISTICA LIKE '%" + target + "%'"
					+ "OR struttureTuristiche.nome LIKE '%" + target + "%' "
					+ "AND STRUTTURATURISTICA = struttureTuristiche.PartitaIva");

			while (result.next()) {
				int idPrenotazione = result.getInt("idprenotazione");
				LocalDate dataArrivo = LocalDate.parse(result.getDate("dataArrivo").toString());
				LocalDate dataPartenza = LocalDate.parse(result.getDate("dataPartenza").toString());
				double prezzoTot = result.getDouble("prezzoTotale");
				String cfCliente = result.getString("CLIENTE");
				int idInserzione = result.getInt("INSERZIONE");
				String pIva = result.getString("STRUTTURATURISTICA");
				Prenotazione p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, cfCliente, idInserzione, pIva);
				prenotazioni.put(idPrenotazione, p);
			}     

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenotazioni;
	}

	@Override
	public Prenotazione doRetrieveByIdPrenotazione(int id) {
		Prenotazione p = null;
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM PRENOTAZIONI WHERE idprenotazione=\"" + id + "\"");

			while (result.next()) {
				int idPrenotazione = result.getInt("idprenotazione");
				LocalDate dataArrivo = LocalDate.parse(result.getDate("dataArrivo").toString());
				LocalDate dataPartenza = LocalDate.parse(result.getDate("dataPartenza").toString());
				double prezzoTot = result.getDouble("prezzoTotale");
				String cfCliente = result.getString("cliente");
				int idInserzione = result.getInt("inserzione");
				String pIva = result.getString("strutturaTuristica");
				p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, cfCliente, idInserzione, pIva);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void delete(int id) {
		try {
			System.out.println(id);
			Statement statement = connection.getConnection().createStatement();
			int result = statement.executeUpdate("DELETE FROM PRENOTAZIONI WHERE idprenotazione=\"" + id + "\"");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Prenotazione insertPrenotazione(Prenotazione p) {
		try {
			String query = "INSERT INTO prenotazioni (idPrenotazione, dataArrivo, dataPartenza, prezzoTotale, Cliente, Inserzione, StrutturaTuristica)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setString(1, null);
			preparedStmt.setDate(2, Date.valueOf(p.getDataArrivo()));
			preparedStmt.setDate(3, Date.valueOf(p.getDataPartenza()));
			preparedStmt.setDouble(4, p.getPrezzoTot());
			preparedStmt.setString(5, p.getCfCliente());
			preparedStmt.setInt(6, p.getIdInserzione());
			preparedStmt.setString(7, p.getPIva());
			preparedStmt.executeUpdate();

			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Prenotazione updatePrenotazione(Prenotazione p) {
		try {
			String query = "UPDATE prenotazioni SET idPrenotazione = ?, dataArrivo = ?, dataPartenza = ?, prezzoTotale = ?, Cliente = ?, Inserzione = ?, StrutturaTuristica = ? WHERE idPrenotazione = ?";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, p.getIdPrenotazione());
			preparedStmt.setDate(2, Date.valueOf(p.getDataArrivo()));
			preparedStmt.setDate(3, Date.valueOf(p.getDataPartenza()));
			preparedStmt.setDouble(4, p.getPrezzoTot());
			preparedStmt.setString(5, p.getCfCliente());
			preparedStmt.setInt(6, p.getIdInserzione());
			preparedStmt.setString(7, p.getPIva());
			preparedStmt.setInt(7, p.getIdPrenotazione());

			preparedStmt.executeUpdate();

			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean controlloDisponibilita(Inserzione in, LocalDate dataArrivo, LocalDate dataPartenza) {
		boolean disponibilita = false;
		LocalDate dataInizio = in.getDataInizio();
		LocalDate dataFine = in.getDataFine();

		if(dataInizio.isBefore(dataArrivo) && dataFine.isAfter(dataPartenza)) {
			for(Prenotazione p : DAOFactory.getDAOPrenotazione().doRetrieveAllByIdInserzione(in.getIdInserzione()).values()) {
				if(dataArrivo.isAfter(p.getDataPartenza()) || dataPartenza.isBefore(p.getDataArrivo()));
				else return disponibilita;
			};
		}

		disponibilita = true;
		return disponibilita;
	}
}