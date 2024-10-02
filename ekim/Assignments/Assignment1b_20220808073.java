//COMPUTE GPASCORE - FEYİZ ALİ BOZKURT 20.10.2023
import java.util.Scanner;
public class Assignment1b_20220808073 {
public static void main(String[] args)
{
  // necessary keys
  String studentName = "Feyiz Ali BOZKURT";
  int weightOfQuiz;
  int weightOfHomework;
  int weightOfMidExam;
  int weightOfFinalEXam;
  int sumOfValues;
  int resultQuiz;
  int resultHomework;
  int resultFinalExam;      
  int resultMidExam;
  double gpaPOint;
      // step one: get weight of categories
      Scanner scanner = new Scanner(System.in);
      System.out.println("write weight(persantage) of Quiz:");
      weightOfQuiz = scanner.nextInt();
      if (0<=weightOfQuiz && weightOfQuiz<=100){
      System.out.println("write weight(persantage) of Homework:");
      weightOfHomework = scanner.nextInt();
        if (0<=weightOfHomework&&weightOfHomework<=100){
        System.out.println("write weight(persantage) of Middterm-Exam:");
        weightOfMidExam = scanner.nextInt();
          if (0<=weightOfMidExam&&weightOfMidExam<=100){
          System.out.println("write weight(persantage) of Final Exam:");
          weightOfFinalEXam = scanner.nextInt();
            if (0<=weightOfFinalEXam&&weightOfFinalEXam<=100) {
            sumOfValues = (weightOfQuiz + weightOfHomework
                           +weightOfMidExam + weightOfFinalEXam);
              // step two: determine continiouing or giving error
              if (sumOfValues==100){
                   //step three: get results
              System.out.println("Please write result of quiz:");
              resultQuiz = scanner.nextInt();
                if  (0<=resultQuiz&&resultQuiz<=100){
                System.out.println("Please write result of homework:");
                resultHomework =scanner.nextInt();
                  if (0<=resultHomework&&resultHomework<=100){
                  System.out.println("Please write result of Midterm:");
                  resultMidExam = scanner.nextInt();
                    if (0<=resultMidExam&&resultMidExam<=100){
                    System.out.println("Please write result of FinalExam:");
                    resultFinalExam = scanner.nextInt();
                      if (0<=resultFinalExam&&resultFinalExam<=100){
                      //step four: calculate GPASCORE
                      gpaPOint = (resultQuiz*(weightOfQuiz/100.0))
                                 +(resultHomework*(weightOfHomework/100.0))+
                                 (resultMidExam*(weightOfMidExam/100.0))
                                 +(resultFinalExam*(weightOfFinalEXam/100.0));
                      gpaPOint *=10;
                      gpaPOint = (int)gpaPOint;
                      gpaPOint /= 10.0;
                        //step five: give feedback
                        if (88<=gpaPOint&&gpaPOint<=100) { 
                        System.out.println(studentName+" passed CSE 101 with a score of "
                        +gpaPOint+", GPA points of 4.0 and a grade letter of AA.");}
                          else if (81<=gpaPOint) { 
                          System.out.println(studentName+" passed CSE 101 with a score of "
                                             +gpaPOint+", GPA points of 3.5 and a grade letter of BA.");}
                            else if (74<=gpaPOint) { 
                            System.out.println(studentName+" passed CSE 101 with a score of "
                                               +gpaPOint+", GPA points of 3.0 and a grade letter of BB.");}
                              else if (67<=gpaPOint) { 
                              System.out.println(studentName+" passed CSE 101 with a score of "
                                                 +gpaPOint+", GPA points of 2.5 and a grade letter of CB.");}
                                else if (60<=gpaPOint) { 
                                System.out.println(studentName+" passed CSE 101 with a score of "
                                                   +gpaPOint+", GPA points of 2.0 and a grade letter of CC.");}
                                  else if (53<=gpaPOint) { 
                                  System.out.println(studentName+" Conditionally passed CSE 101 with a score of "
                                                     +gpaPOint+", GPA points of 1.5 and a grade letter of DC.");}
                                    else if (46<=gpaPOint) { 
                                    System.out.println(studentName+" Conditionally passed CSE 101 with a score of "
                                                       +gpaPOint+", GPA points of 1.0 and a grade letter of DD.");}
                                      else if (35<=gpaPOint) { 
                                      System.out.println(studentName+" failed CSE 101 with a score of "
                                                         +gpaPOint+", GPA points of 0.5 and a grade letter of FD.");}
                                        else if (0<=gpaPOint) { 
                                        System.out.println(studentName+" failed CSE 101 with a score of "
                                                           +gpaPOint+", GPA points of 0.0 and a grade letter of FF.");}
                                                                                   }
                               //step six: give error mesaages
                      else 
                      System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}                                
                    else 
                    System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}
                  else 
                  System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}
                else 
                System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}      
              else 
              System.out.println("ERROR: The values sum to "
                                                            +sumOfValues+
                                                                         " but should sum to 100");}
            else 
            System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}
          else 
          System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}    
        else 
        System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");}                                      
      else 
      System.out.println("ERROR: Invalid value entered (must be between 0 and 100)");                                              
  }
}                          
                                                
                                              
                                            
                                          
                                        
                                      
                                    

                             
                             
                             
                             
                             
                             
                             
                        
        
                                   
    
