package ma.ac.emi.MinuteBrico.Models;
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
	private Long clientId ;
	private String firstName;
	private String lastName;
	private String email;
	private String birthday;
	private Byte photo ;
	private String role;
	
	@OneToOne
	private ClientAccount clientAccount;
	
	
	public Client (long id, String firstName, String lastName, String email, String birthday, Byte photo) {
		super();
		setClientId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setBirthday(birthday);
		setPhoto(photo);
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


	public ClientAccount getClientAccount() {
		return clientAccount;
	}


	public void setClientAccount(ClientAccount clientAccount) {
		this.clientAccount = clientAccount;
	}


	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", birthday=" + birthday + ", photo=" + photo + ", role=" + role + ", clientAccount="
				+ clientAccount + "]";
	}


	
}
