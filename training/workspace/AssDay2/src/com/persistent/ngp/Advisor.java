package com.persistent.ngp;

public class Advisor {
		public String [] advice=new String[5];
		
		public Advisor() {
				advice[0]="Never say No!";
				advice[1]="Forwarned is forearmed";
				advice[2]="Rai ka pahad mat banao";
				advice[4]="Work hard, sleep harder";
				
		}
		
		public String getAdvice()
		{
			int rand=(int)((Math.random()*10)%5);
			return "Advice: "+ advice[rand];
		}
}
