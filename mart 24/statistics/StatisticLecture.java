import javax.sound.midi.Soundbank;

public class StatisticLecture{
    public static void main(String[] args) {
    // double[] datas= {10,20,22,34,18,22,34};
    // double[] datas2={30,40,52,50,40,52,48,34,32};
    Statistic ff=new Statistic();
    // System.out.println("datas 1 mean: "+ff.mean(datas));
    // System.out.println("datas 2 mean: "+ff.mean(datas2));
    // System.out.println("datas 1 var : "+ff.varianceS_2(datas));
    // System.out.println("datas 2 var : "+ff.varianceS_2(datas2));
    // System.out.println(ff.BinomialDistribution(20, 6, 0.25));
    // System.out.println(ff.recursiveFactorial(5));
    System.out.println(ff.normalDistribution(500, 575, 50));

    
    }


}

class Statistic{
    private static double mean;
    private static double mod;
    private static double medyan;
    private static double varianceS_2;
    private static double BinomialDistribution;
    private double poissonDistrbution;
    private double normalDistribution;

    public double normalDistribution(double mean, double x, double variance){

        normalDistribution=(1/variance*Math.sqrt(2*Math.PI))*(Math.pow(Math.E, (1/2)*Math.pow(((x-mean)/variance),2)));
    return normalDistribution;
    }

    public double transformation(double mean, double x, double variance){
          return (x-mean)/variance;
    } 

    public double poissonDistrbution(double mean, int x){
        poissonDistrbution= (Math.pow(Math.E,-mean)*Math.pow(mean, x)/recursiveFactorial(x));
        return poissonDistrbution;
    }


    public double BinomialDistribution(int n, int x, double p){
        double q=1-p;
        BinomialDistribution=100*combination(n, x)*Math.pow(p, x)*Math.pow(q, n-x);;

        //yüzde olarak sonuç verir
        // return 100*(combination(n, x)*Math.pow(p, x)*Math.pow(q, n-x));  
        return BinomialDistribution;
    }

    public static Long combination(int n, int x){
        // over flow oluyor eğer kısa yazarsan
        if(x<14)
        return recursiveFactorial(n)/(recursiveFactorial(x)*recursiveFactorial(n-x));
        else{
        int combination=1;
        for(int i=n;i>(int)Math.max(x, n-x);i--){
            combination=combination*i;
        }
        return combination/recursiveFactorial(Math.min(x, n-x));}
    }

    public static long recursiveFactorial(int n){
        if(n==1||n<1)
        return 1;
        else
        return n*recursiveFactorial(n-1);
    }
    public double mean(double[] datas){
        mean=0;
        for (int index = 0; index < datas.length; index++) {
            mean+=datas[index]/datas.length;
        }
        return mean;
    }

    public double varianceS_2(double[] datas){
        varianceS_2=0;
        mean=mean(datas);
        for (int index = 0; index < datas.length; index++) {
            varianceS_2+=Math.pow((mean-datas[index]), 2)/(datas.length-1);
        }
        return varianceS_2;
    }

    public double mod(double[] datas){
        double candidateData=0;
        double data=0;
        int candidateTimes=0;
        int times=0;
        for (int then = 0; then < datas.length; then++) {
            candidateData=datas[then];
            for (int index = 0; index < datas.length; index++) {
                if(datas[index]==candidateData)
                candidateTimes++;
            }
            if(candidateTimes>times){
                times=candidateTimes;
                data= candidateData;
            }
        }
        mod=data;
        return medyan;
    }

    public void sortArray(double[] array){
        double swap=0;
        for (int index = 0; index < array.length; index++) {
            for (int j = 0; j < array.length; j++) {
                if(array[index]>array[j]){
                    swap=array[j];
                    array[j]=array[index];
                    array[index]=swap;
                }
            }
        }
    }

    public double medyan(double[] datas){
        if(datas.length%2==1){
            return (datas[datas.length/2]+datas[datas.length/2+1])/2;
        }
        else
        return datas[datas.length/2];
    }
    
    public int h(double[] datas){
        return (int)Math.sqrt(datas.length);
    }

    public double[][] frequence(double[] datas){

        double[][] frequance= new double[eliminateDublicate(datas).length][2];
        int times=0;
        for (int index = 0; index < eliminateDublicate(datas).length; index++) {
            times=0;
            for (int j = 0; j < data.length; j++) {
                if(datas[index]==datas[j])
                times++;
            }
            frequance[index][1]=times;
        }
        return frequance;
    }
     public double modShort(double[] datas){
        double[][] listOfData=frequence(datas);
        for (int i = 0; i < listOfData.length; i++) {
            if(listOfData[i][1]<mod)
                mod=listOfData[i][0];
        }
        return mod;
     }

    public double[][] addetiveFrequence(double[][] frequance){
        double a= (int)frequance[0][1];
        double[][] addetiveFrequence= new double[frequance.length][2];
        addetiveFrequence[0][1]=a;
        for(int i=1;i<frequance.length;i++){
            addetiveFrequence[i][1]=a+frequance[i][1];
            a=addetiveFrequence[i][1];
        }
        return addetiveFrequence;
    }

    // public double[][] classBoundary(int h){
    //     double alt=-0.5;
    //     for(int i=0;i<)
    // }

    public double[] eliminateDublicate(double[] array){
        double[] candidateEliminateDublicate=new double[array.length];
        int a=0;
        for (int index = 0; index < array.length; index++) {
            for (int j = index+1; j < array.length; j++) {
                if(!isThatInArray(array, array[index]))
                    if(!isThatInArray(candidateEliminateDublicate, array[index])) 
                        candidateEliminateDublicate[a]=array[index];
            }
        }  
        int length=0;
        for(int i=0;i<candidateEliminateDublicate.length-2;i++){
            length++;
            if(candidateEliminateDublicate[i+1]==0&&candidateEliminateDublicate[i+1]==0)
            break;
        }
        double[] eliminateDublicate= new double[length]; 
        for (int index = 0; index < eliminateDublicate.length; index++) {
            eliminateDublicate[index]=candidateEliminateDublicate[index];
        }
        return eliminateDublicate;
    }

    public boolean isThatInArray(double[] array, double that){
        int times=0;
        for(int i=0;i>array.length;i++){
            if(that==array[i])
            times++;
            if(times==2)
            return true;
        }
        return false;
    }

    
     
                                      
                                      
  
}