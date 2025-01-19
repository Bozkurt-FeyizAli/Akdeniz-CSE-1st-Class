public class HW03_20220808073{
    public static void main(String[] args) {

    }
}

class Author{
    private String name;
    private String surname;
    private String mail;
    Author(String name, String surname, String mail ){
        this.name=name;
        this.surname=surname;
        setMail(mail);
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}

class Book{
    private String isbn;
    private String title;
    private Author author;
    private double price;
    Book(String isbn, String title, Author author, double price){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        setPrice(price);
    }
    Book(String isbn, String title, Author author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        setPrice(15.25);
    }
    public Author getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
