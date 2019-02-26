package movies.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Movie {
	
	private Integer id;
	private String name;
	private int minutes;
	private Genre genre;
	
	public Movie(String name, int minutes, Genre genre) {
		this(null, name, minutes, genre);
	}
	
	public Movie(Integer id, String name, int minutes, Genre genre) {
		super();
		this.id = id;
		this.name = name;
		this.minutes = minutes;
		this.genre = genre;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null || getClass() != obj.getClass())
			return false;
					
		Movie other = (Movie) obj;
		return genre == other.genre 
				&& Objects.equals(id, other.id) 
				&& Objects.equals(name, other.name)
				&& minutes == other.minutes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, minutes, genre);
	}

	
	
}
