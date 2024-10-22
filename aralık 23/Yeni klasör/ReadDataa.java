//package chapter12;

import java.io.File;
import java.util.Scanner; 

public class ReadDataa {
  public static void main(String[] args) throws Exception {
    // Create a File instance
    java.io.File file = new java.io.File("scores.txt");
   // Today I asked how to only display certain information from the file
   // The first 10 students who send me a java code solution to display only 
   // the one student who received the highest score from a file will receive
   // 5 bonus points on their assignment total.
   // Create a Scanner for the file
    Scanner input = new Scanner(file);

    // Read data from a file
    // while (input.hasNext()) {
    //   String firstName = input.next();
    //   String mi = input.next();
    //   String lastName = input.next();
    //   int score = input.nextInt();
    //   System.out.println(
    //     firstName + " " + mi + " " + lastName + " " + score);
    // }

    String[] firstName= new String[4];
    String[] mi= new String[4];
    String[] lastName= new String[4];
    int[] scores= new int[4];
    int i=0;
    while (input.hasNext()) {
      firstName[i] = input.next();
      mi[i] = input.next();
      lastName[i] = input.next();
      scores[i] = input.nextInt();
      i++;
    }
    displayBestStudent(firstName, mi, lastName, scores);

    // Close the file
    input.close();
  }
  public static void displayBestStudent(String[] firstName, String[] mi,
                                        String[] lastName, int[] scores){
    int index=0;
    int BestScore=scores[0];
    for(int i=1;i<scores.length;i++){
        if(BestScore<scores[i]){
           index=i;
        }
    }
    System.out.printf("%s %s %s is became best with a grade %d"
                              ,firstName[index], mi[index], lastName[index],
                              scores[index]);
  }
}
