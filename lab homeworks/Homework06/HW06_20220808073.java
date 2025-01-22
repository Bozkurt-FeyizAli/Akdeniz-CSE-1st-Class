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
class Matroschka <T extends Wrappable> extends Product implements Wrappable, Package<T>{
    private T item;

    Matroschka(T item){
        super("Doll", 5+(item==null? 0: item.getPrice()));
        pack(item);
    }
    @Override
    public String toString(){
        return super.toString() + "{" + item + "]"; 
    }
    @Override
    public boolean pack(T item){
        if(this.item!=null){
            return false;
        }
        this.item = item;
        return true;
    }
    @Override
    public boolean isEmpty(){
        return this.item==null;
    }
    @Override
    public T extract(){
        T eItem = item;
        item = null;
        return eItem;
    }
}
class Box <T extends Sellable> implements Package<T>{
    private T item;
    private boolean seal;
    Box(){
        item=null;
    }
    Box(T item){
        seal=true;
        pack(item);
    }
    public T extract(){
        T eItem = item;
        this.item = null;
        this.seal = false;
        return eItem;
    }
    public boolean isSealBroken(){
        return seal;
    }
    @Override
    public boolean pack(T item){
        if(this.item!=null){
            return false;
        }
        this.item = item;
        return true;
    }
    @Override
    public boolean isEmpty(){
        return this.item==null;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " {" + item + "} Seal: " + seal; 
    }
}