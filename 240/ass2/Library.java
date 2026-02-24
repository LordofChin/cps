import java.util.ArrayList;

public class Library 
{
    // fields/attributes
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    // constructors
    public Library() {}
    public Library(String name) 
    {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // method to add a book
    public void addBook(Book book) 
    {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // method to remove a book
    public void removeBook(Book book) 
    {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    //method to register a member
    public void registerMember(Member member) 
    {
        members.add(member);
        System.out.println("Registered member: " + member.getName());
    }

    //method to find a book by title
    public Book findBook(String title)
    {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    // getters
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

    // setters
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

}
