import java.util.Scanner;
public class cs101{
    public static void main(String[] args){
    // System.out.println(random(1, 2));      
//   display2D(generateArray2D(1, 3, 5, 7));
     int [][] newArray=generateArray2D(10, 13, 3, 15);

    }

    public static int random(int a, int b){
        return a+(int)(Math.random()*(b-a+1));
    }

    public static char randomChar(char a, char b){
        return (char)(random((int)a, (int)b));
    }

    public static int[][] generateArray2D(int m, int n, int start, int end){
        int [][] generateArray2D =new int[m][];
        for(int i=0;i<generateArray2D.length;i++){
            generateArray2D[i]= new int[random(start, end)];
            for(int j=0;j<generateArray2D[i].length;j++){
                   generateArray2D[i][j]=random(start, end);
            }
        }
        return generateArray2D;
    }

    public static void display2D(int[][] array2D){
        for (int[] i :array2D) {
            display(i);
        }
    }
    
    public static void display(int[] array){
        for (int k : array) {
          System.out.printf("%2d",k);  
        }
        System.out.println();
    }

    public static void majorDiagonals(int[][] array2D){
    int soldanSağa=0;
    int sağdanSola=0;
    for(int i=0;i<array2D.length;i++){
       for(int j=0;j<array2D[0].length;j++){
        if(i==j){
        sağdanSola+=array2D[i][j];
        soldanSağa=array2D[array2D.length-i-1][j];}
       }
    }
    System.out.println("sağdanSola: "+sağdanSola);
    System.out.println("soldanSağa: "+soldanSağa);
   }
     
    
   public static int[] getClosesPoints(int[][] points, int pointInedex){
   int[] result = new int[points.length*points[0].length];
   int colsestPoint=0;
   for(int i=0;i<points.length;i++){
    for(int j=0;j<points[i].length;j++){
        result[i+j]=distance(points[i].length, points[i][j]);
    }
   }
   for(int i=0;i<result.length;i++){
    if(result[i]>colsestPoint){
        colsestPoint=result[i];
    }
   }
   return colsestPoint;
   }

   public static double distance(int[] pointA, int[] pointB){
    int result=0;
    if(pointA.length==pointB.length){
    for (int i=0; i<pointA.length;i++){
            result+=Math.pow(pointA[i], pointB[i]);
        }
    }
    return (Math.sqrt(result));
   }

    public static int[] distance1(int[] pointA, int[] pointB){
        int[] result= new int[pointA.length*pointB.length];
        for (int i=0; i<pointA.length;i++){
            for(int j=0;j<pointB.length;j++){
                result[i+j]=(int)(Math.sqrt(Math.pow(pointA[i], 2)+Math.pow(pointB[j], 2)));
            }
        }
   return result;
   }

   



}