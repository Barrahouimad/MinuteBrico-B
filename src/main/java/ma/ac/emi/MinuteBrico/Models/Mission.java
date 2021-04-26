package ma.ac.emi.MinuteBrico.Models;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="missions")
public class Mission {
	
	
	public Mission() {
		
	}
	


	
	public Mission(int iDMission, String titre_mission, String state, String adresse, int etat_mission, String images,
			String ville, int interval_temps, String mission_description,  Date date, int zip_code,
			int bricoleur_choisi, List<Categorie> categories, List<BricoleurModel> bricoleurs) {
		this.id = iDMission;
		this.titre_mission = titre_mission;
		this.state = state;
		this.adresse = adresse;
		this.etat_mission = etat_mission;
		this.images = images;
		this.ville = ville;
		this.interval_temps = interval_temps;
		this.mission_description = mission_description;

		this.date = date;
		this.zip_code = zip_code;
		this.bricoleur_choisi = bricoleur_choisi;
		this.categories = categories;
		this.bricoleurs = bricoleurs;
	}




	public Mission(Map<String,Object> userMap) {
		if (userMap.get("id") != null)	
			
		this.id = (int )userMap.get("id");
		this.state = (String) userMap.get("state");
		this.titre_mission = (String) userMap.get("titre_mission");
		this.interval_temps = (int) userMap.get("interval_temps");
		this.mission_description = (String) userMap.get("mission_description");
		this.ville=(String) userMap.get("ville");
		this.adresse=(String) userMap.get("adresse");
		this.etat_mission=(int) userMap.get("etat_mission");
		this.images=(String) userMap.get("images");
		this.zip_code=(int) userMap.get("zip_code");
		this.date=(Date) userMap.get("date");
		this.categories=(List<Categorie>) userMap.get("categories");
	}
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String titre_mission;
		private String state;
		private String adresse;
		private int etat_mission;
		private String images;
		private String ville;
		private int interval_temps;
		private String mission_description;
		private Date date;
		private int zip_code;
		private int bricoleur_choisi;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="mission_id")
private List<Categorie> categories;


@JsonManagedReference
@ManyToMany
@JoinTable(
		name="mission_brico",
		joinColumns=@JoinColumn(name="mission_id"),
		inverseJoinColumns=@JoinColumn(name="brico_id"))
List<BricoleurModel> bricoleurs;




public void addBrico(BricoleurModel brico) {
	
	if (bricoleurs == null) {
		bricoleurs = new ArrayList<>();
	}
	
	bricoleurs.add(brico);
	

}	


public void add(Categorie cat) {
	
	if (categories == null) {
		categories = new ArrayList<>();
	}
	
	categories.add(cat);
	

}




public int getID() {
	return id;
}




public void setID(int iDMission) {
	id = iDMission;
}




public String getTitre_mission() {
	return titre_mission;
}

public List<BricoleurModel> getBricoleurs() {
	return bricoleurs;
}



public void setBricoleurs(List<BricoleurModel> bricoleurs) {
	this.bricoleurs = bricoleurs;
}


public void setTitre_mission(String titre_mission) {
	this.titre_mission = titre_mission;
}




public String getState() {
	return state;
}




public void setState(String state) {
	this.state = state;
}




public String getAdresse() {
	return adresse;
}




public void setAdresse(String adresse) {
	this.adresse = adresse;
}




public int getEtat_mission() {
	return etat_mission;
}




public void setEtat_mission(int etat_mission) {
	this.etat_mission = etat_mission;
}




public String getImages() {
	return images;
}




public void setImages(String images) {
	this.images = images;
}




public String getVille() {
	return ville;
}




public void setVille(String ville) {
	this.ville = ville;
}




public int getInterval_temps() {
	return interval_temps;
}




public void setInterval_temps(int interval_temps) {
	this.interval_temps = interval_temps;
}




public String getMission_description() {
	return mission_description;
}




public void setMission_description(String mission_description) {
	this.mission_description = mission_description;
}








public Date getDate() {
	return date;
}




public void setDate(Date date) {
	this.date = date;
}




public int getZip_code() {
	return zip_code;
}




public void setZip_code(int zip_code) {
	this.zip_code = zip_code;
}




public int getBricoleur_choisi() {
	return bricoleur_choisi;
}




public void setBricoleur_choisi(int bricoleur_choisi) {
	this.bricoleur_choisi = bricoleur_choisi;
}




public List<Categorie> getCategories() {
	return categories;
}




public void setCategories(List<Categorie> categories) {
	this.categories = categories;
}



}
