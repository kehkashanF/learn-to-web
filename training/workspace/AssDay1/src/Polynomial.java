public class Polynomial{
	Term []t=new Term[5];
	static int count;
	public Polynomial() {
		for(int i=0;i<5;i++)
			t[i]=new Term();
	}
	void setTerm(int coeff, int expo){
		
		if(count==5){
			System.out.println("Polynomial is:");
			count=0;
		}
		else
		{
			t[count]=new Term();
			boolean flag=false;
			for(int i=0;i<Term.count;i++)
			{
				
				if(t[i].getExponent()==t[count].getExponent())
				{
						System.out.println("This exponent already exists!");
						flag=true;
						break;
				}
				
			}
			if(t[count].getExponent()<0)
			{
				System.out.println("It is Negative and Not Allowed!");
				flag=true;
			}
			if(!flag){
				t[count].setExponent(expo);
				t[count].setCoefficient(coeff);
			}
		}	
		count++;
	}
	
	public void sort()
	{
		Term p;
		for(int i=0;i<4;i++)
		{
			for(int j=i;j<5;j++)
			{
				if(t[i].getExponent()<t[j].getExponent())
				{	
					p=t[j];
					t[j]=t[i];
					t[i]=p;	
				}	
			}
		}
		
	}
	
	public void display()
	{
		
		for(int i=0;i<5;i++)
		{
			System.out.print(t[i].getCoefficient()+"^"+t[i].getExponent()+" + ");
		}
	}

	public static void main(String[] args) {
		Polynomial p=new Polynomial();
		p.setTerm(3,8);
		p.setTerm(2,4);
		p.setTerm(8,3);
		p.setTerm(5,5);
		p.setTerm(6,6);
		p.sort();
		p.display();
	}
}