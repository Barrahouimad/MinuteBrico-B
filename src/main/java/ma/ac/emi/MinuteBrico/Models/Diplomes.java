package ma.ac.emi.MinuteBrico.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Diplomes")
public class Diplomes {

	 public Diplomes(int id, byte photo) {
		 setId(id);
		 setPhoto(photo);
	 }
	 public Diplomes() {
		 
	 }
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private byte photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte getPhoto() {
		return photo;
	}
	public void setPhoto(byte photo) {
		this.photo = photo;
	}
	
}
