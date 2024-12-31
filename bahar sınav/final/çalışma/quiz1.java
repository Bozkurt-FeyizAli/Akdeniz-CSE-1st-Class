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
