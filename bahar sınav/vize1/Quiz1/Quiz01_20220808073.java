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
