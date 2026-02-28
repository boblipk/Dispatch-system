import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IncidentQueue queue = new IncidentQueue(scanner);

        OUTER:
        while (true) {
            System.out.println("choose an option: ");
            System.out.println("1: Add an Incident");
            System.out.println("2: view all Incidents");
            System.out.println("3: process next Incident");
            System.out.println("4: veiw details of unique Incident types today");
            System.out.println("5: search for an Incident");
            System.out.println("6: trend analysis of Incident types");
            System.out.println("7: exit");
            int option = -1;
            while (true) {
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (option >= 1 && option <= 7) {
                        break; // Valid option, exit the loop
                    }
                } else {
                    scanner.nextLine(); // Consume the invalid input
                }
                System.out.println("Please enter a valid option (1-7): ");
            }
            switch (option) {
                case 1 -> queue.addIncident();
                case 2 -> queue.displayIncidents();
                case 3 -> queue.proccessIncident();
                case 4 -> System.out.println("Viewing details of unique Incident types today..."); // Code to view details of unique Incident types today
                case 5 -> System.out.println("Searching for an Incident..."); // Code to search for an Incident
                case 6 -> System.out.println("Performing trend analysis of Incident types..."); // Code for trend analysis of Incident types
                case 7 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    break OUTER;
                }
                default -> {
                }
            }
        }
    }
} 