package ma.ac.emi.MinuteBrico.Services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ma.ac.emi.MinuteBrico.Models.ClientAccount;
import ma.ac.emi.MinuteBrico.Repositories.ClientAccountRepository;
import ma.ac.emi.MinuteBrico.Repositories.ClientRepository;

@Service
@Transactional
public class AccountClientServices {
	private final ClientAccountRepository accountrepository;

	public AccountClientServices( ClientAccountRepository clientAccountRepository) {
		
		this.accountrepository = clientAccountRepository;
	}
	
	public boolean deleteAccount(int id) {
		 try {
			 accountrepository.deleteById((long) id);
		 }catch(Exception ex) {
			 return false;
		 }
		 return true;
	 }

	public ClientAccount addAccountClient(ClientAccount clientaccount) {
		
		return accountrepository.save(clientaccount);
	}
	
}
