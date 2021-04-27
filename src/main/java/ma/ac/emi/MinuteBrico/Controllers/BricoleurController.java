package ma.ac.emi.MinuteBrico.Controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import ma.ac.emi.MinuteBrico.Models.Categorie;
import ma.ac.emi.MinuteBrico.Models.Mission;
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
	@GetMapping("/bricoleursCheck/{password}/{email}")
	public List<BricoleurModel> indexCheck(@PathVariable String password,@PathVariable String email) {
		
		return bricoservice.findByEmailAndPassword(email,password);

	}
	
	@CrossOrigin()
	@GetMapping("/bricoleurs/{id}")  
	public BricoleurModel bricoByid(@PathVariable String id) {
		
		    int bricoId= Integer.parseInt(id);
			return bricoservice.findById(bricoId);

		

	}
	
	@CrossOrigin()
	@PostMapping("/bricoleurs")
	public String create(@RequestBody Map<String, Object> bricoMap) {
		
		System.out.println(bricoMap);
		BricoleurModel bricoleur = new BricoleurModel(bricoMap);
		
		bricoservice.addBricoleur(bricoleur);
		return  "brico ajouté";

	}
	
	@CrossOrigin()
	@PutMapping("/bricoleurup/{token}")
	public BricoleurModel updateadd(@PathVariable String token, @RequestBody BricoleurModel body) {
		BricoleurModel bricoleur = bricoservice.findByToken(token);

			BricoleurModel b = bricoleur;
			b.setPhoto(body.getPhoto());
			b.setFirstName(body.getFirstName());
			b.setLastName(body.getLastName());
			

			return bricoservice.addBricoleur(b);
	
	}
	@CrossOrigin()
	@GetMapping("/bricoleurtoken/{token}")
	public BricoleurModel get(@PathVariable String token) {
		
		
		return bricoservice.findByToken(token);
	}
}
