public class circle {
    public static void main(String[] args){
        abc ss= new abc();

        System.out.println(ss.getArea(5.0));
    }





    
}
 class abc{
    // double radius=1.0;
    // abc(){}
    // abc(double newRadius){
    //     radius=newRadius;
    // }
    double getArea(double radius){
       return radius*radius*Math.PI;
    }


    }
