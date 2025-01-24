
public class HW07_20220808057 {

    public static void main(String[] args) {

        // Mirror m1= new Mirror("n", 1, 1, 1);
        // Mirror m2= new Mirror("nu", 2, 2, 2);
        // Mirror m3= new Mirror("nul", 3, 3, 3);
        // Mirror m4= new Mirror("null", 4, 4, 4);
        // Mirror m5= new Mirror("nulll", 5, 5, 5);
        // Paper p1= new Paper("q",1," ");
        // Paper p2= new Paper("q",1," ");
        // Paper p3= new Paper("q",1," ");
        // Paper p4= new Paper("q",1," ");
        // Paper p5= new Paper("q",1," ");

        // Matroschka<Paper> MA= new Matroschka<Paper>(p1);
        // Box<Paper> b1= new Box<Paper>(10,p1);
        // Box<Mirror> b2= new Box<Mirror>(12, m2);
        // Box<Paper> b3= new Box<Paper>(24, p4);
        // b1.pack(p1);
        // b1.pack(p2);
        // b1.pack(p3);
        // b1.pack(p4);

        // b3.pack(p2);
        // b3.pack(p3);
        // b3.pack(p4);
        
        // Container c1= new Container();
        // Container c2= new Container();
        // Container c3= new Container();
        // c1.push(b3);
        // c1.push(b2);
        // c1.push(b1);
        // CargoFleet cF= new CargoFleet();
        // cF.enqueue(c1);
        // CargoCompany cK= new CargoCompany();
        // cK.add(b2);
        // cK.add(b1);
        // cK.add(b3);
        // for (int i = 0; i < 30; i++) {
        //     cK.add(new Box<Matroschka<Paper>>(10,MA));
        // }
        // System.out.println(cK);

        // Test Mirror sınıfı
        Mirror mirror1 = new Mirror("Mirror",8,5, 4);
        Mirror mirror2 = new Mirror("MIRROR",6,1, 1);
        System.out.println("Mirror 1 Area: " + mirror1.getArea()); // Çıktı: 20
        System.out.println("Mirror 1 Price: " + mirror1.getPrice()); // Çıktı: 160.0
        System.out.println("Mirror 2 Area: " + mirror2.getArea()); // Çıktı: 1
        System.out.println("Mirror 2 Price: " + mirror2.getPrice()); // Çıktı: 6.0
        mirror1.reflect("Hello, Mirror!"); // Çıktı: Hello, Mirror!

        // Test Paper sınıfı
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        paper1.setNote("This is a note.");
        System.out.println("Paper 1 Note: " + paper1.getNote()); // Çıktı: This is a note.

        // Test Matroschka sınıfı
        Matroschka<Paper> matroschka1 = new Matroschka<>(paper1);
        Matroschka<Matroschka<Paper>> matroschka2 = new Matroschka<>(matroschka1);
        System.out.println("Matroschka 1: " + matroschka1); // Çıktı: Matroschka { item = Paper@... }
        System.out.println("Matroschka 2: " + matroschka2); // Çıktı: Matroschka { item = Matroschka { item = Paper@... } }

        // Test Box sınıfı
        Box<Mirror> boxMirror1 = new Box<>(15,mirror1);
        Box<Mirror> boxMirror2 = new Box<>(15,mirror2);
        Box<Paper> boxPaper1 = new Box<>(10,paper1);
        Box<Paper> boxPaper2 = new Box<>(20,paper2);
        Box<Matroschka<?>> boxMatroschka1 = new Box<>(10,matroschka1);
        Box<Matroschka<?>> boxMatroschka2 = new Box<>(10,matroschka2);

        System.out.println("Box Mirror 1 Priority: " + boxMirror1.getPriority()); // Çıktı: 2.6666666666666665
        System.out.println("Box Mirror 2 Priority: " + boxMirror2.getPriority()); // Çıktı: 0.13333333333333333
        System.out.println("Box Paper 1 Priority: " + boxPaper1.getPriority()); // Çıktı: 0.05
        System.out.println("Box Paper 2 Priority: " + boxPaper2.getPriority()); // Çıktı: 0.025
        System.out.println("Box Matroschka 1 Priority: " + boxMatroschka1.getPriority()); // Çıktı: 0.55
        System.out.println("Box Matroschka 2 Priority: " + boxMatroschka2.getPriority()); // Çıktı: 0.55

        // Test Container sınıfı
        Container container1 = new Container();
        container1.push(boxMirror1);
        container1.push(boxMirror2);
        container1.push(boxPaper1);
        container1.push(boxPaper2);
        container1.push(boxMatroschka1);
        container1.push(boxMatroschka2);

        System.out.println("Container 1 Size: " + container1.size()); // Çıktı: 6
        System.out.println("Container 1 Priority: " + container1.getPriority()); // Çıktı: 3.9866666666666664

        Box<?> poppedBox = container1.pop();
        System.out.println("Popped Box: " + poppedBox); // Çıktı: Box [distanceToAddress=10, item=Matroschka { item = Matroschka { item = Paper@... } }, seal=true]

        // Test CargoFleet sınıfı
        CargoFleet cargoFleet = new CargoFleet();
        cargoFleet.enqueue(container1);
        System.out.println("Cargo Fleet Size: " + cargoFleet.size()); // Çıktı: 1
        Container dequeuedContainer = cargoFleet.dequeue();
        System.out.println("Dequeued Container Priority: " + dequeuedContainer.getPriority()); // Çıktı: 3.9866666666666664

        // Test CargoCompany sınıfı
        CargoCompany cargoCompany = new CargoCompany();
        cargoCompany.add(boxMirror1);
        cargoCompany.add(boxMirror2);
        cargoCompany.add(boxPaper1);
        cargoCompany.add(boxPaper2);
        cargoCompany.add(boxMatroschka1);
        cargoCompany.add(boxMatroschka2);
    }       
}


interface Common<T>{
    boolean isEmpty();
    T peek();
    int size();
}

interface Node<T>{
   T getNext();
   double getPriority();
   void setNext(T item); 
   static final int DEFAULT_CAPACITY =2;
}

interface  Package<T>{
    T extract();
    double getPriority();
    boolean isEmpty();
    boolean pack(T item);
}

interface PriorityQueue<T> extends Common<T>{
    static final int FLEET_CAPACITY =3;
    T dequeue();
    boolean enqueue(T item);
}

interface Sellable{
    String getName();
    double getPrice();
}

interface Stack<T> extends Common<T>{
    T pop();
    boolean push(T item);
}

interface Wrappable extends Sellable{

    @Override
    default String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    default double getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }
    
}


class Box<T extends Sellable> extends Object implements Package<T>{
    private int distanceToAddress;
    private T item;
    private boolean seal;

    public Box() {
        this.distanceToAddress = 0;
        this.item = null;
        this.seal = false;
    }

    public Box(int disstanceToAddress, T item) {
        this.distanceToAddress = disstanceToAddress;
        this.item = item;
        this.seal = true;
    }

    @Override
    public T extract(){
        if(!seal||isEmpty()){
            return null;
        }
        T extractedItem = item;
        item = null;
        seal = false;
        return extractedItem;
    }

    // public boolean isEmpty(){
    //     if(seal==false || isEmpty()){
    //         return true;
    //     }
    //     return false;
    // }

    @Override
    public boolean isEmpty() {
        return seal == false || item == null;
    }

    @Override
    public boolean pack(T item){
        if (!isEmpty()) return false;
    this.item = item;
    seal = true;
    return true;
    }


    boolean isSealBroken(){
        return !seal;
    }

    @Override
    public double getPriority() {
        if (isEmpty()) {
            return 0;}
    return item.getPrice() / (double) distanceToAddress;
    }

    @Override
    public String toString() {
        return "Box [distanceToAddress=" + distanceToAddress + ", item=" + item + ", seal=" + seal + "]";
    }

    
}


class CargoCompany extends Object{
    private CargoFleet queue;
    private Container stack;

    CargoCompany(){
        this.stack = new Container();
        this.queue = new CargoFleet();
    }

    public <T extends Box<?>> void add(T box){
        if(!stack.push(box)){
            if(!queue.enqueue(stack)){
                ship(queue);
                queue.enqueue(stack);
            }
            stack = new Container();
            stack.push(box);
        }
    }

    public void ship(CargoFleet fleet){
        while(!fleet.isEmpty()){
            empty(fleet.dequeue());
        }
    }

    public void empty(Container container){
        while (!container.isEmpty()) {
            deliver(container.pop());
        }
    }

    private <T extends Box<?>> Sellable deliver(T box) {
        return box.extract();
    }
}
