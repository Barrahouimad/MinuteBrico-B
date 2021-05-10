package ma.ac.emi.MinuteBrico.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import ma.ac.emi.MinuteBrico.Models.Categorie;
import ma.ac.emi.MinuteBrico.Models.Certification;
import ma.ac.emi.MinuteBrico.Models.Diplomes;
import ma.ac.emi.MinuteBrico.Models.Langues;
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
	@GetMapping("/bricoleursCheck/{email}/{password}")
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
	@PostMapping("/bricoleurscertif")
	public String createwithcertif(@RequestBody Map<String, Object> bricoMap) {
		BricoleurModel bricoleur = new BricoleurModel(bricoMap);		   
		
		for(int i=0;i<((List<Categorie>) (bricoMap).get("Categorie")).size();i++) {
				
			Categorie exl = new Categorie((((List<Map<String, Object>>) (bricoMap).get("Categorie")).get(i)));
			
			bricoleur.addCategorie(exl);

		}
		for(int i=0;i<((List<Certification>) (bricoMap).get("Certification")).size();i++) {
			
			Certification exl = new Certification((((List<Map<String, Object>>) (bricoMap).get("Certification")).get(i)));
			
			bricoleur.addCertification(exl);

		}
		for(int i=0;i<((List<Diplomes>) (bricoMap).get("Diplomes")).size();i++) {
			
			Diplomes exl = new Diplomes((((List<Map<String, Object>>) (bricoMap).get("Diplomes")).get(i)));
			
			bricoleur.addDiplomes(exl);

		}
	/*	for(int i=0;i<((List<Langues>) (bricoMap).get("Langues")).size();i++) {
			
			Langues exl = new Langues((((List<Map<String, Object>>) (bricoMap).get("Langues")).get(i)));
			
			bricoleur.addLangues(exl);

		}
		*/
	
		bricoservice.addBricoleur(bricoleur);
		return "Brico ajouté" ;

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
