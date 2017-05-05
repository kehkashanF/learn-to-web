
public class TestMedicine {
	public static void main(String[] args) {
		Medicine []m= new Medicine[10];
		int rand;
		
		for(int i=0;i<10;i++)
		{
			rand=(int)(((Math.random()*10)%3)+1);
			if(rand==1)
			{
				m[i]=new Tablet();
				m[i].displayLabel();
				System.out.println();
			}
			else if(rand==2)
			{
				m[i]=new Syrup();
				m[i].displayLabel();
				System.out.println();
			}
			
			else 
			{
				m[i]=new Ointment();
				m[i].displayLabel();
				System.out.println();
			}
		
		}	
	}
}
