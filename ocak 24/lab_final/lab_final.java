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


