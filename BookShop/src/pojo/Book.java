package pojo;

public class Book {
	int bookId;
	String bookName,autorName,subjectName;
	float price;
	
	public Book() {
		
	}

	public Book(int bookId, String bookName, String autorName, String subjectName, float price) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.autorName = autorName;
		this.subjectName = subjectName;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getautorName() {
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", autorName=" + autorName + ", price=" + price + "]";
	}
	

}
