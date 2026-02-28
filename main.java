import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IncedentQueue queue = new IncedentQueue(scanner);

        while (true) {
            System.out.println("choose an option: ");
            System.out.println("1: Add an incident");
            System.out.println("2: view all incidents");
            System.out.println("3: process next incident");
            System.out.println("4: veiw details of unique incedent types today");
            System.out.println("5: search for an incident");
            System.out.println("6: trend analysis of incident types");
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

            if (option == 1) {
                queue.addIncedent();
            } else if (option == 2) {
                queue.displayIncedents();
            } else if (option == 3) {
                System.out.println("Processing next incident..."); // Code to process next incident
            } else if (option == 4) {
                System.out.println("Viewing details of unique incident types today..."); // Code to view details of unique incident types today
            } else if (option == 5) {
                System.out.println("Searching for an incident..."); // Code to search for an incident
            } else if (option == 6) {
                System.out.println("Performing trend analysis of incident types..."); // Code for trend analysis of incident types
            } else if (option == 7) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
            
        }
    }
} 