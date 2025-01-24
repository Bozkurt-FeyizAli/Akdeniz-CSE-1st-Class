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
