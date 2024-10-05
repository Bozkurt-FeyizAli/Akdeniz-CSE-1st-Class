//@FEYIZ ALI BOZKURT @SINCE 04 NOVEMBER 2023 ;
import java.util.Scanner;
public class Assignment2_20220808073{
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
//KEYS
int weightOfQuiz, weightOfAttendance,sumOfWeights,
    weightOfAssignment, weightOfFinalExam, weightOfMidtermExam;
double resultQuiz, resultAttendance,gpaPoint, sumOfResults,
       resultAssignment, resultMidtermExam, resultFinalExam;
int itemsOfQuiz=3,itemsOfAttendance=3, 
    itemsOfAssignment=1, itemsOfMidtermExam=1,itemsOfFinalExam=1;
String gradeLetter, statu;

//Category Information Entry

System.out.println("************Category Information Entry**************");
System.out.println();
System.out.println();
System.out.println("Please enter the name of category 1 :");
String name1 = scanner.nextLine();
name1 = formatCategoryName(name1);
System.out.printf("Please enter how many items of type %s were given: "
                          ,name1);
itemsOfQuiz=scanner.nextInt();
System.out.println();
boolean itemsOfType1=isQuantityValid(itemsOfQuiz)? true: false;
System.out.println(itemsOfType1);
while(itemsOfType1==false){
   System.out.println("ERROR: Invalid value please write a new value!");
   itemsOfQuiz=scanner.nextInt();
   System.out.println();
itemsOfType1=isQuantityValid(itemsOfQuiz)? true: false;
System.out.println(itemsOfType1);}

System.out.printf("Please enter the percentage weight of %s :"
                          ,name1);
weightOfQuiz= scanner.nextInt();
while(weightOfQuiz<0||weightOfQuiz>100){
   System.out.printf("ERROR: invalid value please enter"
   +"the percentage weight of %s :",name1);
   weightOfQuiz= scanner.nextInt();}
sumOfWeights=0;
Boolean resultWeight1=isWeightValid(weightOfQuiz,sumOfWeights);
System.out.println(resultWeight1);
scanner.nextLine();


System.out.println("Please enter the name of category 2 :");
String name2 = scanner.nextLine();
name2 = formatCategoryName(name2);
System.out.printf("Please enter how many items of type %s were given: "
                          ,name2);
itemsOfAttendance=scanner.nextInt();
System.out.println();
boolean itemsOfType2=isQuantityValid(itemsOfAttendance)? true: false;
System.out.println(itemsOfType2);
while(itemsOfType2==false){
   System.out.println("ERROR: Invalid value please write a new value!");
   itemsOfAttendance=scanner.nextInt();
   System.out.println();
itemsOfType2=isQuantityValid(itemsOfAttendance)? true: false;
System.out.println(itemsOfType2);}

System.out.printf("Please enter the percentage weight of %s :",name2);
weightOfAttendance= scanner.nextInt();
while(weightOfAttendance<0||weightOfAttendance>100){
   System.out.printf("ERROR: invalid value please enter"
   +"the percentage weight of %s :",name2);
   weightOfAttendance= scanner.nextInt();}
   sumOfWeights=weightOfQuiz;
Boolean resultWeight2=isWeightValid(weightOfAttendance,sumOfWeights);
System.out.println(resultWeight2);
scanner.nextLine();


System.out.println("Please enter the name of category 3 :");
String name3 = scanner.nextLine();
name3 = formatCategoryName(name3);
System.out.printf("Please enter how many items of type %s were given: "
                          ,name3);
itemsOfAssignment=scanner.nextInt();
System.out.println();
boolean itemsOfType3=isQuantityValid(itemsOfAssignment)? true: false;
System.out.println(itemsOfType3);
while(itemsOfType3==false){
   System.out.println("ERROR: Invalid value please write a new value!");
   itemsOfAssignment=scanner.nextInt();
   System.out.println();
itemsOfType3=isQuantityValid(itemsOfAssignment)? true: false;
System.out.println(itemsOfType3);}

System.out.printf("Please enter the percentage weight of %s :",name3);
weightOfAssignment= scanner.nextInt();
while(weightOfAssignment<0||weightOfAssignment>100){
   System.out.printf("ERROR: invalid value please enter"
   +"the percentage weight of %s :",name3);
   weightOfAssignment= scanner.nextInt();}
      sumOfWeights=weightOfQuiz+weightOfAttendance;
Boolean resultWeight3=isWeightValid(weightOfAttendance,sumOfWeights);
System.out.println(resultWeight3);
scanner.nextLine();



System.out.println("Please enter the name of category 4 :");
String name4 = scanner.nextLine();
name4 = formatCategoryName(name4);
System.out.printf("Please enter how many items of type %s were given: "
                          ,name4);
itemsOfMidtermExam=scanner.nextInt();
System.out.println();
boolean itemsOfType4=isQuantityValid(itemsOfMidtermExam)? true: false;
System.out.println(itemsOfType4);
while(itemsOfType4==false){
   System.out.println("ERROR: Invalid value please write a new value!");
   itemsOfMidtermExam=scanner.nextInt();
   System.out.println();
itemsOfType4=isQuantityValid(itemsOfMidtermExam)? true: false;
System.out.println(itemsOfType4);}

System.out.printf("Please enter the percentage weight of %s :",name4);
weightOfMidtermExam= scanner.nextInt();
while(weightOfMidtermExam<0||weightOfMidtermExam>100){
   System.out.printf("ERROR: invalid value please enter"
   +"the percentage weight of %s :",name4);
   weightOfMidtermExam= scanner.nextInt();}
   sumOfWeights=weightOfQuiz+weightOfAttendance+
                weightOfAssignment;
Boolean resultWeight4=isWeightValid(weightOfMidtermExam,sumOfWeights);
System.out.println(resultWeight4);
scanner.nextLine();


System.out.println("Please enter the name of category 5 :");
String name5 = scanner.nextLine();
name5 = formatCategoryName(name5);
System.out.printf("Please enter how many items of type %s were given: "
                  ,name5);
itemsOfFinalExam=scanner.nextInt();
System.out.println();
boolean itemsOfType5=isQuantityValid(itemsOfFinalExam)? true: false;
System.out.println(itemsOfType5);
while(itemsOfType5==false){
   System.out.println("ERROR: Invalid value please write a new value!");
   itemsOfFinalExam=scanner.nextInt();
   System.out.println();
itemsOfType5=isQuantityValid(itemsOfFinalExam)? true: false;
System.out.println(itemsOfType5);}

System.out.printf("Please enter the percentage weight of %s :",name5);
weightOfFinalExam= scanner.nextInt();
while(weightOfFinalExam<0||weightOfFinalExam>100){
   System.out.printf("ERROR: invalid value please enter"
   +"the percentage weight of %s :",name5);
   weightOfFinalExam= scanner.nextInt();}
   sumOfWeights=weightOfQuiz+weightOfAttendance+weightOfAssignment
                +weightOfMidtermExam;
Boolean resultWeight5=isWeightValid(weightOfFinalExam,sumOfWeights);
System.out.println(resultWeight5);
   scanner.nextLine();
   sumOfWeights=weightOfQuiz+weightOfAttendance+weightOfAssignment
                +weightOfMidtermExam+weightOfFinalExam;
if (sumOfWeights==100){

//Student Grades Entry

System.out.println();
System.out.println();
System.out.println("****************Student Grades Entry****************");
System.out.println();
System.out.println();
System.out.println("Please enter values that"+
                   " the student earned for each item");

resultQuiz= resultExam(name1, itemsOfQuiz,weightOfQuiz,scanner);
resultAttendance=resultExam(name2, itemsOfAttendance
                            ,weightOfAttendance,scanner);
resultAssignment=resultExam(name3, itemsOfAssignment,
                            weightOfAssignment,scanner);
resultMidtermExam=resultExam(name4, itemsOfMidtermExam,
                             weightOfMidtermExam,scanner);
resultFinalExam=resultExam(name5, itemsOfFinalExam,weightOfFinalExam,scanner);

sumOfResults=(resultQuiz*weightOfQuiz)/100.0
             +(resultAttendance*weightOfAttendance)/100.0
             +(resultAssignment*weightOfAssignment)/100.0
             +(resultMidtermExam*weightOfMidtermExam)/100.0
             +(resultFinalExam*weightOfFinalExam)/100.0;

//Student Resutls

System.out.println();
System.out.println();
System.out.println("*******************Student Resutls*******************");
System.out.println();
System.out.println();
gpaPoint=gpaPoints(sumOfResults);
gradeLetter=gradeLetter(sumOfResults);
statu=status(sumOfResults);
System.out.printf("%s : %.1f",name1,resultQuiz);
System.out.println();
System.out.printf("%s : %.1f",name2,resultAttendance);
System.out.println();
System.out.printf("%s : %.1f",name3,resultAssignment);
System.out.println();
System.out.printf("%s : %.1f",name4,resultMidtermExam);
System.out.println();
System.out.printf("%s : %.1f",name5,resultFinalExam);
System.out.println();
System.out.printf("The student has %s CSE 101 with a score of %.2f,"+
                  " GPA point of %.1f, and a grade letter of %s",
                  statu,sumOfResults,gpaPoint,gradeLetter);
    }
    else  
System.out.printf("ERROR: The values sum to %d but should be 100!"
                          ,sumOfWeights);}

//METHODS

     public static String formatCategoryName(String name1){
    char upperCase1= name1.charAt(0);
  upperCase1= Character.toUpperCase(upperCase1);
     name1 =name1.substring(1);
        name1= name1.toLowerCase();
    name1= upperCase1+name1;
    return name1;
    }

public static Boolean isQuantityValid(int quantity){
Boolean result =  (quantity>0) ? true : false;
return result;
    } 

public static Boolean isWeightValid(int weight, int sumweight){
Boolean result = (weight>=0&&sumweight+weight<=100)? true :false;
return result;
    }

    public static  String gradeLetter(double grade ){
      if (grade>=88) return "AA"; 
      else if (grade>=81) return "BA";
      else if (grade>=74) return "BB";
      else if (grade>=67) return "CB";
      else if (grade>=60) return "CC";
      else if (grade>=53) return "DC";
      else if (grade>=46) return "DD";
      else if (grade>=35) return "FD";
      else return "FF";}

      public static double gpaPoints(double grade){
         double result;
      if (grade>=88) result = 4.0;
      else if (grade>=81) result = 3.5;
      else if (grade>=74) result = 3.0;
      else if (grade>=67) result = 2.5;
      else if (grade>=60) result = 2.0;
      else if (grade>=53) result = 1.5;
      else if (grade>=46) result = 1.0;
      else if (grade>=35) result = 0.5;
      else result = 0.0;
      return result;}

      public static String status(double grade){
         String result ;
         if (grade>=60) result = "passed";
         else if (grade>=46) result = " conditionally passed";
         else result = "failed";
         return result;}
      public static Double resultExam(String nameOfType,int itemsOfType,
                                      int weightOfType,Scanner scanner){
    double resultType=0.0;
    int a1;
    double valueType;
    double sumType=0.0;
         for( a1=1;itemsOfType>0;itemsOfType--,a1++){
         System.out.printf("%s %d:",nameOfType,a1);
         valueType=scanner.nextDouble();
         if(valueType<0||valueType>100){
         System.out.println("ERROR: invalid value please write again!");
         a1--;itemsOfType++;
         continue;}
         sumType+=valueType;
         if(itemsOfType==1)
            resultType=(sumType/a1);
         }scanner.nextLine();
         return resultType;}
      }
      
    






    
