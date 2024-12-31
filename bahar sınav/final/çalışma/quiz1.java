import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class quiz1 {
    public static void main(String[] args) {
        // Queue<A> queue= new ConcurrentLinkedQueue<>();
        // queue.add(new A("q"));
        // System.out.println(queue.peek());
    }
}

interface Item extends Comparable<Item>{
    double getPrice();
    String getName();
}

interface PaymentMethod{
    boolean pay(List<Item> cart);
}

interface Colorable{
    void paint(String color);
}

abstract class  Product implements Item {
    private String name;
    private double price;
    
    public Product(String name, double price) throws InvalidPriceException {
        this.name = name;
        setPrice(price);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) throws InvalidPriceException {
        if(price<0)
            throw new InvalidPriceException(price);
        this.price = price;
    }
    @Override
    public int compareTo(Item o) {
        return Double.compare(price, o.getPrice());
    }
}

class Tax implements Item{
    private double taxRate;
    private Item item;
    
    public Tax(int taxRate, Item item) {
        this.taxRate = taxRate/100.0;
        this.item=item;
    }
    @Override
    public int compareTo(Item o) {
        return -1*(int)(o.compareTo(this));
    }
    @Override
    public double getPrice() {
        return item.getPrice()*(1.0+taxRate);
    }
    @Override
    public String getName() {
        return item.getName();
    }
}
class Discount implements Item{
    private double percent;
    private Item item;
    
    public Discount(int percent, Item item) {
        this.percent = percent/100.0;
        this.item=item;
    }
    @Override
    public int compareTo(Item o) {
        return -1*(int)(o.compareTo(this));
    }
    @Override
    public double getPrice() {
        return item.getPrice()*(1.0-percent);
    }
    @Override
    public String getName() {
        return item.getName();
    }
}

class CreditCard implements PaymentMethod{
    private long cardNumber;
    private String holderName;
    private Date expirationDate;
    private int cvv;
    
    public CreditCard(long cardNumber, String holderName, int cvv) throws CreditCardException {
        setCardNumber(cardNumber);
        this.holderName = holderName;
        setCvv(cvv);
        this.expirationDate= new Date(System.currentTimeMillis());
    }
    public void setCardNumber(Long cardNumber) throws CreditCardException{
        if(String.valueOf(cardNumber).length()!=16)
            throw new CreditCardException(cardNumber);
        this.cardNumber=cardNumber;
    }
    public void setCvv(int cvv) throws CreditCardException{
        if(String.valueOf(cvv).length()!=3)
            throw new CreditCardException(cvv);
        this.cvv=cvv;
    }
    @Override
    public boolean pay(List<Item> cart) {
        double total=0;
        for (Item item : cart) {
            Item item2= new Tax(4, item);
            total+=item2.getPrice();
        }
        System.out.println("Paid: " + total + " with " + this.getClass().getSimpleName() + holderName);
        cart.clear();
        return true;
    }
}

class PayPal implements PaymentMethod{
    private String username;
    private String password;
    
    public PayPal(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean pay(List<Item> cart) {
        double total=0;
        for (Item item : cart) {
            Item item2= new Discount(6, item);
            total+=item2.getPrice();
        }
        cart.clear();
        System.out.println("Paid: " + total + " with " + this.getClass().getSimpleName() + username);
        return true;
    }   
}

class Customer{
    private String name;
    private PaymentMethod paymentMethod;
    private List<Item> card;
    
    public Customer(String name) {
        this.name = name;
        card= new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public boolean addItem(Item item){
        Item item2= item;
        if(item instanceof Colorable)
            item2= new Discount(8, item2);
        if(item2.getPrice()>500)
            item2= new Tax(20, item2);
        item2= new Tax(12, item2);
        return card.add(item2);
    }
    public boolean removeItem(Item item){
        return card.remove(item);
    }
    public boolean purchase(){
        return this.paymentMethod.pay(this.card);
    }
    public void display(){
        card.sort(Comparable<Item>::compareTo);
        for (Item item : card) {
            System.out.println(item.getPrice()+" - "+item.getName());
        }
    }
}

class InvalidPriceException extends RuntimeException{
    private double price;
    InvalidPriceException(double price){
        super("ERROR: Invalid price: "+price);
        this.price=price;
    }
    public double getPrice() {
        return price;
    }
}
class CreditCardException extends Exception{
    private long cardNumber;
    private int cvv;
    CreditCardException(int cvv){
        super("ERROR: Invalid cvv "+cvv);
        this.cvv=cvv;
    }
    CreditCardException(long cardNumber){
        super("ERROR: Invalid cvv "+cardNumber);
        this.cardNumber=cardNumber;
    }
    public long getCardNumber() {
        return cardNumber;
    }
    public int getCvv() {
        return cvv;
    }
}

class A{
    String s;
    A(String a){
        s=a;
    }
    @Override
    public String toString() {
        return s;
    }
}