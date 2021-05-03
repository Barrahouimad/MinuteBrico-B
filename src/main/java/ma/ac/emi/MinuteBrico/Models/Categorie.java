package ma.ac.emi.MinuteBrico.Models;
import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categorie{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;    
	private String nom;
	
	public Categorie() {
		
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	 public Categorie(Map<String,Object> CategorieMap) {
			if (CategorieMap.get("id") != null)	
				
			this.id = (int )CategorieMap.get("id");
			this.nom = (String )CategorieMap.get("name");

			
		}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + nom + "]";
	}
	
}
