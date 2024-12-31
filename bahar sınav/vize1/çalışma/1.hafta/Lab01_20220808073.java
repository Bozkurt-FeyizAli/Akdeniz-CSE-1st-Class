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


    // costructor is a special kind of method not doing anything
    // overrid is used for give a special output for sth
    @Override
    public String toString(){
        return String.format("Circle with %s colour, with %d area", colour, radius);
    }
    
    static int count=0;
    // ststic used for when we need to use a value later
     
    static void display(Circle1[] circles){
        for (Circle1 c : circles) {
            if(!c.equals(null))
            System.out.println(c);
        }
    }
    // mutator
    // immutable = un changeable
    void setRadius(int radius){
        if(radius>=0)
        this.radius= radius;
        else
        System.out.println("ERROR: invalid values ");
    }

}

class Color{
    String name="RED";
        @Override
    public String toString(){
        return String.format("Circle with %s colour, with %d m^2 area", name, 25);
    }

    class Fields{
        static int count=0;
        static Fields[] employee= new Fields[8]; 
        String name="Default Employee";
        double salary=23277.53;
        int id=-1;
        int level=0;

        Fields(String name, double salary, int level){
            this.name= Character.toUpperCase(name.charAt(0))+name.substring(1).toLowerCase();
            this.salary= salary;
            this.level= level;

        }
        int random(int level){
            if(level==2)
            return 1000+(int)(Math.random()*9+1)*100+(int)(Math.random()*9+1)*10+(int)(Math.random()*9+1);
            else return 2143;
        }
        public int getID(){
        System.out.println("ID data is accesed.");
        return id;
        }
        public String getName(){
        System.out.println("name data is accesed.");
        return name;
        }
        public double getSalary(){
        System.out.println("salary data is accesed.");
        return salary;
        }
        public int getLevel(){
        System.out.println("name level is accesed.");
        return level;
        }
        void setName(String name){
        this.name= name;
        }
        void setSalary(double salary){
            if(salary>=0)
        this.salary= salary;
        else
        System.out.println("ERROR: invalid value");
        }
        int generateId(int level){
            return this.level*1000+(int)(Math.random()*9+1)*100+(int)(Math.random()*9+1)*10+(int)(Math.random()*9+1);
        }
        Fields[] promote(Fields[] employee){
            return employee;
        }
        @Override
        public String toString(){
            return String.format("name: ", name);
        }

        
    }
}








    