import java.util.*;
import java.io.*;
public class Quiz2_20220808073{
    public static void main(String[] args){
    boolean[] a= {true, true, true, true, true, true, true, true, true, true};
    int[] ab= lockerPuzzle(a);
    for (int c : ab) {
        System.out.println(c);
    }
    System.out.println(sort("bcad"));


    // int[] aa= decimalToBinary(4);
    // for (int i : aa) {
    //     System.out.println(i);
    // }
    // System.out.println(factorial(5));
    // System.out.println(isPalindrome("abac"));
    }
    public static int[]  lockerPuzzle(boolean[] isDoorOpen){
        
        int numberOFIndex=0;
        for(int i=1;i<isDoorOpen.length;i++){
            for(int j=i;j<isDoorOpen.length;j++){
                if(j%i==0){
                    isDoorOpen[i-1]=!isDoorOpen[i-1];
                }
            }
        }
        for(int i=0;i<isDoorOpen.length;i++){
            if(isDoorOpen[i])
            numberOFIndex++;
        }
        int[] lockerPuzzle=new int[numberOFIndex];
        int index=0;
        for(int i=0;i<isDoorOpen.length;i++){
            if(isDoorOpen[i]){
            lockerPuzzle[index]=i;
            index++;
        }
        }
        return lockerPuzzle;
    }

    public static  String sort(String word){
        word=word.toUpperCase();
        int[] array=new int[word.length()];
        for(int i=0;i<word.length();i++){
            array[i]=(int)word.charAt(i);
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i]>array[j])
                    swap(array, i, j);
            }
        }
        String result=Character.toString((char)array[0]);
        for(int i=1;i<array.length;i++){
            result+=Character.toString((char)array[i]);
        }
        return result;
    }

    public static void swap(int[] array, int a, int b){
        int swap=a;
        array[a]=b;
        array[b]=swap;
    }

    public static int  factorial(int n){
        if(n==1){
            return 1;
        }
        else return n* factorial(n-1);
    }
    // done
    public static boolean isPalindrome(String word){
        int start=0;
        int end=word.length();
        if(word.length()==1||word.equals("")){
            return true;
        }
        else if(word.charAt(start)!=word.charAt(end-1)){
            return false;
        }
        else{
            return isPalindrome(word.substring(start+1, end-1));
        }
    }
    //done
    public static int[] decimalToBinary(int n){
        int index=0;
        int number=n;
        for(int i=0;n!=0;i++){
            n/=2;
            index++;
        }
        int result[] = new int[index];
        for(int i=1;number!=0;i++){
            result[result.length-i]=number%2;
            number/=2;
        }
        return result;
    }
      //Done
    public static boolean isMarkovMatrix(int[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j]<0)
                return false;
            }
        }
        double colum=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                 colum+=array[j][i];
                 if(colum!=1)
                 return false;
        
            }
            colum=0;
        }
        return true; 
    }

    //     public static boolean isMarkovMatrix(double[][] array){
    //     for(int i=0;i<array.length;i++){
    //         for(int j=0;j<array.length;j++){
    //             if(array[i][j]<0)
    //             return false;
    //         }
    //     }
    //     double colum=0;
    //     for(int i=0;i<array.length;i++){
    //         for(int j=0;j<array.length;j++){
    //              colum+=array[j][i];
    //              if(colum!=1)
    //              return false;
        
    //         }
    //         colum=0;
    //     }
    //     return true; 
    // }
    // done
    public static File movingAverage(String sourceFileName, String writeFileName, int windowSize) throws Exception{
        File file= new File(writeFileName);
        int indexSouce=0;
        File readen= new File(sourceFileName);
        Scanner read= new Scanner(readen);
        while(read.hasNext()){
           String a= read.next();
           indexSouce++;
        }
        read.close();
        File Areaden= new File(sourceFileName);
        double[] datas= new double[indexSouce];
        Scanner readSource= new Scanner(Areaden);
        int indexOfArrayS=0;
        while(readSource.hasNext()){
            datas[indexOfArrayS]=Double.parseDouble(readSource.next());
        }
        readSource.close();
        double[] result= new double[windowSize];
        for(int i=0;i<windowSize;i++){
            double sumAverage=0;
            for(int j=i;j<windowSize;j++){
                sumAverage+=datas[j];
            }
            sumAverage/=windowSize;
            result[i]= sumAverage;
        }
        PrintWriter writer= new PrintWriter(file);
        for(int i=0;i<windowSize;i++){
            writer.print((double)((int)(result[i]*10))/10+",");
        }
        writer.close();
        return file; 
    }
}