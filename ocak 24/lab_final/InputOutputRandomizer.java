import java.util.Random;

public class InputOutputRandomizer {
   
   public static void main(String[] args) {
      // input methods
//       0: Command line arguments
//       1: User enters information
//       2: Read from a file
//       3: Parameter to a method

      // output methods
      // 0: Display to screen
      // 1: Return from a method
      // 2: Writing to a file
      String algorithm = "To calculate the factorial of a given number.\n" +
      "Input = integer\nOutput = n! value";
      String[] inMethods = 
         {"getting it directly from a user.",
          "sending a parameter to a method.",
          "reading it from a file.",
          "a command line argument."};
      String[] outMethods = 
         {"displaying it to the screen.",
          "returning it from a method.",
          "writing it to a file."};
      
      Random r = new Random();
      int inIndex=0;
      int outIndex=0;
      String inputMethod="";
      String outputMethod="";
      do{
      inIndex = r.nextInt(inMethods.length);
      inputMethod = inMethods[inIndex];
      outIndex = r.nextInt(outMethods.length);
      outputMethod = outMethods[outIndex];
      }while(inIndex==outIndex||((inIndex==3)&&(outIndex==0)));
       // In the class this weeek, we wrote this program to randomly give an input method and output method
       // I also mentioned how some I/O methods pair together such as:
       // 1. getting information from a user (Scanner(System.in)) and displaying to a screen (System.out.print)
       // 2. parameter to a method and return from a method
       // 3. reading from a file and writing to a file.
       // The first 20 students who write privately to me to suggest how to modify this java code
       // to prevent the input method and output method being any of the pairs above will 
       // receive 5 bonus points on the final exam.
       // You must write your response before the exam to receive these five points
//       int num = // get a random number;
//       switch num {
//          case 0: 
      System.out.println(algorithm);
      System.out.print("I want to get the information by ");
      System.out.println(inputMethod);
      System.out.print("I want to output the information by ");
      System.out.println(outputMethod);
      
      if(r.nextBoolean())
         System.out.println("This solution must be recursive");
      else
         System.out.println("This solution must be iterative");
      
   }
}
