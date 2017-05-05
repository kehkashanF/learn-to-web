package com.psl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



import com.psl.bean.Movie;
import com.psl.bean.Show;



public class PvrDAO {
	private  static List<Movie> movies = new CopyOnWriteArrayList<Movie>();
	
	static{
		
			List<Show> shows = new ArrayList<Show>();
			shows.add(new Show(1,"Monday", "12:30", 30));
			shows.add(new Show(2,"Tuesday", "9:30", 40));
			shows.add(new Show(3,"Wednesday", "1:30", 70));
			
			List<Show> shows1 = new ArrayList<Show>();
			shows1.add(new Show(1,"Monday", "12:30", 30));
			shows1.add(new Show(2,"Tuesday", "9:30", 40));
			shows1.add(new Show(3,"Wednesday", "1:30", 70));
			
			List<Show> shows2 = new ArrayList<Show>();
			shows2.add(new Show(1,"Monday", "12:30", 30));
			shows2.add(new Show(2,"Tuesday", "9:30", 40));
			shows2.add(new Show(3,"Wednesday", "1:30", 70));
			
			List<Show> shows3 = new ArrayList<Show>();
			shows3.add(new Show(1,"Monday", "12:30", 30));
			shows3.add(new Show(2,"Tuesday", "9:30", 40));
			shows3.add(new Show(3,"Wednesday", "1:30", 70));
			
			List<Show> shows4 = new ArrayList<Show>();
			shows4.add(new Show(1,"Monday", "12:30", 30));
			shows4.add(new Show(2,"Tuesday", "9:30", 40));
			shows4.add(new Show(3,"Wednesday", "1:30", 70));
			
			List<Show> shows5 = new ArrayList<Show>();
			shows5.add(new Show(1,"Monday", "12:30", 30));
			shows5.add(new Show(2,"Tuesday", "9:30", 40));
			shows5.add(new Show(3,"Wednesday", "1:30", 70));
			
		movies.add(new Movie(1, "Forrest Gump", shows));
		movies.add(new Movie(2, "Shawshank Redemption", shows1)); 
		movies.add(new Movie(3, "12 Angry Men", shows2));  
		movies.add(new Movie(4, "Interstellar", shows3)); 
		movies.add(new Movie(5, "Darkest Hour", shows4)); 
		movies.add(new Movie(6, "Queen", shows5));
		
	}
	
	
	public Movie getMovieById(int movieId) {
		Movie _movie = new Movie();
		_movie.setMovieId(movieId);
//		if(movies.indexOf(_movie)==-1)
//			throw new MovieNotFoundException();
//		else
			return movies.get(movies.indexOf(_movie));
		//to use indexOf you must override hashCode and equals methods in bean class
		//WebApplicationException(Response.status(Status.BAD_REQUEST).build())
	}

	public List<Movie> getMovieByName(String name){
		List<Movie> movList=new ArrayList<Movie>();
		
		for(Movie _mov : movies){
			
			if(_mov.getMovie().toLowerCase().contains(name.toLowerCase()))
				movList.add(_mov);
		}
		 return movList;
	}
	
	
	public boolean bookSeats(int movieId, int showId, int tickets) {
		Show _show = new Show();
		_show.setId(showId);
		
		Movie _movie = new Movie();
		_movie.setMovieId(movieId);
		
		
//		if(_movie.getShows().indexOf(_show)==-1)
//			throw new ShowNotFoundException();
//		else
//		{	
			
//			if(movies.get(movies.indexOf(_movie)).getShows().get(movies.get(movies.indexOf(_movie)).getShows().indexOf(_show)).getSeats()==0)
//			{
//				movies.get(movies.indexOf(_movie)).getShows().remove(movies.get(movieId).getShows().indexOf(_show));
//				return false;
//			}
//			else
//			{
				
				if(movies.get(movies.indexOf(_movie)).getShows().get(movies.get(movieId).getShows().indexOf(_show)).getSeats()>=tickets)
				{
					movies.get(movies.indexOf(_movie)).getShows().get(movies.get(movies.indexOf(_movie)).getShows().indexOf(_show)).
								setSeats(movies.get(movies.indexOf(_movie)).getShows().get(movies.get(movies.indexOf(_movie)).getShows().
												indexOf(_show)).getSeats()-tickets);
					return true;
				}
				else
					return false;
//			}
			
		//}
		
	}

	public List<Movie> getAllMovies() {
		return movies;
	}


	
	
//	if(movieList.get(id).getShows().get(showid).getTickets()>tickets)
//	{
//	movieList.get(id).getShows().get(showid).setTickets(movieList.get(id).getShows().get(showid).getTickets()-tickets);
//	return movieList.get(id);
//	}
//	else
//	 
//	return null;
//	 
	
//	public void deleteMovie(int id) {
//		Movie _movie=getMovieById(id);
//		
//		movies.remove(movies.indexOf(_movie));
//		
//		
//	}
//
//	public void save(Customer customer) {
//		customers.add(customer);
//		
//	}
//
//
//	public Customers getCustomers(int start, int size) {
//		Customers _customers=new Customers();
//		_customers.setCustomers(customers.subList(start, start+size));
//		
//		return _customers;
//	}


}
