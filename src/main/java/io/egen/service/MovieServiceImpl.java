package io.egen.service;

import io.egen.dao.MovieDao;
import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao dao;

	@Override
	public List<Movie> findAll() {
		return dao.findAll();
	}

	@Override
	public Movie findById(String Id) throws MovieNotFoundException {
		Movie movie=dao.findById(Id);
		if(movie==null){
			throw new MovieNotFoundException() ;
		}else{
		return movie;
		}
	}
	

	@Override
	public Movie findByTitle(String title) throws MovieNotFoundException {
		Movie movie=dao.findByTitle(title);
		if(movie==null){
			throw new MovieNotFoundException() ;
		}else{
		return movie;
		}
	}
	@Override
	public List<Movie> filterByType(String type) {
		List<Movie> movie=dao.filterByType(type);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}
	
	@Override
	public List<Movie> filterByGenre(String genre) {
		List<Movie> movie=dao.filterByGenre(genre);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}

	@Override
	public List<Movie> filterByYear(String year) {
		List<Movie> movie=dao.filterByYear(year);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}
	
	@Override
	public List<Movie> topRatedMovies(String type) {
		List<Movie> movie= dao.topRatedMovies(type);
		if(movie.size()==0){
			return null;
		}
		else{
		return movie;
		}
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExitsException {
		Movie existing =  dao.findById(movie.getImdbID());
		if(existing == null) {
			return dao.create(movie);
		}
		else {
			throw new MovieAlreadyExitsException();
		}
		
	}

	@Override
	public Movie update(String Id, Movie movie) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			return dao.update(movie);
		}
	}

	@Override
	public void delete(String Id) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			dao.delete(existing);
		}
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		dao.insertAllMovie(movies);
		
	}

	@Override
	public List<Movie> sortByRating() {
		
		return dao.sortByRating();
	}

	@Override
	public List<Movie> sortByYear() {
		return dao.sortByYear();
	}

	@Override
	public List<Movie> sortByVotes() {
		return dao.sortByVotes();
	}

	

	
	



	
}
