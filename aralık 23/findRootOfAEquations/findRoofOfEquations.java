import java.util.Scanner;

public class findRoofOfEquations{
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] katsayilar={1,0,-7,0};
    double[] interval={2,3};
System.out.println(newtonMethod(katsayilar));
}

// public static double[] KatsayilarAl(Scanner input){
//     System.out.println("Please write what degreee your equation is:");
//     int degree= input.nextInt();
//     double[] katsayilar= new double[degree];
//     for(int i=0;i<degree;i++){
//     System.out.printf("Please write katsayişar of x^%s",i);
//     katsayilar[i]=input.nextDouble();
//     }
//     return katsayilar;
// } 

// public static double findRoot(double[] katsayilar){
//     int start;
//     for(int i=0;;i--){
//     if(resultOfEquation(katsayilar, i)<0){
//       if(resultOfEquation(katsayilar, i)>0){}

//     }
//     }
// }

// public static double resultOfEquation(double[] katsayilar, double x){
//     double result=0;
//     for(int i=0;i<katsayilar.length;i++){
//         result+=Math.pow(x, katsayilar[i]);
//     }
//     return result ;
// }

public static double newtonMethod(double[] katsayilar, double[] interval){;
    double startPoint=(interval[0]+interval[1])/2.0;
    double root=startPoint;
    try{
    while(true){
        root=startPoint-(resultOfFunction(katsayilar, root)/resultOfFunction(derivationOfAnFunction(katsayilar), root));
        if(resultOfFunction(katsayilar, root)==0){
            break;
        }
        startPoint=root;
        // if(root>3||root<2){
        //     break;
        // }
    }
}
catch(ArithmeticException e){
    System.out.println(e.getMessage());
}
    return root;
}

public static double newtonMethod(double[] katsayilar){
    double[] interval=findRootInterval(katsayilar);
    double startPoint=(interval[0]+interval[1])/2.0;
    double root=startPoint;
    try{
    while(true){
        root=startPoint-
        (resultOfFunction(katsayilar, root)/
        resultOfFunction(derivationOfAnFunction(katsayilar), root));
        if(resultOfFunction(katsayilar, root)==0){
            break;
        }
        startPoint=root;
        // if(root>3||root<2){
        //     break;
        // }
    }
}
catch(ArithmeticException e){
    System.out.println(e.getMessage());
}
    return root;
}

public static double[] findRootInterval(double[] katsayilar){
    int start=-100;
    double[] interval= new double[2];
    int pozitif=0;
    int negatif=0;
    double value=0;
    if(resultOfFunction(katsayilar, start)>0){
    while(true){
       if(resultOfFunction(katsayilar, start)<0){
       negatif=start;
       break;
       }
       pozitif=start;
       start++;
    }
    }
    else if(resultOfFunction(katsayilar, start)<0){
    while(true){
       if(resultOfFunction(katsayilar, start)>0){
       pozitif=start;
       break;
       }
       negatif=start;
       start++;
    }
    }
    interval[0]=negatif;
    interval[1]=pozitif;
    return interval;
}

// works
public static double[] derivationOfAnFunction(double[] katsayilar){
    double[] derivationOfAnFunction= new double[katsayilar.length-1];
    int kuvvet=katsayilar.length-1;
    // derivationOfAnFunction[katsayilar.length-1]=0;
    for(int i=0;i<derivationOfAnFunction.length;i++){
        derivationOfAnFunction[i]=kuvvet*katsayilar[i];
        kuvvet--;
    }
    return derivationOfAnFunction;
}

// works
public static double resultOfFunction(double[] katsayilar, double x){
    double result=0;
    for(int i=0,j=katsayilar.length-1;i<katsayilar.length;i++,j--){
        result+=katsayilar[i]*Math.pow(x, j);

    }
    return result;
} 

public static double derivationWithFormalLimitRule(double[] katsayilar, double[] interval){
    return (resultOfFunction(katsayilar, interval[1])-resultOfFunction(katsayilar, interval[0]))
                                       /(interval[1]-interval[0]);
}




}