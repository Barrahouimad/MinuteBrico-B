package ma.ac.emi.MinuteBrico.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import  ma.ac.emi.MinuteBrico.Repositories.BricoleurRepository;
import  ma.ac.emi.MinuteBrico.Models.BricoleurModel;

@Service
@Transactional
//definir les méthodes
public class BricoleurServices {

	 private final BricoleurRepository bricoleurreppository ;
	 
	 public BricoleurServices(BricoleurRepository bricoleurrepository) {
		 this.bricoleurreppository=bricoleurrepository;
	 }

		public List<BricoleurModel> findAll() {
			return  bricoleurreppository.findAll();
		}
		public Optional<BricoleurModel> findById(int id) {
			return bricoleurreppository.findById(id);
		}

		public List<BricoleurModel> findBySearch(String searchText) {
			return bricoleurreppository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
		}

	 
	 
}
