import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, World!");
        while (true) {
            System.out.println("Enter an incident type ");
            String incType = scanner.nextLine();
            System.out.println("Enter an incident district ");
            String incDistrict = scanner.nextLine();
            System.out.println("Is this a high priority incident? (true/false) ");
            while (!scanner.hasNextBoolean()) {
                System.out.println("Please enter 'true' or 'false' for high priority: ");
                scanner.next(); // Consume the invalid input
            }
            boolean isHighPriority = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline character
            
            
            
        }
    }
} 