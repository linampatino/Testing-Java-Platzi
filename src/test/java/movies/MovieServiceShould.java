package movies;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import movies.data.MovieDao;
import movies.data.MovieRepository;
import movies.services.MovieService;

public class MovieServiceShould {

	@Test
	public void return_movies_by_genre() {
		
		MovieDao movieRepository = Mockito.mock(MovieDao.class);
		
		MovieService movieService = new MovieService(movieRepository);
		movieService.findMoviesByGenre();
	}

}
