package io.egen.dao;

import io.egen.entity.Comment;
import io.egen.entity.Movie;
import io.egen.entity.Users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Comment findComment(Movie movie, Users user) {
		TypedQuery<Comment> qlString = em
				.createNamedQuery("Comment.findCommentByMovieAndUser",
						Comment.class).setParameter("movie", movie)
				.setParameter("user", user);
		List<Comment> comment = qlString.getResultList();
		if (comment != null && comment.size() == 1) {
			return comment.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Comment addComment(Comment com) {
		return em.merge(com);
	}

	@Override
	public List<Comment> findCommentByMovie(Movie movie) {
		TypedQuery<Comment> qlString = em.createNamedQuery(
				"Comment.findCommentByMovie", Comment.class).setParameter(
				"movie", movie);
		List<Comment> comment = qlString.getResultList();
		if (comment != null) {
			return comment;
		} else {
			return null;
		}

	}

}
