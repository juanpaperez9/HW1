import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeaponDatabase weaponDB = new WeaponDatabase();
        Scanner scanner = new Scanner(System.in);

        // Example: Adding weapons
        weaponDB.addWeapon("sword", 10);
        weaponDB.addWeapon("axe", 15);
        weaponDB.addWeapon("bow", 8);
        weaponDB.addWeapon(("bomb"), 100);

        while (true) {
            System.out.print("Enter weapon name (type 'quit' to exit, 'list' to list all weapons): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                weaponDB.listAllWeapons();
            } else {
                int strength = weaponDB.getWeaponStrength(userInput);
                if (strength != -1) {
                    System.out.println("The strength of " + userInput + " is " + strength + ".");
                } else {
                    System.out.println("Weapon not found.");
                }
            }
        }
        scanner.close();
    }
}
