package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import  ma.ac.emi.MinuteBrico.Models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	 List<Client> findByEmail(String email);
	 Client findById(int id);
	List<Client> findByEmailAndPassword(String email, String password);
	Client findByToken(String token);

}
