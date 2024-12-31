public class Lab02_20220808073{
    public static void main(String[] args) {
        Rectangle a= new Rectangle(2, 2);
        System.out.println(a);
        // boolean isCArOn=start("Tesla", "Red", true, 23, 23);
        // int carSpeed=accelerate();
        Car car= new Car("tesla model s", "red", 12);
        Car toyota= new Car("toyota", "a", 34);
        car.accelerate();
        car.start();
        car.stop();
        Car[] gallery= new Car[] {car, toyota};
        System.out.println(gallery);
    }
    public static boolean start(String model, String color, boolean isOn, int speed, int acceleration){
        if(isOn){
            String s1=String.format("Car, %s%s,", model, color);
        String s2= s1+String.format("is running and has speed of %d/N", speed);
        return isOn=!isOn;

        }
        else{
            System.out.printf("%s %s is starting.../n",model, color);
            return false;
        }
    }   
}
class Rectangle{
    // mines mean private ya da altı çiziliyse private yap!
    private double length;
    private double width;
    Rectangle(double length, double width){
        this.length=length;
        this.width=width;
        getArea();
        getPerimeter();
    }
    public void setLength(double length){
        if(length>0)
        System.out.println("ERROR");
        this.length=length;
    }
    public void setWidth(double width){
        if(width<0)
        throw new IllegalArgumentException("ERROR: illegal a length");
        this.width=width;
    }
    public double getArea(){
        return length*width;
    }
    public double getPerimeter(){
        return 2*(length+width);
    }
    @Override
    public String toString(){
        return String.format("Rectangle, length is: %.2f m^2, width is: %.2f.", length, width);
    }
}
class Car{
    // firstl write form of the skeleton/ body of the class 
    private String model;
    private String color;
    private int speed;
    private boolean isOn;
    private int acceleration;
    Car(String  model, String color){
        this.model=model;
        this.color=color;
        setAcceleration(5);
    }
    Car(String  model, String color, int acceleration){
        this.acceleration=acceleration;
        this.model=model;
        this.color=color;
    }
    public void setAcceleration(int acceleration){
        this.acceleration=acceleration;
    }
    public void start(){
        if(!isOn){
        isOn=!isOn;
        accelerate();
        System.out.printf("%s %s is starting.../n",model, color);
        }
        else 
        System.out.println("car is already running!");
    }
    public void stop(){
        if(isOn){
            isOn=!isOn;
            speed-=speed;
            System.out.printf("%s %s is stopped.../n",model, color);
        }
        else
        System.out.println("car has already stopped!");
    }
    public void accelerate(){
        if(isOn){
            speed+=acceleration;
            System.out.printf("%s %s have the speed %d", model, color, speed);
        }
    }
    public void accelerate(int acceleration){
        setAcceleration(acceleration);
        accelerate();
    }
    @Override
    public String toString(){
        String s1=String.format("Car, %s%s,", model, color);
        String s2= s1+String.format("is running and has speed of %d/N", speed);
        return isOn? s2: s1;
    }
}
class Person{
    private String name;
    // aggregetion being ndepend , composition a part of sth and there is a relation, indiate there is no relation
    // property= setter and getters
    
    private class Car {                                                                                                                                                             
    }
    private class Wallet{
        private String color;
        private int amount;
        Wallet(String color){
            this.color=color;
            this.amount=50;
        }
        Wallet(String color, int amount){
            this.amount=amount;
            this.color=color;
        }
        public void getColor(String color){
            this.color=color;
        }
        public void getAmount(int amount){
            this.amount=amount;
        }
        public void addMoney(int money){
            if(money>0)
            getAmount(money);
            // else
            // throw Exception IllegalArgumentException("ahgsk");
        }
    }
    private class Brain {
    }
} 