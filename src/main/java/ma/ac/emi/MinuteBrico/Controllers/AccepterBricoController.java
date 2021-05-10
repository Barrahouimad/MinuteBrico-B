package ma.ac.emi.MinuteBrico.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.emi.MinuteBrico.Repositories.AccepterBricoRepository;

@RestController
public class AccepterBricoController {

	
	@Autowired
	AccepterBricoRepository acceptRepository;

	public AccepterBricoController(AccepterBricoRepository acceptRepository) {
		this.acceptRepository = acceptRepository;
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
		return "brico acceptes Mission  :"+ missionid;
	}
	
}
