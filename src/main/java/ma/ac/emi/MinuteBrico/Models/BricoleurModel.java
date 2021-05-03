package ma.ac.emi.MinuteBrico.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//modeliser la table et les données de chaque classe
@Entity
@Table(name="Bricoleur")
public class BricoleurModel{
	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;
		private String password;
		private Long clientId ;
		private String ville;
		private String firstName;
		private String lastName;
		private String email;
		private String birthday;
		private String photo ;
		private String role;
		private String token;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "Certification_Bricoleur",referencedColumnName = "id")
		private List<Certification> certifications;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "diplomes_Bricoleur",referencedColumnName = "id")
		private List<Diplomes> diplomes;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "langues_Bricoleur",referencedColumnName = "id")
		private List<Langues> langues;
		
		@OneToMany(/*fetch = FetchType.LAZY , targetEntity = Category.class,*/ cascade = CascadeType.ALL)
		@JoinColumn(name = "Category_Bricoleur",referencedColumnName = "id")
		private List<Categorie> categorie ;
		
		
		public BricoleurModel() {
			
		}
		
	



		public BricoleurModel(int id, String password, Long clientId, String ville, String firstName, String lastName,
				String email, String birthday, String photo, String role, String token,
				List<Certification> certifications,
				List<Diplomes> diplomes,
				List<Langues> langues, List<Categorie> categorie, String domaine,
				List<Mission> missions) {
			this.id = id;
			this.password = password;
			this.clientId = clientId;
			this.ville = ville;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.birthday = birthday;
			this.photo = photo;
			this.role = role;
			this.token = token;
			this.certifications = certifications;
			this.diplomes = diplomes;
			this.langues = langues;
			this.categorie = categorie;
			this.domaine = domaine;
			this.missions = missions;
		}










		public BricoleurModel(BricoleurModel bricoleurMap) {
			super();
            if(bricoleurMap.getId()!= 0)
            	
				this.id = (Integer)bricoleurMap.getId();
				this.photo = (String) bricoleurMap.getPhoto();
				this.firstName = (String) bricoleurMap.getFirstName();
				this.lastName = (String) bricoleurMap.getLastName();
				this.email = (String) bricoleurMap.getEmail();
		    	this.password=(String)bricoleurMap.getPassword();
				this.token=(String)bricoleurMap.getToken();
				
				this.categorie=(List<Categorie>)bricoleurMap.getCategorie();
				this.certifications=(List<Certification>)bricoleurMap.getCertifications();
				this.diplomes=(List<Diplomes>)bricoleurMap.getDiplomes();
				this.langues=(List<Langues>)bricoleurMap.getLangues();

		}
		
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		public List<Categorie> getCategorie() {
			return categorie;
		}





		public void setCategorie(List<Categorie> categorie) {
			this.categorie = categorie;
		}





		public List<Certification> getCertifications() {
			return certifications;
		}

		public void setCertifications(List<Certification> certifications) {
			this.certifications = certifications;
		}

		public List<Diplomes> getDiplomes() {
			return diplomes;
		}

		public void setDiplomes(List<Diplomes> diplomes) {
			this.diplomes = diplomes;
		}

		public List<Langues> getLangues() {
			return langues;
		}

		public void setLangues(List<Langues> langues) {
			this.langues = langues;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public Long getClientId() {
			return clientId;
		}
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "BricoleurModel [password=" + password + ", domaine=" + domaine + ", getClientId()=" + getClientId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getClientEmail()="
				+ getEmail() + ", getBirthday()=" + getBirthday() + ", getPhoto()=" + getPhoto() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String domaine;
	
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	@JsonManagedReference

	@ManyToMany
	@JoinTable(
			name="mission_brico",
			joinColumns=@JoinColumn(name="brico_id"),
			inverseJoinColumns=@JoinColumn(name="mission_id"))
	List<Mission> missions;
	
	public void addMission(Mission mission) {
		
		if (missions == null) {
			missions = new ArrayList<>();
		}
		
		missions.add(mission);
		

	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}	
	
	
}
