package services;

import java.util.Collection;

import entities.Client;

public interface IClientDAO {

	public Boolean register(Client client);
	
	public void delete(Long cpf);
	
	public void change(Client client);
	
	public Client consult(Long cpf);
	
	public Collection<Client> searchAll();
	
}
