public class Book 
{
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book() {}
    public Book(String title, String author, String isbn) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

        public void borrow()
        {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("You have borrowed: " + title);
            } else {
                System.out.println("Book is not available: " + title);
            }
        }

        public void returnBook() 
        {
            System.out.println("You have returned: " + title);
            isAvailable = true;
        }

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
