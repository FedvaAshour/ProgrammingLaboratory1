
package week8;
import java.util.ArrayList;

public class Team {

    private ArrayList<GameCharacter> characters;

    public Team() {
        characters = new ArrayList<>();
    }

    // Add character
    public void addCharacter(GameCharacter character) {

        if (character == null) {
            return;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Duplicate name! Character not added.");
            return;
        }

        characters.add(character);
    }

    // Remove character
    public boolean removeCharacter(String name) {

        GameCharacter character = findByName(name);

        if (character != null) {
            characters.remove(character);
            return true;
        }

        return false;
    }

    // Find character
    public GameCharacter findByName(String name) {

        for (GameCharacter c : characters) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    // Attack all
    public void attackAll(GameCharacter target) {

        if (target == null || !target.isAlive()) {
            return;
        }

        for (GameCharacter c : characters) {

            if (c.isAlive() && c instanceof Attacker) {

                Attacker attacker = (Attacker) c;

                int damage = attacker.attack(target);

                System.out.println(c.getName()
                        + " dealt " + damage + " damage.");
            }

            if (!target.isAlive()) {
                break;
            }
        }
    }

    // Heal team member with lowest health ratio
    public void healTeam() {

        GameCharacter weakest = null;
        double lowestRatio = Double.MAX_VALUE;

        for (GameCharacter c : characters) {

            if (c.isAlive()) {

                double ratio = (double) c.getHealth()
                        / c.getMaxHealth();

                if (ratio < lowestRatio) {
                    lowestRatio = ratio;
                    weakest = c;
                }
            }
        }

        if (weakest == null) {
            return;
        }

        for (GameCharacter c : characters) {

            if (c.isAlive() && c instanceof Supporter) {

                Supporter supporter = (Supporter) c;

                int restored = supporter.heal(weakest);

                System.out.println(c.getName()
                        + " restored " + restored
                        + " HP to " + weakest.getName());
            }
        }
    }

    // Total power
    public int getTotalPower() {

        int total = 0;

        for (GameCharacter c : characters) {

            if (c.isAlive()) {
                total += c.calculatePower();
            }
        }

        return total;
    }

    // Display team
    public void displayTeam() {

        System.out.println("\n===== TEAM MEMBERS =====");

        for (GameCharacter c : characters) {
            System.out.println(c.getCharacterInfo());
        }

        System.out.println("Total Team Power: " + getTotalPower());
    }
}
