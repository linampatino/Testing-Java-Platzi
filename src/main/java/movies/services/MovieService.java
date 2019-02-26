package movies.services;

import java.util.List;
import java.util.stream.Collectors;

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
		return movieRepository
				.findAll()
				.stream()
				.filter(movie -> movie.getGenre() == genre)
				.collect(Collectors.toList());
	}

	public List<Movie> findMoviesByLength(int length) {
		return movieRepository
				.findAll()
				.stream()
				.filter(movie -> movie.getMinutes() <= length)
				.collect(Collectors.toList());
	}

	public List<Movie> findMovieByName(String name){
		return movieRepository
				.findAll()
				.stream()
				.filter(movie -> movie.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());
	}
}
