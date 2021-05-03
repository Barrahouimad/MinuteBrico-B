package ma.ac.emi.MinuteBrico.Models;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Certification")
public class Certification implements Serializable {

    
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;	
	private String name_certification;
	private String name_centre;
	private String date_obtention;
	private String date_expiration;
	
	public Certification() {
		
	}
	
	public Certification(String name_certification,
			             String name_centre,
			             String date_obtention,
			             String date_expiration
			             ) {
		super();
		this.name_certification = name_certification;
		this.name_centre = name_centre;
		this.date_obtention = date_obtention;
		this.date_expiration = date_expiration;
	}
	
	
    public Certification(Map<String,Object> certificationMap) {
			if (certificationMap.get("id") != null)	
				
			this.Id = (int )certificationMap.get("id");
			this.name_certification = (String) certificationMap.get("name_certification");
			this.name_centre = (String) certificationMap.get("name_centre");
			this.date_obtention = (String) certificationMap.get("date_obtention");
			this.date_expiration = (String) certificationMap.get("date_expiration");
			
		}
		
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName_certification() {
		return name_certification;
	}
	public void setName_certification(String name_certification) {
		this.name_certification = name_certification;
	}
	public String getName_centre() {
		return name_centre;
	}
	public void setName_centre(String name_centre) {
		this.name_centre = name_centre;
	}
	public String getDate_obtention() {
		return date_obtention;
	}
	public void setDate_obtention(String date_obtention) {
		this.date_obtention = date_obtention;
	}
	public String getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(String date_expiration) {
		this.date_expiration = date_expiration;
	}
	@Override
	public String toString() {
		return "Certification [Id=" + Id + ", name_certification=" + name_certification + ", name_centre=" + name_centre
				+ ", date_obtention=" + date_obtention + ", date_expiration=" + date_expiration + "]";
	}
	
	
}