package ma.ac.emi.MinuteBrico.Models;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;    
	private String nom;
	
	public Categorie() {
		
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
		
	}
	public Categorie(String nom,int id) {
		super();
		this.nom = nom;
		this.id=id;
	}
	 public Categorie(Map<String,Object> CategorieMap) {
			if (CategorieMap.get("id") != null)	
				
			this.id = (int )CategorieMap.get("id");
			this.nom = (String )CategorieMap.get("nom");
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
