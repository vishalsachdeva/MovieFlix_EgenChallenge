package io.egen.dao;

import io.egen.entity.Movie;
//import io.egen.entity.Users;
import io.egen.entity.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		
		TypedQuery<Movie> query  = em.createQuery("SELECT m FROM Movie m ORDER BY m.id ASC", Movie.class);
		List<Movie> movies= query.getResultList();
		return movies;
	}

	@Override
	public Movie findById(String Id) {
		Movie movie= em.find(Movie.class, Id);
		return movie;
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.findByTitle", Movie.class);
		qlString.setParameter("title",title);
         List<Movie> movie = qlString.getResultList();
          if (movie != null && movie.size() == 1 ) {
	         return movie.get(0);
             } 
          else {
	      return null;
	      }
      }


	@Override
	public Movie create(Movie movie) {
		 em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		for(Movie mv:movies){
			em.persist(mv);
		}
	}

	@Override
	public List<Movie> filterByType(String type) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.filterByType", Movie.class);
		qlString.setParameter("type",type);
		List<Movie> movie = qlString.getResultList();
		if (movie.size() >0) {
			return movie;
		} else {
			return null;
		}
	}
	@Override
	public List<Movie> filterByYear(String year) {
		TypedQuery<Movie> qlString = em.createNamedQuery(
				"Movie.filterByYear", Movie.class).setParameter("year",
						year);
		List<Movie> movie = qlString.getResultList();
		if (movie.size() >0) {
			return movie;
		} else {
			return null;
		}
	}
	@Override
	public List<Movie> filterByGenre(String genre) {
		TypedQuery<Movie> qlString = em.createNamedQuery(
				"Movie.filterByGenre", Movie.class).setParameter("genre","%"+
						genre+"%");
		List<Movie> movie = qlString.getResultList();
		if (movie.size() >0) {
			return movie;
		} else {
			return null;
		}
	}
	
	@Override
	public List<Movie> topRatedMovies(String type) {
		
		TypedQuery<Movie> qlString = em.createNamedQuery(
				"Movie.topRatedMovies", Movie.class).setParameter("type",
						type);
		List<Movie> movies= new ArrayList<Movie>();
		List<Movie> movie = qlString.getResultList();
		
		if (movie.size() >0) {
		for(int i=0;i<5;i++){
			movies.add(movie.get(i));
			
		}
		return movies;
			
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> sortByRating() {
		
		TypedQuery<Movie> qlString = em.createQuery("SELECT m FROM Movie m ORDER BY m.imdbRating DESC ", Movie.class);
		List<Movie> movies	=	qlString.getResultList();
		return movies;
	}

	@Override
	public List<Movie> sortByYear() {
		String qlString = "SELECT m FROM Movie m ORDER BY m.year DESC ";
		List<Movie> movies = em.createQuery(qlString, Movie.class)
				.getResultList();
		return movies;
	}

	@Override
	public List<Movie> sortByVotes() {
		String qlString = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC ";
		List<Movie> movies = em.createQuery(qlString, Movie.class)
				.getResultList();
		return movies;
	}

	

	

	

	
}
