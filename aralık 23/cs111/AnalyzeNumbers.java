//package chapter7;

public class AnalyzeNumbers {
  public static void main(String[] args) {
//     java.util.Scanner input = new java.util.Scanner(System.in);
//     System.out.print("Enter the number of items: ");
//     int n = input.nextInt();
//     // In class today, we asked what would happen if I entered 0 for n
//     // The first five students to send me a message with the code output
//     // for entering 0 will receive 5 bonus points on the homework score
//     double[] numbers = new double[n];
//     double sum = 0;
    
//     System.out.print("Enter the numbers: ");
// //    for (int i = 0; i < numbers.length; i++) {

//     for (int i = 0; i < n; i++) {
//       numbers[i] = input.nextDouble();
//       sum += numbers[i];
//     }
    
//     double average = sum / n;

//     int count = 0; // The numbers of elements above average
//     for (int i = 0; i < n; i++) 
//       if (numbers[i] > average)
//         count++;

//     System.out.println("Average is " + average);
//     System.out.println("Number of elements above the average is "
//       + count);
System.out.println(mystery(2,100));
  }

  public static int mystery(int a,int b){
    if(b==0)
    return 0;
    else if(b%2==0)
    return mystery(a+a,b/2);
    return mystery(a+a,b/2)+a;
  }
}