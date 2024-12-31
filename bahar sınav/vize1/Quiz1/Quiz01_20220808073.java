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

