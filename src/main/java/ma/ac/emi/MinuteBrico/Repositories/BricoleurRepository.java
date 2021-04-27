package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import  ma.ac.emi.MinuteBrico.Models.BricoleurModel;

//etablir la connection avec la base de donnee

public interface BricoleurRepository extends JpaRepository<BricoleurModel,Integer> {
	List<BricoleurModel> findByEmailContainingOrPassword(String email, String password);
    List<BricoleurModel> findByEmailAndPassword(String email,String password);
      BricoleurModel findByToken(String token);
	List<BricoleurModel> findByFirstNameContainingOrLastNameContaining(String nom,String prenom);
	
}
