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
