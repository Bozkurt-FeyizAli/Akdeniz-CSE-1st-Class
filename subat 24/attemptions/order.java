import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class order {

    public static void main(String[] args) {
        String[] or = new String[1358];
        datas("ErasmusResults.txt", or);
        orderr(or);
        writeArrayToFile(or, "orderedOver71.txt");
    }

    

    public static void writeArrayToFile(String[] array, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : array) {
                if (line != null) {
                    String[] lineA= line.split(" ");
                    if(Integer.parseInt(lineA[3])>72)
                    writer.write(line + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken hata oluştu: " + e.getMessage());
        }
    }

    public static void datas(String fileName, String[] array) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            for (int index = 0; scanner.hasNextLine() && index < array.length; index++) {
                array[index] = scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void orderr(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                continue;
            }
            String[] a = array[i].split(" ");
            int valueBefore = Integer.parseInt(a[3]);

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == null) {
                    continue;
                }
                String[] b = array[j].split(" ");
                int valueAfter = Integer.parseInt(b[3]);
                if (valueBefore > valueAfter) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    String[] tempArray = a;
                    a = b;
                    b = tempArray;
                    valueBefore = Integer.parseInt(a[3]);
                }
            }
        }
    }
}