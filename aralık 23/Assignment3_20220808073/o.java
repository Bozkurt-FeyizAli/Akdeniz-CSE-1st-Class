import java.util.Scanner;
// Özkan Damdelen 
// 11/12/2023
//20220808057
// 1. Year Student
public class o{
   public static void main(String[] args) {
    

    String[] deneme1={"quiz","homework","midterm exam","final exam"};
    int[] deneme2={4,3,1,1};
    int[] deneme3={10,20,30,40};

    calculateGrade(deneme1, deneme2, deneme3);
    
}
/////////////////////////////////////////////////////
public static int menu(Scanner kt,String[] list){
     for(int i = 0; i < list.length ; i++ ){
        System.out.println(i +"-"+list[i]);
     }
     System.out.println("Q - to Quit ");
     String seçim = kt.nextLine();
     String Seçim = seçim.toUpperCase();
     if(seçim.equals("Q")){
        return -1;
     }
     else if(seçim.equals("q")){
        return -1;
     }
     else if(Integer.parseInt(Seçim)== -1){
        return -2; 
     }
     else{
        int girilen = Integer.parseInt(Seçim);
        return girilen;
     }
   }
//////////////////////////////////////////////////////
public static void formatCategorName(String name[]){
    for(int i = 0; i < name.length ; i++){
        char capital = Character.toUpperCase(name[i].charAt(0));
        name[i]=capital+name[i].substring(1).toLowerCase();
    }    
   }
//////////////////////////////////////////////////////
public static Boolean isQuantityValid(int quantity[]){
    Boolean result =true;
    for(int i=0;i<quantity.length;i++){
    result=quantity[i]>0;
    if(quantity[i]< 0 ){
        System.out.println("Error : Invalid quantity entered");
    }
        if(result==false){break;}
    }
    return result;
    } 
/////////////////////////////////////////////////////
public static Boolean isWeightValid(int weight[]){
        Boolean result=true;
        int sumOfWeight=0;
        for(int i=0;i<weight.length;i++){
            sumOfWeight+=weight[i];
            if(sumOfWeight > 100 ){
                System.out.println("Error : Invalid weight entered");
            }
            else if(weight[i]<0){
                System.out.println("Error : Invalid weight entered");
            }
            
        result=(weight[i]>0); 
            if(result==false){
            break;}
        }
        int val = 0;
        for(int i=0;i<weight.length;i++){
        val+=weight[i];
        }
        if(val!=100){
            System.out.println("Error : Invalid weight entered");        
            }
        result=(result&&sumOfWeight<=100);
        return result;
        }
//////////////////////////////////////////////////////
public static double gradeCalculeter( double deger, int girdisayisi){
                double ortalama = deger / girdisayisi;
                return ortalama;
    }
//////////////////////////////////////////////////////
 public static String gradeLetter(Double ortalama){
        if(ortalama > 87){
            return "AA";}
        else if(ortalama > 80){
            return "BA";}
        else if(ortalama > 73){
            return "BB";}
        else if(ortalama > 66){
            return "CB";}
        else if(ortalama > 59){
            return "CC";}
        else if(ortalama > 52){
            return "DC";}
        else if(ortalama > 45){
            return "DD";}
        else if(ortalama > 34){
            return "FD";}
        else{
            return "FF";}
    }
//////////////////////////////////////////////////////
public static double gpaPoint(double ortalama){
    if(ortalama >= 87){
        return 4.0;}
    else if(ortalama > 80){
        return 3.5;}
    else if(ortalama > 73){
        return 3.0;}
    else if(ortalama > 66){
        return 2.5;}
    else if(ortalama > 59){
        return 2.0;}
    else if(ortalama > 52){
        return 1.5;}
    else if(ortalama > 45){
        return 1.0;}
    else if(ortalama > 34){
        return 0.5;}
    else{
        return 0.0;}
    }
//////////////////////////////////////////////////////
public static String ArePassed(double grade){
    if(grade >= 60){
        return "Passed";
        }
    else if(grade >= 46){
        return "Conditionally passed";
        }
    else{
        return "Failed";
        }
    }
/////////////////////////////////////////////////////
public static boolean Same(String[] category,int[] quantity,int[] weight){
    if( weight.length == quantity.length && category.length == quantity.length){
        return true;
    }
    else{
        System.out.println("ERROR: Array lengths are not all the same");
        return false;
        }
    }
////////////////////////////////////////////////////////
public static void EnterGrades(String[] category, int[] quantity, 
         Scanner kt , double[] c1, double[] c2, double[] c3, double[] c4){
    for(int i = 0; i<category.length; i++){
         for(int j = 1; j<=quantity[i]; j++){
            System.out.print("Please enter grade for " + category[i]
                              +" " + j + ">> ");
            switch(i){
             case 0:
                c1[j-1] = kt.nextInt();
                kt.nextLine();
                while(c1[j-1] < 0 ){
                System.out.print("Please enter grade for Quiz "+(j)+" >>\n" ); 
                c1[j-1] = kt.nextInt();
                kt.nextLine();
                }
                while( c1[j-1]> 100){
                System.out.print("Please enter grade for Quiz "+(j)+" >>\n" ); 
                c1[j-1] = kt.nextInt();
                kt.nextLine();
                }
                break;
             case 1:
                c2[j-1] = kt.nextInt();
                kt.nextLine();
                while(c2[j-1] < 0 ){
                System.out.print("Please enter grade for Homework "+(j)+" >>\n" ); 
                c2[j-1] = kt.nextInt();
                kt.nextLine();
                }
                while( c2[j-1]> 100){
                System.out.print("Please enter grade for Homework "+(j)+" >>\n" ); 
                c2[j-1] = kt.nextInt();
                kt.nextLine();
                }
                break;   
             case 2:
                c3[j-1] = kt.nextInt();
                kt.nextLine();
                while(c3[j-1] < 0){
                System.out.print("Please enter grade for Midterm exam "+(j)+" >>\n" ); 
                c3[j-1] = kt.nextInt();
                kt.nextLine();
                }
                while( c3[j-1]> 100){
                System.out.print("Please enter grade for Midterm exam "+(j)+" >>\n" ); 
                c3[j-1] = kt.nextInt();
                kt.nextLine();
                }
                break;   
                case 3:
               c4[j-1] = kt.nextInt();
                kt.nextLine();
                while(c4[j-1] < 0){
                System.out.print("Please enter grade for Final exam "+(j)+" >>\n" ); 
                c4[j-1] = kt.nextInt();
                kt.nextLine();
                }
                while( c4[j-1]> 100){
                System.out.print("Please enter grade for Final exam "+(j)+" >>\n" ); 
                c4[j-1] = kt.nextInt();
                kt.nextLine();
                }
                break;      
                }
     
            }
        }
}
////////////////////////////////////////////////////////
public static void GradeDisplay(String[] category,int[] quantity,
        int[] weight,double[] c1, double[] c2,double[] c3,double[] c4){
        double val1 = 0, val2 = 0, val3 = 0, val4 = 0;
        for (double kt1 : c1) {
            val1 += kt1;
        }
        for (double kt2 : c2) {
            val2 += kt2;
        }
        for (double kt3 : c3) {
            val3 += kt3;
        }
        for (double kt4 : c4) {
            val4 += kt4;
        }
        double grade1;
        double grade2;
        double grade3;
        double grade4;
        grade1 =val1 / quantity[0];
        grade2 =val2 / quantity[1];
        grade3 =val3 / quantity[2];
        grade4 =val4 / quantity[3];
        System.out.print(category[0]);
        System.out.printf(" - %.2f\n" ,grade1);
        System.out.print(category[1]);
        System.out.printf(" - %.2f\n" ,grade2);
        System.out.print(category[2]);
        System.out.printf(" - %.2f\n" ,grade3);
        System.out.print(category[3]);
        System.out.printf(" - %.2f\n" ,grade4);
        double gradeoverall = grade1 * weight[0]/100.0 +grade2 * 
               weight[1]/100.0+grade3*weight[2]/100.0 + 
               grade4*weight[3]/100.0 ;
        System.out.printf("Overall Grade - %.2f\n",gradeoverall);
        System.out.printf("Grade Letter - %s\n", gradeLetter(gradeoverall));
        System.out.printf("GPA Points - %.1f\n" ,gpaPoint(gradeoverall));
        System.out.printf("Status - %s\n", ArePassed(gradeoverall)); 
        System.out.println();                    
    }
////////////////////////////////////////////////////////
public static void GradeChanging(String[] category,int[] quantity,
                                 Scanner kt ,double[] c1,double[] c2,
                                 double[] c3,double[] c4){
    System.out.println("Please enter the category ");
    for(int i = 0 ; i < category.length ; i++){
        System.out.println(i+" - "+category[i]);
    }                    
    System.out.println("Q - to Quit ");
    String scanner = kt.nextLine();
    if(scanner.toUpperCase().equals("Q")){return;}

    int decision = Integer.parseInt(scanner);
    int decision1 = 1 ;
    switch(decision){
        case 0 :
          if(c1.length != 1 ){
            System.out.println("Please enter which " + 
            category[decision] + " you would like to change "
            + "(1 - " + quantity[decision] + ") >> ");

            decision1 = kt.nextInt();
            kt.nextLine();
            if(decision1 > quantity[0] || decision1 < 1){
                System.out.println("Invalid choise");
            }
            while(c1.length < 0 && c1.length >100){
                System.out.print("Please enter grade for Quiz"+(1)+" >>\n" ); 
                decision = kt.nextInt();
                kt.nextLine();
                }
        }   break;
        case 1 :
           if(c2.length != 1 ){
            System.out.println("Please enter which " +
             category[decision] + " you would like to change "
            + "(1 - " + quantity[decision] + ") >> ");

            decision1 = kt.nextInt();
            kt.nextLine();
            if(decision1 > quantity[1] || decision1 < 1){
                System.out.println("Invalid choise");
            }
            while(c2.length < 0 && c2.length >100){
                System.out.print("Please enter grade for Quiz"+(2)+" >>\n" ); 
                decision = kt.nextInt();
                kt.nextLine();
                }
        }   break;
        case 2 :
          if(c3.length != 1 ){
            System.out.println("Please enter which " + 
            category[decision] + " you would like to change "
            + "(1 - " + quantity[decision] + ") >> ");

            decision1 = kt.nextInt();
            kt.nextLine();
            if(decision1 > quantity[3] || decision1 < 1){
                System.out.println("Invalid choise");
            }
            while(c3.length < 0 && c3.length >100){
                System.out.print("Please enter grade for Quiz"+(3)+" >>\n" ); 
                decision = kt.nextInt();
                kt.nextLine();
                }
        }  break;
        case 3 :
          if(c4.length != 1 ){
            System.out.println("Please enter which " +
             category[decision] + " you would like to change "
            + "(1 - " + quantity[decision] + ") >> ");

            decision1 = kt.nextInt();
            kt.nextLine();
            if(decision1 > quantity[4] || decision1 < 1){
                System.out.println("Invalid choise");
            }
            while(c4.length < 0 && c4.length >100){
                System.out.print("Please enter grade for Quiz"+(4)+" >>\n" ); 
                decision = kt.nextInt();
                kt.nextLine();
                }
        }   break;
        default:
        System.out.println("Invalid choice");
        return;
    }
    //////////////
    switch(decision){
        case 0:
            System.out.println("The current grade for " +
             category[decision] +" " + decision1 +" is " + c1[decision1-1] ); 
            System.out.print("Please enter the new grade value >> ");
            c1[decision1-1] = kt.nextInt();
            kt.nextLine();
            break;
        case 1:
            System.out.println("The current grade for " + 
            category[decision] +" " + decision1 +" is " + c1[decision1-1] ); 
            System.out.print("Please enter the new grade value >> ");
            c2[decision1-1] = kt.nextInt();
            kt.nextLine();
            break;
        case 2:
            System.out.println("The current grade for " +
             category[decision] +" " + decision1 +" is " + c1[decision1-1] ); 
            System.out.print("Please enter the new grade value >> ");
            c3[decision1-1] = kt.nextInt();
            kt.nextLine();
            break;
        case 3:
            System.out.println("The current grade for " +
             category[decision] +" " + decision1 +" is " + c1[decision1-1] ); 
            System.out.print("Please enter the new grade value >> ");
            c4[decision1-1] = kt.nextInt();
            kt.nextLine();
            break;
        default:
        System.out.println("Invalid choice");break;
        }
        System.out.println();
    }
////////////////////////////////////////////////////////
public static void calculateGrade(String[] category,
                                   int[] quantity, int[] weight){
   if(Same(category, quantity, weight)&& isQuantityValid(quantity)
      &&isWeightValid(weight)){
    System.out.println("Welcome to our university grade system.");
    Scanner kt = new Scanner(System.in);
    String[] conditions = {"Enter all grades","Display all grade information",
                           "Change a single grade"};
    formatCategorName(category);

    double[] c1 = new double[quantity[0]];
    double[] c2 = new double[quantity[1]];
    double[] c3 = new double[quantity[2]];
    double[] c4 = new double[quantity[3]];
    int decision ;
    boolean statement = true;
    // false to true
    boolean i = true ;
    while(statement == i){
        System.out.println();
        System.out.println("Please enter choice below : ");
        decision = menu(kt, conditions);
        switch(decision){
            case 0 :
              EnterGrades(category, quantity, kt, c1, c2, c3, c4);
              break;
            case 1 :
              GradeDisplay(category, quantity, weight, c1, c2, c3, c4);
              break;
            case 2:
              GradeChanging(category, quantity, kt, c1, c2, c3, c4);  
              break;
            case -1 :
              System.out.println("Thank you for using our system."+
                                 " Have a nice day. ");
              return;
            default:
            System.out.println("Invalid choice"); 

        }

    }
   }
   else;
   }


}

