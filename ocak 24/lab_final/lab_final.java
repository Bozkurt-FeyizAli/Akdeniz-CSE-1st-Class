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
public static void tamPiramit(int n){
    if(n!=1&&n>0){
        for(int i=n;i!=0;i--){
            System.out.print(i+" ");
        }
        for(int i=2;i<=n; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        tamPiramit(n-1);
    }
    else
    for(int i=n;i!=0;i--){
        System.out.print("  ");
    }
    System.out.println(1);
}

public static int[] decimalToBinary1(int number){
    int arrayLength=0;
    while(number!=0){
        number/=2;
        arrayLength++;
    }
    int[] decimalToBinary= new int[arrayLength];
    int a=1;
    while(number!=0){
        decimalToBinary[decimalToBinary.length-a]=number%2;
        number/=2;
        a++;
    }
    return decimalToBinary;
}

public static int recursiveGCD(int m, int n){
    if(m%n==0){
        return n;
    }
    else{
        return recursiveGCD(n, m%n);
    }
}

public static double sumSeries(int i){
    if(i==1){
        return 1/3.0;
    }
    else{
        return (i*1.0/2*i+1)+sumSeries(i-1);
    }
}

public static void reverseDisplay(int number){
    if(number/10==0){
        System.out.print(number%10);
    }
    else{
        System.out.print(number%10);
        reverseDisplay(number/10);
    }
}

public static void reverseDisplayString(String n){
    if(n.length()==1){
        System.out.print(n.charAt(0));
    }
    else{
        System.out.print(n.charAt(n.length()-1));
        reverseDisplayString(n.substring(0, n.length()-1));
    }
}

public static int count(char[] chars, char ch, int high){
   if(high==-1){
    return 0;
   }
   else{
    if(chars[high]==ch){
    return 1+count(chars, ch, high-1);
    }
    else{
        return count(chars, ch, high-1);
    }
   }
}

public static int count(char[] chars, char ch){
    int result=0;
    int high= chars.length;
       result+=count(chars, ch, (high-1));
    return result;
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

    public static int countWordInRow(String fileNmae) throws Exception{
        File file = new File(fileNmae);
        Scanner input= new Scanner(file);
        int countWordInRow=0;
        while(input.hasNext()){
            String[] line= input.nextLine().split(" ");
            if(line.length>countWordInRow)
            countWordInRow=line.length;
        }
        return countWordInRow;

    }



    public static void removeSpecifiedWord(String fileName, String deleteWord) throws Exception{
        File file = new File(fileName);
        String[][] allWords= new String[countCategory(fileName)][countWordInRow(fileName)];
        try(Scanner input= new Scanner(file);){
            int i=0;
            while(input.hasNextLine()){
                int j=0;
                while(input.hasNext()){
                    if(input.next().equals(deleteWord)){
                allWords[i][j]=input.next();
                j++;
                    }
                }
                i++;
            }
        }
        catch(FileNotFoundException e){

        }
        catch(Exception e){
        }

         
        try(FileWriter writer = new FileWriter(file, true);){
        for(int i=0;i<allWords.length;i++){
            for(int j=0;j<allWords[i].length;j++){
                if(allWords[i][j]!=null)
                writer.write(allWords[i][j]);
                writer.write(" ");
            }
            writer.write("\n");
        }
    }
        catch(IOException e){}
}

    public static char randomChar(){
        return (char)((int)('A')+ Math.random()*(int)('Z'));
    }    
    public static String randomWord(int i){
        String word="";
        for(int j=0;j<i;j++){
            word+=randomChar();
        }
        return word;
    }
    
    public static String randomPalindrome(int n){
        String result="";
        while(!isPalindrome(result)){
            result=randomWord(n);
        }
        return result;
    }

    public static boolean isPalindrome(String word){
        if(word.length()==1||word.equals("")){
            return true;
        }
        else if(word.charAt(0)!=word.charAt(word.length()-1)){
            return false;
        }
        else{
            return isPalindrome(word.substring(1, word.length()-1));
        }
    }

    public static boolean isPalindrome(String str, int start, int end){
        // start=0;
        // end=str.length()-1;
        if(str.equals("")||str.length()==1||str.length()==0||str.length()<2){
            return true;
        }
        else if(str.charAt(end)!=str.charAt(start)){
            return false;
        }
        else{
            if(start+1==end||start+1>end){
                return true;
            }
            return isPalindrome(str, start+1, end-1);
        }
 
    }

    public static void file(String path, String fileName, String txtName) throws Exception{
        File txt = new File(txtName);
        
        
        String randomPath="";
        for(int i=0;i<Math.random()*5;i++){
             randomPath+="\\"+randomWord(5);
        }
        File folder= new File(path+"\\"+randomPath);
        folder.mkdirs();
        File file = new File(folder.getAbsolutePath()+"\\"+fileName);
       


        boolean devam=false;
        String[][] txtWords= new String[countCategory(txtName)][countWordInRow(txtName)];
        String[][] fileWords= new String[countCategory(txtName)][countWordInRow(txtName)];
        FileWriter writer= new FileWriter(file, true);
        int k=1;
        for(int i=0;i<txtWords.length;i++){
            for(int j=0; j<txtWords[i].length;j++){
                do{
                    String candidate= randomWord(k);
                    
                    devam= isWordInArray(txtWords, txtName);
                    if(devam){
                        fileWords[i][j]=candidate;
                    }
                    k++;
                }while(devam);
            }
        }
        for(int i=0;i<fileWords.length;i++){
            for(int j=0;j<fileWords[i].length;j++){
                writer.write(fileWords[i][j]);
            }
        } 
        writer.close();

    }
    public static boolean isWordInArray(String[][] array, String word){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]==null)
                continue;
                if(array[i][j].equals(word))
                return true;
            }
        }
        return false;
    }

    public static void FAB(String F, String A, String B, String study)throws Exception{
        File folder= new File(F);
        folder.mkdirs();
        File aFile= new File(folder.getAbsolutePath()+"\\"+A);
        aFile.createNewFile();
        File bFile= new File(folder.getAbsolutePath()+"\\"+B);
        bFile.mkdirs();
        File sFile= new File(folder.getAbsolutePath()+"\\"+B+"\\"+study);
        sFile.createNewFile();
        FileWriter sFileW= new FileWriter(sFile);
        sFileW.write("zaman akıyor.");
        sFileW.close();
    }





















// private static int recursiveBinarySearch(int[] list, int key,
// int low, int high) {
// if (low > high) // The list has been exhausted without a match
// return -low - 1;

// int mid = (low + high) / 2;
// if (key < list[mid])
// return recursiveBinarySearch(list, key, low, mid - 1);
// else if (key == list[mid])
// return mid; 
// else
// return recursiveBinarySearch(list, key, mid + 1, high);
// }


