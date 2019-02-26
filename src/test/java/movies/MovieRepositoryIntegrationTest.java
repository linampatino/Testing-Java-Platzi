package movies;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;

public class MovieRepositoryIntegrationTest {
	
	private MovieRepository movieRepository;
	private DataSource dataSource; 
	
	@Before
	public void setup() throws ScriptException, SQLException {
		dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
		
		movieRepository = new MovieRepository(jdbcTemplate);
	}
	
	@Test
	public void load_all_movies() throws ScriptException, SQLException {
		
		List<Movie> movies = movieRepository.findAll();
		
		assertThat(movies, CoreMatchers.is(Arrays.asList(
				new Movie(1,"movie 1", 90, Genre.THRILLER),
				new Movie(2,"movie 2", 120, Genre.THRILLER),
				new Movie(3,"movie 3", 90, Genre.ACTION)
			)));
	}
	
	@Test 
	public void load_movie_by_id() {
		Movie movie = movieRepository.findById(2);
		assertThat(movie, is(new Movie(2,"movie 2", 120, Genre.THRILLER)));
	}
	
		
	@Test
	public void insert_a_movie(){
		Movie movie = new Movie("movie 4", 90, Genre.ACTION);
		movieRepository.saveOrUpdate(movie);
		
		movie.setId(4);
		
		Movie movieSaved = movieRepository.findById(4);
		assertThat(movieSaved, is(movie));
	}
	
	@After
	public void tearDown() throws SQLException {
		final Statement st = dataSource.getConnection().createStatement(); 
		st.execute("drop all objects delete files");
	}

}
