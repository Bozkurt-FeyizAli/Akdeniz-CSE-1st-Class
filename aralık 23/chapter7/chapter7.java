    public static void shuffle(int array[], int number){
    for(int i=0;i<number;i++){
        int a=(int)(Math.random()*array.length);
        int b=(int)(Math.random()*array.length);
        int swap=array[a];
        array[a]=array[b]; 
        array[b]=swap;   
    }
    }
    public static void lockers(boolean[] lockers){
        for(int student=1;student<=lockers.length;student++){
            for(int lock=student;lock<=lockers.length;lock++){
                if(lock%student==0)
                lockers[lock-1] = !lockers[lock-1];  
            }
        }  
    }
    
    public static void countOccurrenceOfNumbers(Scanner scanner){
        int arrayLenght=scanner.nextInt();
                int[] numbers=new int[arrayLenght];
        for(int i=0;i<arrayLenght;i++){
        numbers[i]=scanner.nextInt();
        }
        for(int i=0;i<numbers.length;i++){
            int count=0;
            for(int j=0;j<numbers.length;j++){
                if(numbers[i] == numbers[j])
            count++;   
            }
            if(count==1)
            System.out.printf("%d occours %d time\n", numbers[i], count);
            else System.out.printf("%d occours %d times\n", numbers[i], count);
        }
    }

    public static void printDistinctNumbers(int[] numbers){
        eliminateDuplicates(numbers);
        int arraylenght=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]!=0){
                arraylenght++;
            }
        }
        int[] arrayResult=new int[arraylenght];
        for(int i=0;i<arrayResult.length;i++){
            arrayResult[i]=numbers[i];
        }
    }
 
    public static void displayStatistics(double[] data) {
    double sum = 0;
    double sumSquare = 0;
    double deviation = 0.0;

    for (int i=0;i<data.length;i++) {
        sum+=data[i];
        sumSquare+=Math.pow(data[i],2);
    }
    double mean = sum/data.length;
    deviation = Math.sqrt((sumSquare - (Math.pow(sum, 2) /
                data.length)) / (data.length - 1));

    System.out.printf("Mean = %.2f .\n", mean);
    System.out.printf("Standard deviation is %.5f\n", deviation);
}
    
    public static int computingGCD(int[] numbers){
    int gcd=1;
    int minArray=numbers[0];
    boolean test=false;
    for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] < minArray) {
            minArray = numbers[i];
        }
    }
    for(int j=2;j<minArray;j++){
    for(int k=0;k<numbers.length;k++){
    test=numbers[k]%j==0;
    if(!test) break;
    else{return j;}}

}
return gcd;
}
    
    public static double computeTimeDifference(double[] list){
    long startTime = System.currentTimeMillis();
    displayStatistics(list);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime; 
    return executionTime;
    }
    




}