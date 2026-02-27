
import java.util.Scanner;

public class IncedentQueue {
    private Incedent head;
    private Incedent tail;
    private Scanner scanner;

    public IncedentQueue(Scanner scanner) {
        this.head = null;
        this.tail = null;
        this.scanner = scanner;
    }
    public void addIncedent() {

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
        
        Incedent newIncedent = new Incedent(incType, incDistrict, isHighPriority);
    
        if (head == null) {
            head = newIncedent;
            tail = newIncedent;
        } else if (newIncedent.getPriority()) {
            newIncedent.newNext(head);
            head = newIncedent;
        } else {
            tail.newNext(newIncedent);
            tail = newIncedent;
        }
    
    }
}