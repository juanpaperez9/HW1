import java.util.HashMap;
import java.util.Map;

public class WeaponDatabase {
    private HashMap<String, Integer> weaponStrengths;

    public WeaponDatabase() {
        weaponStrengths = new HashMap<>();        
    }

    public void addWeapon(String name, int strength) {
        weaponStrengths.put(name, strength);
    }

    public int getWeaponStrength(String name) {
        return weaponStrengths.getOrDefault(name, -1); // Return -1 if weapon not found
    }

    public void listAllWeapons() {
        System.out.println("List of all weapons in the database:");
        for (Map.Entry<String, Integer> entry : weaponStrengths.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
