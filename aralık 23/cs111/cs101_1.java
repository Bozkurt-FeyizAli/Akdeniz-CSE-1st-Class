import java.util.Scanner;
public class cs101 {
    public static void main(String[] args){
Scanner input = new Scanner(System.in);
random0to10(2,67);
System.out.println(random0to10(1));
randomChar(45,90);
randomChar();
randomWord(9);
random(9,7,5);

    }
    // Creates random number 0 to 10
        public static int random0to10(){
int number=(int)(Math.random()*11);
return number;
    }


        
    
    // overloading, same name differemt result; method header,all things; method signutureafter type.

        public static int random0to10(int a){
int number=(int)(Math.random()*11);
return number;}


        public static void random0to10(int a,int b){
int number=a+(int)(Math.random()*b-1);
System.out.println(number);
        }


        public static char randomChar(int a,int b){
char number=(char)(a+(int)(Math.random()*(b-a+1)));
return number;}


  public static char randomChar(){
char number=(char)((int)(Math.random()*123));
return number;}


public static void randomWord(int n){
String result="";
    for(int i=n;i>0;i--){
        result+=randomChar((int)'a',(int)'z');
    }
    System.out.println(result);
}

public static int random(int... exculded){
    int result=(int)Math.random()+11;
  for(int i=0;0<exculded.length;i++){
    if(exculded[i]==result)
    result=random(exculded);
    }
    return result;
}





}