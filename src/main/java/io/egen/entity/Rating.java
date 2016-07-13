package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_rating")
@NamedQueries(@NamedQuery(name = "Rating.findRatingByMovie", query = "SELECT r FROM Rating r WHERE r.movie = :movie"))

public class Rating {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	private Long rating;

	@OneToOne
	private Movie movie;
	@ManyToOne
	private Users user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	

}
