package movies.services;

import java.util.List;

import movies.data.MovieDao;
import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;

public class MovieService {

	private MovieDao movieRepository;
		
	public MovieService(MovieDao movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	public List<Movie> findMoviesByGenre(Genre genre) {
		return movieRepository.findAll();
	}

}
