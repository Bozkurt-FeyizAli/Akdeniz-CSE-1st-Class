import java.sql.Date;
import java.util.Random;


public class vize1{
    public static void main(String[] args) {
        
    
    deneme d= new deneme();
    d.date1dayLater();
    System.out.print(d.getD()); 
    }

}

class deneme{
    private double preFee;
    private double curFee;
    private Date d;
    public double getChangePercent(){
        return ((curFee-preFee)/preFee)*100;
    }
    public void date1dayLater(){
        d= new Date(System.currentTimeMillis()+24*60*60*1000);
    }
    public Date getD() {
        return d;
    }
    public int random(){
        Random a= new Random();
        return a.nextInt();
    }
    public int random(int b, int f){
        return b+ (int)(random()*f+1);
    }

}

interface Scalable{
    void scale(double factor);
}

interface Resizable{
    void resize(double facor);
}

abstract class Shape{
    abstract double area();
    abstract double perimeter();
    abstract double volume();

}

class Sphere extends Shape implements Resizable{
    private double radius;
    private double area;
    private double perimeter;
    private double volume;
    private String color;
    Sphere(int radius, String color){
        setRadius(radius);
    }
        
    @Override
    public void resize(double facor) {
        radius*=facor;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setRadius(double radius) throws InvalidRadiusException {
        if(radius<0)
            throw new InvalidRadiusException("color");
        this.radius = radius;
    }
    public double getArea() {
        return area;
    }
    public String getColor() {
        return color;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getRadius() {
        return radius;
    }
    public double getVolume() {
        return volume;
    }
    
    @Override
    public double volume(){
        return (4/3)*Math.PI*radius*radius*radius;
    }
    @Override
    public double perimeter(){
        return 4*Math.PI*radius*radius;
    }
    @Override 
    public double area(){
        return perimeter();
    }

}

class Rectangle extends Shape implements Scalable{
    private double side1;
    private double side2;
    private double side3;
    private double area;
    private double perimeter;
    private double volume;
    private String color;
    Rectangle(int side1, int side2, int side3, String color){
        setColor(color);  
            setSide1(side1);
            setSide2(side2);
            setSide3(side3);

    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSide1(double side1) throws InvalidLengthException {
        if(side1<0)
            throw new InvalidLengthException("color");
        this.side1 = side1;
    }
    public void setSide2(double side2) throws InvalidLengthException{
        if(side2<0)
            throw new InvalidLengthException("color");
        this.side2 = side2;
    }
    public void setSide3(double side3) throws InvalidLengthException{
        if(side3<0)
            throw new InvalidLengthException("color");
        this.side3 = side3;
    }
    public double getArea() {
        return area;
    }
    public String getColor() {
        return color;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getSide1() {
        return side1;
    }
    @Override
    public void scale(double factor) {
        side1*=factor;
        side2*=factor;
        side3*=factor;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }
    public double getVolume() {
        return volume;
    }
    @Override
    public double volume(){
        return side1*side2*side3;
    }
    @Override
    public double perimeter(){
        return 2*side1*side2+2*side1*side3+2*side2*side3;
    }
    @Override 
    public double area(){
        return perimeter();
    }
}
