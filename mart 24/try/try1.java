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
Copy code
Attributes:
- make (String): The make of the motorcycle.
- model (String): The model of the motorcycle.
- year (int): The year the motorcycle was manufactured.
- pricePerDay (double): The rental price per day for the motorcycle.
- engineVolume (int): The engine volume of the motorcycle.

Methods:
- calculateRentalCost(int days): Computes the rental cost for a given number of days. */




class Car extends Vehicle{
    private int passengerCapacity;
    private boolean automaticTransmission;
    public Car(String brand, String model, int year, boolean isRented,int passengerCapacity, boolean automaticTransmission){
    super(brand, model, year, isRented);
    // you can de that with protected keyword otherwise from private
    // this.brand=brand;
    setPassengerCapacit(passengerCapacity);
    setAutomaticTransmission(automaticTransmission);
    }
    public boolean getAutomaticTransmission(){
        return automaticTransmission;
    }
    public int getPassengerCapacity(){
        return passengerCapacity;
    }
    public void setAutomaticTransmission(boolean automaticTransmission){
        this.automaticTransmission=automaticTransmission;
    }
    public void setPassengerCapacit(int passengerCapacity){
        this.passengerCapacity=passengerCapacity;
    }
    @Override
    public void run(){
       System.out.println("Car is running");
    }
}

class Truck extends Vehicle{
    private int loadCapacity;
    private boolean fourWheelDrive;    
    public void run(){
        System.out.println("Truck is running");
    }

    public Truck(String brand, String model, int year,boolean isRented, int loadCapacity, boolean fourWheelDrive){
        super(brand, model, year, isRented);
        setLoadCapacity(loadCapacity);
        
    }
    public int getLoadCapacity(){
        return loadCapacity;
    }
    public boolean getFourWheelDrive(){
        return fourWheelDrive;
    }
    public void setFourWheelDrive(boolean fourWheelDrive){
        this.fourWheelDrive=fourWheelDrive;
    }
    public void setLoadCapacity(int loadCapacity){
        this.loadCapacity=loadCapacity;
    }
}
class Motorcycle extends Vehicle{
    public void run(){
        System.out.println("Motocycle is running");
    };
    private int engineVolume;
    private boolean hasABS;
    public Motorcycle(String brand, String model,int  year,boolean isRented, int engineVolume, boolean hasABS){
        super(brand, model ,year ,isRented);
        setEngineVolume(engineVolume);
        setHasABS(hasABS);
    }
    public int getEngineVolume(){
        return engineVolume;
    }
    public boolean getHasABS(){
        return hasABS;
    }
    public void setEngineVolume(int engineVolume){
        this.engineVolume=engineVolume;
    }
    public void setHasABS(boolean hasABS){
        this.hasABS=hasABS;
    }
}
class Customer{
    private String firstName;
    private String lastName;
    private int ID;
    private ArrayList<Vehicle> rentedVehicles;
    private ArrayList<RentalContrat> contrats;

    Customer(String firstName, String lastName, String id){
        rentedVehicles= new ArrayList<>();
        contrats= new ArrayList<>();
        
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getID(){
        return ID;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
     void setID(){
        Random rnd= new Random();
        ID=rnd.nextInt(1000,9999);
    }
    // public void rent(Vehicle v){
    //     rentedVehicles.add(v);
    //     RentalContrats.add(new RentalContrat(this, v, startDate, endDate));
    // RentalContact.get(RentalContact.size()-1)
    // }
    public Vehicle turnIn(RentalContrat contract){
        Vehicle a= contract.getRentedVehicle();
        rentedVehicles.remove(a);
        Customer c=contract.getCustomer();
        // rentedContacts.remove(contract);
        return a;
    }


}
// class RentalContrat{
//     Customer customer;
//     Vehicle vehicle;
//     Date renta;
//     Date end;
//     RentalContrat(Customer customer, Vehicle vehicle, Date rDate, Date eDate){

//     }


//}
class RentalContrat{
    Customer customer;
    Vehicle rentedVehicle;
    Date rentalStartDate;
    Date rentalEndDate;
    public RentalContrat(Customer customer, Vehicle rentedVehicle,Date rentalStartDate, Date rentalEndDate){

    }
    void CalculateRentalPeriod(){
        System.out.println(rentalEndDate.compareTo(rentalStartDate));
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }
    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }
    public void setRentedVehicle(Vehicle rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Date getRentalEndDate() {
        return rentalEndDate;
    }
    public Date getRentalStartDate() {
        return rentalStartDate;
    }
    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }
}










