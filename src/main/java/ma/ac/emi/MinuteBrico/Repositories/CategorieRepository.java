package ma.ac.emi.MinuteBrico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.emi.MinuteBrico.Models.Categorie;



@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
