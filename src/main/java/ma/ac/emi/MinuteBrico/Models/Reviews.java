package ma.ac.emi.MinuteBrico.Models;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews  implements Serializable  {

	/**
	 *@author iliass Alilou
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	private String userName_Client;
	private int star ; 
	private String comment;
	
	public Reviews(){
		
	}


	public Reviews(String userName_Client, int star, String comment) {
		super();
		this.id=id;
		this.userName_Client = userName_Client;
		this.star = star;
		this.comment = comment;
	}
	
	
	 public Reviews(Map<String,Object> ReviewsMap) {
			if (ReviewsMap.get("id") != null)	
				
			this.id = (int )ReviewsMap.get("id");
			this.userName_Client = (String) ReviewsMap.get("userName_Client");
			this.star = (int) ReviewsMap.get("star");
			this.comment = (String) ReviewsMap.get("comment");
		
			
		}

	public String getUserName_Client() {
		return userName_Client;
	}

	public void setUserName_Client(String userName_Client) {
		this.userName_Client = userName_Client;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Reviews [id=" + id + ", userName_Client=" + userName_Client + ", star=" + star + ", comment=" + comment
				+ "]";
	}

	
}
