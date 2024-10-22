import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08_20220808057 {

public static void main(String[] args) {
        readFilterPokeStats("PokeStats 1.txt");
    }

public static void intLogger(String filename){
        File file = new File(filename);
        Scanner scan = new Scanner(System.in);
        try {
            PrintWriter writer = new PrintWriter(file);
            int z;
            do{
                z = scan.nextInt();
                writer.print(z+" ");
            }
            while(z!=0);
            scan.close();
            writer.close();
            Scanner fileread = new Scanner(file);
            if(!fileread.hasNextLine()){
                PrintWriter writer1 = new PrintWriter(file);
                writer1.println("non-integer-input");
                writer1.close();
            }
        } 
        catch (Exception e) {
          System.out.println(e);    
        }
    }


public static int[] intReader(String filename) {
    File file = new File(filename);
        
        int val = 0;
        try {
            Scanner fileread = new Scanner(file);
            while(fileread.hasNext()){
                fileread.next();
                val++;
            }
            fileread.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        int[] ints = new int[val];
        try{
           
            Scanner fileread1 = new Scanner(file);
            int i = 0;
            while(fileread1.hasNext()){
            ints[i] = fileread1.nextInt();
                i++;
            }
            fileread1.close();
                     
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(InputMismatchException e ){
            System.out.println(e);
        }
          return  ints;
     
    }
     // Question 3: Replace Specific Numbers in the Log File
public static void replaceNumbers(String filename1,String filename2, int oldNum, int newNum) {
    int[] ints = intReader(filename1);
    for(int i = 0; i < ints.length; i++){
        if(ints[i] == oldNum)
            ints[i] = newNum;
        }
        try {
            PrintWriter writer = new PrintWriter(filename2);
            for(int i = 0; i < ints.length; i++){
                writer.print(ints[i]+" ");
            }
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(InputMismatchException e){
            System.out.println(e);
        }
    }

public static void readSortPokeStats(String datafile, String sortedfile) {
    try (Scanner scanner = new Scanner(new FileReader(datafile))) {
        String[] name = new String[17];
        String[] type1 = new String[17];
        String[] type2= new String[17];
        int[] hp = new int[17];
        int[] attack = new int[17];
        int[] defence = new int[17];
        int[] spAttc = new int[17];
        int[] spDefn = new int[17];
        int[] speed = new int[17];
        int index =0;
        while(scanner.hasNextLine()){
            String line =scanner.nextLine();
            if(index ==0){
                index++;
                continue;
                }
            String[] part = line.split("\\s");
            name[index]= part[0];
            type1[index] = part[1];
            type2[index] = part[2];
            hp[index]= Integer.parseInt(part[3]);
            attack[index]=Integer.parseInt(part[4]);
            defence[index]=Integer.parseInt(part[5]);
            spAttc[index]=Integer.parseInt(part[6]);
            spDefn[index]=Integer.parseInt(part[7]);
            speed[index]=Integer.parseInt(part[8]);
            index++;
            }
sortPokemonArrays(name,type1,type2,hp,attack,defence,spAttc,spDefn,speed);
writeSortedData(sortedfile, name, type1, type2, hp, 
               attack, defence, spAttc, spDefn, speed);
        } 
        catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }


// Question 5: Read and Filter Pokémon Stats Data by Type
public static String[] readFilterPokeType(String filename, String poketype) {
    String[] pokeName = new String[16];
    int index =0;
    try(Scanner scanner = new Scanner(new FileReader(filename))) {
    if(scanner.hasNextLine()){
        scanner.nextLine();
    }
    while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        String[] part = line.split("\\s");
        if(part.length>=3 && (part[1].equals(poketype))|| 
           part[2].equals(poketype)){
            pokeName[index]=part[0];
            index++;
            if(index>=pokeName.length){
              pokeName=newArray(pokeName, index*2);
            }
        }
    }
   }
   catch (IOException e) {
    System.out.println("Error : Reading from file "+filename);
   }
   return newArray(pokeName, index);
}

// Question 6: Read and Filter Pokémon Stats Data by Highest Speed Stat
public static void readFilterPokeStats(String filename) {
     try(Scanner scan = new Scanner(new FileReader(filename))) {
        String[] firstLine = scan.nextLine().split("\\s");
        // System.out.println(String.join(" ", firstLine));
        int pokeNumber = 5;
        String[][] bestPoke = new String[pokeNumber][firstLine.length];
        int[] highest = new int[pokeNumber];
        int lowest =0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] part =line.split("\\s");
            int speed = Integer.parseInt(part[8]);
            if(speed > highest[lowest]){
                highest[lowest]=speed;
                bestPoke[lowest]=part.clone();
                int newLowest = Integer.MAX_VALUE;
                for(int i=0; i<pokeNumber ; i++){
                    if(highest[i]<newLowest){
                        newLowest=highest[i];
                        lowest =i;
                    }
                }

            }
        }
        for(int i=0; i<pokeNumber;i++){
            String bestSpeed=bestPoke[i][8];
            System.out.print(String.join(" ", bestPoke[i]));
            System.out.println(" - Speed: "+bestSpeed);
        }
     } catch (IOException e) {
        System.out.println("Error : Reading from file "+filename);
    }
}


/////////////////////////////////////////////////////////////////////////////////////////
    public static void sortPokemonArrays(String[] name, String[] type1, String[] type2,
    int[] hp, int[] attack, int[] defense,
    int[] spAtk, int[] spDef, int[] speed) {
    for (int i = 0; i < hp.length - 1; i++) {
    for (int j = 0; j < hp.length - 1 - i; j++) {
    if (calculateTotalStats(hp[j], attack[j], defense[j], spAtk[j], spDef[j], speed[j]) <
        calculateTotalStats(hp[j + 1], attack[j + 1], defense[j + 1], spAtk[j + 1], spDef[j + 1], speed[j + 1])) {
        swap(name, j, j + 1);
        swap(type1, j, j + 1);
        swap(type2, j, j + 1);
        swap(hp, j, j + 1);
        swap(attack, j, j + 1);
        swap(defense, j, j + 1);
        swap(spAtk, j, j + 1);
        swap(spDef, j, j + 1);
        swap(speed, j, j + 1);
    }
   }
  }
}
public static int calculateTotalStats(int hp, int attack, int defense, int spAtk, int spDef, int speed) {
    return hp + attack + defense + spAtk + spDef + speed;
}
public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
public static void swap(String[] array, int i, int j) {
    String temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
public static void writeSortedData(String sortedfile, String[] name,
                                  String[] type1, String[] type2,
                                  int[] hp, int[] attack, int[] defense,
                                  int[] spAtk, int[] spDef, int[] speed) {
    try (FileWriter writer = new FileWriter(sortedfile)) {
      writer.write("Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed\n");
            for (int i = 0; i < name.length; i++) {
                writer.write(name[i] + " " + type1[i] + " " +
                 type2[i] + " " +
                hp[i] + " " + attack[i] + " " +
                defense[i] + " " + spAtk[i] + " " + spDef[i] +
                 " " + speed[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + sortedfile);
            e.printStackTrace();
        }
    }


/////////////FOR 5///////////////////////////////
    public static String[] newArray(String[] array, int newSize) {
        String[] newArr = new String[newSize];
        System.arraycopy(array, 0, newArr, 0, Math.min(array.length, newSize));
        return newArr;
    }
    // public static void swap(int[] array, int i, int j) {
    //     int temp = array[i];
    //     array[i] = array[j];
    //     array[j] = temp;
    // }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }


    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}