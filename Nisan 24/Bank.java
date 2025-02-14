import java.util.ArrayList;

public class Bank{
    Staff[] staffes;
    Manager[] managers;

   
        public static void main(String[] args) {
            String result = repeatString("abc", 321);
            System.out.println(result); // Output: aaabbbccc
        }
    
        public static String repeatString(String s, int ns) {
            if (ns <= 0) {
                return "";
            } else {
                int length = s.length();
                char firstChar = s.charAt(0);
                int repeatCount = ns / (int) Math.pow(10, length - 1);
                String remainingString = s.substring(1);
                return repeatChar(firstChar, repeatCount) + repeatString(remainingString, ns % (int) Math.pow(10, length - 1));
            }
        }
    
        public static String repeatChar(char c, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
            return sb.toString();
        }

    
    
}

class Staff{
    String name;
    int age;
    double salary;

    void getRaise(int n){
        if(n>=1&&n<=100)
        salary+=salary*n/100;
    }

}
class Manager extends Staff{
    int employees;

    void hireStaff(){
        employees++;
    }
    void fireStaff(){
        employees--;
    }

}
