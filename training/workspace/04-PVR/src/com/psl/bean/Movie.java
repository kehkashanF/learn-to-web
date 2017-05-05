package com.psl.bean;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="movie")
public class Movie {
		private int movieId;
		private String movie;
		private List<Show> shows;

		public Movie() {
			// TODO Auto-generated constructor stub
		} 
		public Movie(int movieId, String movie, List<Show> shows) {
			super();
			this.movieId=movieId;
			this.movie = movie;
			this.shows = shows;
		}

		@XmlAttribute(name="movieId")
		public int getMovieId() {
			return movieId;
		}
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		
		@XmlElement(name="Movie")
		public String getMovie() {
			return movie;
		}

		public void setMovie(String movie) {
			this.movie = movie;
		}

		@XmlElement(name="Shows")
		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + movieId;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Movie other = (Movie) obj;
			if (movieId != other.movieId)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Movie [movieId=" + movieId + ", movie=" + movie
					+ ", shows=" + shows + "]";
		}

		
		
		
		
}
