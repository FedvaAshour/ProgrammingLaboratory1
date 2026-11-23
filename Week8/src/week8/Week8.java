
package week8;
public class Week8 {

    public static void main(String[] args) {

        Team team = new Team();

        // Create team members
        Warrior warrior = new Warrior("Thor", 10, 200, 20);

        Mage mage = new Mage("Merlin", 15, 120, 100);

        Healer healer = new Healer("Angel", 12, 150, 30);

        // Create enemy
        Warrior enemy = new Warrior("Golem", 20, 500, 10);

        // Add characters
        team.addCharacter(warrior);
        team.addCharacter(mage);
        team.addCharacter(healer);

        // Test duplicate name
        team.addCharacter(
                new Mage("Thor", 5, 100, 50)
        );

        // Test invalid level
        Warrior invalid = new Warrior("Invalid", 150, 100, 10);
        team.addCharacter(invalid);

        // Display initial team
        team.displayTeam();

        // Battle Round 1
        System.out.println("\n===== ROUND 1 =====");

        team.attackAll(enemy);

        System.out.println("Golem Health: " + enemy.getHealth());

        int enemyDamage = enemy.attack(warrior);

        System.out.println("Golem attacked Thor: "
                + enemyDamage + " damage.");

        team.healTeam();

        // Battle Round 2
        System.out.println("\n===== ROUND 2 =====");

        team.attackAll(enemy);

        System.out.println("Golem Health: " + enemy.getHealth());

        enemyDamage = enemy.attack(mage);

        System.out.println("Golem attacked Merlin: "
                + enemyDamage + " damage.");

        team.healTeam();

        // Remove character
        System.out.println("\n===== REMOVE =====");

        team.removeCharacter("Thor");

        // Search character
        System.out.println("\n===== SEARCH =====");

        GameCharacter found = team.findByName("Merlin");

        if (found != null) {
            System.out.println("Character found: "
                    + found.getCharacterInfo());
        } else {
            System.out.println("Character not found.");
        }

        // Final team
        team.displayTeam();
    }
}


