public class HW07_20220808073{
    public static void main(String[] args) {

        // Mirror m1= new Mirror(2, 3);
        // Box<Mirror> boxMirror1 = new Box<>();
        // boxMirror1.pack(m1);
        // System.out.println(boxMirror1.isEmpty());// Test Mirror sınıfı

    }
}

class Box<T extends Sellable> implements Package<T>{
    private int distanceToAddress;
    private T item;
    private boolean seal;

    public Box(int distanceToAddress, T item) {
        this.distanceToAddress = distanceToAddress; 
        pack(item);
    }
    public Box() {
    }
    public T extract(){
        if(isEmpty())
            return null;
        T newItem=this.item;
        this.item=null;
        seal=false;
        return newItem;
    }
    public boolean pack(T item){
        if(isEmpty()){
            seal=true; // i added
            this.item=item;
            return true;
        }
        return false;
    }
    public boolean isSealBroken(){
        return !seal;
    }
    public double getPriority(){
        if(distanceToAddress!=0&&!isEmpty())
            return item.getPrice()/distanceToAddress;
        return 0;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" + 
        item +" with distance to Adress: "+distanceToAddress + " } Seal: "+seal;
    }
    @Override
    public boolean isEmpty() {
        return item==null;
    }
}
class CargoCompany{
    private CargoFleet queue;
    private Container stack;
    CargoCompany(){
        stack= new Container();
        queue= new CargoFleet();
    }
    public <T extends Box<?>> void add(T box){
        if(!queue.isEmpty())
            ship(queue);
        if(!stack.isEmpty())
            queue.enqueue(stack);
        stack.push(box);
    }
    private void ship(CargoFleet fleet){
        while (!fleet.isEmpty()) {
            empty(fleet.dequeue());
        }
        
    }
    private void empty(Container container){
        while(!container.isEmpty()){
            // System.out.println(container.pop()); // i added
            deliver(container.pop());    
        }
    }
    private <T extends Box<?>> Sellable deliver(T box){
        if(box==null)
        return null;
        // System.out.println("delivered "+box);// i added
        return box.extract();
    }
}
class CargoFleet implements PriorityQueue<Container> {
    private Container head;
    private int size;
    public CargoFleet(){
    }
    @Override
    public boolean isEmpty() {
        return head==null;
    }
    
    @Override
    public Container peek() {
        return head;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean enqueue(Container item) {
        if(size==FLEET_CAPACITY)
            return false;
        if(isEmpty()){
            head=item;
        }
        else{
            Container cHead=this.head;
            Container cTail=null;
            while(cHead.getNext()!=null&&cHead.compareTo(item)<0){
                cTail=cHead;
                cHead=cHead.getNext();
            }
            if(cTail==null){
                item.setNext(cHead);
                this.head=item;
            }
            else{
                cTail.setNext(item);
                item.setNext(cHead);
            }
            // while(container.getNext()!=null&&item.compareTo(container)<0)
            //     container=container.getNext();
            // item.setNext(container.getNext());
            // container.setNext(item);    
        }
        size++;
        return true;
    }
    @Override
    public Container dequeue() {
        if(isEmpty())
            return null;
        Container container=head;
        head=head.getNext();
        size--;
        return container;
    }
    
}
class Container implements Stack<Box<?>>, Node<Container>, 
                                          Comparable<Container>{
    private Box<?>[] boxes;
    private Container next;
    private double priority;
    private int size;
    private int top;
    public Container() {
        boxes=new Box<?>[DEFAULT_CAPACITY];
    }
    @Override
    public String toString() {
        return "CargoCompany [priority=" + priority + "]";
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public Box<?> peek(){
        if(isEmpty())
        return null;
        return boxes[top];
    }
    @Override
    public Box<?> pop(){
        if(isEmpty())
            return null;
        if(boxes[top-1]==null)
            return null;
        Box<?> newItem=boxes[top-1];
        priority-=boxes[top-1].getPriority();
        boxes[top-1]=null;
        top--;
        size--;
        return newItem; 
    }
    @Override
    public void setNext(Container item){
        this.next=item;
    }
    @Override
    public Container getNext() {
        return next;
    }
    @Override
    public double getPriority() {
        return priority;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public int compareTo(Container o) {
        return (int)(this.priority-o.getPriority());
    }
    @Override
    public boolean push(Box<?> item) {
        if(top==DEFAULT_CAPACITY)
            return false;
        boxes[top]=item;
        top++;
        size++;
        priority+=item.getPriority();
        return true;
    }

}
class Matroschka <T extends Wrappable> extends Product
                    implements Wrappable, Package<T>{
    private T item;
    Matroschka(T item){
        super("Doll", 5+(item==null? 0: item.getPrice()));
        pack(item);
    }
    public T extract(){
        T newItem=this.item;
        this.item=null;
        return newItem;
    }
    public double getPriority() throws UnsupportedOperationException{
        throw new UnsupportedOperationException
        ("UnsupportedOperationException - "+
        "because getting the priority is not implemented");
    }
    @Override
    public String toString() {
        return super.toString() + "{" + item + "]"; 
    }
    public boolean pack(T item){
        if(!isEmpty())
            return false;
        this.item=item;
        return true;
    }
    public boolean isEmpty(){
        return this.item==null;
    }
    
}
class Mirror extends Product{
    private int height;
    private int width;
    Mirror(int width, int height){
        super("mirror",2);
        this.height = height;
        this.width = width;
    }
    public int getArea(){
        return width*height;
    }
    public double getPrice(){
        return getArea()*super.getPrice();
    }
    public <T>T reflect(T item){
        System.out.println(item);
        return item;
    }

}
class Paper extends Product implements Wrappable{
    private String note;
    public Paper() {
        super("Paper", 0.5);
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
abstract class Product implements Sellable{
    private String name;
    private double price;
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" 
        + name + ", " + getPrice() + ")";
    }
    
    
}
interface Common<T>{
    boolean isEmpty();
    T peek();
    int size();
}
interface Node<T>{
    int DEFAULT_CAPACITY=2;
    T getNext();
    double getPriority();
    void setNext(T item);
}
interface Package<T>{
    T extract();
    double getPriority();
    boolean isEmpty();
    boolean pack(T item);
}
interface PriorityQueue<T> extends Common<T>{
    int FLEET_CAPACITY=3;
    T dequeue();
    boolean enqueue(T item);    
}
interface Stack<T> extends Common<T>{
    T pop();
    boolean push(T item);
}
interface Wrappable extends Sellable{

}
interface Sellable{
    String getName();
    double getPrice();
}
