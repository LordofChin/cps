<<<<<<< HEAD
public class Member {
    
=======
import java.util.ArrayList;

public class Member 
{
    // fields/attributes
    private String name;
    private String memberId;
    private ArrayList<Book> borrowedBooks;

    // constructors
    public Member(){}
    public Member(String name, String memberId, ArrayList<Book> borrowedBooks) 
    {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = borrowedBooks;
    }
    public Member(String name, String memberId) 
    {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // method to borrow a book
    public void borrowBook(Book book) 
    {
        if (book.getIsAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
        } else {
            System.out.println("Cannot borrow: " + book.getTitle());
        }
    }

    // method to return a book
    public void returnBook(Book book) 
    {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("You did not borrow: " + book.getTitle());
        }
    }

    // getters
    public String getName() 
    {
        return name;
    }
    public String getMemberId()
    {
        return memberId;
    }
    public ArrayList<Book> getBorrowedBooks() 
    {
        return borrowedBooks;
    }

    // setters
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }
    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) 
    {
        this.borrowedBooks = borrowedBooks;
    }
>>>>>>> 9139c2fcc23c777c856769d93f62f25404a7ee62
}
