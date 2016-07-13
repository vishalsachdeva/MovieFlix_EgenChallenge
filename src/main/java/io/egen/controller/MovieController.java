package io.egen.controller;

import java.util.List;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
@Api(tags = "movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find All Movie", notes = "Returns the list of movies in the system.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find Movie from Specified ID", notes = "Returns the Movie from the system with same ID.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Movie findById(@PathVariable("id") String id)
			throws MovieNotFoundException {
		return service.findById(id);
	}

	@RequestMapping(value = "title/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find Movie from Specified title", notes = "Returns the Movie from the system with mentioned title.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Movie findByTitle(@PathVariable("title") String title)
			throws MovieNotFoundException {
		return service.findByTitle(title);
	}
	@RequestMapping(value = "filter/type/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Filter by particular type", notes = "Returns the Movies from the system with particular type .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> filterByType(@PathVariable("type") String type)
			throws MovieNotFoundException {
		return service.filterByType(type);
	}
	
	@RequestMapping(value = "filter/year/{year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Filter by particular year", notes = "Returns the Movies from the system with particular year .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> filterByYear(@PathVariable("year") String year)
			throws MovieNotFoundException {
		return service.filterByYear(year);
	}
	
	@RequestMapping(value = "filter/genre/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Filter by particular genre", notes = "Returns the Movies from the system with particular genre .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> filterByGenre(@PathVariable("genre") String genre)
			throws MovieNotFoundException {
		return service.filterByGenre(genre);
	}
	@RequestMapping(value = "topRated/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get 5 top rated movies", notes = "Returns the 5 top rated movies from the system  .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Movie is not found in the system"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> topRatedMovies(@PathVariable("type") String type)
			throws MovieNotFoundException {
		return service.topRatedMovies(type);
	}
	
	@RequestMapping(value = "sort/rating",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "sort all movies by rating", notes = "Returns the list of movies sorted by rating.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> sortByRating() {
		return service.sortByRating();
	}
	
	@RequestMapping(value = "sort/year",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "sort all movies by year", notes = "Returns the list of movies sorted by year.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(value = "sort/votes",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "sort all movies by votes", notes = "Returns the list of movies sorted by votes.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<Movie> sortByVotes() {
		return service.sortByVotes();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a new movie", notes = "Create the new movie in the system if it is not present in system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Movie create(@RequestBody Movie movie)
			throws MovieAlreadyExitsException {
		return service.create(movie);
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "Enter the movie list", notes = "Enter all movie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void insertAllMovie(@RequestBody List<Movie> Movies){
		service.insertAllMovie(Movies);
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Movie", notes = "Update an existing Movie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie)
			throws MovieNotFoundException {
		return service.update(id, movie);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete Movie", notes = "Delete an existing Movie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void delete(@PathVariable("id") String id)
			throws MovieNotFoundException {
		service.delete(id);
	}

}
