import java.util.Scanner;
public class deneme {
    // @ Feyiz Ali Bozkurt @ Since 5 December 2023


    public static void main(String[] args){

        Scanner input= new Scanner(System.in);


        String[] deneme1={"quiz","homework","midterm exam","final exam"};
        int[] deneme2={4,3,1,1};
        int[] deneme3={10,20,30,40};
    
        calculateGrade(deneme1, deneme2, deneme3);

    }

    public static int menu(Scanner input, String list[]){
        String girdi="";
        int result;
        formatCategoryName(list);
        for(int i=0;i<list.length;i++)
        {
            System.out.printf("%d - %s \n", i, list[i]);
        }
        System.out.println("Q - to quit");
        girdi = input.nextLine(); 
        girdi=girdi.toUpperCase();
        if(girdi.equalsIgnoreCase("Q")){girdi="-1";}
        if (!girdi.isEmpty()) {
             result=Integer.parseInt(girdi);
        }
        else{
            result = -2;
        }       
         
        return result;
    }
    
    public static void calculateGrade(String category[],
                                      int quantity[], int weight[]){
        Scanner input=new Scanner(System.in);
        if(category.length!=quantity.length||category.length!=weight.length){  
            System.out.println("ERROR: Array lenghts are not all the same");}
        else{
        formatCategoryName(category);
        boolean isQuantity;
        boolean isWeight;
        isQuantity=isQuantityValid(quantity);
            if(isQuantity==false){
                System.out.println("ERROR: Invalid quantity entered");}   
                isWeight=isWeightValid(weight);
            if(isWeight==false){
                System.out.println("ERROR: Invalid weight entered");}
                if(isQuantity==true&&isWeight==true){
                    String[] list={"Enter all grades",
                    "Display grade information","Change a single grade"};
                    formatCategoryName(list);
                    int menuChoise;
                    int choiseForCategory=0;
                    int choiseForQuantity=0;
                    boolean isUserEnteredGrades=false;
                    int maxQuantityOfArray=0;
                        for(int i=0;i<quantity.length;i++){
                            if(quantity[i]>maxQuantityOfArray){
                               maxQuantityOfArray=quantity[i];
                            } 
                        }

                    double[][] allExamResults=
                    new double[category.length][maxQuantityOfArray];
                    System.out.println
                    ("Welcome to our university grade system.");
                    do{
                        System.out.println();
                        System.out.println("Please enter a choice below:");
                        menuChoise=menu(input, list);
                        System.out.println();
                            if(menuChoise==0){
                                allExamResults=
                                allExamResultArray(input,category, quantity);  
                                isUserEnteredGrades=true;
                            }
                            else if(menuChoise==1){
                                if(!isUserEnteredGrades){
                                    System.out.println
                        ("ERROR: you have not entered exam results yet!");
                                }
                                else{
                                    voidGrades(allExamResults,
                                               category, quantity, weight);
        
                                }
                            }
                            else if(menuChoise==2){
                                if(!isUserEnteredGrades){
                                    System.out.println
                        ("ERROR: you have not entered exam results yet!");
                                }
                                else{
                                    choiseForCategory=
                                    choiceForCategory(input, category);
                                    if(choiseForCategory<0||
                                       choiseForCategory>=category.length){
                                        System.out.println
                                        ("Invalid choice."); 
                                    }
                                    else{
                                        choiseForQuantity=
                                        choiceForQuantity
                                        (input, category,
                                        choiseForCategory, quantity);
                                        if(choiseForQuantity<0||
                                        choiseForQuantity>=
                                        quantity[choiseForCategory]){
                                            System.out.println
                                            ("Invalid choice.");  
                                        }
                                        else{
                                            changeAsingleGrade
                                            (category, choiseForCategory,
                                            choiseForQuantity, input,
                                            allExamResults);
                                        }
                                    }
                                }
                            }
        
                        }while(menuChoise!=-1); 
                        if(menuChoise==-1){
                            System.out.println
                    ("Thank you for using our system. Have a nice day.");
                
                }
            }
        }

            
        
}
    
    public static double[] allExamResult(Scanner input,
                                         String category[], int quantity[]){
        int weightOfExamResultArray=0;
            for(int i=0;i<quantity.length;i++){
                        weightOfExamResultArray+=quantity[i];
            }
        double[] result=new double[weightOfExamResultArray];
        int index = 0;
            for(int i=0;i<category.length;i++){
                for(int k=1;k<=quantity[i];k++){
                    do{
                        System.out.printf
                        ("Please enter grade for %s %d >> "
                        ,category[i],k);
                        result[index]=input.nextInt();
                            if(result[index]<0||result[index]>100){
                                System.out.println("Invalid choice.");
                            }   
                    }while(result[index]<0||result[index]>100);
                    index++;
                }
            }
        return result;
    }
   
    public static double[][] allExamResultArray(Scanner input,
                                                String category[],
                                                int quantity[]){
        int maxQuantityOfArray=0;
            for(int i=0;i<quantity.length;i++){
                if(quantity[i]>maxQuantityOfArray){
                   maxQuantityOfArray=quantity[i];
                }
            }          
        double[][] result=new double[category.length][maxQuantityOfArray];

            for(int i=0;i<category.length;i++){
               for(int k=0;k<quantity[i];k++){
                    do{
                    System.out.printf
                    ("Please enter grade for %s %d >> "
                    ,category[i],k+1);
                    result[i][k]=input.nextInt();
                        if(result[i][k]<0||result[i][k]>100){
                            System.out.println("Invalid choice.");
                        }
                    }while(result[i][k]<0||result[i][k]>100);
                }
        }
        return result;
    }

    public static double[] gradeAvregeForCategories
                                                    (double[] examResults,
                                                    String[] Category,
                                                    int[] quantity){
        double[] result= new double[Category.length];
        int resultIndex=0;
            for(int i=0;i<Category.length;i++){
                double sumForCategory=0;
                    for(int j=0;j<quantity[i];j++){
                        sumForCategory += examResults[resultIndex];
                        resultIndex++;
                    }
                result[i] = sumForCategory / quantity[i];
            }
        return result;
        }
     
    public static void changeASingleGrade(Scanner input, String[] category,
                                          int[] quantity,
                                          double[][] allExamResult){
        int choiseForCategory=0;
        int choiseForQuantity=0;
        int candidsteResult=0;
           System.out.println("Please enter the category");
           choiseForCategory= menu(input, category);
           input.nextLine();
            if(choiseForCategory>=0){
                if(quantity[choiseForCategory]>1){
                    System.out.printf
          ("Please enter which %s you would like to change (1 - %d) >>",
                   category[choiseForCategory],
                   quantity[choiseForCategory]);
                   choiseForQuantity=input.nextInt()-1;
                }
                else 
                    choiseForQuantity=0;
                if(choiseForQuantity>-1&&
                   choiseForQuantity<
                   quantity[choiseForCategory]){
                    System.out.printf
                    ("The current grade for %s is %.1f",
                    category[choiseForCategory],
                       allExamResult[choiseForCategory][choiseForQuantity]);
                                    System.out.println();
                                    System.out.println
                                    ("Please enter the new grade value >>");
                                    candidsteResult=input.nextInt();
                                        if(candidsteResult>=0||
                                           candidsteResult<=100){
                        allExamResult[choiseForCategory][choiseForQuantity]=
                        candidsteResult; 
                                        }
                                        else 
                                            System.out.println
                                            ("Invalid choice.");
                                }
                                else 
                                    System.out.println("Invalid choice.");
                                }
                                else 
                                    System.out.println("Invalid choice.");

    }
 
    public static int choiceForCategory(Scanner input, String[] category){
        System.out.println("Please enter the category");
        return menu(input, category);
    }

    public static int choiceForQuantity(Scanner input, String[] category,
                                        int choiceForCategory, int[] quantity){
        int choiceForQuantity=0;
        if(quantity[choiceForCategory]==1){
            return 0;
        }
        else{
            System.out.printf
         ("Please enter which %s you would like to change (1 - %d) >>",
            category[choiceForCategory],quantity[choiceForCategory]);
            choiceForCategory=input.nextInt();
            if(choiceForQuantity>0&&
               choiceForQuantity<=quantity[choiceForCategory]){
                return choiceForQuantity-1;
            }
            else{
                return -2;
            }
        }
    }
    
    public static void changeAsingleGrade(String[] category,
                                          int choiceForCategory,
                                          int choiceForQuantity,
                                          Scanner input,
                                          double[][] allExamResults){
        int candidsteGrade;
        System.out.printf("The current grade for %s is %.1f",
        category[choiceForCategory],
        allExamResults[choiceForCategory][choiceForQuantity]);
        System.out.println();
        System.out.println("Please enter the new grade value >>");
        candidsteGrade=input.nextInt();
        if(candidsteGrade>=0&&candidsteGrade<=100){
            allExamResults[choiceForCategory][choiceForQuantity]=candidsteGrade;
        }
        else System.out.println("Invaild choice.");
    }

    public static void voidGrades(double[][] allExamResults, String[] category,
                                  int[] quantity, int[] weight){
        double overAllGrade;
        double GPAPoint;
        double[] resultOgEachGrade;
                resultOgEachGrade= gradeAvregeForCategories(allExamResults,
                                 category, quantity);
        overAllGrade=getGPAPoint(resultOgEachGrade,category, weight);
        System.out.println("Category Information:");
            for(int i=0;i<category.length;i++){
                System.out.printf("%s - %.1f",category[i],
                                                     resultOgEachGrade[i]);
                System.out.println();
        }
        System.out.println();
        GPAPoint=gpaPoints(overAllGrade);
        String gradeLetter=gradeLetter(overAllGrade);
        String status=status(overAllGrade);
        System.out.printf ("Overall Grade - %.2f", overAllGrade);
        System.out.println();
        System.out.printf("Grade letter - %s", gradeLetter);
        System.out.println();
        System.out.printf("GPA point - %.1f", GPAPoint);
        System.out.println();
        System.out.printf("Status - %s", status);
        System.out.println();
    }

    public static double[] gradeAvregeForCategories
        (double[][] examResults, String[] Category, int[] quantity){
        double[] result= new double[Category.length];
        for(int i=0;i<Category.length;i++){
            for(int j=0;j<quantity[i];j++){
                result[i]+=examResults[i][j]/quantity[i];
            }
        }
        return result;
    }

    public static double getGPAPoint(double[] gradeOfCategories,
                                     String[] category, int[] weight){       
        double result=0;
            for(int i=0;i<category.length;i++){
               result+=gradeOfCategories[i]*weight[i]*0.01;
            }
        return result;
    }

    public static void formatCategoryName(String name[]){
            for(int i=0;i<name.length;i++){
               name[i]=formatCategoryName(name[i]);
            }
    }
    
    public static Boolean isQuantityValid(int quantity[]){
        Boolean result =true;
            for(int i=0;i<quantity.length;i++){
                result=isQuantityValid(quantity[i]);
                if(result==false)
                break;
            }
        return result;
    } 
    
    public static Boolean isWeightValid(int weight[]){
        Boolean result=true;
        int sumweight=0;
        for(int i=0;i<weight.length;i++){
           if(weight[i]<0||weight[i]>100){
                result=false;
                break;
            }            
            sumweight+=weight[i];
        }
        if(sumweight!=100){
            result=false;
        }
        return result;
    }
    
    public static  String gradeLetter(double grade ){
        if      (grade>=87.5) return "AA";
        else if (grade>=80.5) return "BA";
        else if (grade>=73.5) return "BB";
        else if (grade>=66.5) return "CB";
        else if (grade>=59.5) return "CC";
        else if (grade>=52.5) return "DC";
        else if (grade>=45.5) return "DD";
        else if (grade>=34.5) return "FD";
        else                  return "FF";
    }

    public static double gpaPoints(double grade){
        double result;
            if      (grade>=87.5) result = 4.0;
            else if (grade>=80.5) result = 3.5;
            else if (grade>=73.5) result = 3.0;
            else if (grade>=66.5) result = 2.5;
            else if (grade>=59.5) result = 2.0;
            else if (grade>=52.5) result = 1.5;
            else if (grade>=45.5) result = 1.0;
            else if (grade>=34.5) result = 0.5;
            else                  result = 0.0;
        return result;
    }

    public static String status(double grade){
        String result;
            if      (grade>=59.5) result = "passed";
            else if (grade>=45.5) result = " conditionally passed";
            else                  result = "failed";
        return result;}
        
    public static String formatCategoryName(String name1){
        char upperCase1= name1.charAt(0);
        upperCase1= Character.toUpperCase(upperCase1);
        name1 =name1.substring(1);
        name1= name1.toLowerCase();
        name1= upperCase1+name1;
        return name1;
    }
    
    public static Boolean isQuantityValid(int quantity){
        Boolean result =  (quantity>0) ? true : false;
        return result;
    } 
    public static Boolean isWeightValid(int weight, int sumweight){
        Boolean result = (weight>=0&&sumweight+weight<=100)? true :false;
        return result;
    }
    
}
    

