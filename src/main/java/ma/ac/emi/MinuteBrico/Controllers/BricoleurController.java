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
import ma.ac.emi.MinuteBrico.Models.Reviews;
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
	public List<BricoleurModel> indexCheck(@PathVariable String email, @PathVariable String password) {
		
		
			if((bricoservice.findByEmailAndPassword(email,password).size()==0)) {
				BricoleurModel brico = new BricoleurModel();
				brico.setFirstName("Null");
				List<BricoleurModel> list = bricoservice.findByEmailAndPassword(email,password) ;
				list.add(brico);
				
				return list;
				
			}
			  
		
	
		
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
	@PutMapping("/bricoleurs/{id}")
	public/* List<Reviews>*/ int update(@PathVariable int id, @RequestBody Map<String, Object> body) {
			int bricoleurId = id;
			BricoleurModel b = bricoservice.findById(bricoleurId);
          /*  b.setPhoto((String)  body.get("photo"));
			b.setEmail((String)body.get("email"));
			b.setPassword((String)body.get("password"));
			b.setFirstName((String)body.get("firstName"));
			b.setLastName((String)body.get("lastName"));
			b.setBirthday((String)body.get("birthday"));
			b.setPhone((String)body.get("phone"));
			b.setAdresse((String)body.get("adresse"));
			b.setToken((String)body.get("token"));
			b.setDescriptionProfil((String)body.get("descriptionProfil"));*/
			
         //   b.setReviewsOnBrico((List<Reviews>) body.get("reviewsOnBrico"));
			
			for( int i=0 ; i<((List<Reviews>) (body).get("reviewsOnBrico")).size() ; i++) {
				
				Reviews exl = new Reviews((((List<Map<String, Object>>) (body).get("reviewsOnBrico")).get(i)));
				
			    	b.addReview(exl);

			}
			//Reviews exl = new Reviews((((List<Map<String, Object>>) (body).get("reviewsOnBrico")).get(0)));
			//b.addReview(exl);
	         bricoservice.addBricoleur(b);
			return b.getReviewsOnBrico().get(0).getId();
		
	
	}	

	@CrossOrigin()
	@PostMapping("/bricoleurscertif")
	public String createwithcertif(@RequestBody Map<String, Object> bricoMap) {
		BricoleurModel bricoleur = new BricoleurModel(bricoMap);		   
		
		for(int i=0;i<((List<Categorie>) (bricoMap).get("categorie")).size();i++) {
				
			Categorie exl = new Categorie((((List<Map<String, Object>>) (bricoMap).get("categorie")).get(i)));
			
			bricoleur.addCategorie(exl);

		}
		for(int i=0;i<((List<Certification>) (bricoMap).get("certification")).size();i++) {
			
			Certification exl = new Certification((((List<Map<String, Object>>) (bricoMap).get("certification")).get(i)));
			
			bricoleur.addCertification(exl);

		}
		for(int i=0;i<((List<Diplomes>) (bricoMap).get("diplomes")).size();i++) {
			
			Diplomes exl = new Diplomes((((List<Map<String, Object>>) (bricoMap).get("diplomes")).get(i)));
			
			bricoleur.addDiplomes(exl);

		}
		for(int i=0;i<((List<Langues>) (bricoMap).get("langues")).size();i++) {
			
			Langues exl = new Langues((((List<Map<String, Object>>) (bricoMap).get("langues")).get(i)));
			
			bricoleur.addLangues(exl);

		}
	
	
		bricoservice.addBricoleur(bricoleur);
		return "Brico ajouté" ;

	}
	
	@CrossOrigin()
	@PutMapping("/bricoleurup/{token}")
	public BricoleurModel updateadd(@PathVariable String token, @RequestBody Map<String, Object> body) {
		    BricoleurModel bricoleur = bricoservice.findByToken(token);
			//BricoleurModel b = bricoleur;
			//b.setPhoto(body.getPhoto());
		    bricoservice.findByToken(token).setFirstName((String) body.get("firstName"));
		    bricoservice.findByToken(token).setLastName((String) body.get("lastName"));
		    bricoservice.findByToken(token).setPhone((String) body.get("phone"));
		 return bricoservice.addBricoleur(bricoservice.findByToken(token));
	
	}
	
	@CrossOrigin()
	@PutMapping("/motdepasse/{token}")
	public BricoleurModel updateaddpass(@PathVariable String token, @RequestBody Map<String, Object> body) {
		    BricoleurModel bricoleur = bricoservice.findByToken(token);
			//BricoleurModel b = bricoleur;
			//b.setPhoto(body.getPhoto());
		    bricoservice.findByToken(token).setPassword((String) body.get("password"));
		    return bricoservice.addBricoleur(bricoservice.findByToken(token));
	
	}
	
	@CrossOrigin()
	@GetMapping("/bricoleurtoken/{token}")
	public BricoleurModel get(@PathVariable String token) {
		
		
		return bricoservice.findByToken(token);
	}
}
