package ma.ac.emi.MinuteBrico.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.MinuteBrico.Services.BricoleurServices;
import ma.ac.emi.MinuteBrico.Services.MissionServices;
import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import ma.ac.emi.MinuteBrico.Models.Categorie;
import ma.ac.emi.MinuteBrico.Models.Mission;

@RestController
public class MissionController {

	
	@Autowired
	  private MissionServices missionService;
	
	@Autowired
	  private BricoleurServices bricoleurServices;
	
	@CrossOrigin
	@GetMapping("/missions")
	public List<Mission> index(){
		return missionService.findAll();
	}
	@CrossOrigin
	@GetMapping("/missions/{id}")
	public Mission indexById(@PathVariable String id){
		int missionId = Integer.parseInt(id);
		return missionService.findById(missionId);
		
	}
	@CrossOrigin()
	@PostMapping("/missions")
	public int create(@RequestBody Map<String, Object> missionMap) {
		
		System.out.println(missionMap);
		Mission mission = new Mission(missionMap);
		Categorie cat;
		
		for(String titre : (List<String>) (missionMap).get("titre")) {
				cat =new Categorie(titre);
				mission.add(cat);
		}
		
		missionService.savemission(mission);
		return  ((List<String>) (missionMap).get("titre")).size();

	}
	@CrossOrigin()
	@GetMapping("/bricoaumission/{bricoleurId}/{missionId}")
	public String ajouter(@PathVariable int bricoleurId,@PathVariable int missionId) {
		
	     
		 BricoleurModel bricoleur =  bricoleurServices.findById(bricoleurId);
		  ( missionService.findById(missionId)).addBrico(bricoleur);
	
		return  bricoleur.getFirstName() +  missionService.findById(missionId).getImages();

	}
	
}
