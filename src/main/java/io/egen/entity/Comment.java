package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_comment")
@NamedQueries({
		@NamedQuery(name = "Comment.findCommentByMovie", query = "SELECT c FROM Comment c WHERE c.movie = :movie"),
		@NamedQuery(name = "Comment.findCommentByMovieAndUser", query = "SELECT c FROM Comment c WHERE c.movie = :movie and c.user= :user") })

public class Comment {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	private String comment;

	@ManyToOne
	private Movie movie;

	@ManyToOne
	private Users user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
