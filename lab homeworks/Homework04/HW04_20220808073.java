public class HW04_20220808073{
    public static void main(String[] args){
    //     CPU cpu= new CPU("i5_13500K", 90000000);
    //     RAM ram = new RAM("DDR5 ", 10000);
    //     Computer c = new Computer(cpu, ram);
    //     try{
    //     c.run();
    //     String[] s= { "a", "s", "d" ,"f"};
    //     Desktop d= new Desktop(cpu, ram, s);
    //     System.out.println(d);
    //     System.out.println(double.class);
    //     }
    //     catch(ComputationException e){
    //         System.out.println(e);
    //     }
        

    //  cpu = new CPU("Intel", 6000);
    //      ram = new RAM("DDR4", 128);

    //     // Laptop oluştur
    //     Laptop laptop = new Laptop(cpu, ram, 100000);

    //     // Desktop oluştur
    //     String[] peripherals = {"Keyboard", "Mouse", "Monitor"};
    //     Desktop desktop = new Desktop(cpu, ram, peripherals);

    //     // Bilgisayarları çalıştır
    //     laptop.run();
    //     desktop.run();

    //     // Laptop'un şarj durumunu kontrol et
    //     System.out.println("Laptop Battery Percentage: " + laptop.batteryPercentage());

    //     // Laptop'u şarj et
    //     laptop.charge();

    //     // Laptop'u tekrar çalıştır
    //     laptop.run();

    //     // Laptop'un şarj durumunu kontrol et
    //     System.out.println("Laptop Battery Percentage After Charging: " + laptop.batteryPercentage());

    //     // Bilgisayarları yazdır
    //     System.out.println("Laptop: " + laptop);
    //     System.out.println("Desktop: " + desktop);

    }
}
class Computer{
    protected CPU cpu;
    protected RAM ram;
    
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
    }
    public RAM getRam() {
        return ram;
    }
    public void run() throws ComputationException, MemoryException{
        int result = 0;
        int index=0;
        try {
            for (index = 0; index < ram.getCapacity(); index++) 
                result=cpu.compute(result, ram.getValue(index, index));
        } catch (MemoryException e) {
            throw new MemoryException(ram, 0, 0);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        catch(ComputationException e){
            try {
                result =
                e.fixComputation(result, ram.getValue(result, 
                                         ram.getValue(index, index)));
                ram.setValue(0, 0, result);
            } catch (Exception ex) {
                e.getStackTrace();
            }
        }
        ram.setValue(0, 0, result);
    }
    public int[] sumDiagonal(int[][] array) {
        int[] sum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sum[i] += array[i][i];
        }
        return sum;
    }
    public int sumDigonal(int[][] array) throws ComputationException{
        int result=0;
        for(int i=0;i<array.length;i++){
            result+=ram.getValue(i, i);
        }
        return result;
    }
    @Override
        public String toString(){
             return "Computer: "+cpu+" "+ram;
        }
}

class CPU{
    private String name;
    private double clock;

    CPU(String name, double clock){
      this.clock=clock;
      this.name=name;
    }

    public double getClock() {
        return clock;
    }
    public String getName() {
        return name;
    }
    public int compute(int a, int b ) throws java.lang.InterruptedException,
                                                       ComputationException {
        try{
            Thread.sleep((int)((5/clock)*1000));
        }
        catch(InterruptedException e){
            System.out.println
            ("Exception occurred due to internal clock speed: "+clock);
        }
        if(a+b<0){
            throw new ComputationException(this, a+b);
        }
        return a+b;    
    }
    public String toString(){
        return "CPU: " + name + " " + clock + "Ghz";
    }
}

class RAM{
    private String type;
    private int capacity;
    private int[][] memory;
    
    RAM(String type, int capacity){
        this.capacity=capacity;
        this.type=type;
        initMemory();
    }
    
    public void setMemory(int[][] memory) {
        this.memory = memory;
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
        java.util.Random random = new java.util.Random();
       this.memory= new int[capacity][capacity];
       for(int i=0;i<memory.length;i++){
           for(int j=0;j<memory.length;j++){
            memory[i][j]=random.nextInt(11);
           }
       }
    }
    public int random(){
        java.util.Random r= new java.util.Random();
        return r.nextInt( 11);
    }
    private boolean check(int i, int j) throws MemoryException{
        if(i<0||i>capacity||j<0||j>capacity)
        throw new MemoryException(this, i, j);
        else 
        return true;
    }
    public int getValue(int i, int j){
        if(check(i, j))
        return memory[i][j];
        else throw new MemoryException(this, i, j);
    }
    public void setValue(int i, int j, int value)throws MemoryException{
        try{
        if(check(i, j))
            this.memory[i][j]=value;
        }
        catch(MemoryException e){
            throw new MemoryException(this, i, j);
        }
    }
    public String toString(){
        return  "RAM: " + type + " " + capacity + "GB";
    }
}

