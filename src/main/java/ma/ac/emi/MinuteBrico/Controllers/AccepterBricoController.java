package ma.ac.emi.MinuteBrico.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.MinuteBrico.Models.AccepterBrico;
import ma.ac.emi.MinuteBrico.Repositories.AccepterBricoRepository;
import ma.ac.emi.MinuteBrico.Repositories.MissionRepository;
import ma.ac.emi.MinuteBrico.Services.MissionServices;

@RestController
public class AccepterBricoController {

	
	@Autowired
	AccepterBricoRepository acceptRepository;
	@Autowired

	MissionRepository MissionRepository;
	
	@Autowired
	  private MissionServices missionService;
	public AccepterBricoController(AccepterBricoRepository acceptRepository,MissionRepository MissionRepository) {
		this.acceptRepository = acceptRepository;
		this.MissionRepository = MissionRepository;

	}
	
	@CrossOrigin()
	@PutMapping("/ClientAccept/{bricoid}/{missionid}/{accept}")
	public int ClientAccept(@PathVariable int  bricoid,@PathVariable int missionid,@PathVariable int accept) {
		
		acceptRepository.findByBricoIdAndMissionId(bricoid, missionid).setClientAccept(accept);	
		acceptRepository.save(acceptRepository.findByBricoIdAndMissionId(bricoid, missionid));
		return acceptRepository.findByBricoIdAndMissionId(bricoid, missionid).getClientAccept();
	}
	
	@CrossOrigin()
	@PutMapping("/BricoAccept/{bricoid}/{missionid}/{accept}")
	public String BricoAccept(@PathVariable int  bricoid,@PathVariable int missionid,@PathVariable int accept) {
		acceptRepository.findByBricoIdAndMissionId(bricoid, missionid).setBricoAccept(accept);
		acceptRepository.save(acceptRepository.findByBricoIdAndMissionId(bricoid, missionid));
		AccepterBrico accepterBrico=acceptRepository.findByBricoIdAndMissionId(bricoid, missionid);
         if(accepterBrico.getBricoAccept()==1 && accepterBrico.getClientAccept()==1 )
         {
        	 missionService.findById(missionid).setEtat_mission(1);
        	 MissionRepository.save(missionService.findById(missionid));
         }
		return "brico acceptes Mission  :"+ missionid;
	}
	
}
