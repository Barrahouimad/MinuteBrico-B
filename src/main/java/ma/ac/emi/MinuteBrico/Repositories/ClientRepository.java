package ma.ac.emi.MinuteBrico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import  ma.ac.emi.MinuteBrico.Models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
