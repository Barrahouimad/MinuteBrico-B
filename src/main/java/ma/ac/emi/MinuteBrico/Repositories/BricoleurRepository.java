package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import  ma.ac.emi.MinuteBrico.Models.BricoleurModel;

//etablir la connection avec la base de donnee

public interface BricoleurRepository extends JpaRepository<BricoleurModel,Integer> {
	List<BricoleurModel> findByEmailContainingOrFirstNameContainingOrLastNameContaining(String email, String firstName,String lastName);

	
}
