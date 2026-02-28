
import java.util.Scanner;

public class IncedentQueue {
    private Incedent head;
    private Incedent tail;
    private Scanner scanner;

    private String tableLine(String pos, String type, String district, String priority) {
        int chunklen = 4;
        String[] data = {pos, type, district, priority};
        StringBuilder line = new StringBuilder("│");
        for (String datum : data) {
            if (datum.length() > (chunklen)) {
                datum = datum.substring(0, chunklen - 3) + "...";
            } else {
                int padding = chunklen - datum.length();
                int leftPadding = padding / 2;
                int rightPadding = padding - leftPadding;
                datum = " ".repeat(leftPadding) + datum + " ".repeat(rightPadding);
            }
            line.append(datum).append("│");
            chunklen = 30; // Set chunklen to 30 for the remaining columns
        }
        return line.toString();
    }

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

    public void displayIncedents() {
        System.out.println("┌────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┐");
        String between = "├────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤";
        System.out.println(tableLine("Pos", "Type", "District", "Priority"));
        int linepos = 1;
        Incedent current = head;
        while (current != null) {
            System.out.println(between);
            String dispPrio = current.getPriority() ? "High" : "Low";
            System.out.println(tableLine(Integer.toString(linepos), current.getIncType(), current.getIncDistrict(), dispPrio));
            current = current.getNext();
            linepos++;
        }
        System.out.println("└────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");


    }
}
        