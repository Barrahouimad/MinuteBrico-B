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

	 private final BricoleurRepository bricoleurrepository ;
	 
	 public BricoleurServices(BricoleurRepository bricoleurrepository) {
		 this.bricoleurrepository=bricoleurrepository;
	 }

	 public BricoleurModel findByToken(String token) {
			return bricoleurrepository.findByToken(token);
		}
		public List<BricoleurModel> findAll() {
			return  bricoleurrepository.findAll();
		}
		public BricoleurModel findById(int id) {
			return bricoleurrepository.findById(id).get();
		}

		public List<BricoleurModel> findBySearch(String searchText,String pass) {
			return bricoleurrepository.findByEmailAndPassword(searchText,pass);
		}
        public List<BricoleurModel> findByNomContainingOrPrenomContaining(String text){
        	return bricoleurrepository.findByFirstNameContainingOrLastNameContaining(text,text);
        }
        public BricoleurModel addBricoleur(BricoleurModel bricoleur) {
        	return bricoleurrepository.save(bricoleur);
        }
        
        public List<BricoleurModel> findByEmailAndPassword(String email,String password) {
        	return bricoleurrepository.findByEmailAndPassword(email,password);
        }
}
