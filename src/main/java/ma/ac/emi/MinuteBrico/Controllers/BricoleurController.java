package ma.ac.emi.MinuteBrico.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import  ma.ac.emi.MinuteBrico.Services.BricoleurServices;

@RestController
//attribuer les méthodes aux différents request mapping 
public class BricoleurController {

	

	@Autowired
	private BricoleurServices bricoservice;

	
	@CrossOrigin()
	@GetMapping("/bricoleurs")
	public List<BricoleurModel> index(@RequestParam(value = "search", required = false) String searchText) {
		if (searchText == null) {
			return bricoservice.findAll();
		}
		return bricoservice.findByNomContainingOrPrenomContaining(searchText);

	}
	@CrossOrigin()
	@GetMapping("/bricoleurs/{id}")  
	public Optional<BricoleurModel> bricoByid(@PathVariable String id) {
		
		    int bricoId= Integer.parseInt(id);
			return bricoservice.findById(bricoId);

		

	}
	
}
