import java.util.ArrayList;
import java.util.List;

public class HW05_20220808073{
    public static void main(String[] args) {
            }
        }
      


interface Damageable{
    void takeDamage(int damage);
    void takeHealing(int healing);
    boolean isAlive();
}

interface Caster{
    void castSpell(Damageable target);
    void learnSpell(Spell spell);
}

interface Combat extends Damageable{
    void attack(Damageable target);
    void lootWeapon(Weapon weapon);
}

interface Useable{
    int use();
}
// spell=büyü
class Spell implements Useable{
    private int minHeal;
    private int maxHeal;
    private String name;

    Spell(String name, int minHeal, int maxHeal){
        this.maxHeal=maxHeal;
        this.minHeal=minHeal;
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int use() {
        return heal();
    }
    private int heal(){
        return minHeal +(int)((maxHeal+1)*Math.random());
    }

}

class Weapon implements Useable{
    private int minDamage;
    private int maxDamage;
    private String name;
    
    Weapon(String name, int minDamage, int maxDamage){
        setName(name);
        this.maxDamage=maxDamage;
        this.minDamage=minDamage;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public int use() {
        return attack();
    }
    private int attack(){
        return minDamage +(int)((maxDamage+1)*Math.random());
    }
}

class Attributes{
    private int strength;
    private int intelligence;
    
    Attributes(){
        this.strength=3;
        this.intelligence=3;
    }
    Attributes(int strength, int intelligence){
        this.intelligence=intelligence;
        this.strength=strength;
    }

    public void increaseStrength(int amount){
        this.strength+=amount;
    }
    public void increaseIntelligence(int amount){
        this.intelligence+=amount;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public int getStrength() {
        return strength;
    }
    @Override
    public String toString(){
        return String.format("Attributes [Strength= " + strength +
                             ", intelligence= " + intelligence +
                             "]", strength, intelligence);
    }
}
