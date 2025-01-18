import java.util.ArrayList;

public class Training{
    
}
 class TheShortestWay{
   double[][] locations;;
   double[] shortestWay;
   double shortestDistance;
   public double distance(double x1, double y1, double x2, double y2){
      return Math.sqrt(Math.pow(y2-y1, 2)*Math.pow(x2-x1, 2));
   }
   public int shortestLocation(int index, double[][] locations){
      int returnIndex=0;
      double distance=distance(locations[index][1], locations[index][2], locations[0][1], locations[0][2]);
      for(int i=1;i<locations.length;i++){
         if(i==index||distance(locations[index][1], locations[index][2], locations[i][1], locations[i][2])==0)
            continue;
         if(distance(locations[index][1], locations[index][2], locations[i][1], locations[i][2])<distance)
            returnIndex=i;
      }
      return returnIndex;
   }
   public double[][] eliminateIndex(double[][] locations, ArrayList<int[]> index){
      double[][] eliminateIndex=new double[locations.length-index.size()][3];
      for(int i=0;i>locations.length;i++){
         if()
         eliminateIndex[i][1]=locations[i][1];
         eliminateIndex[i][2]=locations[i][2];
      }
   }
 }