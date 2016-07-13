package io.egen.test.service;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.egen.dao.MovieDao;
import io.egen.entity.Movie;

import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;

import io.egen.service.MovieService;
import io.egen.service.MovieServiceImpl;
import io.igen.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieServiceTest {

	@Mock
	private MovieDao dao;
	
	@InjectMocks
	private MovieService service= new MovieServiceImpl();

	private Movie movie;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		movie = new Movie();
		movie.setId(UUID.randomUUID().toString());
		movie.setTitle("Avengers: Age of Ultron");
		movie.setYear("2015");
		movie.setRated("PG-13");
		movie.setReleased("01 May 2015");
		movie.setRuntime("141 min");
		movie.setGenre("Action, Adventure, Sci-Fi");
		movie.setDirector("Joss Whedon");
		movie.setWriter("Joss Whedon, Stan Lee (Marvel comics), Jack Kirby (Marvel comics)");
		movie.setActors("Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans");
		movie.setPlot(
				"When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.");
		movie.setLanguage("English");
		movie.setCountry("USA");
		movie.setAwards("1 win & 12 nominations.");
		movie.setPoster(
				"http://ia.media-imdb.com/images/M/MV5BMTU4MDU3NDQ5Ml5BMl5BanBnXkFtZTgwOTU5MDUxNTE@._V1_SX300.jpg");
		movie.setMetascore("66");
		movie.setImdbRating("7.6");
		movie.setImdbVotes("370,909");
		movie.setImdbID("tt2395427");
		movie.setType("movie");

	}

	
	@Test
	public void testFindALl()
	{
		service.findAll();
		Mockito.verify(dao).findAll();
		
	}
	
	@Test
	public void testFindById() throws MovieNotFoundException
	{
		Mockito.when(dao.findById(movie.getId())).thenReturn(movie);
		Movie actual = service.findById(movie.getId());
		Assert.assertEquals(movie, actual);
	}
	
	@Test
	public void testFindByTitle() throws MovieNotFoundException
	{
		Mockito.when(dao.findByTitle(movie.getTitle())).thenReturn(movie);
		Movie actual = service.findByTitle(movie.getTitle());
		Assert.assertEquals(movie, actual);
	}
	
	@Test
	public void testCreate() throws MovieAlreadyExitsException {
		Mockito.when(dao.findById(movie.getImdbID())).thenReturn(null);
		service.create(movie);
		Mockito.verify(dao).create(movie);

	}
	@Test(expected=MovieAlreadyExitsException.class)
	public void testCreateException() throws MovieAlreadyExitsException {
		Mockito.when(dao.findById(movie.getImdbID())).thenReturn(movie);
		service.create(movie);
		

	}
	
	@Test
	public void testDelete() throws MovieNotFoundException {
		Mockito.when(dao.findById(movie.getId())).thenReturn(movie);
		service.delete(movie.getId());
		Mockito.verify(dao).delete(movie);
	}

	@Test
	public void testUpdate() throws MovieNotFoundException  {
		Mockito.when(dao.findById(movie.getId())).thenReturn(movie);
		service.update(movie.getId(), movie);
		Mockito.verify(dao).update(movie);

	}
	@Test(expected = MovieNotFoundException .class)
	public void testUpdateException() throws MovieNotFoundException  {
		Mockito.when(dao.findById(movie.getId())).thenReturn(null);
		service.update(movie.getId(), movie);
		

	}
	
	
}
