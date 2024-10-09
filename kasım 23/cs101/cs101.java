import java.util.Scanner;
public class cs101 {
    public static void main(String[] args){
Scanner input = new Scanner(System.in);
// random0to10(2,67);
// System.out.println(random0to10(1));
// randomChar(45,90);
// randomChar();
// randomWord(9);
// random(9,7,5);
randomPalindromeStrings(input);

    }
    // Creates random number 0 to 10
//         public static int random0to10(){
// int number=(int)(Math.random()*11);
// return number;
//     }


        
    
    // overloading, same name differemt result; method header,all things; method signutureafter type.

//         public static int random0to10(int a){
// int number=(int)(Math.random()*11);
// return number;}

        public static int random65to97(){
int number=65+(int)(Math.random()*29);
return number;}

//         public static void random0to10(int a,int b){
// int number=a+(int)(Math.random()*b-1);
// System.out.println(number);
//         }


//         public static char randomChar(int a,int b){
// char number=(char)(a+(int)(Math.random()*(b-a+1)));
// return number;}


//   public static char randomChar(){
// char number=(char)((int)(Math.random()*123));
// return number;}


// public static void randomWord(int n){
// String result="";
//     for(int i=n;i>0;i--){
//         result+=randomChar((int)'a',(int)'z');
//     }
//     System.out.println(result);
// }

// public static int random(int... exculded){
//     int result=(int)Math.random()+11;
//   for(int i=0;0<exculded.length;i++){
//     if(exculded[i]==result)
//     result=random(exculded);
//     }
//     return result;
// }
// public static int swap(int a, int b){
//     int n=a;
//     a=b;
//     b=a;
//     return (a+" "+b);
    
// }
    //  public static void reverse(int number){
    //     int n=0;
    //     String reverseNumber="";
    //     for(int a=0;number/(int)Math.pow(10,a)>0;a++){
    //         n++;
    //     }

    //  for(int a=n/2;number/Math.pow(10,a)>=0;a++,n--){
    //     int first=number/Math.pow(10,a);
    //     int last=number/Math.pow(10,n);
    //     reverseNumber=last+reverseNumber+first;

    //  }
    //  System.out.println(reverseNumber);

    //  }
     public static int reserveNumber(int number){
        int result=0;
        int remain=0;

        do{remain=number%100;
           result*=10;
           result+=remain;
           number/=100;
        }while(number!=0);

        return result;

     }
     public static boolean isPalindrome(int number){
            boolean result= number==reserveNumber(number);
     return result;
        }
public static void randomPalindromeStrings(Scanner input){
    System.out.println("What will be the lenght of the String");
    int lenght=input.nextInt();
    String result="";
    if(lenght%2==1){ for(int i=lenght/2;i>0;i--){
            result+=(char)random65to97();
    }
result=result+(char)random65to97()+inverseString(result);
    }
    if(lenght%2==0){
    for(int i=lenght/2;i>0;i--){
            result+=(char)random65to97();
    }
    result+=inverseString(result);
}
System.out.println(result);
}
public static void numberstoPalindromeString(int a){
    String result="";
    while(a!=0){
    int harf=a%100;
    char letter=(char)harf;
    result+=letter;
    a/=100;
}
System.out.println(result);
}
public static String inverseString(String word){
    String result="";
    for(int i=word.length()-1;i>=0;i--){
        result+=word.charAt(i);
    }
    return result;
}


}