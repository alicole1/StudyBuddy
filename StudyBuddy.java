// Import Java Scanner.
import java.util.Scanner;
// Import the HashMap class.
import java.util.HashMap;


// MAIN LOOP
public class StudyBuddy {
    public static void main(String[] args) {
        // Import new scanner object.
        Scanner scan = new Scanner(System.in);
        // Import new study set (from study set class defined above).
        StudySetEditor studySet = new StudySetEditor();

        // String[] studySetNames = studySet.returnStudySetNames();
        // HashMap[] studySetHashMaps = studySet.returnstudySetHashMaps();

        // Welcome message.
        System.out.printf("%n%n%n     STUDY BUDDY %n");
        System.out.println("Hello and welcome to Study Buddy. We are so excited to have you!");
        System.out.println("This is your homepage. Use the following commands to navigate:");

        do {
            System.out.println("1: View current sets   || 2: Quit program ");
            System.out.print("Input: ");
            int intUserChoice = scan.nextInt();

            if (intUserChoice == 1) {
                studySet.viewStudySets();
                System.out.printf("%n Use the following commands to move around from here: %n");
                System.out.println("1: Create new study set. || 2: Edit study set. || 3: Select a study set to study: || 4: Return to home.");
                System.out.print("Input: ");
                intUserChoice = scan.nextInt();
                if (intUserChoice == 1) {
                    studySet.pickStudySet();
                    studySet.nameStudySet();
                    addingTerms:
                    do {
                        System.out.print("Type v to view current set, s to enter terms, or q to quit entering terms: ");
                        String stringInput = scan.nextLine().toLowerCase();
                        if (stringInput.equals("v")) {
                            studySet.viewCurrentStudySet();
                        } else if (stringInput.equals("s")) {
                            studySet.enterTerm();
                        } else if (stringInput.equals("q")) {
                            break addingTerms;
                        } else {
                            System.err.printf("%nPlease only enter v, s, or q%n");
                        }
                    } while (true);
                } else if (intUserChoice == 2) {
                    return;
                } else {
                    System.err.println("Please enter one of the following commands:");
                }
            }
        } while (true);
    }
}

// STUDY SET EDITOR CLASS
class StudySetEditor {
    // Create scanner object "scan".
    Scanner scan = new Scanner(System.in);
    
    String input = ""; // user input.

    // Create all accessible study sets.
    HashMap<String, String> studySetArray1 = new HashMap<String, String>();
    HashMap<String, String> studySetArray2 = new HashMap<String, String>();
    HashMap<String, String> studySetArray3 = new HashMap<String, String>();
    HashMap<String, String> studySetArray4 = new HashMap<String, String>();
    HashMap<String, String> studySetArray5 = new HashMap<String, String>();
    HashMap<String, String> studySetArray6 = new HashMap<String, String>();
    HashMap<String, String> studySetArray7 = new HashMap<String, String>();
    HashMap<String, String> studySetArray8 = new HashMap<String, String>();
    HashMap<String, String> studySetArray9 = new HashMap<String, String>();
    HashMap<String, String> studySetArray10 = new HashMap<String, String>();

    // Put all study sets in an array.
    HashMap[] studySetHashMaps = new HashMap[] {
        studySetArray1, 
        studySetArray2, 
        studySetArray3, 
        studySetArray4, 
        studySetArray5,
        studySetArray6,
        studySetArray7,
        studySetArray8,
        studySetArray9,
        studySetArray10,
    };

    // Create all accessible study names.
    String studySetName1 = "Study Set 1";
    String studySetName2 = "Study Set 2";
    String studySetName3 = "Study Set 3";
    String studySetName4 = "Study Set 4";
    String studySetName5 = "Study Set 5";
    String studySetName6 = "Study Set 6";
    String studySetName7 = "Study Set 7";
    String studySetName8 = "Study Set 8";
    String studySetName9 = "Study Set 9";
    String studySetName10 = "Study Set 10";

    String[] studySetNames = new String[] {
        studySetName1, 
        studySetName2,
        studySetName3,
        studySetName4,
        studySetName5,
        studySetName6,
        studySetName7,
        studySetName8,
        studySetName9,
        studySetName10,
    };

    HashMap<String, String> currentHashMap;
    String currentSetName;
    int locationOfCurrentSet;

    // VIEW STUDY SETS
    public void viewStudySets() {
        System.out.printf("%nCurrent Study Sets: %n");
        for (int i = 0; i<studySetNames.length; i++) {
            String setName = studySetNames[i];
            if (! setName.equals("Study Set " + (i+1))) {
                System.out.println((i+1) + ":" + studySetNames[i]);
            } else {
                System.out.println((i+1) + ":");
            }
        }
    }

    // PICK STUDY SET
    public void pickStudySet() {
        System.out.print("Which study set would you like to edit? ");
        int locationOfCurrentSet = scan.nextInt() - 1;
        currentHashMap = studySetHashMaps[locationOfCurrentSet];
        currentSetName = studySetNames[locationOfCurrentSet];
    }

    // RENAME STUDY SET
    // Create function to change variable studySetName.
    public void nameStudySet() {
        // Get info from user on what they want new name to be.
        do {
            System.out.print("Name your study set: ");
            String currentSetName = scan.nextLine();
            if (currentSetName.equals(studySetNames[locationOfCurrentSet])) {
                System.err.println("Oops! Sorry. For technical reasons, you cannot name you study set that. Try another name!");
            } else {
                confirmAnswer:
                do {
                    // Get info from user.
                    System.out.print("You named your study set " + currentSetName + ". Is this correct? (y/n) ");
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("y")) { // If user entered y (yes)...
                        studySetNames[locationOfCurrentSet] = currentSetName;
                        return; // Break out of whole function.
                    } else if (input.equals("n")) { // If user entered n (no)...
                        break confirmAnswer; // Break out of confirmation loop, returns to "Rename your study set".
                    } else { // If user enters anything other than y or n...
                        System.err.println("please enter either y or n"); // Sends message to user to tell them to input correct variables, stays in confirmation loop.
                    }
                } while (true);
            }
        } while (true);
    }

    // ADD TERMS AND DEFINITIONS
    // Create function to allow user to add new terms and definitons.
    public void enterTerm() {
        System.out.println("If at any point you would like to quit entering terms, type q instead of the term."); // Communicates to user basic commands.
        collectTermAndDef:
        do {
            // Collect info from user for the term they want.
            System.out.print("Enter term: "); 
            String term = scan.nextLine();

            // Loop to allow user to break out of function if they type q.
            if (term.toLowerCase().equals("q")) {
                // q on its own could be a term. Just to check, confirm with user.
                confirm:
                do {
                    // Get info from user. 
                    System.out.print("Are you sure you want to quit entering terms? (y/n)"); 
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("y")) { // If user says y (yes), they do want to quit...
                        break collectTermAndDef; // Break out of function.
                    } else if (input.equals("n")) { // If user says n (no), they don't want to quit...
                        break confirm; // Break out of confirm method. Continue entering terms and definitions. Q or q remains the value for term.
                    } else { // If user says anything other than y or n...
                        System.err.println("Please enter either y or n"); // Sends message to user to tell them to input correct variables, remains in confirm method.
                    }
                } while (true);
            }

            // Collect info from user for the defintion they want.
            System.out.print("Enter definition: ");
            String definition = scan.nextLine();

            // Input term and definition to array.
            currentHashMap.put(term, definition);
        } while (true);
        studySetHashMaps[locationOfCurrentSet] = currentHashMap;
        return;
    }

    // VIEW CURRENT SET
    // Create function to allow user to view current set.
    public void viewCurrentStudySet() {
        System.out.printf("%n%n   Study Set name: %S %n%n", studySetNames[locationOfCurrentSet]); // Returns twice, prints study set name in caps, returns twice.
        System.out.printf("   Terms           ||   Definitions %n======================================================== %n"); // Prints titles, returns, border, returns.
        // Loops through each term - definition pair in the array.
        for (String i : currentHashMap.keySet()) {
            System.out.printf("   %-15s ||   %-50s %n", i , currentHashMap.get(i));
        }
    }

    // ACCESS VARIABLES
    // Return variable studySetName.
    public String studySetName() {
        return studySetNames[locationOfCurrentSet];
    }

    // Return HashMap array studySetArray.
    public HashMap studySetArray() {
        return studySetHashMaps[locationOfCurrentSet];
    }

    public HashMap[] returnstudySetHashMaps() {
        return studySetHashMaps;
    }

    public String[] returnStudySetNames() {
        return studySetNames;
    }
}