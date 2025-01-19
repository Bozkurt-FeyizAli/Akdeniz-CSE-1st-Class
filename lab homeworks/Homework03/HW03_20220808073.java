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

class EBook extends Book{
    String downloadUrl;
    String sizeMb;

    EBook(String isbn, String title, Author author, double price, String downloadUrl, String sizeMb ) {
        super(isbn, title, author, price);
        this.downloadUrl=downloadUrl;
        this.sizeMb=sizeMb;
    } 
    EBook(String isbn, String title, Author author, String downloadUrl, String sizeMb ) {
        super(isbn, title, author);
        this.downloadUrl=downloadUrl;
        this.sizeMb=sizeMb;
    } 
    public String getDownloadUrl() {
        return downloadUrl;
    }
    public String getSizeMb() {
        return sizeMb;
    }
}

class PaperBook extends Book{
    int shippingWeight;
    boolean inStock;

    PaperBook(String isbn, String title, Author author, double price, int shippingWeight, boolean inStock) {
        super(isbn, title, author, price);
        this.shippingWeight=shippingWeight;
        setInStock(inStock);
    }
    PaperBook(String isbn, String title, Author author, boolean inStock) {
        super(isbn, title, author);
        this.shippingWeight=(int)(Math.random()*11)+5;
        setInStock(inStock);
    }
    public int getShippingWeight() {
        return shippingWeight;
    }
    public boolean getInStock(){
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    
}

