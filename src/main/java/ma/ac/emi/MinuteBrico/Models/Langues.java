package ma.ac.emi.MinuteBrico.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Langues")
public class Langues {

	public Langues() {
		
	}
	public Langues(int id,String level,String langue) {
		setId(id);
		setLevel(level);
		setLangue(langue);
	}
	@Id
	private int id;
	private String level;
	private String langue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
}
