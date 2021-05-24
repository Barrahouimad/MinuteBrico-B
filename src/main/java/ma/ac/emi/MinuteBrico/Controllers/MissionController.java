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

import ma.ac.emi.MinuteBrico.Services.ClientServices;
import ma.ac.emi.MinuteBrico.Services.MissionServices;
import ma.ac.emi.MinuteBrico.Models.AccepterBrico;
import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import ma.ac.emi.MinuteBrico.Models.Categorie;
import ma.ac.emi.MinuteBrico.Models.Mission;
import ma.ac.emi.MinuteBrico.Repositories.AccepterBricoRepository;

@RestController
public class MissionController {

	
	@Autowired
	  private MissionServices missionService;
	
	@Autowired
	  private BricoleurServices bricoleurServices;
	
	@Autowired
	  private ClientServices ClientServices;
	@Autowired
    private   AccepterBricoRepository accepterBricoRepository;
	
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
	@PostMapping("/missions/{id}")
	public int createwithId(@RequestBody Map<String, Object> missionMap,@PathVariable int id) {
		
		System.out.println(missionMap);
		Mission mission = new Mission(missionMap);
		Categorie cat;
		
		for(String titre : (List<String>) (missionMap).get("titre")) {
				cat =new Categorie(titre);
				mission.add(cat);
		}
		mission.missionAddClient(ClientServices.findById(id));
		missionService.savemission(mission);
		return  ((List<String>) (missionMap).get("titre")).size();

	}
	
	@CrossOrigin()
	@PostMapping("/missions")
	public int create(@RequestBody Map<String, Object> missionMap) {
		
		System.out.println(missionMap);
		Mission mission = new Mission(missionMap);
		Categorie cat;
		
		for(String titre : (List<String>) (missionMap).get("categorie")) {
				cat =new Categorie(titre);
				mission.add(cat);
		}
		
		missionService.savemission(mission);
		return  ((List<String>) (missionMap).get("titre")).size();

	}
	@CrossOrigin()
	@GetMapping("/bricoaumission/{bricoleurId}/{missionId}")
	public String ajouter(@PathVariable int bricoleurId,@PathVariable int missionId) {
		//ajouter une relation de postuler pour gérer l'acceptation
		
		AccepterBrico accepterbrico =new  AccepterBrico(bricoleurId,missionId);
		accepterBricoRepository.save(accepterbrico);
		
		 BricoleurModel bricoleur =  bricoleurServices.findById(bricoleurId);
		  ( missionService.findById(missionId)).addBrico(bricoleur);
		  missionService.save(  missionService.findById(missionId));
		return  bricoleur.getFirstName() ;

	}
	@CrossOrigin
	@GetMapping("/Bricoofmissions/{id}")
	public List<BricoleurModel> indexByIdBrico(@PathVariable String id){
		int missionId = Integer.parseInt(id);
		Mission mission =missionService.findById(missionId);
		return  mission.getBricoleurs();
	}
	
	
}
