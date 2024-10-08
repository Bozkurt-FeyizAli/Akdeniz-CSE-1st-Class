import java.util.Scanner;
public class Calendar{
public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    int result;
    Integer year;
    String month;
    do{
System.out.println("please write month :");
    month=input.nextLine();
    result=isMonth(month)?1:0;
}while(result==1);
    do{
    input.nextLine();
    System.out.println("please write year as an integer:");
    year = input.nextInt();
    result=year>=-100000||year<=100000?1:0;
}while(result==0);
monthDay(month, year);
}

static boolean isMonth(String month){
    boolean result;
  switch (month.toLowerCase()) {
      case "january":
      case "march":
      case "may":
      case "july":
      case "august":
      case "october":
      case "december":
      case "april":
      case "june":
      case "september":
      case "november":
      case "february":
      result=true;
      default:
         result=false;
  }
  return result;
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