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
  }
}
