package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import  ma.ac.emi.MinuteBrico.Models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	 List<Client> findByEmail(String email);
	 Client findById(int id);
	 List<Client> findByEmailAndPassword(String email, String password);
	 Client findByToken(String token);
	 
	 //Optional<Client> findByEmail1(String email);

}
