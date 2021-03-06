package movies.data;

import java.util.List;

import movies.model.Movie;

public interface MovieDao {
	public Movie findById(int id);
	public List<Movie> findAll();
	public void saveOrUpdate(Movie movie);
	
}
