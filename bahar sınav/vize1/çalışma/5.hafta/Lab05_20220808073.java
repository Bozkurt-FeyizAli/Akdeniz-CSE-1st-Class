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

class RAM{
    String type;
    int capacity;
    int[][] memory;
    RAM(String type, int capacity){
        setCapacity(capacity);
        setType(type);
        initMemory();
    }
    public void setValue(int i, int j, int result) {
        if(check(i, j))
        memory[i][j]=result;
        else
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setMemory(int[][] memory) {
        this.memory = memory;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCapacity() {
        return capacity;
    }
    public int[][] getMemory() {
        return memory;
    }
    public String getType() {
        return type;
    }
    // use random class
    private void initMemory(){
        Random random = new Random();
       this.memory= new int[capacity][capacity];
       for(int i=0;i<memory.length;i++){
           for(int j=0;j<memory.length;j++){
            memory[i][j]=random.nextInt(0,10);
           }
       }
    }
    public int random(){
        return (int) Math.random()*10+1;
    }
    private boolean check(int i, int j) throws ArithmeticException{
     // add
     CPU a= new CPU(type, j);
        if(j<capacity+1&&j>-1||capacity+1>i&&i>-1)
        return true;
        else 
        throw 
        new ArithmeticException();
        // // computationException(cpu, i, j);
        
        
    }
    public int getValue(int i, int j) throws computationException{
        if(check(i, j))
        return memory[i][j];
        else return -1;
    }
    // public void setValue(int i, int j, int value)throws ArrayIndexOutOfBoundsException{
    //     if(value<11&&value>-1)
    //     if(check(i, j))
    //     this.memory[i][j]=value;
    //     else
    //     throw new AssertionError(i);
        
    //      System.out.println("ERROR");
    

    // }
    public String toString(){
        return  "RAM: " + type + ", " + capacity + "GB";
    }



}

// out of bound memory
class Laptop extends Computer{
    int milliAmp;
    int battery;
    Laptop(CPU cpu, RAM ram, int milliAmp){
        super(cpu, ram);
        setMilliAmp(milliAmp);
        this.battery=30;

    }
    public void setBattery(int battery) {
        this.battery = battery;
    }
    public void setMilliAmp(int milliAmp) {
        this.milliAmp = milliAmp;
    }
    public int getBattery() {
        return battery;
    }
    public int getMilliAmp() {
        return milliAmp;
    }
    public int  batteryPercentage(){
        return getBattery();
    }
    public void charge(){
        if(battery<90){
            this.battery+=2;
        }
    }
    @Override
    public void run(){
        if(battery>5)
        this.battery-=5;
    }
    public String toString(){
        return super.toString()+" "+Integer.toString(battery);
    }
}

class Desktop extends Computer{
    java.util.ArrayList<String> peripherals;
    Desktop(CPU cpu, RAM ram,String[] varargsPeripherals){
        super(cpu, ram);
        // this.peripherals=Array.varargsPeripherals;
    }
    @Override
    public void run(){
        
    }
    public void plugIn(String peripheral){
        this.peripherals.add(peripheral);
    }
    public void plugOut(){
        this.peripherals.remove(peripherals.size()-1);
    }
    public String plugOut(int index){
        String result= peripherals.get(index);
        peripherals.remove(index);
        return result;
    }
    @Override
    public String toString(){
        String result= super.toString()+" ";
        for(int i=0;i<peripherals.size();i++){
            result+= peripherals.get(i)+" ";
        }
        return result;
    }

} 
class MemoryException extends RuntimeException{
    RAM ram;
    MemoryException(RAM ram, int i, int j){
        super("indexes are out of bound of the memory"+"for indexes"+i+", and"+j);
        this.ram=ram;
    }

}
class computationException extends Exception{
    CPU cpu;
    computationException(CPU cpu, int result){
        super("an exception occures durring comp. ,"+result);
