package services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entities.Client;

public class ClientSetDAO implements IClientDAO{

	private Set<Client> set;
	
	public ClientSetDAO() {
		this.set = new HashSet<>();
	}
	
	@Override
	public Boolean register(Client client) {
		return this.set.add(client);
	}

	@Override
	public void delete(Long cpf) {
		Client clientCatch = null;
		
		for (Client client : this.set) {
			if (client.getCpf().equals(cpf)) {
				clientCatch = client;
				break;
			}
		}
	}

	@Override
	public void change(Client client) {
		 
		
	}

	@Override
	public Client consult(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
