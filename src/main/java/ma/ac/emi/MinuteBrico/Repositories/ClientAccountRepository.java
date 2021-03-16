package ma.ac.emi.MinuteBrico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import  ma.ac.emi.MinuteBrico.Models.ClientAccount;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

}
