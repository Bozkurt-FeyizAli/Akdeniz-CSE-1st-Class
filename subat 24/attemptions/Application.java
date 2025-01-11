

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



class  LinearEquation{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    // accesor
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getD(){
        return d;
    }
    public double getE(){
        return e;
    }
    public double getF(){
        return f;
    }
    public boolean isSolveable(){
        return (a*d-b*c==0) ? false : true;
    }
    //  x = ed- bf / ad- bc  and  y = af- ec / ad- bc
            
    public double getX(){
        return ((e*d-b*f)/(a*d-b*c));
    }
    public double getY(){
        return ((a*f-e*c)/(a*d-b*c));
    }
    @Override
    public String toString(){
        if(isSolveable())
        return String.format("value of x is %.3f , and value of y is %.3f .", getX(), getY());
        else return "The equation has no solution";
    }


}

class Time{
    double startTime;
    double currentTime;
    double timePassed;
    String[] time;
    Time(){

    }
    Time(double startTime, double currentTime){
        timePassed=timePassed(startTime, currentTime);
    }
    public double startTime(){
        return System.currentTimeMillis();
    }
    public double currentTime(){
        return System.currentTimeMillis();
    }
    public double timePassed(double startTime, double currentTime){
        return currentTime-startTime;
    }
    public String[] time(double timePassed){
        String[] time= new String[4];
        time[2]=Double.toString(timePassed%60)+" minute";
        timePassed/=60;
        time[1]=Double.toString(timePassed%60)+" hour";
        timePassed/=60;
        time[2]=Double.toString(timePassed%24)+" day";
        timePassed/=24;
        time[3]=Double.toString(timePassed%365)+" year";
        return time;
    }

    public String timeEdit(String[] time){
        String timeS="";
        for (int index = 0; index < time.length; index++) {
            if(!time[index].equals("null"))
                timeS+=time[index];
        }
        return timeS;
    }

    @Override
    public String toString(){
        return String.format("The time passed is %s .", timeEdit(time(timePassed)));
    }

}
