package ma.ac.emi.MinuteBrico.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AcceptBrico")
public class AccepterBrico {
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int bricoId;
	private int missionId;
	private int clientAccept;
	private int BricoAccept;
	
	
	
	
	public AccepterBrico() {
	}
	
	public AccepterBrico( int bricoId, int missionId) {
	
		this.bricoId = bricoId;
		this.missionId = missionId;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBricoId() {
		return bricoId;
	}
	public void setBricoId(int bricoId) {
		this.bricoId = bricoId;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getClientAccept() {
		return clientAccept;
	}
	public void setClientAccept(int clientAccept) {
		this.clientAccept = clientAccept;
	}
	public int getBricoAccept() {
		return BricoAccept;
	}
	public void setBricoAccept(int bricoAccept) {
		BricoAccept = bricoAccept;
	}
	
	
	
}
