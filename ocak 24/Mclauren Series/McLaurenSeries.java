import java.util.*;
public class McLaurenSeries{
    public static void main(String[] args){
    // double[][] a= relativeFunctionsInfos(3);
    // for(double[] b : a){
    // for (double d : b) {
    //     System.out.println(d);
    // }
//}
resultOfRelativeFunction(3, 0.5);
}

    public static void resultOfRelativeFunction(int n, double value){
        findResultOfrelativeFuncInfos(n, value);
        findErrorBound(n, value);
    }
    
    public static void findResultOfrelativeFuncInfos(int n, double value){
        double[][] informations= relativeFunctionsInfos(n);
        double result=0;
        for (int index = 0; index < informations.length; index++) {
            result+=informations[index][0]*Math.pow(value, informations[index][1])/recursiveFactoriel(informations[index][1]);
        }
        System.out.println(result);
    }
// problemfull part
    public static double findErrorBound(int n, double value){
        double errorBound=0;
        Scanner girdi= new Scanner(System.in);
        System.out.printf("please write maximum possible result of %d . differentiation of function :",n);
        double maxResult= girdi.nextDouble();
        errorBound= maxResult*Math.pow(value, n)/recursiveFactoriel(n);
        return errorBound;
    }
    
    public static double[][] relativeFunctionsInfos(int n){
        double[][] relativeFunctionsInfos= new double[n][2];
        Scanner input= new Scanner(System.in);
        for(int i=0;n!=0;i++,n--)
        {
            System.out.printf("please write result of %d . differentiation of function :",i);
            relativeFunctionsInfos[i][0]=input.nextDouble()/recursiveFactoriel(i);
            relativeFunctionsInfos[i][1]=i;
        }
        input.close();
        return relativeFunctionsInfos;
    }
    public static double recursiveFactoriel(double n){
        if(n==0){
            return 1;
        }
        else 
        return n*recursiveFactoriel(n-1);
    }


}