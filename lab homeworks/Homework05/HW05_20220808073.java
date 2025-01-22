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

abstract class Character implements Comparable<Character>, Damageable {
    private String name;
    protected int level;
    protected Attributes attributes;
    protected int health;

    Character(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    abstract void levelUp();

    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.level, other.level);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
               + " LvL: " + level + " – " + attributes;
    }
}

abstract class PlayableCharacter  extends Character {
    boolean inParty;
    Party party;

    PlayableCharacter(String name, Attributes attributes)
                          throws AlreadyInPartyException{
        super(name, attributes);
    }
    /// differ from pdf
    public boolean isInParty(){
        return inParty;
    }
    public void levelUp(){
        level+=1;
    }
    // unfinished
    public void joinParty(Party party) 
    throws AlreadyInPartyException , PartyLimitReachedException{
        if(isInParty())
            throw new AlreadyInPartyException("the error message");
        else{
            try {
                party.addCharacter(this);
            } catch (PartyLimitReachedException  e) {
                throw new 
                PartyLimitReachedException("the error message"); 
            }
        } 
    }
    public void quitParty() throws CharacterIsNotInPartyException{
        if(isInParty()){
            try {
                party.removeCharacter(this);
                inParty=false;
                party=null;
            } catch (CharacterIsNotInPartyException e) {
                throw new CharacterIsNotInPartyException
                ("the error message");
            }
        }
        else{
            throw new CharacterIsNotInPartyException
            ("the error message");
        }
    }
}

abstract class NonPlayableCharacter  extends Character{

    NonPlayableCharacter(String name, Attributes attributes) {
        super(name, attributes);
    }
    
}

class Merchant extends NonPlayableCharacter{
    private java.util.ArrayList<Useable> inventory;    
    // have problem
    

    Merchant(String name) {
        super(name, new Attributes(0,0));
        inventory=new ArrayList<>();
    }

    public void display(){
        for (Useable useable : inventory) {
            System.out.println(useable);
        }
    }
    public Useable buy(int itemNumber)throws ItemNotFoundException{
        try {
            return inventory.get(itemNumber);
        }catch (IndexOutOfBoundsException e) {
            throw new ItemNotFoundException("the error message");
        }
    }
    public void sell(Useable item){
        if(isAlive())
        inventory.add(item);
    }
    
    @Override
    public int compareTo(Character character){
        return super.compareTo(character);
    }

    @Override
    public void takeDamage(int damage) {
        if(isAlive())
        health-=damage;
    }

    @Override
    public void takeHealing(int healing) {
        if(isAlive())
        health+=healing;
    }

    @Override
    public boolean isAlive() {
        return health>0;
    }

    @Override
    public void levelUp() {
    }
}

class Skeleton extends NonPlayableCharacter implements Combat{

    Skeleton(String name, Attributes attributes) {
        super(name, attributes);
        
    }
    
    @Override
    public void takeDamage(int damage) {
        if(isAlive())
        health-=damage;
    }

    @Override
    public void takeHealing(int healing) {
        if(isAlive())
        takeDamage(healing);
    }

    @Override
    public boolean isAlive() {
        return health>0; 
    }
    @Override
    public void attack(Damageable target) {
        if(isAlive())
        target.takeDamage(super.attributes.getStrength());
    }

    @Override
    public void lootWeapon(Weapon weapon) {
    }
    @Override
    public void levelUp() {
        if(isAlive()){
        level+=1;
        attributes.increaseIntelligence(1);
        attributes.increaseStrength(1);
        }
    }

}

class Warrior extends PlayableCharacter implements Combat{
    private Useable weapon;

    Warrior(String name) throws AlreadyInPartyException {
        super(name, new Attributes(4,2));
        health=35;
    }

    @Override
    public void takeDamage(int damage) {
        if(isAlive())
        health-=damage;
    }
    @Override
    public void takeHealing(int healing) {
        if(isAlive())
        healing+=healing;
    }
    @Override
    public boolean isAlive() {
        return health>0;
    }
    @Override
    public int compareTo(Character c) {
        return super.compareTo(c);
    }

    @Override
    public void attack(Damageable target) {
        if(isAlive())
        target.takeDamage(weapon.use());
    }

    @Override
    public void lootWeapon(Weapon weapon) {
        if(isAlive())
        this.weapon=weapon;
    }
    @Override
    public void levelUp(){
        if(isAlive()){
        super.levelUp();
        attributes.increaseIntelligence(1);
        attributes.increaseStrength(2);
        }
    }
    
}

class Cleric extends PlayableCharacter implements Caster{
    private Useable spell;

    Cleric(String name) throws AlreadyInPartyException {
        super(name, new Attributes(4,2));
        health=25;
    }

    @Override
    public int compareTo(Character c) {
        return super.compareTo(c);
    }

    @Override
    public void takeDamage(int damage) {
        if(isAlive())
        health-=damage;
    }

    @Override
    public void takeHealing(int healing) {
        if(isAlive())
        health+=healing;
    }

    @Override
    public boolean isAlive() {
       return health>0;
    }
    // anlamadım
    @Override
    public void castSpell(Damageable target) {
        int healing = attributes.getIntelligence() + ((Spell) spell).use();
        if(isAlive())
        target.takeHealing(healing);
    }

    @Override
    public void learnSpell(Spell spell) {
        this.spell = spell;
    }
    @Override
    public void levelUp(){
        if(isAlive()){
        super.levelUp();
        attributes.increaseIntelligence(2);
        attributes.increaseStrength(1);
        }
    }
    
}

class Paladin extends PlayableCharacter implements Caster , Combat{
    private Useable weapon;
    private Useable spell;

    Paladin(String name) throws AlreadyInPartyException {
        super(name, new Attributes());
        health=30;
    }

    @Override
    public void takeDamage(int damage) {
        if(isAlive())
        health-=damage;
    }
    @Override
    public void takeHealing(int healing) {
        if(isAlive())
        health+=healing;
    }

    @Override
    public boolean isAlive() {
        return health>0;
    }

    @Override
    public int compareTo(Character c) {
        return super.compareTo(c);
    }

    @Override
    public void attack(Damageable target) {
        if(isAlive())
        target.takeDamage(weapon.use());
    }

    @Override
    public void lootWeapon(Weapon weapon) {
        if(isAlive())
        this.weapon=weapon;
    }

    @Override
    public void castSpell(Damageable target) {
        int healing = attributes.getIntelligence() + ((Spell) spell).use();
        if(isAlive())
        target.takeHealing(healing);
    }

    @Override
    public void learnSpell(Spell spell) {
        if(isAlive())
        this.spell = spell;
    }
    @Override
    public void levelUp(){
        if(isAlive()){
        if(getLevel()/2==0){
            attributes.increaseIntelligence(1);
            attributes.increaseStrength(2);
        }
        else{
            attributes.increaseIntelligence(2);
            attributes.increaseStrength(1);
        }
        super.levelUp();
    }
    }
    
}

class Party {
    private static final int partyLimit = 8;
    private ArrayList<PlayableCharacter> fighters;
    private ArrayList<PlayableCharacter> healers;
    private int counter;

    public Party() {
        this.fighters = new ArrayList<>();
        this.healers = new ArrayList<>();
        this.counter = 0;
    }

    public void addCharacter(PlayableCharacter character) 
    throws PartyLimitReachedException {
        if (fighters.size() + healers.size() >= partyLimit) {
            throw new PartyLimitReachedException
            ("the error message:Party limit reached"+
            ". Cannot add more characters.");
        }
        if (character instanceof Warrior) {
            fighters.add((Warrior) character);
        } else if (character instanceof Cleric) {
            healers.add((Cleric) character);
        } else if (character instanceof Paladin) {
            if (counter < 4) {
                fighters.add((Paladin) character);
            } else {
                healers.add((Paladin) character);
            }
            counter++;
        }
    }

    public void removeCharacter(PlayableCharacter character)
     throws CharacterIsNotInPartyException {
        if (character instanceof Warrior) {
            if (!fighters.remove((Warrior) character)) {
                throw new CharacterIsNotInPartyException
                ("the error message: Warrior is not in the party.");
            }
        } else if (character instanceof Cleric) {
            if (!healers.remove((Cleric) character)) {
                throw new CharacterIsNotInPartyException
                ("the error message:Cleric is not in the party.");
            }
        } else if (character instanceof Paladin) {
            if (fighters.remove((Paladin) character)||
                healers.remove((Paladin) character)) {
                counter--;
            } else {
                throw new CharacterIsNotInPartyException
                ("the error message:Paladin is not in the party.");
            }
        }
    }
    public void partyLevelUp(){
        for(int i=0;i<fighters.size();i++){
            fighters.get(i).levelUp();
        }
        for(int i=0;i<healers.size();i++){
           if(!(healers.get(i) instanceof Paladin))
            healers.get(i).levelUp();
        }
    }
    @Override
    public String toString() {
        List<Character> characters = new ArrayList<>();
        characters.addAll(fighters);
        characters.addAll(healers);
        characters.sort(Comparable::compareTo);
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character).append("\n");
        }
        return sb.toString();
    }
}
class AlreadyInPartyException extends Exception{
    AlreadyInPartyException(String message){
        super(message);
    }

}
class CharacterIsNotInPartyException extends Exception{
    CharacterIsNotInPartyException(String message){
        super(message);
    }
}

class ItemNotFoundException extends Exception{
    ItemNotFoundException(String message){
        super(message);
    }
}

class PartyLimitReachedException extends Exception{
    PartyLimitReachedException(String message){
        super(message);
    }
}
// class MissingFormatArgumentException {

// }






