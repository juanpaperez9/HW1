import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Testing {

    @Test
    public void testAddWeapon() {
        WeaponDatabase weaponDB = new WeaponDatabase();
        weaponDB.addWeapon("sword", 10);
        weaponDB.addWeapon("axe", 15);
        assertEquals(10, weaponDB.getWeaponStrength("sword"));
        assertEquals(15, weaponDB.getWeaponStrength("axe"));

    }
    @Test
    public void testGetWeaponStrength() {
        WeaponDatabase weaponDB = new WeaponDatabase();
        weaponDB.addWeapon("sword", 10);
        weaponDB.addWeapon("axe", 15);
        assertEquals(10, weaponDB.getWeaponStrength("sword"));
        assertEquals(15, weaponDB.getWeaponStrength("axe"));
        assertEquals(-1, weaponDB.getWeaponStrength("bow")); // Non-existent weapon
    }
    @Test
    public void testGetWeaponStrengthNonexistent() {
        WeaponDatabase weaponDB = new WeaponDatabase();
        assertEquals(-1, weaponDB.getWeaponStrength("nonexistent")); // Non-existent weapon
    }
    @Test
    public void testListAllWeapons() {
        WeaponDatabase weaponDB = new WeaponDatabase();
        weaponDB.addWeapon("sword", 10);
        weaponDB.addWeapon("axe", 15);
        weaponDB.addWeapon("bow", 8);

        // Redirect output stream to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        weaponDB.listAllWeapons();

        // Restore original output stream
        System.setOut(System.out);

        String expectedOutput = "List of all weapons in the database:\n" +
                                "sword: 10\n" +
                                "axe: 15\n" +
                                "bow: 8\n";
        String actualOutput = outputStream.toString();
        
        // Split the strings into lists of lines
        ArrayList<String> expectedLines = new ArrayList<>(Arrays.asList(expectedOutput.split("\\r?\\n")));
        ArrayList<String> actualLines = new ArrayList<>(Arrays.asList(actualOutput.split("\\r?\\n")));
        
        // Sort the lists to make order irrelevant
        Collections.sort(expectedLines);
        Collections.sort(actualLines);
        
        // Compare the sorted lists
        assertEquals(expectedLines, actualLines);
    }
    
    }


