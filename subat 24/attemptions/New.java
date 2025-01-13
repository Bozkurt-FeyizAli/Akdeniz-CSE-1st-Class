public class New{
    public static void main(String[] args){
        Triangle f=new Triangle(3, 4, 5);
        System.out.println(f.area());
        System.out.println(f.perimeter());

    }
}
class Account{
    String name;
    Account(String name, long ID, double balance){

    }
    /*Add a new data field named transactions whose type is ArrayList
     that stores the transaction for the accounts. Each transaction is an instance 
     of the Transaction class. The Transaction class is defined as shown in  */

}
class Transaction{
    String date;
    char type;
    double amount;
    double balance;
    String description;
    Transaction(char type, double amount, double balance, String description){

    }
}
class Triangle{
        double side1;
        double side2;
        double side3;
        double area;
        double perimeter;
        Triangle(){side1=5;
        }
    Triangle(double side1, double side2, double side3){
        this();
    }
    public double area(double side1, double side2, double side3){
        double s=(side1+side2+side3)/2;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
    public double perimeter(double side1, double side2, double side3){
        return side1+side2+side3;
    } 
    public double area(){
        double s=(side1+side2+side3)/3;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
    public double perimeter(){
        return side1+side2+side3;
    } 
    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +" side3 = " + side3;
    }

}
