package ma.ac.emi.MinuteBrico.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//modeliser la table et les données de chaque classe
@Entity
@Table(name="Bricoleur")
public class BricoleurModel{
	 @Id
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
	
	
	
	
}
