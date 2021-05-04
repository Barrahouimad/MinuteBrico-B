package ma.ac.emi.MinuteBrico.Models;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Diplome")
public class Diplomes implements Serializable {

    /**
	 * @author iliass Alilou
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String school;
	private String annee_entre;
	private String annee_sortie;
	private String diplome;
	private String domaine;
	private String description;
	
	public Diplomes() {
		
	}
	
	public Diplomes(String school, String annee_entre, String annee_sortie, String diplome, String domaine,
			String descrition) {
		super();
		this.school = school;
		this.annee_entre = annee_entre;
		this.annee_sortie = annee_sortie;
		this.diplome = diplome;
		this.domaine = domaine;
		this.description = descrition;
	}
	
	 public Diplomes(Map<String,Object> diplomeMap) {
			if (diplomeMap.get("id") != null)	
				
			this.Id = (int )diplomeMap.get("Id");
			this.school = (String) diplomeMap.get("school");
			this.annee_entre = (String) diplomeMap.get("annee_entre");
			this.annee_sortie = (String) diplomeMap.get("annee_sortie");
			this.diplome = (String) diplomeMap.get("diplome");
			this.domaine = (String) diplomeMap.get("domaine");
			this.description = (String) diplomeMap.get("descrition");
			
			
		}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAnnee_entre() {
		return annee_entre;
	}

	public void setAnnee_entre(String annee_entre) {
		this.annee_entre = annee_entre;
	}

	public String getAnnee_sortie() {
		return annee_sortie;
	}

	public void setAnnee_sortie(String annee_sortie) {
		this.annee_sortie = annee_sortie;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrition) {
		this.description = descrition;
	}

	@Override
	public String toString() {
		return "Diplomes [Id=" + Id + ", school=" + school + ", annee_entre=" + annee_entre + ", annee_sortie="
				+ annee_sortie + ", diplome=" + diplome + ", domaine=" + domaine + ", descrition=" + description + "]";
	}
	
	
	
}
