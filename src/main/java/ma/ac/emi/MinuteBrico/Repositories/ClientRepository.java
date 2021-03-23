package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import  ma.ac.emi.MinuteBrico.Models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	 List<Client> findByEmail(String email);

}
