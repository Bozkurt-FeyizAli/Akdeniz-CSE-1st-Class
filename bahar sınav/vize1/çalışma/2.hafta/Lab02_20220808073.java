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
