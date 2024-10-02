import java.util.Scanner;
public class Assignment1b_20220808073 {
    public static void main(String[] args)
    {
// step one (get weight of categories)
       String StudentName = "Feyiz Ali BOZKURT";
       Scanner pers1 = new Scanner(System.in); 
       System.out.print("write weight(persantage) of Quiz:");
       int WeightOfQuiz = pers1.nextInt();
       Scanner pers2 = new Scanner(System.in); 
       System.out.print("write weight(persantage) of Homework:");
       int WeightOfHomework = pers2.nextInt();
       Scanner pers3 = new Scanner(System.in);
       System.out.print("write weight(persantage) of Middterm-Exam:");
       int WeightOfMidExam = pers3.nextInt();
       Scanner pers4 = new Scanner(System.in); 
       System.out.print("write weight(persantage) of Final Exam:");
       int WeightOfFinalEXam = pers4.nextInt();
       int SumOfValues = (WeightOfQuiz + WeightOfHomework) +
                         (WeightOfMidExam + WeightOfFinalEXam);
                        if (SumOfValues == 100) {
                        Scanner result1 = new Scanner(System.in);
                        System.out.println("Please write reultt of quiz:");
                        int ResultOfQuiz = result1.nextInt();
                        }   else 
                            System.out.println("ERROR : Idvalid number entered"+
                                               "(must be between 0 and 100) ");
                                if  (0<ResultOfQuiz<100){
                                Scanner result2 = new Scanner(System.in);
                                System.out.println("Please write reultt of homework:");
                                int ResultHomework = result2.nextInt();
                                }       
                                    else
                                    System.out.println("ERROR : Idvalid number entered"+
                                                       "(must be between 0 and 100) "); 
                                        if  ((ResultHomework>= 0) || (ResultHomework<=100)) {
                                        Scanner result3 = new Scanner(System.in);
                                        System.out.println("Please write reultt of Midterm:");
                                        int ResultMidterm = result3.nextInt();
                                        }
                                            else 
                                            System.out.println("ERROR : Idvalid number entered"+
                                                               "(must be between 0 and 100) ");
                                                if((ResultMidterm>= 0) || (ResultMidterm<=100)) {
                                                Scanner result4 = new Scanner(System.in);
                                                System.out.println("Please write reultt of FinalExam:");
                                                int ResultFinalExam = result4.nextInt();
                                                }
                                                    else 
                                                    System.out.println("ERROR : Idvalid number entered"+
                                                                       "(must be between 0 and 100) ");
                                                        if ((type)StudentName == String)
                                                        System.out.println("ok");


      
        

    }
}