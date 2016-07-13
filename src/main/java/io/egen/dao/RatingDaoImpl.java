package io.egen.dao;

import io.egen.entity.Movie;
import io.egen.entity.Rating;
import io.egen.entity.Users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RatingDaoImpl implements RatingDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Rating addRating(Rating rating) {
		return em.merge(rating);
	}

	@Override
	public List<Rating> findRatingByMovie(Movie movie) {
		TypedQuery<Rating> qlString = em.createNamedQuery(
				"Rating.findRatingByMovie", Rating.class).setParameter("movie",
				movie);
		List<Rating> rating = qlString.getResultList();
		if (rating != null) {
			return rating;
		} else {
			return null;
		}

	}

	@Override
	public Rating findRating(Movie movie, Users user) {
		TypedQuery<Rating> qlString = em
				.createQuery(
						"SELECT r FROM Rating r WHERE r.movie = :movie and r.user= :user",
						Rating.class).setParameter("movie", movie)
				.setParameter("user", user);
		List<Rating> rating = qlString.getResultList();
		if (rating != null && rating.size() == 1) {
			return rating.get(0);
		} else {
			return null;
		}
	}

}
