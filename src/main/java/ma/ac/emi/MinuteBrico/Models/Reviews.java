package ma.ac.emi.MinuteBrico.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reviews")
public class Reviews {
	public Reviews() {
		
	}
	public Reviews(String comment,int id, int stars) {
		setComment(comment);
		setStars(stars);
		setId(id);
	}
	
 @Id
 private int id;
 private String comment;
 private int stars;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getStars() {
	return stars;
}
public void setStars(int stars) {
	this.stars = stars;
}
 
	
}
