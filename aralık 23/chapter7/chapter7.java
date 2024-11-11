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