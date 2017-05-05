import java.util.Comparator;


public class MovieComparator2 implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getLanguage().compareTo(o2.getLanguage())==-1)
					return -1;
		else if(o1.getLanguage().compareTo(o2.getLanguage())==1)
			return 1;
		else
			{	
			if(o1.getReleaseDate().before(o2.getReleaseDate()))return -1;
			else if(o1.getReleaseDate().after(o2.getReleaseDate())) return 1;
			else return 0;
			}
			
	}


		
}
