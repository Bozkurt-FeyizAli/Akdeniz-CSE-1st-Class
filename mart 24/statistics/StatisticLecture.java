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

