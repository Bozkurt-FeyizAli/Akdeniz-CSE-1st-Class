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

 class Tesla extends Car implements Electric, Rentable{
    private int currentBattery;

    Tesla(String model, int year, int horsePower) {
        
        super(model, year, horsePower);
       
    }

    @Override
    public int compareTo(Car o) {
        return this.getHorsePower()-o.getHorsePower();
    }

    @Override
    public Rentable rentOut(Gallery gallery) {
        return this;
    }

    @Override
    public void returnVehicle(Gallery gallery) {
    }

    @Override
    public void chargeBattery(int amount) {
        currentBattery+= amount;
    }
    

    @Override
    void startEngine() {
       System.out.println("Started the engine of "+ this.getClass().getSimpleName());
      
    }
    @Override
    public void drive() {
    System.out.println( "Electrical");
    super.drive();
    }
    public int getCurrentBattery() {
        return currentBattery;
    }
    
 }
 class Ford extends Car implements Combustion{
    

    Ford(String model, int year, int horsePower) {
        super(model, year, horsePower);
    }

    @Override
    public int compareTo(Car o) {
        return this.getHorsePower()-o.getHorsePower();
    }

    @Override
    void startEngine() {
       System.out.println("Started the engine of "+ this.getClass());
    }

    @Override
    public void refuael() {
       
    }
    @Override 
    public void drive(){
        System.out.println( "Combustion");
        super.drive();
    }

 }

 class Mercedes extends Veicle implements Electric, Diesel{
    private int currentBattery;
    Mercedes(String model, int year, int horsePower) {
        super(model, year, horsePower);
       
    }

    @Override
    public void refuael() {
        System.out.println("Refuleging ..."+ this);
    }

    @Override
    public Rentable rentOut(Gallery gallery) {
        return this;
    }

    @Override
    public void returnVehicle(Gallery gallery) {
        
    }

    @Override
    public void cleanDieselFilter() {
        System.out.println("Uses clean diesel");
    }

    @Override
    public void chargeBattery(int amount) {
        currentBattery += amount;
    }

    @Override
    void startEngine() {
        System.out.println("Started the engine of "+ this.getClass());
    }
    @Override
    public int getCurrentBattery() {
       return currentBattery;
    }

    
 }

 class Gallery{
    // private ArrayList<Veicle> vehicles;
    private ArrayList<Combustion> combustionCars;
    private ArrayList<Electric> electricCars;
    Gallery(){
        combustionCars= new ArrayList<>();
        electricCars= new ArrayList<>();
    }
    public void addCar(Car car){
        if(car instanceof Combustion)
        combustionCars.add((Combustion) car);
        else if(car instanceof Electric)
            electricCars.add((Electric) car);
    }
    public void addCombustionCar(Combustion car){
        // if(car instanceof Combustion )
        combustionCars.add(car);
    }
    public void addElectricCar(Electric car){
        // if(car instanceof Electric)
        electricCars.add(car);
    }
    public void displayRentableCars(){
        ArrayList<Car> rentableCars = new ArrayList<>();
        for(Combustion car : combustionCars){
            if(car instanceof Rentable)
            rentableCars.add((Car) car);
        }
        for(Electric car : electricCars){
            if(car instanceof Rentable)
            rentableCars.add((Car) car);
        }
        Collections.sort(rentableCars);

        for(Car car: rentableCars){
            System.out.println(car.toString());
        }
        // combustionCars.sort(null);
        // electricCars.sort(null);
        
    }
    
 }


// class Bike extends Veicle{

// }

