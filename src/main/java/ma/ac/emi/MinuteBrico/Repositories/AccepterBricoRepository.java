package ma.ac.emi.MinuteBrico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.emi.MinuteBrico.Models.AccepterBrico;

public interface AccepterBricoRepository extends JpaRepository<AccepterBrico,Integer>  {

	AccepterBrico findByBricoIdAndMissionId(int bricoId,int missionId);
	
}
