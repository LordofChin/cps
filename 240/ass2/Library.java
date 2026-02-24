<<<<<<< HEAD
public class Library {
    
=======
import java.util.ArrayList;

public class Library 
{
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {}

    public Library(String name) 
    {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) 
    {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }
    public void removeBook(Book book) 
    {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }
    public void registerMember(Member member) 
    {
        members.add(member);
        System.out.println("Registered member: " + member.getName());
    }
    public Book findBook(String title)
    {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    public String getName()
    {
        return name;
    }
    public ArrayList<Book> getBooks() 
    {
        return books;
    }
    public ArrayList<Member> getMembers()
    {
        return members;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public void setBooks(ArrayList<Book> books)
    {
        this.books = books;
    }
    public void setMembers(ArrayList<Member> members) 
    {
        this.members = members;
    }

>>>>>>> 9139c2fcc23c777c856769d93f62f25404a7ee62
}
