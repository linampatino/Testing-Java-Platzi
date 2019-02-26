package movies.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import movies.model.Genre;
import movies.model.Movie;

public class MovieRepository implements MovieDao{

	private JdbcTemplate jdbcTemplate;
		
	public MovieRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie findById(int id) {
		Object[] args = {id};
		return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
	}

	@Override
	public List<Movie> findAll() {
		return this.jdbcTemplate.query("select * from movies", movieMapper);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		jdbcTemplate.update("insert into movies(name, minutes, genre) values(?,?,?)",  movie.getName(), movie.getMinutes(), movie.getGenre().toString());
	}
	
	private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
		@Override
		public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Movie(
					resultSet.getInt("id"), 
					resultSet.getString("name"),
					resultSet.getInt("minutes"),
					Genre.valueOf(resultSet.getString("genre")));
			
		}
	};
}
