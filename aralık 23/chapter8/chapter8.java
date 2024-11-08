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

