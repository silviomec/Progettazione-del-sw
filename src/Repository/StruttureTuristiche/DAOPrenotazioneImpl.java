package Repository.StruttureTuristiche;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import StruttureTuristiche.Model.*;
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
	public HashMap<String, Prenotazione> doRetrieveAll() {
		HashMap<String, Prenotazione> prenotazioniCollection = new HashMap<String, Prenotazione>();
		Statement statement = null;
		try {
			statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM PRENOTAZIONI");

			while (result.next()) {
				int idPrenotazione = result.getInt("idprenotazione");
				Date dataArrivo = result.getDate("dataArrivo");
				Date dataPartenza = result.getDate("dataPartenza");
				double prezzoTot = result.getDouble("prezzoTotale");
				int idCliente = result.getInt("cliente");
				int idInserzione = result.getInt("inserzione");
				int idStrutturaTuristica = result.getInt("strutturaTuristica");
				Prenotazione p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, idCliente, idInserzione, idStrutturaTuristica);
				prenotazioniCollection.put(Integer.toString(idPrenotazione), p);
			}     

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenotazioniCollection;
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
				Date dataArrivo = result.getDate("dataArrivo");
				Date dataPartenza = result.getDate("dataPartenza");
				double prezzoTot = result.getDouble("prezzoTotale");
				int idCliente = result.getInt("cliente");
				int idInserzione = result.getInt("inserzione");
				int idStrutturaTuristica = result.getInt("strutturaTuristica");
				p = new Prenotazione(idPrenotazione, dataArrivo, dataPartenza, prezzoTot, idCliente, idInserzione, idStrutturaTuristica);
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
	public int updatePrenotazione(Prenotazione p) {
		try {
			delete(p.getIdPrenotazione());
			
			String query = " insert into PRENOTAZIONI (idPrenotazione, dataArrivo, dataPartenza, prezzoTotale, Cliente, Inserzione, StrutturaTuristica)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.getConnection().prepareStatement(query);
			preparedStmt.setInt(1, p.getIdPrenotazione());
			preparedStmt.setDate(2, p.getDataArrivo());
			preparedStmt.setDate(3, p.getDataPartenza());
			preparedStmt.setDouble(4, p.getPrezzoTot());
			preparedStmt.setInt(5, p.getIdCliente());
			preparedStmt.setInt(6, p.getIdInserzione());
			preparedStmt.setInt(7, p.getIdStrutturaTuristica());
		
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}