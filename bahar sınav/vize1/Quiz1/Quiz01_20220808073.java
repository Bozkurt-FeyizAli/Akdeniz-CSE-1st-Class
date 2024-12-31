import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Quiz01_20220808073{
    public static void main(String[] args) {
         
        
        
       
    }
}

interface  Item extends Comparable<Item>{
    public double getPrice();
    public String getName();
} 

interface PaymentMethod {
     public boolean pay(ArrayList<Item> cart);
}

interface Colorable{
    public void paint(String color);
}

abstract class Product implements Item{
    private String name;
    private double price;
    Product(String name, double price) throws InvalidPriceException{
        setName(name);
        setPrice(price);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) throws InvalidPriceException {
        if(price<0)
        throw new InvalidPriceException(price);
        this.price = price;
    }

} 

class Tax implements Item{
    private double taxRate;
    private Item item;
    Tax(int taxRate, Item item){
        setTaxRate(taxRate);
        setItem(item);
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate/100;
    }

    
    @Override
    public int compareTo(Item o) {
        return (int)(this.taxRate-o.getPrice());
    }

    @Override
    public double getPrice() {
        return item.getPrice()+item.getPrice()*taxRate;
    }

    @Override
    public String getName() {
        return item.getName();
    }
   
}

class  Discount implements Item{
    double percent;
    Item item;

    @Override
    public int compareTo(Item o) {
        return (int)(this.item.getPrice()-o.getPrice());
    }

    @Override
    public double getPrice() {
        return item.getPrice()+item.getPrice()*percent;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    Discount(int percent, Item item){
        setItem(item);
        setPercent(percent);
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public void setPercent(double percent) {
        this.percent = percent/100;
    }

    

}

class CreditCard implements PaymentMethod{
    private long cardNumber;
    private String holderName;
    private Date expirationDate;
    private int cvv;

    CreditCard(long cardNumber, String holderName, Date expirationDate, int cvv) throws CreditCardException{
        setCardNumber(cardNumber);
        setCvv(cvv);
        this.holderName=holderName;
        this.expirationDate= new Date(System.currentTimeMillis());
        
    }
    @Override
    public boolean pay(ArrayList<Item> cart) {
        double sumPrice=0;
        for (Item item : cart) {
            sumPrice+=item.getPrice();
        }
        cart.clear();
        System.out.println( "Paid: " + sumPrice + " with " + super.getClass().getSimpleName() + holderName );
        return true;
    }

    public void setCardNumber(long cardNumber) throws CreditCardException {
        try {
            if(cardNumber/Math.pow(10, 16)!=0&&!(cardNumber/Math.pow(10, 15)>0));
            throw new CreditCardException(cardNumber);
            
        } catch (CreditCardException e) {
            
        }
        this.cardNumber = cardNumber;
        
        
        
    }
    public void setCvv(int cvv)throws CreditCardException {
        try {
            if(cvv/Math.pow(10, 3)!=0&&!(cvv/Math.pow(10, 2)>0))
            throw new CreditCardException(cvv); 
        
        } catch (CreditCardException e) {
            
        }
        this.cvv = cvv;
    }   
}

class PayPal {
    private String username;
    private String password;
    PayPal(String username, String password){
        this.username=username;
        this.password=password;
    }

    public boolean pay(List<Item> cart){
        double sumPrice=0;
        for (Item item : cart) {
            sumPrice+=item.getPrice();
        }
        cart.clear();
        System.out.println( "Paid: " + sumPrice + " with " + super.getClass().getSimpleName() + username );
        return true;
    }
} 

class  Customer{
    private String name;
    private PaymentMethod paymentMethod;
    private ArrayList<Item> cart;
    Customer(String name){
        this.name=name;
        this.cart= new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public boolean addItem(Item item){
        if(item instanceof Colorable){
            cart.add(Product(item.getName(), (item.getPrice()+item.getPrice()*0.008)));
            cart.remove(item);
        

            return true;
        }
        if(item.getPrice()>500){
            cart.add(Product(item.getName(), (item.getPrice()+item.getPrice()*0.20)));
            cart.remove(item);
        }
        
            cart.add(Product(item.getName(), (item.getPrice()+item.getPrice()*0.12)));
            cart.remove(item);
        
         return true;
        // return false;
    }

    private Item Product(String name2, double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Product'");
    }
    public boolean removeItem(Item item){
        this.cart.remove(item);
        return true;
    }
    public boolean purchase(){
        paymentMethod.pay(cart);
        return true;
    }
    public void display(){
        cart.sort(Comparable<Item>::compareTo);
        for (Item item : cart) {
            System.out.println(item.getPrice()+" - "+item.getName());;
        }
    }

}
