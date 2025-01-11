import java.util.*;
public class code {
    public static void main(String[] args){
        System.out.println(sumOfI(5));
    }
    public static double sumOfI(int n){
        if(n==1)
        return 1/2;
        else 
        return n/(n+1) + sumOfI(n-1);
    }
}
