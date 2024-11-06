import java.util.*;
import java.io.*;

public class exam {
    public static void main(String[] args) throws Exception{
        File df= new File("sd");
        String path=df.getAbsolutePath();
        File newFile=fileInFolder(path, "abc.txt", "asd");
    }

    public static File fileInFolder(String path, String fileName, String folderName) throws Exception{
        File folder= new File("\\"+path+"\\"+folderName);
        folder.mkdirs();
        File newFile= new File("\\"+path+"\\"+folderName+"\\"+fileName);
        newFile.createNewFile();
        PrintWriter writer= new PrintWriter(newFile);
        writer.write("i created a new file in that directory");
        writer.close();
        return newFile;
    }
}
