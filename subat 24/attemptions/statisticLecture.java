        return recursiveFactorial(n)/(recursiveFactorial(x)*recursiveFactorial(n-x));
        else{
        Long combination=1L;
        for(int i=n;i>(int)Math.max(x, n-x);i--){
            combination=combination*i;
        }
        return combination/recursiveFactorial(Math.min(x, n-x));}
    }

    public static long recursiveFactorial(int n){
        if(n<=1)
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

