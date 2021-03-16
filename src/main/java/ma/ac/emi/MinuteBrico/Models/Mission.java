package ma.ac.emi.MinuteBrico.Models;
import java.sql.Time;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="missions")
public class Mission {
	
	
	public Mission() {
		
	}
	public Mission(int id,String description,int etatMission,String state,int Duree,String domaine,String ville,String adresse) {
		setId(id);
		setDescription(description);
		setState(state);
		setDuree(Duree);
		setDomaine(domaine);
		setVille(ville);
		 setAdresse(adresse);
		setEtatMission(etatMission);
		setImage(image);
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Mission(Map<String,Object> userMap) {
		if (userMap.get("id") != null)	
			
		this.id = (int )userMap.get("id");
		this.state = (String) userMap.get("state");
		this.duree = (int) userMap.get("duree");
		this.domaine = (String) userMap.get("domaine");
		this.description = (String) userMap.get("description");
		this.ville=(String) userMap.get("ville");
		this.adresse=(String) userMap.get("adresse");
		this.etatMission=(int) userMap.get("etatMission");
		this.image=(String) userMap.get("image");
	}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String state;
private String adresse;
private int etatMission;
private String image;
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

private String ville;
public int getEtatMission() {
	return etatMission;
}
public void setEtatMission(int etatMission) {
	this.etatMission = etatMission;
}

private int duree;
private String description;
private String domaine;


public String getDomaine() {
	return domaine;
}
public void setDomaine(String domaine) {
	this.domaine = domaine;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
@Override
public String toString() {
	return "Mission [id=" + id +  ", state=" + state + ", duree=" + duree + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getState() {
	return state;
} 
public void setState(String state) {
	this.state = state;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}
	
	
}
