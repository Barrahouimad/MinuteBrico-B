package ma.ac.emi.MinuteBrico.Models;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="clientAccount")
public class ClientAccount {

	@Id
	private Long id ;
	private String fisrtName;
	private String lastName;
	
	@NotNull
	private String clientEmail;
	@NotNull
	private String clientPassword;
	@Column(length = 256)
	private String creationDate;
	
	
	public ClientAccount() {
		
	}
	
	
	
	public ClientAccount(Long id, String fisrtName, String lastName, String clientEmail, String clientPassword,
			String creationDate) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.clientEmail = clientEmail;
		this.clientPassword = clientPassword;
		this.creationDate = creationDate;
	}



	public ClientAccount(Map<String,Object> userMap) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime today = LocalDateTime.now();

		if (userMap.get("id") != null)
		
		this.id = (Long)userMap.get("id");
		this.clientEmail = (String) userMap.get("clientEmail");
		this.fisrtName = (String) userMap.get("fisrtName");
		this.lastName = (String) userMap.get("lastName");
		this.clientPassword = (String) userMap.get("clientPassword");
		this.creationDate =  formatter.format(today);
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFisrtName() {
		return fisrtName;
	}



	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getClientEmail() {
		return clientEmail;
	}



	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}



	public String getClientPassword() {
		return clientPassword;
	}



	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}



	@Override
	public String toString() {
		return "ClientAccount [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", clientEmail="
				+ clientEmail + ", clientPassword=" + clientPassword + ", creationDate=" + creationDate + "]";
	}
	
	
}
