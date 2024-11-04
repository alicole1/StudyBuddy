// Import the HashMap class
import java.util.HashMap;

public class App {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    // System.out.println(capitalCities);

    // System.out.println(capitalCities.get("England"));
    // System.out.println(capitalCities.get("London"));
    // System.out.println(capitalCities.size());

    // Print keys
    /*
    for (String i : capitalCities.keySet()) {
    System.out.println(i);
    }
    */

    // Print values
    /*
    for (String i : capitalCities.values()) {
    System.out.println(i);
    }
    */

    // Print keys and values
    System.out.printf("%n%n%n   Terms           ||   Definitions %n======================================================== %n");
    for (String i : capitalCities.keySet()) {
    System.out.printf("   %-15s ||   %-50s %n", i ,capitalCities.get(i));
    }

    HashMap<String, Integer> map = new HashMap<>();
    map.put("key1", 1);
    map.put("key2", 2);
    System.out.println(map);


    // Edit a key
    String oldKey = "key1";
    String newKey = "newKey";
    if (map.containsKey(oldKey)) {
      int value = map.get(oldKey);
      map.remove(oldKey);
      map.put(newKey, value);
    }

    // Edit a value
    String key = "newKey";
    int newValue = 10;
    if (map.containsKey(key)) {
      map.put(key, newValue);
    }

    System.out.println(map);

  }
}
