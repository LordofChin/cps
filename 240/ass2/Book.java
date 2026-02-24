public class Book 
{
    // fields/attributes
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // constructors
    public Book() {}
    public Book(String title, String author, String isbn) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

        // methods to borrow a book
        public void borrow()
        {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("You have borrowed: " + title);
            } else {
                System.out.println("Book is not available: " + title);
            }
        }

        // method to return a book
        public void returnBook() 
        {
            System.out.println("You have returned: " + title);
            isAvailable = true;
        }

    //getters
    public String getTitle() 
    {
        return title;
    }
    public String getAuthor() 
    {
        return author;
    }
    public String getIsbn() 
    {
        return isbn;
    }
    public boolean getIsAvailable() 
    {
        return isAvailable;
    }

    // setters
    public void setTitle(String title) 
    {
        this.title = title;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public void setIsAvailable(boolean isAvailable) 
    {
        this.isAvailable = isAvailable;
    }

}
