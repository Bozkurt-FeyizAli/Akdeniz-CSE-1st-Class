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
