import java.util.Scanner;
public class Ex04_20220808073{
    public static void main(String[] args){
Scanner input = new Scanner(System.in);


//Qustion 1


System.out.println("please write center of ciercle: (x , y)");
double centerofCircleX = input.nextInt();
double centerofCircleY = input.nextInt();
System.out.println("please write a point on ciercle: (x , y)");
double pointOnCiercleX = input.nextInt();
double pointOnCiercleY = input.nextInt();
double radius = Math.sqrt(Math.pow((pointOnCiercleX-centerofCircleX),2)
                +Math.pow((pointOnCiercleY-centerofCircleY),2));
double circumference = 2*Math.PI*radius;
double area = Math.PI*radius*radius;
System.out.printf("Circumference of circle is %f , area of circle is %f ."
                  , circumference , area);
System.out.println("");


//Question 2


input.nextLine();
System.out.println("Please enter your name and surname:");
String nSN = input.nextLine();
int k = nSN.indexOf(' ');
String name = nSN.substring(0,k);
String surname = nSN.substring(k+1);
System.out.println(surname+" , "+name);



//Question 3


    System.out.println("Please write a number to find value in day:");
    int numberOfDay = input.nextInt();
    if (numberOfDay>0&&numberOfDay<8){
    switch(numberOfDay){
        case 1 :
        System.out.println("Monday");
        break ;
        
        case 2 : 
        System.out.println("Tuesday");
        break ;

        case 3 : 
        System.out.println("Wednesday");
        break;

        case 4 : 
        System.out.println("Thursday");
        break;

        case 5 : 
        System.out.println("Friday");
        break;

        case 6 : 
        System.out.println("Saturday");
        break;

        case 7 : 
        System.out.println("Sunday");
        break;}}
    else 
    System.out.println("ERROR: you have only 7 possibility!");
       

       //Question 4


       input.nextLine();
    System.out.println("Please write name of first city: ");
    String city1 = input.nextLine();
    System.out.println("Please write name of second city: ");
    String city2 = input.nextLine();
    System.out.println("Please write name of third city: ");
    String city3 = input.nextLine();
    
    if (city1.compareTo(city2) < 0 && city1.compareTo(city3)< 0 
        && city2.compareTo(city3)<0)
      System.out.println("The cities in alphabetical order are " +
                         city1 + " " + city2 + " " + city3);
    else if (city1.compareTo(city3) < 0 && city3.compareTo(city2)< 0 
             && city1.compareTo(city2)<0)
      System.out.println("The cities in alphabetical order are " +
                         city1 + " " + city3 + " " + city2);
    else if (city2.compareTo(city1) < 0 && city2.compareTo(city3)< 0 
             && city1.compareTo(city3)<0)
      System.out.println("The cities in alphabetical order are " +
                         city2 + " " + city1 + " " + city3);
    else if (city2.compareTo(city1) < 0 && city2.compareTo(city3)< 0 
             && city3.compareTo(city1)<0)
      System.out.println("The cities in alphabetical order are " +
                         city2 + " " + city3 + " " + city1);    
    else if (city3.compareTo(city1) < 0 && city3.compareTo(city2)< 0 
             && city1.compareTo(city2)<0)
      System.out.println("The cities in alphabetical order are " +
                         city3 + " " + city1 + " " + city2);  
    else if (city3.compareTo(city1) < 0 && city3.compareTo(city2)< 0 
             && city2.compareTo(city1)<0)
      System.out.println("The cities in alphabetical order are: " +
                         city3 + ", " + city2 + ", " + city1);  

                         
    //Question 5

input.nextLine();
double heightOfAngle;
double baseOfAngle;
double areaOfTriangle;
          System.out.println("Pease write height of triangle:");
          heightOfAngle = input.nextDouble();
          if (heightOfAngle>0){
          System.out.println("Pease write base of triangle:");
          baseOfAngle = input.nextDouble();
            if(baseOfAngle>0){
            areaOfTriangle = (baseOfAngle * heightOfAngle)/2 ;
            System.out.printf("value of area %.3f", areaOfTriangle);}
            else
          System.out.println("Height of an angle can not have mines value!");
          }
        else
        System.out.println("base of an angle can not have mines value!");
      }
}