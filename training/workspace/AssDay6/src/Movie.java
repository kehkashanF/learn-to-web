import java.sql.Time;
import java.util.Comparator;
import java.util.Date;


public class Movie implements Comparable<Movie>{
			private String name;
			private String language;
			private Date releaseDate;
			private String director;
			private String producer; 
			private float duration;
			public Movie(String name, String language, Date releaseDate,
					String director, String producer, float duration) {
				super();
				this.name = name;
				this.language = language;
				this.releaseDate = releaseDate;
				this.director = director;
				this.producer = producer;
				this.duration = duration;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getLanguage() {
				return language;
			}
			public void setLanguage(String language) {
				this.language = language;
			}
			public Date getReleaseDate() {
				return releaseDate;
			}
			public void setReleaseDate(Date releaseDate) {
				this.releaseDate = releaseDate;
			}
			public String getDirector() {
				return director;
			}
			public void setDirector(String director) {
				this.director = director;
			}
			public String getProducer() {
				return producer;
			}
			public void setProducer(String producer) {
				this.producer = producer;
			}
			public float getDuration() {
				return duration;
			}
			public void setDuration(float duration) {
				this.duration = duration;
			}
			@Override
			public String toString() {
				return "Name = " + name + "\nLanguage=" + language
						+ "\nRelease Date =" + releaseDate + "\nDirector = "
						+ director + "\nProducer = " + producer + "\nDuration = "
						+ duration + "\n";
			}
		
			@Override
			public int compareTo(Movie o) {
				return this.language.compareToIgnoreCase(o.getLanguage());
			}
			
			
}
