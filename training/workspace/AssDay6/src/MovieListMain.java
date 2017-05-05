import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class MovieListMain {

		public List<Movie> createMovieList(){
			List<Movie> list=new ArrayList<Movie>();
			String name;
			String language;
			Date releaseDate;
			String director;
			String producer; 
			float duration;
			int ch;
			try {
				Scanner s=new Scanner(System.in);
				do{
					System.out.println("Movie Name: ");
					name=s.nextLine();
					System.out.println("Language: ");
					language=s.nextLine();
					System.out.println("Date: ");
					String str=s.nextLine();
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					releaseDate=sdf.parse(str);
					System.out.println("Director: ");
					director=s.nextLine();
					System.out.println("Producer: ");
					producer=s.nextLine();
					System.out.println("Duration: ");
					duration=Float.parseFloat(s.nextLine());
					Movie m=new Movie(name, language, releaseDate, director, producer, duration);
					list.add(m);
					System.out.println("Continue? (0/1)");
					ch=Integer.parseInt(s.nextLine());
				}while(ch==1);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return list;
			
		}
		
		public void sortByLanguage(List<Movie> list)
		{
			Collections.sort(list);
			System.out.println("By Language: "+list);
		}
		
		public void sortbyDuration(List<Movie> list)
		{
			Collections.sort(list, new MovieComparator());
			System.out.println("By Duration: "+list);
		}
		
		public void tooMuchSort(List<Movie> list){
			Collections.sort(list, new MovieComparator2());
			System.out.println("By too much: "+list);
		}
		public static void main(String[] args) {
			MovieListMain ml=new MovieListMain();
			 List<Movie> list1=new ArrayList<Movie>();
			list1=ml.createMovieList();
			System.out.println(list1);
			
			ml.sortByLanguage(list1);
			
			ml.sortbyDuration(list1);
			
			ml.tooMuchSort(list1);
			
			
		}
}
