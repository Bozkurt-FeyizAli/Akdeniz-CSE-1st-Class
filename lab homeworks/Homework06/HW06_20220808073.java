public class HW06_20220808073{
    public static void main(String[] args){
        
    }
}

interface Sellable{
    public String getName();
    public double getPrice();
}
interface Package <T>{
    public T extract();
    public boolean pack(T item);
    public boolean isEmpty();
}
interface Wrappable extends Sellable{

}

abstract class Product implements Sellable{
    private String name;
    private double price;
    Product(String name, double price){
        setName(name);
        setPrice(price);
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getPrice(){
        return price;
    }
    private void setName(String name){
        this.name = name;
    }
    private void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " (" + name + ", " + getPrice() + ")"; 
    }
}
class Mirror extends Product{
    private int width;
    private int height;
    Mirror(int width, int height){
        super("mirror",2);
        setHeight(height);
        setWidth(width);
    }
    private void setHeight(int height){
        this.height = height;
    }
    private void setWidth(int width){
        this.width = width;
    }
    // public int getHeight(){
    //     return height;
    // }
    // public int getWidth(){
    //     return width;
    // }
    public int getArea(){
        return height*width;
    }
    @Override
    public double getPrice(){
        return super.getPrice()*getArea();
    }
    public <T> T reflect(T item){
        System.out.println("reflected item: " + item);
        return item;
    }
    // @Override
    // public String toString(){
    //     return this.getClass().getSimpleName() + " (" + super.getName() + ", " + getPrice() + ")"; 
    // }
    
}
class Paper extends Product implements Wrappable{
    private String note;
    Paper(){
        super("Paper", 0.5);
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }
}
