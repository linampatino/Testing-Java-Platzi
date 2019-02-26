package movies;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import movies.data.MovieDao;
import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;
import movies.services.MovieService;

public class MovieServiceShould {

	public MovieService movieService;
	
	@Before
	public void setup() {
		MovieDao movieRepository = Mockito.mock(MovieDao.class);
		Mockito.when(movieRepository.findAll()).thenReturn(
					Arrays.asList(
						new Movie(1,"movie 1", 90, Genre.THRILLER),
						new Movie(2,"hola mundo 2", 120, Genre.THRILLER),
						new Movie(3,"movie 3", 90, Genre.ACTION),
						new Movie(4,"Ola loca 4", 60, Genre.COMEDY),
						new Movie(5,"movie 5", 120, Genre.DRAMA),
						new Movie(6,"movie 6", 90, Genre.HORROR),
						new Movie(7,"movie 7", 90, Genre.COMEDY)
					)
				);
		
		movieService = new MovieService(movieRepository);
	}
	
	@Test
	public void return_movies_by_genre() {

		List<Movie> comedies = movieService.findMoviesByGenre(Genre.COMEDY);
		assertThat(getMovieIds(comedies), CoreMatchers.is(Arrays.asList(4, 7)));
	}
	
	@Test
	public void return_movies_by_length() {
		List<Movie> movies = movieService.findMoviesByLength(119);
		assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1, 3, 4, 6, 7)));
	}

	@Test
	public void load_movie_by_name() {
		List<Movie> movies = movieService.findMovieByName("ola");
		assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 4)));		
	}
	
	private List<Integer> getMovieIds(List<Movie> movies) {
		List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
		return movieIds;
	}
	
}
