package io.egen.test.dao;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
import io.egen.dao.MovieDaoImpl;
import io.egen.entity.Movie;

import io.igen.test.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MovieDaoTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private MovieDao dao = new MovieDaoImpl();

	@Mock
	private TypedQuery<Movie> query;
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
	public void testFindAll() {
		List<Movie> expected = Arrays.asList(movie);

		Mockito.when(em.createQuery("SELECT m FROM Movie m ORDER BY m.id ASC", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Movie> movies = dao.findAll();
		Assert.assertEquals(expected, movies);

	}

	@Test
	public void testFindById() {
		Mockito.when(em.find(Movie.class, movie.getId())).thenReturn(movie);
		Movie actual = dao.findById(movie.getId());

		Assert.assertEquals(movie, actual);
	}

	@Test
	public void testFindByTitle() {
		List<Movie> expected = Arrays.asList(movie);
		Mockito.when(em.createNamedQuery("Movie.findByTitle", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		Movie actual = dao.findByTitle(movie.getTitle());
		Assert.assertEquals(movie, actual);
	}

	@Test
	public void testFindByTitleNull() {

		Mockito.when(em.createNamedQuery("Movie.findByTitle", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(null);

		Movie actual = dao.findByTitle(movie.getTitle());
		Assert.assertEquals(null, actual);
	}

	@Test
	public void testCreate() {
		dao.create(movie);
		Mockito.verify(em).persist(movie);
	}

	@Test
	public void testUpdate() {
		dao.update(movie);
		Mockito.verify(em).merge(movie);
	}

	@Test
	public void testDelete() {
		dao.delete(movie);
		Mockito.verify(em).remove(movie);
	}

	@Test
	public void testInsertAll() {
		List<Movie> movies = Arrays.asList(movie);
		dao.insertAllMovie(movies);
		Mockito.verify(em).persist(movie);

	}

	@Test
	public void testFilterByType() {
		List<Movie> expected = Arrays.asList(movie);
		Mockito.when(em.createNamedQuery("Movie.filterByType", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Movie> actual = dao.filterByType(movie.getType());
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSortByRating() {
		List<Movie> expected = Arrays.asList(movie);

		Mockito.when(em.createQuery("SELECT m FROM Movie m ORDER BY m.imdbRating DESC ", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Movie> movies = dao.sortByRating();
		Assert.assertEquals(expected, movies);

	}
}
