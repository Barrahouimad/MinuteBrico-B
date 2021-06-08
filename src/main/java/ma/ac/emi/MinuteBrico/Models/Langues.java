package ma.ac.emi.MinuteBrico.Models;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Langues")
public class Langues {

	public Langues() {
		
	}
	public Langues(/*String level,*/String langue) {
		super();
	
		//setLevel(level);
		setLangue(langue);
	}
	
	 public Langues(Map<String,Object> CategorieMap) {
			if (CategorieMap.get("id") != null)	
				
			this.id = (int )CategorieMap.get("id");
			//this.level = (String )CategorieMap.get("level");
			this.langue = (String )CategorieMap.get("langue");

      }
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//private String level;
	private String langue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}*/
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
}
