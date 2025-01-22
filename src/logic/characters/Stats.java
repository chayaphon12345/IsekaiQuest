package logic.characters;

/**
 * This class is used to store the stats of a character.
 */
public class Stats implements Cloneable {
    private int MAX_HP;
    private int health;
    private int attack;
    private int defense;
    private int magic;
    private int magicDef;
    private int lure;
    private int accuracy;
    private int evade;

    public Stats(int health, int attack, int defense, int magic, int magicDef, int lure, int accuracy, int evade) {
        this.MAX_HP = health;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.magicDef = magicDef;
        this.lure = lure;
        this.accuracy = accuracy;
        this.evade = evade;
    }

    @Override
    public Stats clone() {
        try {
            Stats stats = (Stats) super.clone();
            return new Stats(health, attack, defense, magic, magicDef, lure, accuracy, evade);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) health = 0;
        else if(health > MAX_HP) health = MAX_HP;
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) attack = 0;
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense < 0) defense = 0;
        this.defense = defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        if (magic < 0) magic = 0;
        this.magic = magic;
    }

    public int getMagicDef() {
        return magicDef;
    }

    public void setMagicDef(int magicDef) {
        if (magicDef < 0) magicDef = 0;
        this.magicDef = magicDef;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public void setMAX_HP(int MAX_HP) {
        if (MAX_HP < 0) MAX_HP = 0;
        this.MAX_HP = MAX_HP;
    }

    public int getLure() {
        return lure;
    }

    public void setLure(int lure) {
        if (lure < 0) lure = 0;
        this.lure = lure;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        if (accuracy < 0) accuracy = 0;
        this.accuracy = accuracy;
    }

    public int getEvade() {
        return evade;
    }

    public void setEvade(int evade) {
        if (evade < 0) evade = 0;
        this.evade = evade;
    }
}
