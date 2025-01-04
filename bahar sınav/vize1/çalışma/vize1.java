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
