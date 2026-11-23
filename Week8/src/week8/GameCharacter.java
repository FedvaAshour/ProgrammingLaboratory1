
package week8;

public abstract class GameCharacter {

    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;

        if (level < 1 || level > 100) {
            System.out.println("Invalid level! Setting level to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth <= 0) {
            System.out.println("Invalid maxHealth! Setting it to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int takeDamage(int damage) {
        if (damage <= 0 || !isAlive()) {
            return 0;
        }

        int actualDamage = Math.min(damage, health);
        health -= actualDamage;

        return actualDamage;
    }

    public int restoreHealth(int amount) {
        if (amount <= 0 || !isAlive()) {
            return 0;
        }

        int actualRestore = Math.min(amount, maxHealth - health);
        health += actualRestore;

        return actualRestore;
    }

    public abstract String getCharacterInfo();

    public abstract int calculatePower();
}
