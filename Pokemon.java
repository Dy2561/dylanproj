import java.util.Random;

public class Pokemon {
    String name;
    String type;
    int maxHP;
    int currentHP;
    int attack;
    int defense;
    int speed;
    Move[] moves;
    String statusEffect = "none";
    int sleepCounter = 0;
    Random random = new Random();

    public Pokemon(String name, String type, int maxHP, int attack, int defense, int speed, Move[] moves) {
        this.name = name;
        this.type = type;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = moves;
    }

    public boolean isFainted() {
        return currentHP <= 0;
    }

    public void takeDamage(int damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
    }

    public void applyStatusEffects() {
        if (statusEffect.equals("poison")) {
            int poisonDamage = maxHP / 10;
            takeDamage(poisonDamage);
            System.out.println(name + " is hurt by poison! Lost " + poisonDamage + " HP.");
        } else if (statusEffect.equals("sleep")) {
            if (sleepCounter > 0) {
                sleepCounter--;
                System.out.println(name + " is still asleep!");
            } else {
                statusEffect = "none";
                System.out.println(name + " woke up!");
            }
        }
    }

    public boolean canMove() {
        return !(statusEffect.equals("sleep") && sleepCounter > 0);
    }

    public void setStatus(String effect) {
        if (effect.equals("poison") && !statusEffect.equals("poison")) {
            statusEffect = "poison";
            System.out.println(name + " was poisoned!");
        } else if (effect.equals("sleep")) {
            statusEffect = "sleep";
            sleepCounter = 2 + random.nextInt(2); // 2-3 turns
            System.out.println(name + " fell asleep!");
        }
    }

    public String toString() {
        return name + " (" + type + ") HP: " + currentHP + "/" + maxHP +
            (statusEffect.equals("none") ? "" : " [" + statusEffect + "]");
    }
}
