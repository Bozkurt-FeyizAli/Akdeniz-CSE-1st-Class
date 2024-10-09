import java.util.Scanner;
public class Chapter6{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
// System.out.println("write sth");
// String name=input.nextLine();

monthDay("january",-9999);
}

    
        public static void patternd(int num){
            for(int i=1;i>=num;i++){
            for(int j=1;j>=num-i;num--,j++){
            System.out.printf("%2s"," ");}
        
        for (int j=i;j>=1;j--){
System.out.printf("%d ",j);
        }
System.out.println();}


}public static void paterna(int n){
for(int i=1;i<=n;i++){
for(int j=n-i;j>=1;j--){
    System.out.printf("%2s"," ");
}
for(int j=i;j>=1;j--){
    System.out.printf("%2d",j);
}
// for(int j=2;j<=i;j++){
//     System.out.printf("%2d",j);
// }
System.out.println();
}}

public static void paternA(int lastNUm){
  for(int k=0;k<=lastNUm;k++){

    for (int j=1;j<=k;j++)
    System.out.printf(" %2d",j);
    System.out.println();
  }
  
}
public static void paternB(int lastNUm){
  for(int k=lastNUm;k>0;k--){

    for (int j=1;j<=k;j++)
    System.out.printf(" %2d",j);
    System.out.println();
  }
  
}
public static void paternC(int lastNum){
  for(int k=1;k<=lastNum;k++){
    for(int a=lastNum-1;a>0;a--){
    System.out.printf("%2s", " ");}
    for(int s=k;s>=1;s--){
    System.out.printf("%2d",s);}
    // for (int j=1;j<=k;j++)
    // System.out.printf(" %2d",j);
    System.out.println();
    
  }
  
}



// }
// public static void vowelLetter(String name){
// for (int a =0;a<=name.length();a++){
//     name=name.toUpperCase();
//     char l=name.charAt(a);
//     String letter=(String)l;
//     if (Character.("A")||letter.equals("E")||letter.equals("I")||letter.equals("O")||letter.equals("U"))
//     System.out.printf("vowel letters in your name are %c   ",letter);}
    
// }
// }
// public static double garip(int n){
//     double suma=0.0;
//     double sumb=0.0;
//         int sum1=0;
//         int sum2=0;
//     for (int i=n;n>=0;n--){

// sum1+=n;
// if (n==0){
//     sum1/=i;
// }


//     }
//     for(int b=n;n>=0;n--){

//     sum2+=n*n;
//     if(n==0){
//         sum2/=b;
//     }
// }
    
//     return Math.sqrt((sum1-((sum2*sum2)/n))/n-1);
// }
public static void year(int year, Scanner scanner){
    System.out.println("which month");
    String month=scanner.nextLine();
    if (month.equalsIgnoreCase("january")){
        System.out.println("              JANUARY\n -------------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int n= 1;n<=9;n++){
        System.out.printf("%2d   ", n);
                if(n==7){
            System.out.println();
        }
      }
      for(int i=10;i<=31;i++){
        System.out.printf("%3d  ", i);
        if(i==14||i==21||i==28){
            System.out.println();
      }
    }}
    else if (month.equalsIgnoreCase("February")){
        System.out.println("             FEBRUARY\n --------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int i= 1;i<=9;i++){
        if(i==1){System.out.print("               ");}
        System.out.printf(" %1d   ", i);
                if(i==4||i==11){
            System.out.println();
        }
      }
      for(int i=10;i<=28;i++){
        System.out.printf("%3d  ", i);
        if(i==11||i==18||i==25||i==32){
            System.out.println();
      }
    }
}
else if (month.equalsIgnoreCase("March")){
        System.out.println("             MARCH\n --------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int i= 1;i<=9;i++){
        if(i==1){System.out.print("                              ");}
        System.out.printf(" %1d   ", i);
                if(i==1||i==8){
            System.out.println();
        }
      }
      for(int i=10;i<=31;i++){
        System.out.printf("%3d  ", i);
        if(i==15||i==22||i==29){
            System.out.println();
      }
    }
}
else if (month.equalsIgnoreCase("April")){
        System.out.println("             APRIL\n --------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int i= 1;i<=9;i++){
        if(i==1){System.out.print("          ");}
        System.out.printf(" %1d   ", i);
                if(i==5||i==12){
                    System.out.println();
        }
      }
      for(int i=10;i<=30;i++){
        System.out.printf("%3d  ", i);
        if(i==12||i==19||i==26){
            System.out.println();
      }
    }
}
else if (month.equalsIgnoreCase("May")){
        System.out.println("             MAY\n --------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int i= 1;i<=9;i++){
        if(i==1){System.out.print("                         ");}
        System.out.printf(" %1d   ", i);
                if(i==2||i==9){
            System.out.println();
        }
      }
      for(int i=10;i<=31;i++){
        System.out.printf("%3d  ", i);
        if(i==16||i==23||i==30){
            System.out.println();
      }
    }
}
else if (month.equalsIgnoreCase("june")){
        System.out.println("             JUNE\n --------------------------------");
        System.out.println("Sun  Mon  Wed  Thur Fri  Sat  Sun");
      for(int i= 1;i<=9;i++){
        if(i==1){System.out.print("                              ");}
        System.out.printf(" %1d   ", i);
                if(i==1||i==8){
            System.out.println();
        }
      }
      for(int i=10;i<=30;i++){
        System.out.printf("%3d  ", i);
        if(i==15||i==22||i==29){
            System.out.println();
      }
    }
}




  
}

static Boolean isLeapYear(int year){
  boolean result= (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? true:false;
return result;
}
static int numberOfDay(int year){
  int result;
  if (year>=1997){
  result=(1+ Math.abs(1996-year))%7;}
  else if (year>=0){
  result=7-((1+ Math.abs(1996-year))%7);}
  else result=7-((2+(1996+ Math.abs(year)))%7);
  return result;
}
public static void monthDay(String nameOfMonth, int year) {
 // Adjust for array indexing

  int daysInMonth;
  switch (nameOfMonth.toLowerCase()) {
      case "january":
      case "march":
      case "may":
      case "july":
      case "august":
      case "october":
      case "december":
          daysInMonth = 31;
          break;
      case "april":
      case "june":
      case "september":
      case "november":
          daysInMonth = 30;
          break;
      case "february":
          daysInMonth = isLeapYear(year) ? 29 : 28;
          break;
      default:
          daysInMonth = -1; 
  }

  System.out.println("                 " + nameOfMonth + "\n ----------------------------------------");
  System.out.println("Mond   Tues   Wedn   Thur   Frid   Satu   Sund");

  int dayOfWeek = firsDayOfWeek(year, nameOfMonth);


  for (int space = 1; space < dayOfWeek; space++) {
      System.out.print("       ");
  }

  for (int i = 1; i <= daysInMonth; i++, dayOfWeek++) {
      if (dayOfWeek > 7) {
          System.out.println(); // 
          dayOfWeek = 1;
      }

      System.out.printf("%-7d", i);
  }

  System.out.println();
}



public static void timesOfWord(Scanner input){
  int result=0;
  System.out.println("Please write a sentence: ");
  String word=input.nextLine();
  input.nextLine();
  System.out.println("Which word do you want to search in sentence");
  String searchWord=input.nextLine();
  for(int i=0,k=0;i<=word.lenght();){
int j=word.indexOf(" ");
String wordInSentence=word.substring(k, j-1);
if(wordInSentence.equals(searchWord)){
  result++;
}
k+=j;
i+=k;
  }
  System.out.printf("your word is used %d times in sentence.",result);
}

public static void displayStudentWithScores(int numberOfStudent,Scanner scanner){
  String nameOfHighestpoint=" ";
  String nameOfSecondHighestpoint=" ";
  int highestPoint=0;
  int secondHighestPoint=0;
  for(int i=1;i<=numberOfStudent;i++){
    System.out.printf("write name of student %d:",i);
    String name=scanner.nextLine();
    System.out.println("point of student");
    int point=scanner.nextInt();
    if (point>highestPoint){
      nameOfHighestpoint=name;
      highestPoint=point;
    }
    else if(point>secondHighestPoint){
      nameOfSecondHighestpoint=name;
      secondHighestPoint=point;
    }
    scanner.nextLine();
  }
  System.out.printf("First in exam is %s with a poit of %d .",nameOfHighestpoint,highestPoint);
  System.out.println();
  System.out.printf("second in exam is %s with a point of %d .",nameOfSecondHighestpoint,secondHighestPoint);
}

static int firsDayOfWeek(int year, String nameOfMonth ){
  int firstDayOfWeek = numberOfDay(year);
    switch (nameOfMonth.toLowerCase()) {
   case "january":
   firstDayOfWeek=firstDayOfWeek;
   break;
   case "february":
   firstDayOfWeek= firstDayOfWeek+3;
   break;
      case "march":
      firstDayOfWeek= isLeapYear(year) ? firstDayOfWeek+4:firstDayOfWeek+3;
      break;
      case "april":
       firstDayOfWeek=isLeapYear(year) ? firstDayOfWeek :firstDayOfWeek+6;
      break;
      case "may":
      firstDayOfWeek= isLeapYear(year) ? firstDayOfWeek+2:firstDayOfWeek+1;
      break;
      case "june":
       firstDayOfWeek=isLeapYear(year) ? firstDayOfWeek+1:firstDayOfWeek+4;
      break;
      case "july":
       firstDayOfWeek=isLeapYear(year) ? firstDayOfWeek :  firstDayOfWeek+1;
      break;
      case "august":
      firstDayOfWeek= isLeapYear(year) ? firstDayOfWeek+3:firstDayOfWeek+2;
      break;
      case "september":
      firstDayOfWeek= isLeapYear(year) ? firstDayOfWeek+6:firstDayOfWeek+5;
      break;
      case "october":
       firstDayOfWeek=isLeapYear(year) ? firstDayOfWeek+1:firstDayOfWeek;
      break;
      case "november":
       firstDayOfWeek=isLeapYear(year) ? firstDayOfWeek+4:firstDayOfWeek+3;
      break;
      case "december":
      firstDayOfWeek= isLeapYear(year) ? firstDayOfWeek+6:firstDayOfWeek+5;
      break;
    default:firstDayOfWeek=firstDayOfWeek;
      break;
  }
  return firstDayOfWeek;
}

}