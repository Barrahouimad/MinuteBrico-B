package ma.ac.emi.MinuteBrico.Models;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	

	
	public Client (int id, String firstName, String lastName, String email, String birthday, Byte photo) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setBirthday(birthday);
		setPhoto(photo);
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
	

	}




	public int getId() {
		return id;
	}


	public void setId(int clientId) {
		this.id = clientId;
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





	@Override
	public String toString() {
		return "Client [clientId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", birthday=" + birthday + ", photo=" + photo + ", role=" + role 
				;
	}


	
}
