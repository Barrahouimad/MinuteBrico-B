package ma.ac.emi.MinuteBrico.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {

	/**
	 *@author iliass Alilou
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	private String userName_Client;
	private int star ; 
	private String comment;
	
	public Reviews(){
		
	}


	public Reviews(String userName_Client, int star, String comment) {
		super();
		this.userName_Client = userName_Client;
		this.star = star;
		this.comment = comment;
	}


	public String getUserName_Client() {
		return userName_Client;
	}

	public void setUserName_Client(String userName_Client) {
		this.userName_Client = userName_Client;
	}

	public Reviews (Reviews ReviewsMap) {
		super();

		if (ReviewsMap.getId() != null)
			
		this.id = (Long)ReviewsMap.getId();
		this.userName_Client =(String)ReviewsMap.getUserName_Client();
		this.star= (Integer) ReviewsMap.getStar();
		this.comment = (String) ReviewsMap.getComment();
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
