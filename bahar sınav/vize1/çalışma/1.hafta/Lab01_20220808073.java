import java.util.*;
public class Lab01_20220808073{
    public static void main(String[] args){
        Circle1 c1= new Circle1(5, "RED");
        Circle1 c2= new Circle1(7, "YELLOW");
        //    Circle1.count can be used by its class 
        //   c1.colour= "BLUE";
        //    c1.radius=6;
            Circle1[] circles= {c1, c2};
            Circle1.display(circles);
            System.out.println(c1.getDateOfCreation());
        //    System.out.printf("Circle with %s colour, with %d area",c1.colour, c1.radius);
        //    System.out.println(c1);
        
        // c1.colour;
        // c2.colour;
        // c1.setRadius(-4);

   }
 
}
class Circle{
    double getArea(double radius){
        return Math.PI*radius*radius;
    }
    String toString(double radius, String colour){
        return "area: "+Double.toString(getArea(radius))+"colour: "+colour;
    }
}

class Circle1{
    private int radius=1;
    private Color colour=new Color();
    private Date dateOfCreation;
    //accsesor
    public int getRadius(){
        System.out.println("radius data is accesed.");
        return radius;
    }
    double getArea(double radius){
        return Math.PI*radius*radius;
    }
    Circle1(int radius, String colour){
        // that should be in first coloumn
        this(radius);
        // this.radius= radius;
        this.colour.name= colour;
            // this.colour.name;
        count++;
        setDate();
    
    }
    Circle1(int radius){
    // this();
    this.radius= radius;
    }
    public void setDate(){
        dateOfCreation= new Date(System.currentTimeMillis());
    }
    public Date getDateOfCreation() {
        return dateOfCreation;
    }
