import java.util.Scanner;
public class chapter4{
public static void main(String[] args){
    double b =Math.random();
    b = Math.round(b) ;
    double AREA = (6.0*Math.pow(b , 2)) / (4.0*Math.tan(Math.PI/b)) ;
    System.out.println(AREA);

}
}