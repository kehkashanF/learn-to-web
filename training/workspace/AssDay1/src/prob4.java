
public class prob4 {
public static void main(String[] args) {
	int A[]={3,2,4,5,6,4,5,7,3,2,3,4,7,1,2,0,0,0};
	int sum=0;
	int avg;
	int min=A[0];
	int i;
	for(i=0;i<15;i++)
	{
		sum=sum+A[i];
		if(min>A[i])
			min=A[i];
	}
	A[i]=sum;
	avg=sum/15;
	A[16]=avg;
	A[17]=min;
	
	for(i=0;i<18;i++)
	{
		System.out.print(A[i]+" ");
	}
}
}
