package ma.ac.emi.MinuteBrico.Models;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String firstName;
	private String lastName;
	private String email;
	private String birthday;
	private Byte photo ;
	private String role;
	private String token;
	private String password;
	@JsonManagedReference
@OneToMany(fetch=FetchType.EAGER,
mappedBy="client",
cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
List<Mission> missions;
	



	public Client(int id, String firstName, String lastName, String email, String birthday, Byte photo, String role,
			String token, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.photo = photo;
		this.role = role;
		this.token = token;
		this.password = password;
	}


	public Client() {
		super();
	}


	public Client(Map<String, Object> clientMap) {
		if(clientMap.get("id")!=null)
		this.id = (int) clientMap.get("id");
		this.firstName =(String) clientMap.get("firstName") ;
		this.lastName = (String) clientMap.get("lastName");
		this.email = (String) clientMap.get("email");
		this.birthday = (String) clientMap.get("birthday");
		this.photo = (Byte) clientMap.get("photo");
		this.role =(String) clientMap.get("role") ;
		this.token =(String) clientMap.get("token") ;
		this.password =(String) clientMap.get("password") ;


	}




	public int getId() {
		return id;
	}


	public void setId(int clientId) {
		this.id = clientId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
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





	@Override
	public String toString() {
		return "Client [clientId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", birthday=" + birthday + ", photo=" + photo + ", role=" + role 
				;
	}


	
}
