import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;




public class Lab06_20220808073{
    public static void main(String[] args) {
        
    }
}

// interface Colorable{
//     public static final int RED=255;
//     public static final int Green=255;
//     int blue =89;
//     int grtRED();
// }

// class Car extends Veicle implements Colorable{
//     int price;
//     @Override 
//     public int grtRED(){
//         return 0;
//     }
// }

abstract class  Veicle {
    String model;
    int year;
    int horsePower;
    Veicle(String model, int year, int horsePower){
       setModel(model);
       setYear(year);
       setHorsePower(horsePower);
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    abstract void startEngine();


    @Override
    public String toString() {
        
        return this.getClass().getCanonicalName()+"model "+model+" year "+ getYear();
    }
    
}

abstract class Aircraft extends Veicle{

    Aircraft(String model, int year,  int horsePower) {
        super(model, year, horsePower);
     
    }
    public void fly(){

    }

}

abstract class  Ship extends Veicle {

    Ship(String model, int year,  int horsePower) {
        super(model, year, horsePower);
        
    }

    public void sail(){

    }

    
}
abstract class  Car extends Veicle implements Comparable<Car> {
    public int getHorsePower() {
        return horsePower;
    }
    Car(String model, int year, int horsePower) {
        super(model, year, horsePower);
    
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public int compareTo(Car o){
        return -o.getHorsePower()+this.getHorsePower();
    }
    public void drive(){
        System.out.println("Drive "+this.toString() + " with horsePower"+horsePower);
    }

    
}
