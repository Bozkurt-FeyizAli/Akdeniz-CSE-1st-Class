public class Pyhsics{
    public static void main(String[] args) {
        Electricity e= new Electricity()
        
    }
}
class Electricity{
    Electricity(){

    }
    Electricity(double q1, double q2, double r, double k){
        setK(k);
        setQ1(q1);
        setQ2(q2);
        setR(r);
    }
    double q1;
    double q2;
    Double r;
    double k;
    public void setK(double k) {
        this.k = k;
    }
    public void setQ1(double q1) {
        this.q1 = q1;
    }
    public void setQ2(double q2) {
        this.q2 = q2;
    }
    public void setR(Double r) {
        this.r = r;
    }
    public double getK() {
        return k;
    }
    public double getQ1() {
        return q1;
    }
    public double getQ2() {
        return q2;
    }
    public Double getR() {
        return r;
    }
    public void electricialForce(){
        System.out.println(q1*q2/(r*r)+"k");
    }
    public void electricField(){
        System.out.println(q1/(r*r)+"k");
    }
    public void electricialPotential(){
        System.out.println(q1/(r)+"k");
    }
} 