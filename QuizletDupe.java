// Import Java Scanner
import java.util.Scanner;
// Import the HashMap class
import java.util.HashMap;

class StudySet {
    Scanner scan = new Scanner(System.in);
    HashMap<String, String> studySetArray = new HashMap<String, String>();
    String studySetName = "Study Set 1";
    String input = "";
    public void renameStudySet() {
        System.out.print("Rename your study set: ");
        studySetName = scan.nextLine();
        do {
            System.out.print("You renamed your study set to " + studySetName + ". Is this correct? (y/n) ");
            input = scan.nextLine().toLowerCase();
            if (input.equals("y")) {
                return;
            } else if (input.equals("n")) {
                break;
            } else {
                System.err.println("please enter either y or n");
            }
        } while (true);
    }

    public void choiceToRename() {
        do {
            System.out.print("Your study set name is " + studySetName + ". Would you like to rename it? (y/n) ");
            input = scan.nextLine().toLowerCase();
            if (input.equals("n")) {
                return;
            } else if (input.equals("y")) {
                renameStudySet();
            } else {
                System.err.println("please enter either y or n");
            }
        } while (true);
    }

    public void enterTerm() {
        System.out.println("If at any point you would like to quit entering terms, type q instead of the term.");
        do {
            System.out.print("Enter term: ");
            String term = scan.nextLine();
            if (term.toLowerCase().equals("q")) {
                confirm:
                do {
                    System.out.print("Are you sure you want to quit entering terms? (y/n)");
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("y")) {
                        return;
                    } else if (input.equals("n")) {
                        break confirm;
                    } else {
                        System.err.println("Please enter either y or n");
                    }
                } while (true);
            }
            System.out.print("Enter definition: ");
            String definition = scan.nextLine();
            studySetArray.put(term, definition);
        } while (true);
    }

    public void viewCurrentStudySet() {
        System.out.printf("%n%n   Study Set name: %S %n%n", studySetName);
        System.out.printf("   Terms           ||   Definitions %n======================================================== %n");
        for (String i : studySetArray.keySet()) {
            System.out.printf("   %-15s ||   %-50s %n", i ,studySetArray.get(i));
        }
    }

    public String studySetName() {
        return studySetName;
    }

    public HashMap studySetArray() {
        return studySetArray;
    }
}

public class QuizletDupe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudySet studySet = new StudySet();
        String studySetName = studySet.studySetName();
        HashMap studySetArray = studySet.studySetArray();
        System.out.printf("%n%n%n     QUIZLET (BUT NOT REALLY) %n");
        System.out.println("Hello and welcome to Quizlet Dupe. We are so excited to have you!");
        System.out.println("Use the following commands to navigate: ");
        do {
            System.out.printf(" 1: Create a new study set %n 2:    %n 3:    %n 4: Quit %n%n Input: ");
            int intInput = scan.nextInt();
            if (intInput == 1) {
                renamingSet:
                    studySet.choiceToRename();
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
                        System.err.println("Please only enter v, s, or q");
                    }
                } while (true);
            } else if (intInput == 4) {
                return;
            }
        } while (true);
    }
}