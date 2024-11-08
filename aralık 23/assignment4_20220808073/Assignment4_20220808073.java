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
