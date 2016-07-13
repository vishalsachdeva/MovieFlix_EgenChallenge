package io.egen.dao;

import io.egen.entity.Movie;

import java.util.List;


public interface MovieDao {
	
	List<Movie> sortByRating();
	public List<Movie> findAll();
	public Movie findById(String Id);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	public void insertAllMovie(List<Movie> movies);
	public List<Movie> filterByType(String type);
	List<Movie> sortByYear();
	List<Movie> sortByVotes();
	Movie findByTitle(String title);
	List<Movie> filterByYear(String year);
	List<Movie> filterByGenre(String genre);
	List<Movie> topRatedMovies(String type);
}
