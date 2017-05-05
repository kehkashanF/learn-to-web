
public class BookMain {
	
	public Book createBook(String bookName, double bookPrice)
	{
		Book book1 = new Book();
		book1.setBookName(bookName);
		book1.setBookPrice(bookPrice);
		return book1;
		
	}
	public void ShowBook(Book book)
	{
		System.out.println("Name: "+book.getBookName());
		System.out.println("Price:"+book.getBookPrice());
		
	}
	public static void main(String[] args) {
		
		
		BookMain b=new  BookMain();
		Book b2=new Book();
		b2=b.createBook("Harry Potter", 199.00);
		b.ShowBook(b2);
		
	}
}
