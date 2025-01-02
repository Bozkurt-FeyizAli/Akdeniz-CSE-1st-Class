import java.util.Random;

public class Lab05_20220808073{
    public static void main(String[] args){
        CPU cpu= new CPU("i5_12300K", 60);
        RAM ram = new RAM("DDR5 ", 12);
        Computer c = new Computer(cpu, ram);
        c.run();

    }
}
class Computer{
    CPU cpu;
    RAM ram;
    Computer(CPU cpu, RAM ram){
         setCpu(cpu);
         setRam(ram);
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public void setRam(RAM ram) {
        this.ram = ram;
    }
    public CPU getCpu() {
        return cpu;
    }public RAM getRam() {
        return ram;
    }
    public  void run(){
    int result=-1;
        for (int j = 0; j < ram.memory.length; j++) {
            
        try{
        int value1=ram.getValue(0, 0);
        int value2= ram.getValue(j,j);
        result=cpu.compute(value1, value2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        ram.setValue(0, 0, result);
        System.out.println("result :"+result);
        
        }
  
        // ram.setValue(0, 0, sumDaigonal(ram.memory));
    }
    public int sumDaigonal(int[][] array) throws computationException{
        int result=0;
        for(int i=0;i<array.length;i++){
            result+=ram.getValue(i, i);
        }
        return result;
    }
    @Override
        public String toString(){
             return "Computer "+cpu+" "+ram;
        }
}

class CPU{
    String name;
    double clock;
    CPU(String name, double clock){
      setClock(clock);
      setName(name);
    }
    public void setClock(double clock) {
        this.clock = clock;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getClock() {
        return clock;
    }
    public String getName() {
        return name;
    }

    public int compute(int a, int b ) throws InterruptedException{
        try{
            Thread.sleep((int)((4/clock)*1000));
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
      return a+b;
    }
    public String toString(){
        return "CPU: " + name + " " + clock + "Ghz";
    }


}
