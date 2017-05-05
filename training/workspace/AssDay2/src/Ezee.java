import java.io.*;


public class Ezee {
	 static String[] products= new String[4];
	 String keyword;
	
	static String[] initProductNames(){
		int n = 0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of products to enter in system: ");
		try {
			n=Integer.parseInt(br.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Enter product names: ");
		try {
			for(int i=0;i<n;i++)
			{
				products[i]=br.readLine();
			}
			System.out.println("Products in catalogue are: ");
			for(int i=0;i<n;i++)
			{
				System.out.println(products[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}
	static boolean isPresent(String[] productNames, String keyword)
	{
		boolean flag=false;
		
		for(int i=0; i<products.length; ++i)
		{
			if(products[i].contains(keyword))
			{
				System.out.println("Product: "+products[i]+" contains keyword: "+keyword);
				return true;
			}
		}
		return flag;
		
	}

	public static void main(String[] args) throws IOException{
		String []products1;
		String keyword=null;
		products1=initProductNames();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter keyword to search for product: ");
		try {
			keyword=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean flag1;
		flag1=isPresent(products1, keyword);
		if(flag1)
			System.out.println("Product found!");
		else
			System.out.println("Product not found!");
		
		
		
	}
}
