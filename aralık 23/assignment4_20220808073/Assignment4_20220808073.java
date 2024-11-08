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
