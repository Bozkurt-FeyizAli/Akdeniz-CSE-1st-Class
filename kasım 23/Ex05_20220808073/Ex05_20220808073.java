import java.util.Scanner;
public class Ex05_20220808073{
    public static void main(String[] args){


    }

    public static double computePI(int lastTop){   
        if (lastTop>=0){
double resultPI=0.0;
int i=1;
while(i<=lastTop){
    resultPI+=4*(Math.pow(-1,i+1))/(2*i-1);
    i++;
}
if(lastTop==0) resultPI=3.0;
return resultPI;}
else 
return 0.0;
     }
    
    public static int factorial(int lastDigit){
        if (lastDigit>=0){                  
        int result=1;
        while(lastDigit>0){
            result*=lastDigit;
            lastDigit--;
        }
        return result;}
        else 
        return 0;
     }
    
     public static boolean isPrime(int number){
        if (number>=0){
        boolean result=true;
        int i=2;
        if(number>0){
        while(i<=(number/2)){
            if (number % i == 0) {
                result = false;
                break;
            }
            i++;
        }}
            else 
            result=false;
        if(number==1) result=false;
        return result;}
        else return false;
     }

    public static void nPrime(int number){
    if (number>=0){
for(int i=1,n=0; ;i++){
   if(isPrime(i)){
    System.out.printf("%d ",i);
    n++;
   }
   if (n==number) break;
}}
else System.out.println("ERROR: please write a positive number");
}

    public static boolean isPerfect(int number){
        if (number>=0){
    boolean result=false;
    double i;
    int sum=0;
    for(i=0.0;i<=(number/2);i++){
        if(number%i==0)
        sum+=i;
    }
   result=(sum==number);
   return result;}
   else return false;
}
    
    public static void nPerfects(int number){
        if (number>=0){
for(int i=1,n=0; ;i++){
   if(isPerfect(i)){
    System.out.printf("%d ",i);
    n++;
   }
   if (n==number) break;
}}
else System.out.println("ERROR: please write a positive number");
}
    
    public static void displayStatistics(int numberOfData) {
        Scanner input= new Scanner(System.in);
    double sum = 0;
    double sumSquare = 0;
    double deviation = 0.0;

    for (int i=1;numberOfData>=i;i++) {
        System.out.printf("Please write data %d: ",i);
        double data=input.nextDouble();
        sum+=data;
        sumSquare+=Math.pow(data,2);
    }
    double mean = sum/numberOfData;
    deviation = Math.sqrt((sumSquare - (Math.pow(sum, 2) /
                numberOfData)) / (numberOfData - 1));

    System.out.printf("Mean = %.2f .\n", mean);
    System.out.printf("Standard deviation is %.5f .", deviation);
}

}