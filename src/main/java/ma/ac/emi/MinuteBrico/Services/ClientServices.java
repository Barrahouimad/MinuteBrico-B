package ma.ac.emi.MinuteBrico.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.emi.MinuteBrico.Models.Client;
import ma.ac.emi.MinuteBrico.Repositories.ClientAccountRepository;
import ma.ac.emi.MinuteBrico.Repositories.ClientRepository;

@Service
@Transactional
public class ClientServices {

	private final ClientRepository clientrepository;
	public ClientServices(ClientRepository clientRepo) {
		this.clientrepository=clientRepo;
	}
	
	public List<Client> findAll(){
		return clientrepository.findAll();
	}
	public List<Client> findByEmail(String email){
		return clientrepository.findByEmail(email);
	}
	public Client findById(int id){
		return clientrepository.findById(id);
	}
	
	public Client saveClient(Client client) {
		return clientrepository.save(client);
	}

	
}
