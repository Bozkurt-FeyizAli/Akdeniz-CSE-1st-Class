// @ Feyiz Ali Bozkurt @ Since 23 December 2023
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Assignment4_20220808073{
    public static void main(String[] args)  {
        String categoryInformation="";
        String studentInformation="";
        String writeStudentGrades="";
        String writeErrors="";
        boolean continueToProgram=true;
        if (args.length ==1||args.length ==4) {
            if(args.length==1) {
                categoryInformation=args[0]+"_CourseDetails.txt";
                 studentInformation=args[0]+"_StudentScores.txt";              
                 writeStudentGrades=args[0]+"_StudentGrades.txt";
                        writeErrors=args[0]+"_Errors.log";
            }
            else{
                categoryInformation=args[0]+".txt";
                 studentInformation=args[1]+".txt";
                 writeStudentGrades=args[2]+".txt";
                        writeErrors=args[3]+".log";
            } 
        int arrayLength= countCategory(categoryInformation);
        String[] category=new String[arrayLength];
        int[] quantity=new int[arrayLength];
        int[]    weight=new int[arrayLength];
        String[] studentNames= new String[countCategory(studentInformation)];
        double[] studentScores= new double[countCategory(studentInformation)];
        // get information
        getCategoryInformatinsAsArray(categoryInformation, category,
                                      quantity, weight);
        // overview to values
        continueToProgram=categoryInformationError(category, quantity,
                                                   weight, writeErrors);
        // contnue or not
        if(!continueToProgram){
            System.out.println
        ("ERROR: Program will not continue due to invalid informations.\n");
        }
        else{
            // student info
            studentGrades(studentInformation, category, quantity, weight,
                          writeErrors, studentScores, studentNames);
            // write result
            writeGrades(studentNames, studentScores,
                        writeStudentGrades, writeErrors);  
            }
        errorStudentGradeWriter(writeErrors, studentNames, studentScores);        
        }
        else{
           System.out.println("ERROR: invalid commendLine argument.");
        }   
    }

    public static File commendLineErrorWriter(String fileName){
        File file= new File(fileName);
        try {
            file.createNewFile();
            FileWriter informationWriter = new FileWriter(file);
            informationWriter.write
            ("ERROR: invalid commendLine argument number\n");
            informationWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.\n");

        } catch (IOException e) {
            System.out.println("ERROR: IOException occurred\n");

        }
        return file;
    }
    
    public static void getStudentNames(String studentScoresFile,
                                       String[] studentNames,
                                       int[] quantity, String category){
                                        
        int timesOfScore=0;
        for(int i=0;i<category.length();i++){
            timesOfScore+=quantity[i];
        }
        int numberOfStudents = countCategory(studentScoresFile);
        File file = new File(studentScoresFile);
        try (Scanner input= new Scanner(file);){
        for (int index = 0;input.hasNext(); index++) {
            studentNames[index]= input.next();
            for(int i=0;i<timesOfScore;i++){
            String tempScore= input.next();
            }
        }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void studentGrades(String studentScoresFile,
                                     String[] category, int[] quantity,
                                     int[] weight, String writeErrors,
                                     double[] studentGrades,
                                     String[] studentNames) {
 
        File file = new File(studentScoresFile);
        try (Scanner input= new Scanner(file);){
        for (int index = 0;index<countCategory(studentScoresFile); index++) {
            boolean studentGradeVaild=true;
            double temporaryGrade=0;
            double score=0;
            studentNames[index]= input.next();
            for(int j=0;category.length; j++){
                double categoryGrade = 0;
                for(int k=0; k<quantity[j] ;k++){
                        score = Double.parseDouble(input.next()) / quantity[j];
                        categoryGrade += score;
                    if(score<0||score>100){
                        studentGradeVaild=false;
                    }
                    // if(quantity[j]-1==k){
                    //     break;
                    //}
                }
                temporaryGrade += categoryGrade * weight[j]/100.0;
                if(!studentGradeVaild){
                    studentGrades[index]=Double.MIN_VALUE;
                }
                else{
                    studentGrades[index]=temporaryGrade;
                }
                // if(j==category.length-1){
                //     break;
                //}
            }
        }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        bindeYuzeKadar(studentGrades);
    }

    public static File errorStudentGradeWriter(String studentScoresFile,
                                               String[] studentName,
                                               double[] studentScores){

        File file= new File(studentScoresFile);
        try {
            file.createNewFile();
            FileWriter informationWriter = new FileWriter(file);
            for(int i=0; i<studentName.length;i++){
                if(studentScores[i]==Double.MIN_VALUE){
                informationWriter.write
("ERROR: Student "+studentName[i]+
 " - cannot calculate due to invalid grade.\n");
                }
                else{continue;}
            }
            informationWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Belirtilen dosya bulunamadı.");
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: IOException occurred");
            System.out.println("ERROR: " + e.getMessage());
        }
        return file;
    }

    public static void bindeYuzeKadar(double[] array){
        for(int i=0;i<array.length;i++){
            if(array[i]!=Double.MIN_VALUE)
            array[i]=(double)((int)(array[i]*100))/100.0;
        }
    }

    public static int countCategory(String studentScoresFile)  {
        int numberOfCategories=0;
        File file = new File(studentScoresFile);
        if(!file.exists()){
            System.out.printf("ERROR: %s file does not exist!",
                                      studentScoresFile);
            System.out.println();
        }
        else{
            try (Scanner input = new Scanner(new File(studentScoresFile)); ){
                while (input.hasNext()) {
                    String line = input.nextLine();
                    numberOfCategories++;
                } 
                input.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("ERROR: Belirtilen dosya bulunamadı.");
            }
        }
        return numberOfCategories;
    }

    public static void getCategory(String[] category,
                                      int[] quantity,
                                      int[] weight,
                                      String studentScoresFile){

        File file = new File(studentScoresFile);
        if(!file.exists()){
        System.out.printf("ERROR: File %s does not exist!",
                                  studentScoresFile);
        }
        else{
            try (Scanner input = new Scanner(file); ) 
            {   
                int index=0;
                while (input.hasNext()) 
                {
                    category[index] = input.next();
                    quantity[index]= input.nextInt();
                    weight[index]= input.nextInt();
                    index++;
                } 
                input.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("ERROR: Belirtilen dosya bulunamadı.");
            }
        }
    }

    public static void writeGrades(String[] student, double[] grade,
                                   String studentGradeFileName,
                                   String errorLogFileName){
        String[] gradeLetters= new String[student.length];        
        double[] studentGPAScores=new double[student.length];
        String[] studentStatus=  new String[student.length];
        studentGradesInformations(grade, gradeLetters,
                                  studentStatus, studentGPAScores);
        File file= new File(studentGradeFileName);
        try {
            file.createNewFile();
            FileWriter informationWriter = new FileWriter(file);
                for(int i=0;i<student.length;i++){
                    if(grade[i]==Double.MIN_VALUE){
                    }
                    else{
                    informationWriter.write(student[i]+" "+
                                              grade[i]+" "+
                                       gradeLetters[i]+" "+
                                   studentGPAScores[i]+" "+
                                      studentStatus[i]+"\n");
                    }
                }
            informationWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Belirtilen dosya bulunamadı.");
        } catch (IOException e) {
            System.out.println("ERROR: IOException occurred");
        }
    }
    public static void studentInformationsForWriteGrades
                                                    (double[] grade,
                                                     String[] gradeLetters,
                                                     double[] studentGPAScores,
                                                     String[] studentStatus){

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












