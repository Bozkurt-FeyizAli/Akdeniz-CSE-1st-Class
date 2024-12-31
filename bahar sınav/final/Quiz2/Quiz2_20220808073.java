
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Quiz2_20220808073 {
    public static void main(String[] args) {
        
    }
    
}

abstract class Product{
    private String modelNames;
    private double initialDurability;
    static final int durability=100;
    public Product(String modelNames, double initialDurability) {
        this.modelNames = modelNames;
        this.initialDurability = initialDurability;
    }
    public double getInitialDurability() {
        return initialDurability;
    }
    public String getModelNames() {
        return modelNames;
    }
    abstract double productLine();
    public void setInitialDurability(double initialDurability) {
        this.initialDurability = initialDurability;
    }
}

class GPU extends Product {
    private int VRAM;
    private double qualityScore;
    public GPU(String modelNames, double initialDurability, int vRAM, double qualityScore) {
        super(modelNames, initialDurability);
        VRAM = vRAM;
        this.qualityScore = qualityScore;
    } 
    public double getQualityScore() {
        return qualityScore;
    }
    public int getVRAM() {
        return VRAM;
    }
    @Override
    double  productLine() {
        return (VRAM+qualityScore)-durability;
    }
    public void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }
    public void setVRAM(int vRAM) {
        VRAM = vRAM;
    }
    
    
}

class CPU extends Product{
    private int VRAM;
    private double operatingFrequency;
    public CPU(String modelNames, double initialDurability, int vRAM, double operatingFrequency) {
        super(modelNames, initialDurability);
        VRAM = vRAM;
        this.operatingFrequency = operatingFrequency;
    } 
    public double getOperatingFrequency() {
        return operatingFrequency;
    }
    public int getVRAM() {
        return VRAM;
    }
    @Override
    double productLine() {
        return VRAM+operatingFrequency-durability;
        
    }
    public void setVRAM(int vRAM) {
        VRAM = vRAM;
    }
    public void setOperatingFrequency(double operatingFrequency) {
        this.operatingFrequency = operatingFrequency;
    }
    
}

abstract class Employee{
    private String nameTags;

    public Employee(String nameTags) {
        this.nameTags = nameTags;
    }
    public String getNameTags() {
        return nameTags;
    }
    
}

class Engineer extends Employee{
    private int levelOfExperience;

    public Engineer(String nameTags, int levelOfExperience) {
        super(nameTags);
        this.levelOfExperience = levelOfExperience;
    }
    public int getLevelOfExperience() {
        return levelOfExperience;
    }
    
}

class ChiefEngineer extends Engineer{
    private ArrayList<Engineer> engineers;
    ChiefEngineer(String nameTags, int levelOfExperience) {
        super(nameTags, levelOfExperience);
        engineers= new ArrayList<>();
    }
    public void addEngineers(Engineer engineer) {
        engineers.add(engineer);
    }
}

class QualityAssurance extends Engineer{
    private ArrayList<Product> products= new ArrayList<>();
    private Queue<Product> pOrders= new LinkedList<>();
    
    
    QualityAssurance(String nameTags, int levelOfExperience) {
        super(nameTags, levelOfExperience);
        
    }

    public void test(Product product){
        Random random= new Random();
        if(product instanceof GPU){
            ((GPU)product).setInitialDurability(random.nextInt(100));
            ((GPU)product).setVRAM(random.nextInt(100));
            
        }
        if(product instanceof CPU){
            ((CPU)product).setVRAM(random.nextInt(100));
            ((CPU)product).setOperatingFrequency(random.nextInt(100));
        }
        // product.productLine();
        products.add(product);
        // best product will be added
        
        pOrders.add(product);
        
    }
}
    
// assuarene güvence  exemine denetelemek eşik= treshold
class Customer{
    ArrayList<Product> products;
    public void order(Product product){
        products.add(product);

    }
}

class Facility{
    private ArrayList<Customer> customers= new ArrayList<>();
    private Queue<Product> products;
    private QualityAssurance qualityAssurance;
    private Map<Product, ArrayList<String>> orders;
    private String trend;
    
    public Facility(QualityAssurance qualityAssurance) {
        this.qualityAssurance=qualityAssurance;
        orders = new HashMap<>();
        products= new ConcurrentLinkedQueue<>();
    }

    public void order(Product product, Customer customer){
        orders.putIfAbsent(product, new ArrayList<>());
        orders.get(product).add(product.getModelNames());
        customers.add(customer);
        qualityAssurance.test(product);
        customer.order(product);
    }

