

public class Application {
    public static void main(String[] args){
        // // LinearEquation aa= new LinearEquation(1, 2, 3, 4, 5, 6);
        // // System.out.println(aa);
        // double[] xComponents={1,0,0};
        // double[] interval={0,1};
        // Integration ff = new Integration(xComponents, interval);
        // System.out.println(ff.ustToplam(2));
        Time l = new Time();
        l.startTime=System.currentTimeMillis();
    

        ali aa = new ali();
        aa.possibilityOfName("feyiz");
        l.currentTime=System.currentTimeMillis();
        System.out.println(l);

    }

}
class ali{
    int recursiveFact(int num){
        if (num==2)
        return 2;
        else return num*recursiveFact(num-1);
    }
    double recursiveGCD(int n1, int m1){
        if(m1>n1)
        return -1;
        if (m1%n1==0)
        return n1;
        else return recursiveGCD(m1, n1%m1);
    }
    boolean recursiveIsPalindrome(String word){
        if(word.length()==1||word.equals(""))
        return true;
        if(word.charAt(0)!=word.charAt(word.length()-1))
        return false;
        else return recursiveIsPalindrome(word.substring(1, word.length()-1));
    }
    char randomChar(){
        return (char)((int)'a'+((int)'z'-(int)'a')*Math.random()+1);
    }
    String randomString(int length){
        String word="";
        while(length!=0){
            word+=randomChar();
            length--;
        }
        return word;
    }
    void possibilityOfName(String name){
        int attempt=0;
        String randomWord="";
        int length=name.length();
        do{
           randomWord=randomString(length);
           attempt++;
           if(attempt==9)
           attempt=0;
        }while(!name.equals(randomWord.toLowerCase()));
        System.out.println(100/attempt);
    }
}
