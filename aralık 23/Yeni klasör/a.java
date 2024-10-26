import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class a {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		String filename = "CourseDetails.txt";
		int category_num = countCategory(filename);
		//Ağırlıkların toplamı 100 değil ise 0 döndürdüğü için ve işlem yapılamayacağı için bitiyor program direkt
		if (category_num == 0) {
			System.out.println("Buraya ErrorLog koyun Ağırlıkların(weight) toplamı 100 etmiyor diye");
		}
		else {
			int student_num = countStudent();
			String[] category_names = new String[category_num];
			String[] student_names = new String[student_num];
			Double[] student_grades = new Double[student_num];
			int[] category_quantities = new int[category_num];
			int[] category_weights = new int[category_num];

			getCategory(category_names,category_quantities,category_weights,filename);
			calculateGrade(category_quantities,category_weights,category_num,student_names,student_grades);
			writeGrades(student_names, student_grades);
		}
		
	}
	
	public static int countCategory (String filename) throws FileNotFoundException {
		int weight = 0, category_number = 0;
		String[] s_array = null;
		Scanner s = new Scanner(new File(filename));
		while(s.hasNextLine()) {
			s_array = s.nextLine().split(" ");
			weight += Integer.valueOf(s_array[2]);
			category_number++;
		}
		//Ağırlıların toplamı 100 ise kategori sayısını döndürüyor
		//Değil ise 0 döndürüyor
		if (weight == 100) return category_number;
		else return 0;
	}
	
	public static int countStudent () throws FileNotFoundException {
		int student_num = 0;
		Scanner s = new Scanner(new File("StudentScores.txt"));
		while(s.hasNextLine()) {
			String[] s_array = s.nextLine().split(" ");
			boolean flag = true;
			for(int i = 0; i < s_array.length - 1 ; i++) {
				if(Double.valueOf(s_array[i + 1]) < 0)flag = false;
			}
			if(flag)student_num++;
		}
		return student_num;
	}
 	
	public static void getCategory(String[] category_names,int[] category_quantities, int[] category_weights, String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		int i = 0;
		while(s.hasNextLine()) {
			String[] s_array = s.nextLine().split(" ");
			category_names[i] = s_array[0];
			category_quantities[i] = Integer.valueOf(s_array[1]);
			category_weights[i] = Integer.valueOf(s_array[2]);
			i++;
		}
	}
	
	public static void calculateGrade(int[] cat_quantity, int[] cat_weight, int cat_num,String[] student_names,Double[] student_grades) throws FileNotFoundException {
		Scanner s = new Scanner(new File("StudentScores.txt"));
		int counter2 = 0;
		while(s.hasNextLine()) {
			double grade = 0;
			int counter = 0;
			String[] s_array = s.nextLine().split(" ");
			boolean flag = true;
			for(int i = 0; i < s_array.length - 1 ; i++) {
				if(Double.valueOf(s_array[i + 1]) < 0)flag = false;
			}
			//Hemen yukarıdaki for döngüsünde yanlış bi not girmiş mi diye kontrol ediyor
			//Girmişse flag false oluyor aşağıdaki hesaplama yapılan for döngüsünün içine girmiyor
			if(flag) {
				for(int i = 0; i < cat_num; i++) {
					double total = 0;
					//Yapılan sınavların toplamı
					//4 tane quiz yapılmış ise 4 kere dönüyor , 3 tane homework yapılmışsa 3 kere dönüyor gibi
					for(int j = 1; j < cat_quantity[i] + 1 ; j++) {
						total += Double.valueOf(s_array[counter + j]);
					}
					//% değerini alıyoruz
					grade = grade + (((total / 100) * cat_weight[i] )/ cat_quantity[i]);
					counter += cat_quantity[i];
				}
				student_names[counter2] = s_array[0];
				student_grades[counter2] = grade;
				counter2++;
			}
			else {
				System.out.println("Buraya da yanlış grade girildi error log koyulacak");
				System.out.println("Student: " + s_array[0] + " entered invalid grade");
			}
		}
			
	}
	
	public static void writeGrades(String[] student_names, Double[] grades) throws IOException {
		BufferedWriter w = new BufferedWriter (new FileWriter(new File("StudentGrades.txt")));
		String st;
		for(int i = 0; i < grades.length ; i++ ) {
			if(grades[i] <= 100 && grades[i] >= 88) {
				w.write(student_names[i]+ " " + grades[i] + " AA" + " 4.0" + " Passed");
			} 
			else if (grades[i] < 88 && grades[i] >= 81)w.write(student_names[i]+ " " + grades[i] + " BA" + " 3.5" + " Passed");
			else if (grades[i] < 81 && grades[i] >= 74)w.write(student_names[i]+ " " + grades[i] + " BB" + " 3.0" + " Passed");
			else if (grades[i] < 74 && grades[i] >= 67)w.write(student_names[i]+ " " + grades[i] + " CB" + " 2.5" + " Passed");
			else if (grades[i] < 67 && grades[i] >= 60)w.write(student_names[i]+ " " + grades[i] + " CC" + " 2.0" + " Passed");
			else if (grades[i] < 60 && grades[i] >= 53)w.write(student_names[i]+ " " + grades[i] + " DC" + " 1.5" + " Conditianally Passed");
			else if (grades[i] < 53 && grades[i] >= 46)w.write(student_names[i]+ " " + grades[i] + " DD" + " 1.5" + " Conditianally Passed");
			else if (grades[i] < 46 && grades[i] >= 35)w.write(student_names[i]+ " " + grades[i] + " FD" + " 1.5" + " Failed");
			else if (grades[i] < 35 && grades[i] >= 0 )w.write(student_names[i]+ " " + grades[i] + " FF" + " 1.5" + " Failed");
			w.newLine();
		}
		
		w.close();
	}
}

