package ma.ac.emi.MinuteBrico.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import  ma.ac.emi.MinuteBrico.Models.Mission;

public interface MissionRepository extends JpaRepository<Mission,Integer> {

	List<Mission> findByEtatMission(int etatMission);
	
	
}
