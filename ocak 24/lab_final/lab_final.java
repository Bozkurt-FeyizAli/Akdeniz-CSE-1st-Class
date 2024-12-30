import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.lang.model.type.ErrorType;

public class lab_final{
public static void main(String[] args) throws Exception {

// int[] list={1,2,3,4,5,6,7,8,9,10};
// System.out.println(binarySearch1(list, 4, list.length-1, 5));
// // System.out.println(recursiveBinarySearch(list, 7, 0, list.length-1));
// int lista[]= decimalToBinary(16);
// for (int index = 0; index < lista.length; index++) {
//     System.out.print(lista[index]);
// }
// char[] a= {'a', 'b', 'c', 'a', 'b'};
// System.out.println(count(a, 'b'));
// System.out.println(recursiveGCD(24, 37));
// removeSpecifiedWord("a.txt", "yunus");
// File file = new File("ab");
// String path= file.getAbsolutePath();
// file(path, "ab.txt", "a.txt");
// FAB("Feyiz", "Ali", "Bozkurt", "LabExam");
// tamPiramit(5);
// yarımPiramit(100000);
// piramit(10000);
// System.out.println(isPalindrome("asdfdsa", 0, 6));
// System.out.println(plakaKontrol("57ATC47"));
reverseDisplayString("qwer");

}

public static int binarySearch(int[] list, int key, int high, int low){
    if (low > high)
        return -low - 1;
    int middle= (low+high)/2;
    if(list[middle]==key){
        return middle;
    }
    else if(list[middle]>key){
        return binarySearch(list, key, middle-1, low);
    }
    else{
        return binarySearch(list, key, high, middle+1);
    }
}

// public static int binarySearcah(int[] list, int key, int high, int low){
//     if(high<low){
//         return -1;
//     }
//     int middle=(high+low)/2;
//     if(list[middle]==key){
//         return middle;
//     }
//     else if(list[middle]>key){
//         return binarySearcah(list, key, middle-1, low);
//     }
//     else{
//         return binarySearcah(list, key, high, middle+1);
//     }
// }


public static int[] decimalToBinary(int number){
    int[] binaryRepresentation= new int[9];
    for (int i = 1; number!=0; i++) {
        binaryRepresentation[binaryRepresentation.length-i]=number%2;
        number/=2;
    }
    return binaryRepresentation;

}

// public static static String asdsdffgdString(int n){
//     if(n >0){
//     String  a= Character.toString(randomChar());
//     String result="";
//     if(n!=1){
//         result=a+asdsdffgdString(n-2)+a;}
//     else{
//         result= result;
//     }
//     return result;
//     }
// }

// public static int[] decimalToBinaryas(int n){
//     int[] result= new int[9];
//     for (int index = 1; n!=0; index++) {
//         result[result.length-index]=n%2;
//         n/=2;
//     }
//     return result;
// }

public static void pyramidsRow(int i){
    for (int n = 1; n<i ; n++) {
        System.out.printf("%d", n);
    }
    for (int index =i; index >0; index--) {
        System.out.printf("%d", index);
    }
    System.out.println();
}
public static void piramit(int i){
    for (int index = 1; index <i+1; index++) {
        pyramidsRow(index);
    }
}

public static boolean plakaKontrol(String plaka){
    if(plaka.length()!=7){
        return false;
    }
    else{
        if((int)plaka.charAt(0)>(int)'9'||(int)plaka.charAt(0)<(int)'0'
        ||(int)plaka.charAt(1)>(int)'9'||(int)plaka.charAt(1)<(int)'0'){
            return false;
        }
        if((int)plaka.charAt(2)>(int)'Z'||(int)plaka.charAt(2)<(int)'A'||
           (int)plaka.charAt(3)>(int)'Z'||(int)plaka.charAt(3)<(int)'A'||
           (int)plaka.charAt(4)>(int)'Z'||(int)plaka.charAt(4)<(int)'A'){
            return false;
        }
        if((int)plaka.charAt(5)>(int)'9'||(int)plaka.charAt(5)<(int)'0'
        ||(int)plaka.charAt(6)>(int)'9'||(int)plaka.charAt(6)<(int)'0'){
            return false;
        }
        return true;
    }
}

public static double recursiveCalculatePI(int n){
    if(n==1){
        return 4;
    }
    else{
        if(n==0)
        return 3;
        return ((4*Math.pow(-1,n+1))/(2*n-1)+recursiveCalculatePI(n-1));
    }
}


public static int[] eliminateDuplicates(int[] array) {
    /*
     * Write a method that returns a new array by eliminating the duplicate
     * values in the array. Order of appearences for numbers must not change
     * 
     * Args: array int[]: array containing duplicate elements
     * Returns: int[]: new array that does not contains duplicate elements, but
     * keeps the order of appearences of numbers.
     */

    // Your code goes here...
int[] eliminateDuplicatesArray= new int[array.length];
int k=0;
for (int index=0; index < array.length; index++) {
    for (int j = index+1; j < array.length; j++) {
        if(array[j]!=array[index]){
            if(!isValueInArray(eliminateDuplicatesArray, array[index])){
                eliminateDuplicatesArray[k]=array[index];
                k++;}
        }
        else{
            break;
        }
    }
}
int[] resultArray= new int[k];
for (int index = 0; index < k; index++) {
    resultArray[index]=eliminateDuplicatesArray[index];
}
return resultArray;
}

public static boolean isValueInArray(int[] array, int value){
    for (int index = 0; index < array.length; index++) {
        if(array[index]==value)
        return true;
    }
    return false;
}

public static int binarysearch1(int[] list, int key, int high, int low){
    if(low>high){
        return -1;
    }
    int middle= (low+high)/2;
    if(list[middle]==key){
        return key;
    }
    else if(list[middle]<key){
        return binarySearch(list, key, high, middle+1);
    }
    else{
        return binarySearch(list, key, middle-1, low);
    }
}

// public static int[] eliminateDuplicates1(int[] array){
//     int numberOfNonDuplicates=0;
//     int[] eliminateDuplicates= new int[array.length];
//     for(int i=0;i<array.length;i++){
//         for(int j=i+1;j< array.length;j++){
//             if(array[i]==array[j]){
//                 if(!isValueInArray(eliminateDuplicates, array[j])){
//                     eliminateDuplicates[numberOfNonDuplicates]= array[j];
//                 }
//             }
//         }
//     }
//     int[] resultArray= new int[eliminateDuplicates];
//     for(int i=0;i<numberOfNonDuplicates;i++){
//         resultArray[i]=eliminateDuplicates[i];
//     }
//     return resultArray;
// }

public static void yarımPiramit(int n){
    // if(n==1){
    //     System.out.println(1);
    // }
    // else{
        if(n!=1){
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        yarımPiramit(n-1);}
    //}
}
