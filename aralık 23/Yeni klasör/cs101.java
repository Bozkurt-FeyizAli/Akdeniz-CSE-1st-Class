import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class cs101{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String filename= "df";
        Scanner input= new Scanner(System.in);
    //     File inputFile = null;
    //     do{
    //     try{
        
            
    //         filename= input.nextLine();
    //         inputFile=new File(filename);
    //         inputFile.createNewFile();
    //         System.out.printf("File %s created sucsessfully\n", inputFile.getName());
    //     } 
    //     catch(IOException e){
    //         System.out.printf("ERROR: could mot create file %s\n", inputFile.getName());
    //         System.out.println(e.getMessage());
    //     }
    // }while(!inputFile.exists());
    File file= createFile(filename);
    System.out.println(file.getAbsolutePath());
    System.out.println("relative: "+file.getPath());
    
    String currentDirector= file.getAbsolutePath().replace(file.getName(), "");
    System.out.println("Directory: "+currentDirector);
    File file2 = new File("qwert.txt");
    if(file2.delete()){
        System.out.printf("deleted file %s", file2.getName());
    }
    else{
        System.out.println("could not delete the file");
    }

    // File lab = new File("Lab.java");
    // lab.setWritable(false);
    File dir= new File(currentDirector);
    for (File f : dir.listFiles()) {
        System.out.println("name: "+f.getName());
        System.out.println("iiDir: "+ f.isDirectory());
        System.out.println("isFile: "+f.isFile());
        System.out.println("executable: "+f.canExecute());
        System.out.println("readebla: "+f.canRead());
        System.out.println("writable: "+f.canWrite());
        System.out.println("=================");
    }
    File test_dir = new File("Test");
    System.out.println(test_dir.getAbsolutePath());
    File folder = new File(test_dir.getPath()+"\\"+"Folder3.html");
    folder.mkdir();
    folder.mkdirs();
    File directories= new File(currentDirector+"\\sd\\sd\\sdsd");
    directories.mkdirs();

    for(int i=0;i<5;i++){
        createFile(folder.getPath()+"\\File_"+i+".java");
    }

int counter =0;
    // try{
    // PrintWriter pw= new PrintWriter(file);
    // pw.println("123");
    // pw.close();
    // }
    // catch(FileNotFoundException e){

    // }
    try(
        // PrintWriter pw= new PrintWriter(file);

        FileWriter fw= new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        ){
        pw.write("123\n");
    }
    catch(IOException e){
    //TODO : handle with exception
    }

    try(
        FileReader fr = new FileReader(file);
        Scanner fileReader = new Scanner(fr);
    ){
        fileReader.useDelimiter(" ");
          while(fileReader.hasNext()){
System.out.println(fileReader.nextLine());
System.out.println("counter :"+(++counter));
          }
    }
  
    catch(FileNotFoundException e){
 System.out.printf(" ERROR: file %s nıt found",file.getName());
    }
    catch(IOException e){
System.out.println("ıo exception ");
    
    }

    /////////////generate template///////

    // if(!folfer.exists()){
    //     folfer.mkdirs();
    // }
    //   if(!folfer.exists()){
    //     createFile("Folder");
    // }
    //createFile(test_dir.getAbsolutePath()+"\\"+"deneme2.txt");

    //file.toPath();
    //File file2=createFile("qwert.txt");
    
//System.out.println("relative: "+inputFile.getPath());
    
}












public static File createFile(Scanner input){
    File file = null;
     do{
        try{
        String fileName=input.nextLine();
            
            file=new File(fileName);
            file.createNewFile();
            System.out.printf("File %s created sucsessfully\n", file.getName());
        } 
        catch(IOException e){
            System.out.printf("ERROR: could mot create file %s\n", file.getName());
            System.out.println(e.getMessage());
        }
    }while(!file.exists());
    
    System.out.println(file.getAbsolutePath());
    return file;

}
public static File createFile(String fileName){
    File file = null;
     do{
        try{
            file=new File(fileName);

            if(file.exists()){
                System.out.printf("file %s alresy exist"+" last modified on: %s", file.getName(), new Date(file.lastModified()));
                return file;}

            file.createNewFile();
            System.out.printf("File %s created sucsessfully\n", file.getName());
        } 
        catch(IOException e){
            System.out.printf("ERROR: could mot create file %s\n", file.getName());
            System.out.println(e.getMessage());
        }
    }while(!file.exists());
    
    System.out.println(file.getAbsolutePath());
    return file;
}




    }