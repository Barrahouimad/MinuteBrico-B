package ma.ac.emi.MinuteBrico.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import  ma.ac.emi.MinuteBrico.Repositories.MissionRepository;
import  ma.ac.emi.MinuteBrico.Models.Mission;


@Service
@Transactional
public class MissionServices {

	private final MissionRepository missionRepository;
	
	public MissionServices(MissionRepository mission) {
		this.missionRepository=mission;
	}
	
	public Mission savemission(Mission mission) {
		return missionRepository.save(mission);
	}
	
	public List<Mission> findAll(){
		return missionRepository.findAll();
	}
	
	public Optional<Mission> findById(int id) {
		return missionRepository.findById(id);
	}

	public boolean deleteById(int id) {
		try {
			missionRepository.deleteById(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
}
