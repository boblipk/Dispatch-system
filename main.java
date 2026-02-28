import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> yesterdayTypes = new HashSet<>();

        yesterdayTypes.add("Fire");
        yesterdayTypes.add("Medical");
        yesterdayTypes.add("Traffic");

        IncidentQueue queue = new IncidentQueue(scanner);

        while (true) {
            System.out.println("choose an option: ");
            System.out.println("1: Add an Incident");
            System.out.println("2: view all Incidents");
            System.out.println("3: process next Incident");
            System.out.println("4: view details of unique Incident types today");
            System.out.println("5: search Incidents by type");
            System.out.println("6: search Incidents by district");
            System.out.println("7: trend analysis of Incident types");
            System.out.println("8: exit");
            int option = -1;
            while (true) {
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (option >= 1 && option <= 8) {
                        break; // Valid option, exit the loop
                    }
                } else {
                    scanner.nextLine(); // Consume the invalid input
                }
                System.out.println("Please enter a valid option (1-8): ");
            }
            switch (option) {
                case 1 -> queue.addIncident();
                case 2 -> queue.displayIncidents();
                case 3 -> queue.proccessIncident();
                case 4 -> queue.displayIncTypesToday();
                case 5 -> queue.searchIncidents(true);
                case 6 -> queue.searchIncidents(false);
                case 7 -> queue.trendAnalysis(yesterdayTypes);
                case 8 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                }
                default -> {
                }
            }
        }
    }
} 