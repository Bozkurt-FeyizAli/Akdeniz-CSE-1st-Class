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
