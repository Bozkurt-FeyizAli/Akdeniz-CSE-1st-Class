
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

