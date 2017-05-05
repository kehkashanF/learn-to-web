package DemoMain;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		
		String date = "2015-01-30";
		System.out.println(date);
		Date sqlDate = Date.valueOf(date);
		System.out.println(sqlDate);
	}
}
