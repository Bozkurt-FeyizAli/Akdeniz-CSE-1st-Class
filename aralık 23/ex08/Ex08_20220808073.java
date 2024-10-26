import java.io.*;
import java.util.*;
public class Ex08_20220808073 {
    /*
     * Change the X's in the both file name and class' name to your own
     * student number and submit your file to the assignment given through
     * Teams.
     * 
     * if you do NOT submit your assignment in time, you will recieve 0
     * if your file has compile time errors, and do not compile you will recieve 10
     * if your file does compile but a runtime error occurs, you will recieve 20
     * You MUST NOT change the method headers and comply with their return types
     * 
     * Main method is just there for yosu to test your program, you will not be evaluated by your main method
     * You can write any method you like, and use them in suitable places but you will only be graded
     * for your work for the questions
     */
    public static void main(String[] args) {
    
    }

    // Question 1: Log unspecified number of integers                   //Done
    public static void intLogger(String filename) {
        /*
         * Write a method that logs all integers entered to the console.
         * Your method must handle FileNotFoundException and 
         * InputMismatchException exceptions. 
         * Exception handling message should take only one line in console.
         * Each input has to be logged in separate line.
         * If non-integer number entered to the console: log it as
         * "non-integer-input" (without ") to the text file (specified 
         * with filename). And continues to take inputs.
         * Take inputs until 0 entered. (log 0 too.)
         * 
         * Args:
         *      filename: String that specifies the target log file.
         */

         // Your code goes here...
        
        File file = new File(filename);
        String input="";
         Scanner scanner = new Scanner(System.in);
        do{
            input= scanner.nextLine();
            try(FileWriter writer= new FileWriter(file, true);){
            // file.createNewFile();
            
            if(!isNumber(input)){
                writer.write("non-integer-input\n");
            }   
            else{
                writer.write(input+"\n");
            }
            writer.close();
            }
            catch(FileNotFoundException e){
                System.out.println("ERROR: File not found.");
            }
            catch(InputMismatchException e){
                System.out.println("ERROR: InputMismatchException");
            }
            catch(IOException e){
                System.out.println("ERROR: IO exception");
            }
            }while(!input.equals("0"));
            
    }

    public static boolean isNumber(String girdi){
        if(girdi.substring(0,1).equals("-")
           ||((int)girdi.charAt(0)>47&&(int)girdi.charAt(0)<58)){
            for(int i=1; i< girdi.length(); i++){
                if((int)girdi.charAt(i)<=47||(int)girdi.charAt(i)>=58){
                    return false;
                }
            }
        }
        else if((int)girdi.charAt(0)<=47||
                (int)girdi.charAt(0)>=58){
            return false;
        }
        return true;
    }

    // Question 2: Read Integers from the Log File.           //Done
    public static int[] intReader(String filename) {
        /*
         * Write a method that reads all integers from the log file 
         * you created in the previous Question 1.
         * Your method must handle FileNotFoundException and 
         * InputMismatchException exceptions. 
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target log file.
         * Returns:
         *      int[]: Integer Array that stores the integers in the
         *          log file.
         */
         //Your code goes here...
        // int numberOfLine=countCategory(filename);
        int sizeOfArray=0;
        
            File file = new File(filename);
            try(Scanner input= new Scanner(file);){
                while(input.hasNext()){
                    String girdi = input.nextLine();
                    if(isNumber(girdi)){
                        sizeOfArray++;
                    }
                    // if(girdi.equals("0")){
                    //     break;
                    //}   
                    }
                input.close();
            }    
            catch(FileNotFoundException e){
                System.out.println("ERROR: File not found.");
            }
            catch(InputMismatchException e){
                System.out.println("ERROR: InputMismatchException");
            }
            // catch(IOException e){}
        
        int[] intReader= new int[sizeOfArray];
        try(Scanner input= new Scanner(file);){
            int i=0;
            while(input.hasNext()){
                String girdi = input.next();
                if(isNumber(girdi)){
                    intReader[i]=Integer.parseInt(girdi);
                    i++;                    
                }   
                }
            input.close();
        }    
        catch(FileNotFoundException e){
            System.out.println("ERROR: File not found.");
        }
        catch(InputMismatchException e){
            System.out.println("ERROR: InputMismatchException");
        }
        // catch(IOException e){}
        return intReader;
    }

    // Question 3: Replace Specific Numbers in the Log File         //Done
    public static void replaceNumbers(String filename1, String filename2,
                                      int oldNum, int newNum) {
        /*
         * Write a method that replaces the numbers in the log file
         * you created in Question 1.
         * Your method must handle FileNotFoundException
         * Exception handling message should take only one line in console.
         * Your method must replace the exact numbers into the new number.
         * Example: oldNum=100 newNum=255: All 100s will replaced with
         *  255 but 1000s stays same. (1000 should not be replaced to 2550)
         * 
         * Args:
         *      filename: String that specifies the target log file.
         *      oldNum: The Number to be replaced in the log file.
         *      newNum: The Number to be replaced in the log file.
         */

         // Your code goes here...
         File file= new File(filename1);
         String[][] alldatas= new String[countCategory(filename1)][8];
         int i=0;
         try(Scanner input= new Scanner(file);){
            while(input.hasNext()){
                alldatas[i]= input.nextLine().split(" ");
                for(int j=0;j<alldatas[i].length;j++){
                    if(alldatas[i][j].equals(Integer.toString(oldNum))){
                        alldatas[i][j]=Integer.toString(newNum);
                    }
                }
                i++;
            }

         }
         catch(FileNotFoundException e){
            System.out.println("ERROR: File not found.");
         }
        File newFile= new File(filename2);
        
        try(PrintWriter writer = new PrintWriter(newFile);){
        for(int a=0;a< alldatas.length;a++){
            for(int j=0;j<alldatas[a].length;j++){
                writer.print(alldatas[a][j]+" ");
            }
            writer.println();
        }
        writer.close();
        }
        catch(IOException e){
            System.out.println("ERROR: IO exception");
        }
    }


    /*
     * Example Pokémon Data:
Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed
Bulbasaur Grass Poison 45 49 49 65 65 45
Ivysaur Grass Poison 60 62 63 80 80 60
Venusaur Grass Poison 80 82 83 100 100 80
Charmander Fire null 39 52 43 60 50 65
Charmeleon Fire null 58 64 58 80 65 80
Charizard Fire Flying 78 84 78 109 85 100
Squirtle Water null 44 48 65 50 64 43
Wartortle Water null 59 63 80 65 80 58
Blastoise Water null 79 83 100 85 105 78
Caterpie Bug null 45 30 35 20 20 45
Metapod Bug null 50 20 55 25 25 30
Butterfree Bug Flying 60 45 50 90 80 70
Weedle Bug Poison 40 35 30 20 20 50
Kakuna Bug Poison 45 25 50 25 25 35
Beedrill Bug Poison 65 90 40 45 80 75
Pidgey Flying Normal 40 45 40 35 35 56
     */

    // Question 4: Read and Sort Pokémon Stats Data            //Fone
    public static void readSortPokeStats(String datafile, String sortedfile) {
        /*
         * Write a method that reads pokemon data from a file and sort pokémons
         *  by their total base stats in descending order and writes the sorted
         *  data on a new file in the same format.
         * Data Header in the file is: "Name Type1 Type2 HP Attack Defense
         *  Sp.Atk Sp.Def Speed"
         * Your method must handle FileNotFoundException
         * Exception handling message should take only one line in console.
         * 
         * 
         * Args:
         *      datafile: String that specifies the target data file.
         *      sortedfile: String that specifies the new data file that 
         *          will contain the sorted data.
         * 
         */

         // Your code goes here...
        int sizeOfArray        = countCategory(datafile);
        String basliklar="";
        String[] name          =new String[sizeOfArray-1];
        String[] type1         =new String[sizeOfArray-1];
        String[] type2         =new String[sizeOfArray-1];
        int   [] hp            =new    int[sizeOfArray-1];
        int   [] attack        =new    int[sizeOfArray-1];
        int   [] defense       =new    int[sizeOfArray-1];
        int   [] spAttack      =new    int[sizeOfArray-1];
        int   [] spDefense     =new    int[sizeOfArray-1];
        int   [] speed         =new    int[sizeOfArray-1];
        int   [] totalBaseStat =new    int[sizeOfArray-1];
        getDataPokemons        (name, type1, type2, hp, attack, defense, 
                                spAttack, spDefense, speed, totalBaseStat,
                                datafile, basliklar);
        sortInDecreasingOrder  (name, type1, type2, hp, attack, defense,
                                spAttack, spDefense, speed, totalBaseStat);
        writeSortedPokemonDatas(name, type1, type2, hp, attack, defense,
                                spAttack, spDefense, speed, sortedfile,
                                basliklar);
    }

    public static void getDataPokemons(String[] name, String[] type1,
                                       String[] type2,   int[] hp,
                                          int[] attack,  int[] defense, 
                                          int[] spAttack,int[] spDefense,
                                          int[] speed,   int[] totalBaseStat,
                                          String dataFile, String basliklar){
        File file= new File(dataFile);
        try(Scanner input= new Scanner(file);){
            int i=0;
            basliklar= input.nextLine();
            while(input.hasNext()){
                name         [i]= input.next();
                type1        [i]= input.next();
                type2        [i]= input.next();
                hp           [i]= Integer.parseInt(input.next());
                attack       [i]= Integer.parseInt(input.next());
                defense      [i]= Integer.parseInt(input.next());
                spAttack     [i]= Integer.parseInt(input.next());
                spDefense    [i]= Integer.parseInt(input.next());
                speed        [i]= Integer.parseInt(input.next());
                totalBaseStat[i]= hp[i]+   attack[i]+defense[i]+
                            spAttack[i]+spDefense[i]+  speed[i];
                i++;
           }
        }
        catch(FileNotFoundException e){
            System.out.println("ERROR: File not found.");
        }
    }

    public static void sortInDecreasingOrder
                       (String[] name, String[] type1,
                        String[] type2,   int[] hp,
                           int[] attack,  int[] defense, 
                           int[] spAttack,int[] spDefense,
                           int[] speed,   int[] totalBaseStat){


        for(int i=0; i<totalBaseStat.length; i++){
            for(int j=0; j<totalBaseStat.length; j++){
                if(      totalBaseStat   [i]>totalBaseStat[j]){
                    swap(totalBaseStat,   i ,              j);
                    swap(         name,   i ,              j);
                    swap(        type1,   i ,              j);
                    swap(        type2,   i ,              j);
                    swap(           hp,   i ,              j);
                    swap(       attack,   i ,              j);
                    swap(      defense,   i ,              j);
                    swap(     spAttack,   i ,              j);
                    swap(    spDefense,   i ,              j);
                    swap(        speed,   i ,              j);
                }
            }
        }                                          
    }

    public static File writeSortedPokemonDatas
                       (String[] name, String[] type1,
                        String[] type2,   int[] hp,
                           int[] attack,  int[] defense, 
                           int[] spAttack,int[] spDefense,
                           int[] speed,   String sortedData,
                           String basliklar ){
    File file= new File(sortedData);
    try(FileWriter writer= new FileWriter(file);){
        file.createNewFile();
        for(int i=0;i<name.length;i++){
            if(i==0){
                writer.write(""+basliklar);
            }
            writer.write(name[i]+" "+    type1[i]+" "+  type2[i]+" "+
                           hp[i]+" "+   attack[i]+" "+defense[i]+" "+
                     spAttack[i]+" "+spDefense[i]+" "+  speed[i]+"\n");
    }
    writer.close();

    }
    catch(FileNotFoundException e){
        System.out.println("ERROR: File not found.");
    }
    catch(IOException e){
        System.out.println("ERROR: IO exception");
    }
    return file;
    }

    // Question 5: Read and Filter Pokémon Stats Data by Type       //Done
    public static String[] readFilterPokeType(String filename, 
                                              String poketype) {
        /*
         * Write a method that reads pokemon data from a file and filters
         *  the pokémons with the specified type and returns the names
         *  of the pokémons with specified types as String Array
         * Example: For the data above, poketype="Flying": the output 
         *  should be ["Charizard", "Butterfree", "Pidgey"]
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target data file.
         *      poketype: String that represents the target Pokémon type.
         *          (Do not print a message for non-existant Pokémon types
         *          just return an empty string array in that case.)
         * 
         * Returns:
         *      String[]: String that contains the Pokémon names of
         *  the specified type.
         * 
         */

         // Your code goes here...
        int sizeOfArray        = countCategory(filename);
        String[] name          =new String[sizeOfArray-1];
        String[] type1         =new String[sizeOfArray-1];
        String[] type2         =new String[sizeOfArray-1];
        getDataPokemons             (name, type1, type2, filename);
        String[] readFilterPokeType= 
        getFilteredStringArray      (name, type1, type2, poketype);
        return   readFilterPokeType;
    }
 
    public static String[] getFilteredStringArray(String[] name, 
                                                  String[] type1, 
                                                  String[] type2, 
                                                  String type){
        String[] readFilterPokeType;
        int arrayLength=0;
        for(int i=0;i<name.length;i++){
            if(type1[i].equalsIgnoreCase(type)||
               type2[i].equalsIgnoreCase(type)){
                arrayLength++;
            }
        }
        readFilterPokeType=new String[arrayLength];
        int arrayIndex=0;
        for(int i=0;i<name.length;i++){
            if(type1[i].equalsIgnoreCase(type)||
               type2[i].equalsIgnoreCase(type)){
                readFilterPokeType[arrayIndex]=name[i];
                arrayIndex++;
            }
        }
        return readFilterPokeType;
    }

    public static void getDataPokemons(String[] name,  String[] type1,
                                       String[] type2, String dataFile){
    File file= new File(dataFile);
    try(Scanner input= new Scanner(file);){
        int i=0;
        String firstLine= input.nextLine();
        while(input.hasNext()){
            String[] line= input.nextLine().split(" ");
            name         [i]= line[0];
            type1        [i]= line[1];
            type2        [i]= line[2];
            i++;
       }
    }
    catch(FileNotFoundException e){
        System.out.println("ERROR: File not found.");
    }
    }

    // Question 6: Read and Filter Pokémon Stats Data by Highest Speed Stat
    public static void readFilterPokeStats(String filename) {
        /*
         *  Write a method that reads pokemon data from a file and filters
         *  and prints the 5 pokémons with the highest Speed stat along
         *  with the data header to the console.
         *  Print them with their stats without sorting.
         * 
         *  Exception handling message should take only one line in console.
         *  Args:
         *      filename: String that specifies the target data file.
         * 
        */

         // Your code goes here...
         // best is about speed
        String[] best5Pokemon=  new String[5];
        int   [] best5speed  =  new int   [5];
        best5PokemonArray(filename, best5Pokemon, best5speed);
        for (int i=0;i<5;i++) {
            System.out.printf
            ("%s . Its speed is: %d\n", best5Pokemon[i], best5speed[i]);
        }

    }

    public static void best5PokemonArray(String filename, 
                                         String[] best5Pokemon, 
                                         int[] best5speed){
        int[] speed= new int[countCategory(filename)-1];
        String[] name =new String[countCategory(filename)-1];
        getDataPokemons(speed, name, filename);
        int first=1;
        int second=0;
        int third=0;
        int fourth=0;
        int fifth=0;
        for(int i=1;i<speed.length;i++){
            if(speed[i]>speed[first]){
                fifth = fourth;
                fourth = third;
                third = second;
                second = first;
                first = i;
            } else if (speed[i] > speed[second]) {
                fifth = fourth;
                fourth = third;
                third = second;
                second = i;
            } else if (speed[i] > speed[third]) {
                fifth = fourth;
                fourth = third;
                third = i;

            } else if (speed[i] > speed[fourth]) {
                fifth = fourth;
                fourth = i;
            }
            else if(speed[i]>speed[fifth]){
                fifth = i;
            }
        }
        best5Pokemon[0]=name [first ];
        best5speed  [0]=speed[first ];
        best5Pokemon[1]=name [fourth];
        best5speed  [1]=speed[fourth];
        best5Pokemon[2]=name [second];
        best5speed  [2]=speed[second];
        best5Pokemon[3]=name [third ];
        best5speed  [3]=speed[third ];
        best5Pokemon[4]=name [fifth ];
        best5speed  [4]=speed[fifth ];
        
    }

    public static void getDataPokemons(int[] speed, String[] names,
                                                    String dataFile){
        File file= new File(dataFile);
        try(Scanner input= new Scanner(file);){
        int i=0;
        String firstLine= input.nextLine();
        while(input.hasNext()){
            names[i]=input.nextLine();
            i++;
       }
       input.close();
    }
    catch(FileNotFoundException e){
        System.out.println("ERROR: File not found.");
    }
        try(Scanner inpabcut= new Scanner(file);){
 Scanner abc= new Scanner(file);
       int i=0;
       String firstLine1= abc.nextLine();
        while(abc.hasNext()){
            String[] line=abc.nextLine().split(" ");
            speed[i]=Integer.parseInt(line[8]);
            i++;
        }
    }
    catch(FileNotFoundException e){
        System.out.println("ERROR: File not found.");
    }
          
    }

    /////////////// HELPER METHODS ////////////////////////////

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

    // public static int countNumberOfData(String fileName) throws Exception{
    //     int numberOfData=0;
    //     File file= new File(fileName);
    //     try(Scanner input= new Scanner(file);){
    //         while(input.hasNext()){
    //             String data= input.next();
    //             if(data.equals("0")){ break;}
    //             numberOfData++;
    //         }
    //     }
    //     return numberOfData;
    // }

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
}