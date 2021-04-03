package ma.ac.emi.MinuteBrico.Controllers;

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

import ma.ac.emi.MinuteBrico.Services.MissionServices;
import ma.ac.emi.MinuteBrico.Models.Mission;

@RestController
public class MissionController {

	
	@Autowired
	  private MissionServices missionService;
	
	@CrossOrigin
	@GetMapping("/missions")
	public List<Mission> index(){
		return missionService.findAll();
	}
	@CrossOrigin
	@GetMapping("/missions/{id}")
	public Optional<Mission> indexById(@PathVariable String id){
		int missionId = Integer.parseInt(id);
		return missionService.findById(missionId);
		
	}
	@CrossOrigin()
	@PostMapping("/missions")
	public String create(@RequestBody Map<String, Object> missionMap) {
		System.out.println(missionMap);
		Mission mission = new Mission(missionMap);
		missionService.savemission(mission);
		return "Mission ajouté";

	}
}
