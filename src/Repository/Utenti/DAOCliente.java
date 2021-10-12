package Repository.Utenti;

import java.util.HashMap;

import Utenti.Model.Cliente;

public interface DAOCliente {
	public HashMap<String, Cliente> doRetrieveAll();
	public Cliente doRetrieveByIdCliente(int id);
	public void delete(int id);
	public int updateCliente(Cliente c);
}