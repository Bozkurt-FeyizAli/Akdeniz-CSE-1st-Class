import java.util.Scanner;

public class chapter8{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
polygonSubareas(input);z
    }

    public static void polygonSubareas(Scanner input){
        double[][] points=getPoints(input);
        double[] midPoint=findMiddlePoint(points);
        double[][] sideOfAngles=sideOfAngles(points, midPoint);
        double[] areas=triangeArea(sideOfAngles);
        for (double d : areas) {
            System.out.printf("area is %f",d);
            System.out.println();
        }
    

    }

    public static double[] triangeArea(double[][] sideOfAngles){
        double[] areas = new double[sideOfAngles.length];
        double[] aritmetikKenarOrtalaması=new double[sideOfAngles.length];
        for (int i = 0; i < sideOfAngles.length; i++) {
            for (int j = 0; j < sideOfAngles[i].length; j++) {
                aritmetikKenarOrtalaması[i] += sideOfAngles[i][j];
            }
            aritmetikKenarOrtalaması[i] /= sideOfAngles[i].length;
        }
    
        for (int i = 0; i < sideOfAngles.length; i++) {
            areas[i] = aTriangleArea(sideOfAngles[i][0], sideOfAngles[i][1], sideOfAngles[i][2], aritmetikKenarOrtalaması[i]);
        }
        return areas;
    }

    public static double aTriangleArea(double side1, double side2, double side3, double aritmetikKenarOrtalaması){
         double s = aritmetikKenarOrtalaması / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static double[][] sideOfAngles(double[][] points, double[] midPoint){
        double[][] sideOfAngles = new double[points.length][3];
        for (int i = 0; i < points.length; i++) {
            sideOfAngles[i][0] = calculateSide(points[i][0], points[i][1], midPoint[0], midPoint[1]);
            sideOfAngles[i][1] = calculateSide(points[i][0], points[i][1], points[(i + 1) % points.length][0], points[(i + 1) % points.length][1]);
            sideOfAngles[i][2] = calculateSide(points[(i + 1) % points.length][0], points[(i + 1) % points.length][1], midPoint[0], midPoint[1]);
        }
        return sideOfAngles;
    }

    public static double calculateSide(double point1X, double point1Y, double point2X, double point2Y){
        return Math.sqrt(Math.pow(point2X-point1X, 2)+Math.pow(point2Y-point1Y, 2));
    }

    public static double[] findMiddlePoint(double[][] points){
        double[] midPoint = new double[2];
        for (int i = 0; i < points.length; i++) {
            midPoint[0] += points[i][0] / points.length;
            midPoint[1] += points[i][1] / points.length;
        }
        return midPoint;
    }

    public static double[][] getPoints(Scanner input){
        double[][] points = new double[4][2];
        System.out.println("Please write x1 y1 x2 y2 x3 y3 x4 y4 in order:");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        return points;
    }

    public static void polygonSubareas1(Scanner input) {
        double[][] points = getPoints1(input);
        double[] midPoint = findMiddlePoint1(points);
        double[][] sideOfAngles = sideOfAngles1(points, midPoint);
        double[] areas = triangeArea1(sideOfAngles);
        for (double d : areas) {
            System.out.printf("Area is %.2f%n", d);
        }
    }

    public static double[] triangeArea1(double[][] sideOfAngles) {
        double[] areas = new double[sideOfAngles.length];
        double[] aritmetikKenarOrtalamasi = new double[sideOfAngles.length];

        for (int i = 0; i < sideOfAngles.length; i++) {
            for (int j = 0; j < sideOfAngles[i].length; j++) {
                aritmetikKenarOrtalamasi[i] += sideOfAngles[i][j];
            }
        }

        for (int i = 0; i < sideOfAngles.length; i++) {
            areas[i] = aTriangleArea1(sideOfAngles[i][0], sideOfAngles[i][1], sideOfAngles[i][2], aritmetikKenarOrtalamasi[i]);
        }
        return areas;
    }

    public static double aTriangleArea1(double side1, double side2, double side3, double aritmetikKenarOrtalamasi) {
        double s = aritmetikKenarOrtalamasi / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static double[][] sideOfAngles1(double[][] points, double[] midPoint) {
        double[][] sideOfAngles = new double[points.length][3];
        for (int i = 0; i < points.length; i++) {
            sideOfAngles[i][0] = calculateSide1(points[i][0], points[i][1], midPoint[0], midPoint[1]);
            sideOfAngles[i][1] = calculateSide1(points[i][0], points[i][1], points[(i + 1) % points.length][0], points[(i + 1) % points.length][1]);
            sideOfAngles[i][2] = calculateSide1(points[(i + 1) % points.length][0], points[(i + 1) % points.length][1], midPoint[0], midPoint[1]);
        }
        return sideOfAngles;
    }

    public static double calculateSide1(double point1X, double point1Y, double point2X, double point2Y) {
        return Math.sqrt(Math.pow(point2X - point1X, 2) + Math.pow(point2Y - point1Y, 2));
    }

    public static double[] findMiddlePoint1(double[][] points) {
        double[] midPoint = new double[2];
        for (int i = 0; i < points.length; i++) {
            midPoint[0] += points[i][0] / points.length;
            midPoint[1] += points[i][1] / points.length;
        }
        return midPoint;
    }

    public static double[][] getPoints1(Scanner input) {
        double[][] points = new double[4][2];
        System.out.println("Please write x1 y1 x2 y2 x3 y3 x4 y4 in order:");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        return points;
    }
}

