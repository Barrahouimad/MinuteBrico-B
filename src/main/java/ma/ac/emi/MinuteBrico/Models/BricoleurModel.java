package ma.ac.emi.MinuteBrico.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//modeliser la table et les données de chaque classe
@Entity
@Table(name="Bricoleur")
public class BricoleurModel{
	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private int id;
		private String password;
		private Long clientId ;
		private String ville;
		private String firstName;
		private String lastName;
		private String email;
		private String birthday;
		private Byte photo ;
		private String role;
		public BricoleurModel() {
			
		}
		
		public BricoleurModel(String firstName,String birthday,String lastName,String password,String email,Byte photo,String ville, int id,String domaine) {
			
		    setId(id);
			setFirstName(firstName);
			setLastName(lastName);
			setEmail(email);
			setBirthday(birthday);
			setPhoto(photo);
			 setDomaine(domaine);
			 setPassword(password);
			 setVille(ville);
		   
	 }
	
		public BricoleurModel(Map<String, Object> bricoMap) {
			if(bricoMap.get("id")!=null)
			this.id = (int) bricoMap.get("id");
			this.firstName =(String) bricoMap.get("firstName") ;
			this.lastName = (String) bricoMap.get("lastName");
			this.email = (String) bricoMap.get("email");
			this.birthday = (String) bricoMap.get("birthday");
			this.photo = (Byte) bricoMap.get("photo");
			this.role =(String) bricoMap.get("role") ;
			this.ville =(String) bricoMap.get("ville") ;
			this.domaine =(String) bricoMap.get("domaine") ;


		}
		
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public Byte getPhoto() {
			return photo;
		}
		public void setPhoto(Byte photo) {
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
	@JsonBackReference
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
