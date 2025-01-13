import java.sql.Date;
import java.util.*;

public class try1{
    public static void main(String[] args) {
        Car car= new Car("BMW", "M4", 2002, false, 4, true);
        Truck a= new Truck("BMW", "M4", 2002, false, 4, true);
        car.getPassengerCapacity();
        Vehicle[] parkinglot= new Vehicle[] {car, a};
        // for()

    }
}

abstract  class Vehicle{
    protected String brand;
    private String model;
    private int year;
    private boolean isRented;
    public Vehicle(String brand, String model, int year, boolean isRented){
    this.brand=brand;
    this.model=model;
    this.year=year;
    this.isRented=isRented;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public boolean getIsRented(){
        return isRented;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setIsRented(boolean isRented){
        this.isRented=isRented;
    }
    // if you have an abstract method class should be abstract
    public abstract void run();

    
    
}

/*Attributes:
- make (String): The make of the vehicle.
- model (String): The model of the vehicle.
- year (int): The year the vehicle was manufactured.
- pricePerDay (double): The rental price per day for the vehicle.

Methods:
- calculateRentalCost(int days): Computes the rental cost for a given number of days.
2. Car Class:
plaintext
Copy code
Attributes:
- make (String): The make of the car.
- model (String): The model of the car.
- year (int): The year the car was manufactured.
- pricePerDay (double): The rental price per day for the car.
- passengerCapacity (int): The passenger capacity of the car.

Methods:
- calculateRentalCost(int days): Computes the rental cost for a given number of days.
3. Truck Class:
plaintext
Copy code
Attributes:
- make (String): The make of the truck.
- model (String): The model of the truck.
- year (int): The year the truck was manufactured.
- pricePerDay (double): The rental price per day for the truck.
- loadCapacity (int): The load capacity of the truck.

Methods:
- calculateRentalCost(int days): Computes the rental cost for a given number of days.
4. Motorcycle Class:
plaintext
